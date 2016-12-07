package wanderer;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Söp on 2016.12.05..
 */
abstract class GameObject {
    public Integer healthPoint, defensePoint, strikePoint, xPos, yPos;
    String type;
    private boolean alive;
    PositionedImage tileImage;
    final int imageSize = 72;
    int level;
    private boolean obstacle;
    public final HashMap<String, String> imageSelector = new HashMap<String, String>() {{
        put("F", "src/wanderer/image/floor.png");
        put("W", "src/wanderer/image/wall.png");
        put("H", "src/wanderer/image/hero-down.png");
        put("S", "src/wanderer/image/skeleton.png");
        put("B", "src/wanderer/image/boss.png");
    }};

    GameObject(String type) {
        this.type = type;
    }


    abstract void move(int deltaX, int deltaY);

    abstract void fight();

    public void createElementImage() {
        this.tileImage = new PositionedImage(imageSelector.get(type), xPos * imageSize, yPos * imageSize);
    }


    abstract void moveElementImage();

    abstract void setStartingStats();

    abstract ArrayList<GameElement> inspectNeighbors();

    abstract Integer getXPosition();

    abstract Integer getYPosition();

    abstract String getHP();

    abstract String getDP();

    abstract String getSP();

    abstract PositionedImage getTileImage();

    public String getType() {
        return type;
    }

    public boolean isAlive() {
        return alive;
    }

    public boolean isObstacle() {
        return obstacle;
    }
}