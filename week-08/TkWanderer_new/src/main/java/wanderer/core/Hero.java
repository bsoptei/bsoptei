package wanderer.core;

import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;

/**
 * Created by Söp on 2016.12.07.. The hero
 */
public class Hero extends GameObject {
    private HashMap<String, String> directionImageSelector = new HashMap<String, String>() {{
        put("down", "src/main/java/wanderer/image/hero-down.png");
        put("up", "src/main/java/wanderer/image/hero-up.png");
        put("left", "src/main/java/wanderer/image/hero-left.png");
        put("right", "src/main/java/wanderer/image/hero-right.png");
    }};
    private HashMap<String, GameImage> directionImages = new HashMap<>();
    @Getter
    private int numberOfMoves;
    @Getter
    @Setter
    private GameObject currentOpponent;
    private int heroLevel;

    Hero(int xPos, int yPos) {
        super("H");
        this.xPos = xPos;
        this.yPos = yPos;
        obstacle = false;
        numberOfMoves = 0;
        name = "Hero";
        swanSong = "src/main/java/wanderer/wav/56901__syna-max__wilhelm-scream-outtake.wav";
        initHero();
    }

    void initHero() {
        heroLevel = 1;
        alive = true;
        initStats();
        moveToCorner();
    }

    void reset() {
        moveToCorner();
        numberOfMoves = 0;
        restoreHealth(dice.nextInt(10) + 1);
    }

    private void moveToCorner() {
        xPos = 0;
        yPos = 0;
    }

    @Override
    void initStats() {
        defaultHealthPoint = 20 + 3 * (dice.nextInt(6) + 1);
        healthPoint = defaultHealthPoint;
        defensePoint = 2 * (dice.nextInt(6) + 1);
        strikePoint = 5 + (dice.nextInt(6) + 1);
    }

    private void restoreHealth(int diceThrow) {
        if (diceThrow > 9) {
            healthPoint = defaultHealthPoint;
        } else if (healthPoint > 5) {
            healthPoint = (healthPoint < defaultHealthPoint * 0.75) ? (int) (healthPoint * 1.333) : defaultHealthPoint;
        } else {
            healthPoint = (healthPoint < defaultHealthPoint * 0.9) ? (int) (healthPoint * 1.1) : defaultHealthPoint;
        }
    }

    void createDirectionImages() {
        for (String direction : directionImageSelector.keySet()) {
            directionImages.put(direction, viewer.getImage(directionImageSelector.get(direction), 0, 0));
        }
    }

    @Override
    void move(int deltaX, int deltaY) {
        if (movementIsPossible(deltaX, deltaY)) {
            xPos += deltaX;
            yPos += deltaY;
            gameObjectAudioPlayer.play("src/main/java/wanderer/wav/268758__legowanwan__footsteps.wav");
        } else {
            gameObjectAudioPlayer.play("src/main/java/wanderer/wav/8838__churd-tzu__water-bottle-snare-15-bonk.wav");
        }
        changeElementDirectionImage(deltaX, deltaY);
        moveElementImage();
        incrementNumberOfMoves();
    }

    void changeElementDirectionImage(int deltaX, int deltaY) {
        if (deltaY == -1) {
            gameObjectImage = directionImages.get("up");
        } else if (deltaY == 1) {
            gameObjectImage = directionImages.get("down");
        } else if (deltaX == 1) {
            gameObjectImage = directionImages.get("right");
        } else {
            gameObjectImage = directionImages.get("left");
        }
    }

    @Override
    boolean neighborIsObstacle(int deltaX, int deltaY) {
        int xNeighbor = xPos + deltaX;
        int yNeighbor = yPos + deltaY;
        return (map[xNeighbor][yNeighbor].isObstacle());

    }

    private void incrementNumberOfMoves() {
        numberOfMoves++;
    }

    @Override
    public void strike() {
        if (currentOpponent != null) {
            gameObjectAudioPlayer.play("src/main/java/wanderer/wav/326847__johnbuhr__sword-clash-37.wav");
            currentOpponent.sufferDamage(strikePoint);
        }
    }

    @Override
    public void sufferDamage(int damage) {
        if (damage + (dice.nextInt(6) + 1) * 2 > defensePoint) {
            gameObjectAudioPlayer.play("src//main/java/wanderer/wav/19421__awfulthesample__awfultheaudio-watschn2.wav");
            decreaseHealthPoint(damage);
        }
    }

    @Override
    public void decreaseHealthPoint(int damage) {
        healthPoint -= damage;
        if (healthPoint <= 0) {
            alive = false;
            if (!(swanSong == null)) {
                gameObjectAudioPlayer.play(swanSong);
            }
        }
    }

    void levelUp() {
        heroLevel++;
        defaultHealthPoint += (dice.nextInt(6) + 1);
        defensePoint += (dice.nextInt(6) + 1);
        strikePoint += (dice.nextInt(6) + 1);
    }

    @Override
    public String levelToString() {
        return String.format("Level %s", String.valueOf(heroLevel));
    }
}