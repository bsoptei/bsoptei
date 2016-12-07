package wanderer;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Söp on 2016.12.07..
 */
public class Hero extends GameObject {
    public HashMap<String, PositionedImage> heroDirectionImages = new HashMap<String, PositionedImage>() {{
        put("down", new PositionedImage("src/wanderer/image/hero-down.png", 0, 0));
        put("up", new PositionedImage("src/wanderer/image/hero-up.png", 0, 0));
        put("left", new PositionedImage("src/wanderer/image/hero-left.png", 0, 0));
        put("right", new PositionedImage("src/wanderer/image/hero-right.png", 0, 0));
    }};

    public Hero(int xPos, int yPos) {
        this.xPos = xPos;
        this.yPos = yPos;
        createElementImage();
    }

    @Override
    void move(int deltaX, int deltaY) {

        xPos += deltaX;
        yPos += deltaY;
        changeElementImage(deltaX, deltaY);
        moveElementImage();
    }

    private void changeElementImage(int deltaX, int deltaY) {
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
    void fight() {

    }

    @Override
    void createElementImage() {
        changeElementImage(0, 1);
    }

    @Override
    void moveElementImage() {
        tileImage.setPosX(xPos * imageSize);
        tileImage.setPosY(yPos * imageSize);
    }

    @Override
    void setStartingStats() {

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
    Integer getHealthPoint() {
        return null;
    }

    @Override
    Integer getDefensePoint() {
        return null;
    }

    @Override
    Integer getStrikePoint() {
        return null;
    }

    @Override
    GameElement getNeighbor() {
        return null;
    }

    @Override
    PositionedImage getTileImage() {
        return tileImage;
    }
}
