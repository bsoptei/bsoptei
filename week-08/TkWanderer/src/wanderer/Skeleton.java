package wanderer;

import java.util.Random;

/**
 * Created by Söp on 2016.12.07..
 */
public class Skeleton extends GameObject {
    public boolean hasKey;

    public Skeleton(int xPos, int yPos, int level, boolean hasKey) {
        super("S");
        this.xPos = xPos;
        this.yPos = yPos;
        obstacle = false;
        this.level = level;
        this.hasKey = hasKey;
        name = "Skeleton";
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
    void fight() {

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

    public boolean isKeyHolder() {
        return hasKey;
    }

}
