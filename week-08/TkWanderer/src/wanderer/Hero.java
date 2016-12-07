package wanderer;

import java.util.HashMap;

/**
 * Created by Söp on 2016.12.07.. The hero
 */
class Hero extends GameObject {
    private HashMap<String, PositionedImage> heroDirectionImages = new HashMap<String, PositionedImage>() {{
        put("down", new PositionedImage("src/wanderer/image/hero-down.png", 0, 0));
        put("up", new PositionedImage("src/wanderer/image/hero-up.png", 0, 0));
        put("left", new PositionedImage("src/wanderer/image/hero-left.png", 0, 0));
        put("right", new PositionedImage("src/wanderer/image/hero-right.png", 0, 0));
    }};


    private int numberOfMoves;

    private GameObject currentOpponent;
    private int heroLevel = 1;

    void reset() {
        xPos = 0;
        yPos = 0;
        moveElementImage();
        numberOfMoves = 0;

//        when entering a new area the hero has
//        10% chance to restore all his HP
//        40% chance to restore the third of his HP
//        50% chance to restore 10% of his HP
    }

    Hero(int xPos, int yPos) {
        super("H");
        this.xPos = xPos;
        this.yPos = yPos;
        obstacle = false;
        numberOfMoves = 0;
        name = "Hero";
        createElementImage();
        setDefaultStats();
    }

    @Override
    void move(int deltaX, int deltaY) {
        if (movementIsPossible(deltaX, deltaY)) {
            xPos += deltaX;
            yPos += deltaY;
        }
        incrementNumberOfMoves();
        changeElementImage(deltaX, deltaY);
        moveElementImage();
    }

    void changeElementImage(int deltaX, int deltaY) {
        if (deltaX == -1) {
            tileImage = heroDirectionImages.get("left");
        } else if (deltaX == 1) {
            tileImage = heroDirectionImages.get("right");
        } else if (deltaY == -1) {
            tileImage = heroDirectionImages.get("up");
        } else {
            tileImage = heroDirectionImages.get("down");
        }
    }

    @Override
    void strike() {
        if (currentOpponent != null) {
            currentOpponent.getHit(strikePoint);
        }
    }

    @Override
    void setDefaultStats() {

        defaultHealthPoint = 20 + 3 * (dice.nextInt(6) + 1);
        healthPoint = defaultHealthPoint;
        defensePoint = 2 * (dice.nextInt(6) + 1);
        strikePoint = 5 + (dice.nextInt(6) + 1);
    }

    @Override
    PositionedImage getTileImage() {
        return tileImage;
    }

    public void setGameArea(Area gameArea) {
        this.gameArea = gameArea;
    }

    @Override
    void getHit(int damage) {
        if (damage + (dice.nextInt(6) + 1) * 2 > defensePoint) {
            decreaseHealthPoint(damage);
        }
    }

    private void incrementNumberOfMoves() {
        numberOfMoves++;
    }

    int getNumberOfMoves() {
        return numberOfMoves;
    }

    void setCurrentOpponent(GameObject currentOpponent) {
        this.currentOpponent = currentOpponent;
    }

    void levelUp() {
        heroLevel++;
        defaultHealthPoint += (dice.nextInt(6) + 1);
        defensePoint += (dice.nextInt(6) + 1);
        strikePoint += (dice.nextInt(6) + 1);
    }

    int getHeroLevel() {
        return heroLevel;
    }
}