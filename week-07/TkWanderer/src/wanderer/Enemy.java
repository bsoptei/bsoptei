package wanderer;

import java.util.Arrays;

/**
 * Created by Söp on 2016.12.08.. Common class for skeletons and boss
 */
class Enemy extends GameObject {
    private boolean hasKey;

    Enemy(String type, int xPos, int yPos, int level, boolean hasKey) {
        super(type);
        this.xPos = xPos;
        this.yPos = yPos;
        obstacle = false;
        this.level = level;
        this.hasKey = hasKey;
        createElementImage();
    }

    @Override
    void initStats() {
    }

    @Override
    void move(int deltaX, int deltaY) {
        if (movementIsPossible(deltaX, deltaY)) {
            xPos += deltaX;
            yPos += deltaY;
            moveElementImage();
            if (Arrays.equals(hero.getCoordinates(), new Integer[]{xPos, yPos}) && alive) {
                strike();
            }
        }
    }

    @Override
    boolean neighborIsObstacle(int deltaX, int deltaY) {
        int xNeighbor = xPos + deltaX;
        int yNeighbor = yPos + deltaY;//
        return (gameArea.getTiles()[xNeighbor][yNeighbor].isObstacle());
    }

    @Override
    void changeElementDirectionImage(int deltaX, int deltaY) {
    }

    @Override
    public void strike() {
        hero.sufferDamage(strikePoint);
    }

    @Override
    public void sufferDamage(int damage) {
        if (damage + (dice.nextInt(6) + 1) * 2 > defensePoint) {
            decreaseHealthPoint(damage);
        }
        if (alive) {
            strike();
        }
    }

    @Override
    public void decreaseHealthPoint(int damage) {
        healthPoint -= damage;
        if (healthPoint <= 0) {
            if (!(swanSong == null)) {
                AudioPlayer.play(swanSong);
            }
            alive = false;
            hero.levelUp();
        }
    }

    @Override
    String levelToString() {
        return "";
    }
}
