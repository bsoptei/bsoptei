package wanderer;

import java.util.Random;

/**
 * Created by Söp on 2016.12.07.. The strongest enemy
 */
class Boss extends GameObject {


    Boss(int xPos, int yPos, int level) {
        super("B");
        this.xPos = xPos;
        this.yPos = yPos;
        obstacle = false;
        this.level = level;
        name = "Boss";
        swanSong = "src/wanderer/wav/49470__enochrooted__toni-pitchedscream.wav";
        createElementImage();
        setDefaultStats();
    }


    @Override
    void strike() {
        hero.getHit(strikePoint);
    }


    @Override
    void setDefaultStats() {
        Random dice = new Random();
        defaultHealthPoint = 2 * level * (dice.nextInt(5) + 1) + (dice.nextInt(5) + 1);
        healthPoint = defaultHealthPoint;
        defensePoint = level / 2 * (dice.nextInt(5) + 1) + (dice.nextInt(5) + 1) / 2;
        strikePoint = level * (dice.nextInt(5) + 1) + level;
    }


    @Override
    PositionedImage getTileImage() {
        return tileImage;
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

    @Override
    void changeElementImage(int deltaX, int deltaY) {

    }

    @Override
    void move(int deltaX, int deltaY) {
        if (movementIsPossible(deltaX, deltaY)) {
            xPos += deltaX;
            yPos += deltaY;
        }
        moveElementImage();
    }

}
