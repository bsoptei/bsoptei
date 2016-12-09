package wanderer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Random;

/**
 * Created by Söp on 2016.12.05.. Generic class for pretty much everything (tiles & characters) in the game
 */
abstract class GameObject implements GameMeetingPoint, Battle{
    Integer defaultHealthPoint, healthPoint, defensePoint, strikePoint, xPos, yPos;
    String name;
    String type;
    boolean alive = true;
    PositionedImage tileImage;
    static final ArrayList<String> enemyTypes = new ArrayList<>(Arrays.asList("S", "B"));

    int level;
    boolean obstacle;
    Random dice = new Random();
    final HashMap<String, String> imageSelector = new HashMap<String, String>() {{
        put("F", "src/wanderer/image/floor.png");
        put("W", "src/wanderer/image/wall.png");
        put("H", "src/wanderer/image/hero-down.png");
        put("S", "src/wanderer/image/skeleton.png");
        put("B", "src/wanderer/image/boss.png");
    }};
    String swanSong;

    GameObject(String type) {
        this.type = type;
    }

    abstract void initStats();

    abstract void changeElementImageCoordinates(int deltaX, int deltaY);

    abstract void move(int deltaX, int deltaY);

    abstract boolean neighborIsObstacle(int deltaX, int deltaY);

    abstract String levelToString();

    public void createElementImage() {
        this.tileImage = new PositionedImage(imageSelector.get(type), xPos * imageSize, yPos * imageSize);
    }

    public void moveElementImage() {
        tileImage.setXPos(xPos * imageSize);
        tileImage.setYPos(yPos * imageSize);
    }

    PositionedImage getTileImage() {
        return tileImage;
    }

    boolean isAlive() {
        return alive;
    }

    boolean isObstacle() {
        return obstacle;
    }

    String getName() {
        return name;
    }

    String statsToString() {
        return String.format("HP: %d/%d | DP: %d | SP: %d",
                healthPoint, defaultHealthPoint,
                defensePoint, strikePoint);
    }

    Integer[] getCoordinates() {
        return new Integer[]{xPos, yPos};
    }

    boolean movementIsPossible(int deltaX, int deltaY) {
        return (!(boundaryOfMap(deltaX, deltaY)) && !(neighborIsObstacle(deltaX, deltaY)));
    }

    private boolean boundaryOfMap(int deltaX, int deltaY) {
        return (xPos == 0 && deltaX == -1
                || xPos == gameArea.getWidth() - 1 && deltaX == 1
                || yPos == 0 && deltaY == -1
                || yPos == gameArea.getHeight() - 1 && deltaY == 1);
    }

    String getType() {
        return type;
    }

    int getX() {
        return xPos;
    }

    int getY() {
        return yPos;
    }
}