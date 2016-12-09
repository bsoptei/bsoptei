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
    PositionedImage gameObjectImage;
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

    public void createElementImage() {
        this.gameObjectImage = new PositionedImage(imageSelector.get(type), xPos * imageSize, yPos * imageSize);
    }

    abstract void move(int deltaX, int deltaY);

    boolean movementIsPossible(int deltaX, int deltaY) {
        return (!(isAtboundaryOfMap(deltaX, deltaY)) && !(neighborIsObstacle(deltaX, deltaY)));
    }

    private boolean isAtboundaryOfMap(int deltaX, int deltaY) {
        return (xPos == 0 && deltaX == -1
                || xPos == gameArea.getWidth() - 1 && deltaX == 1
                || yPos == 0 && deltaY == -1
                || yPos == gameArea.getHeight() - 1 && deltaY == 1);
    }

    abstract boolean neighborIsObstacle(int deltaX, int deltaY);

    void moveElementImage() {
        gameObjectImage.setXPos(xPos * imageSize);
        gameObjectImage.setYPos(yPos * imageSize);
    }

    abstract void changeElementDirectionImage(int deltaX, int deltaY);

    String getName() {
        return name;
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

    Integer[] getCoordinates() {
        return new Integer[]{xPos, yPos};
    }

    PositionedImage getGameObjectImage() {
        return gameObjectImage;
    }

    boolean isAlive() {
        return alive;
    }

    boolean isObstacle() {
        return obstacle;
    }

    String statsToString() {
        return String.format("HP: %d/%d|DP: %d|SP: %d",
                healthPoint, defaultHealthPoint,
                defensePoint, strikePoint);
    }

    abstract String levelToString();
}