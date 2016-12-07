package wanderer;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Söp on 2016.12.05..
 */
abstract class GameObject {
    public Integer healthPoint, defensePoint, strikePoint, xPos, yPos;
    public String name;
    String type;
    private boolean alive;
    PositionedImage tileImage;
    final int imageSize = 72;
    int level;
    public boolean obstacle;
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

    public String getHP() {
        return String.format("HP: %d", healthPoint);
    }

    public String getSP() {
        return String.format("SP: %d", strikePoint);
    }

    public String getDP() {
        return String.format("DP: %d", defensePoint);
    }

    PositionedImage getTileImage() {
        return tileImage;
    }

    public String getType() {
        return type;
    }

    public boolean isAlive() {
        return alive;
    }

    public boolean isObstacle() {
        return obstacle;
    }

    public String getName() {
        return name;
    }
}