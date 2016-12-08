package wanderer;


/**
 * Created by Söp on 2016.12.07.. Weak enemy
 */
class Skeleton extends Enemy {

    Skeleton(int xPos, int yPos, int level, boolean hasKey) {
        super("S", xPos, yPos, level, hasKey);
        name = "Skeleton";
        swanSong = "src/wanderer/wav/348310__redafs__zombie-monster-scream.wav";
        setDefaultStats();
    }

    @Override
    void setDefaultStats() {
        defaultHealthPoint = 2 * level * (dice.nextInt(5) + 1);
        healthPoint = defaultHealthPoint;
        defensePoint = level / 2 * (dice.nextInt(5) + 1);
        strikePoint = level * (dice.nextInt(5) + 1);
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

    }

}
