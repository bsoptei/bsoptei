package wanderer;

import java.util.Random;

/**
 * Created by Söp on 2016.12.07..
 */
public class Skeleton extends GameObject {


    public Skeleton(int xPos, int yPos, int level) {
        super("S");
        this.xPos = xPos;
        this.yPos = yPos;
        obstacle = false;
        this.level = level;
        name ="Skeleton";
        createElementImage();
        setStartingStats();
    }

    @Override
    void move(int deltaX, int deltaY) {

    }

    @Override
    void fight() {

    }

    @Override
    void moveElementImage() {

    }

    @Override
    void setStartingStats() {
        Random dice = new Random();
        healthPoint = 2 * level * (dice.nextInt(5) + 1);
        defensePoint = level / 2 * (dice.nextInt(5) + 1);
        strikePoint = level * (dice.nextInt(5) + 1);
    }



    @Override
    PositionedImage getTileImage() {
        return tileImage;
    }


}
