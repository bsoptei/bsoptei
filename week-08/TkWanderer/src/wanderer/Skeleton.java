package wanderer;

import java.util.Random;

/**
 * Created by Söp on 2016.12.07.. Weak enemy
 */
class Skeleton extends GameObject {

    private boolean hasKey;


    Skeleton(int xPos, int yPos, int level, boolean hasKey) {
        super("S");
        this.xPos = xPos;
        this.yPos = yPos;
        obstacle = true;
        this.level = level;
        this.hasKey = hasKey;
        name = "Skeleton";
        swanSong = "src/wanderer/wav/348310__redafs__zombie-monster-scream.wav";
        createElementImage();
        setDefaultStats();
    }

    @Override
    void move(int deltaX, int deltaY) {
        if (movementIsPossible(deltaX, deltaY)) {
            xPos += deltaX;
            yPos += deltaY;
        }
        moveElementImage();
    }

    @Override
    void changeElementImage(int deltaX, int deltaY) {

    }

    @Override
    void strike() {
        hero.getHit(strikePoint);
    }


    @Override
    void setDefaultStats() {
        Random dice = new Random();
        defaultHealthPoint = 2 * level * (dice.nextInt(5) + 1);
        healthPoint = defaultHealthPoint;
        defensePoint = level / 2 * (dice.nextInt(5) + 1);
        strikePoint = level * (dice.nextInt(5) + 1);
    }


    @Override
    PositionedImage getTileImage() {
        return tileImage;
    }

    @Override
    boolean neighborIsObstacle(int deltaX, int deltaY) {
        int xNeighbor = xPos + deltaX;
        int yNeighbor = yPos + deltaY;
        return (deltaX != 0 && gameArea.getTiles()[xNeighbor][yPos].isObstacle()
                || deltaY != 0 && gameArea.getTiles()[xPos][yNeighbor].isObstacle());
    }

    @Override
    void getHit(int damage) {
        if (damage + (dice.nextInt(6) + 1) * 2 > defensePoint) {
            decreaseHealthPoint(damage);
        }
        if (alive) {
            strike();
        }
    }

}
