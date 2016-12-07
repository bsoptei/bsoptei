package wanderer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

/**
 * Created by Söp on 2016.12.07.. The hero
 */
public class Hero extends GameObject {
    public HashMap<String, PositionedImage> heroDirectionImages = new HashMap<String, PositionedImage>() {{
        put("down", new PositionedImage("src/wanderer/image/hero-down.png", 0, 0));
        put("up", new PositionedImage("src/wanderer/image/hero-up.png", 0, 0));
        put("left", new PositionedImage("src/wanderer/image/hero-left.png", 0, 0));
        put("right", new PositionedImage("src/wanderer/image/hero-right.png", 0, 0));
    }};

    public int numberOfMoves;

    public GameObject currentOpponent;

    public void reset() {
        xPos = 0;
        yPos = 0;
        moveElementImage();
        numberOfMoves = 0;
    }

    public Hero(int xPos, int yPos) {
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
            boolean success = (strikePoint + (dice.nextInt(6) + 1) * 2 > currentOpponent.getDefensePoint());
            if (success) {
                currentOpponent.decreaseHealthPoint(strikePoint - currentOpponent.getDefensePoint());
            }
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

    public void incrementNumberOfMoves() {
        numberOfMoves++;
    }

    public int getNumberOfMoves() {
        return numberOfMoves;
    }

    public void setCurrentOpponent(GameObject currentOpponent) {
        this.currentOpponent = currentOpponent;
    }

}