package wanderer.core;

import lombok.Data;

import java.util.HashMap;
import java.util.Random;

/**
 * Created by Söp on 2016.12.05.. Generic class for pretty much everything (tiles & characters) in the game
 */
@Data
public abstract class GameObject implements Battle {
    Integer defaultHealthPoint, healthPoint, defensePoint, strikePoint, xPos, yPos;
    private Integer mapWidth, mapHeight;
    Tile[][] map;
    GameAudioPlayer gameObjectAudioPlayer;
    String name;
    String type;
    boolean alive = true;
    GameImage gameObjectImage;
    int level;
    boolean obstacle;
    private final int imageSize = 40;
    Hero hero;
    Random dice = new Random();
    GameGUI viewer;
    String swanSong;
    private final HashMap<String, String> imageSelector = new HashMap<String, String>() {{
        put("F", "src/main/java/wanderer/image/floor.png");
        put("W", "src/main/java/wanderer/image/wall.png");
        put("H", "src/main/java/wanderer/image/hero-down.png");
        put("S", "src/main/java/wanderer/image/skeleton.png");
        put("B", "src/main/java/wanderer/image/boss.png");

    }};

    GameObject(String type) {
        this.type = type;
    }

    abstract void initStats();

    void createElementImage() {
        this.gameObjectImage = viewer.getImage(imageSelector.get(type), xPos * imageSize, yPos * imageSize);
    }

    abstract void move(int deltaX, int deltaY);

    boolean movementIsPossible(int deltaX, int deltaY) {
        return (!(isAtboundaryOfMap(deltaX, deltaY)) && !(neighborIsObstacle(deltaX, deltaY)));
    }

    private boolean isAtboundaryOfMap(int deltaX, int deltaY) {
        return (xPos == 0 && deltaX == -1
                || xPos == mapWidth - 1 && deltaX == 1
                || yPos == 0 && deltaY == -1
                || yPos == mapHeight - 1 && deltaY == 1);
    }

    abstract boolean neighborIsObstacle(int deltaX, int deltaY);

    void moveElementImage() {
        gameObjectImage.setXPos(xPos * imageSize);
        gameObjectImage.setYPos(yPos * imageSize);
    }

    abstract void changeElementDirectionImage(int deltaX, int deltaY);

    Integer[] getCoordinates() {
        return new Integer[]{xPos, yPos};
    }

    public String statsToString() {
        return String.format("HP: %d/%d|DP: %d|SP: %d",
                healthPoint, defaultHealthPoint,
                defensePoint, strikePoint);
    }

    public abstract String levelToString();
}