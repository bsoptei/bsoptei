package wanderer;

import java.util.Random;

/**
 * Created by Söp on 2016.12.07..
 */
public class Boss extends GameObject {

    Boss(String type) {
        super(type);
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
        healthPoint = 2 * level * (dice.nextInt(5) + 1) + (dice.nextInt(5) + 1);
        defensePoint = level / 2 * (dice.nextInt(5) + 1) + (dice.nextInt(5) + 1) / 2;
        strikePoint = level * (dice.nextInt(5) + 1) + level;
    }

    @Override
    String getHP() {
        return null;
    }

    @Override
    String getDP() {
        return null;
    }

    @Override
    String getSP() {
        return null;
    }

    @Override
    PositionedImage getTileImage() {
        return null;
    }
}
