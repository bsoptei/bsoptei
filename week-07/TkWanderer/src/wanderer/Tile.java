package wanderer;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Söp on 2016.12.05.. Tiles of the map
 */
class Tile extends GameObject {
    @SuppressWarnings("ArraysAsListWithZeroOrOneArgument")
    private final ArrayList<String> obstacleTypes = new ArrayList<>(Arrays.asList("W"));

    Tile(int xPos, int yPos, String type) {
        super(type);
        this.xPos = xPos;
        this.yPos = yPos;
        this.type = type;
        createElementImage();
        setObstacle();
    }

    @Override
    void initStats() {
    }

    @Override
    public void createElementImage() {
        this.gameObjectImage = new PositionedImage(imageSelector.get(type), xPos * imageSize, yPos * imageSize);
    }

    private void setObstacle() {
        obstacle = obstacleTypes.contains(type);
    }

    @Override
    void move(int deltaX, int deltaY) {
    }

    @Override
    boolean neighborIsObstacle(int deltaX, int deltaY) {
        return false;
    }

    @Override
    void changeElementDirectionImage(int deltaX, int deltaY) {
    }

    @Override
    public void strike() {
    }

    @Override
    public void sufferDamage(int damage) {
    }

    @Override
    public void decreaseHealthPoint(int damage) {
    }

    @Override
    String levelToString() {
        return null;
    }
}