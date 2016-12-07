package wanderer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

/**
 * Created by Söp on 2016.12.05..drtktseriogjaeigoeajgweiogewjoiaj
 */
public class GameElement extends GameObject {
    public PositionedImage tileImage;
    public String type;
    public HashMap<String, String> imageSelector = new HashMap<String, String>() {{
        put("F", "src/wanderer/image/floor.png");
        put("W", "src/wanderer/image/wall.png");
        put("S", "src/wanderer/image/skeleton.png");
        put("B", "src/wanderer/image/boss.png");
    }};


    public GameElement(int xPos, int yPos, String type) {
        super(type);
        this.xPos = xPos;
        this.yPos = yPos;
        this.type = type;
        createElementImage();
    }

    @Override
    public void createElementImage() {
        this.tileImage = new PositionedImage(imageSelector.get(type), xPos * imageSize, yPos * imageSize);
    }

    @Override
    void move(int deltaX, int deltaY) {
        xPos += deltaX;
        yPos += deltaY;
        moveElementImage();
    }


    void fight() {
    }

    @Override
    public void moveElementImage() {
        tileImage.setPosX(xPos * imageSize);
        tileImage.setPosY(yPos * imageSize);
    }

    @Override
    void setStartingStats() {
        Random dice = new Random();

        if (type.equals("S")) {
            healthPoint = 2 * level * (dice.nextInt(5) + 1);
            defensePoint = level / 2 * (dice.nextInt(5) + 1);
            strikePoint = level * (dice.nextInt(5) + 1);
        } else if (type.equals("B")) {
            healthPoint = 2 * level * (dice.nextInt(5) + 1) + (dice.nextInt(5) + 1);
            defensePoint = level / 2 * (dice.nextInt(5) + 1) + (dice.nextInt(5) + 1) / 2;
            strikePoint = level * (dice.nextInt(5) + 1) + level;
        }
    }

    @Override
    ArrayList<GameElement> inspectNeighbors() {
        return null;
    }

    @Override
    Integer getXPosition() {
        return null;
    }

    @Override
    Integer getYPosition() {
        return null;
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

    public PositionedImage getTileImage() {
        return tileImage;
    }


}
