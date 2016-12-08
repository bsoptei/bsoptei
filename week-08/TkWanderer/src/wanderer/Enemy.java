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
    void changeElementImage(int deltaX, int deltaY) {
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
    void strike() {
        hero.getHit(strikePoint);
    }

    @Override
    void setDefaultStats() {

    }

    @Override
    boolean neighborIsObstacle(int deltaX, int deltaY) {
        int xNeighbor = xPos + deltaX;
        int yNeighbor = yPos + deltaY;
        return ((deltaX != 0 && (gameArea.getTiles()[xNeighbor][yPos].isObstacle() ||
                neighborIsEnemy(xNeighbor, yPos)))
                || (deltaY != 0 && (gameArea.getTiles()[xPos][yNeighbor].isObstacle() ||
                neighborIsEnemy(xPos, yNeighbor)))
        );
    }

    @Override
    String getLevelToString() {
        return "";
    }

    private boolean neighborIsEnemy(int deltaX, int deltaY) {
        String id = gameArea.getPlayerPositions()[deltaX][deltaY].toString();
        return id.equals("B") || id.equals("S");
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

    private void decreaseHealthPoint(int damage) {
        healthPoint -= damage;
        if (healthPoint <= 0) {
            if (!(swanSong == null)) {
                AudioPlayer.play(swanSong);
            }
            alive = false;
            hero.levelUp();
        }
    }
}
