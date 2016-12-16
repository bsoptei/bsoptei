package wanderer.core;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Söp on 2016.12.05.. Tiles of the map
 */
public class Tile extends GameObject {

    private final ArrayList<String> obstacleTypes = new ArrayList<>(Arrays.asList("W", ""));

    Tile(int xPos, int yPos, String type) {
        super(type);
        this.xPos = xPos;
        this.yPos = yPos;
        this.type = type;
        setObstacle();
    }

    @Override
    void initStats() {
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
    public String levelToString() {
        return null;
    }
}