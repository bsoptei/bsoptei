package wanderer;

import java.util.ArrayList;

/**
 * Created by Söp on 2016.12.05..
 */
abstract class GameObject {
    public Integer healthPoint, defensePoint, strikePoint, xPos, yPos;
    public String type;
    boolean alive;
    PositionedImage tileImage;
    public final int imageSize = 72;
    public int level;
    public boolean obstacle;

    public GameObject(String type) {
        this.type = type;
    }


    abstract void move(int deltaX, int deltaY);

    abstract void fight();

    abstract void createElementImage();

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

    public boolean isObstacle(){return obstacle;}
}