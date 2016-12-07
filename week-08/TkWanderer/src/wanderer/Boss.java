package wanderer;

import java.util.Random;

/**
 * Created by Söp on 2016.12.07..
 */
public class Boss extends GameObject {


    public Boss(int xPos, int yPos, int level) {
        super("B");
        this.xPos = xPos;
        this.yPos = yPos;
        obstacle = false;
        this.level = level;
        name = "Boss";
        createElementImage();
        setDefaultStats();
    }



    @Override
    void fight() {

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
