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

    public GameObject(String type){
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

    abstract Integer getHealthPoint();

    abstract Integer getDefensePoint();

    abstract Integer getStrikePoint();

    abstract GameElement getNeighbor();

    abstract PositionedImage getTileImage();

    public String getType() {
        return type;
    }

}
