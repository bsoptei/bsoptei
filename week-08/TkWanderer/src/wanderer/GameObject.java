package wanderer;


import java.util.HashMap;

/**
 * Created by Söp on 2016.12.05..
 */
abstract class GameObject {
    public Integer defaultHealthPoint, healthPoint, defensePoint, strikePoint, xPos, yPos;
    public String name;
    String type;
    public boolean alive = true;
    PositionedImage tileImage;
    final int imageSize = 72;
    int level;
    public boolean obstacle;
    public Area gameArea;
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

    abstract void changeElementImage(int deltaX, int deltaY);

    abstract void move(int deltaX, int deltaY);

    abstract void fight();

    public void createElementImage() {
        this.tileImage = new PositionedImage(imageSelector.get(type), xPos * imageSize, yPos * imageSize);
    }

    public void moveElementImage() {
        tileImage.setPosX(xPos * imageSize);
        tileImage.setPosY(yPos * imageSize);
    }

    abstract void setDefaultStats();

    PositionedImage getTileImage() {
        return tileImage;
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

    public String getStats() {
        return String.format("HP: %d/%d | DP: %d | SP: %d",
                healthPoint, defaultHealthPoint,
                defensePoint, strikePoint);
    }

    public Integer[] getCoordinates() {
        return new Integer[]{xPos, yPos};
    }

    public void setGameArea(Area gameArea) {
        this.gameArea = gameArea;
    }

    boolean movementIsPossible(int deltaX, int deltaY) {
        boolean possible = true;
        if (boundaryOfMap(deltaX, deltaY) || neighborIsObstacle(deltaX, deltaY)) {
            possible = false;
        }
        return possible;
    }

    private boolean neighborIsObstacle(int deltaX, int deltaY) {
        boolean obstacle = false;
        int xNeighbor = xPos + deltaX;
        int yNeighbor = yPos + deltaY;

        if (deltaX != 0 && gameArea.getTiles()[xNeighbor][yPos].isObstacle()
                || deltaY != 0 && gameArea.getTiles()[xPos][yNeighbor].isObstacle()) {
            obstacle = true;
        }
        return obstacle;
    }

    private boolean boundaryOfMap(int deltaX, int deltaY) {
        return (xPos == 0 && deltaX == -1
                || xPos == 9 && deltaX == 1
                || yPos == 0 && deltaY == -1
                || yPos == 9 && deltaY == 1);
    }
}