package wanderer;

import java.util.ArrayList;

/**
 * Created by Söp on 2016.12.05..
 */
abstract class GameObject {
    public Integer healthPoint, defensePoint, strikePoint, xPosition, yPosition;
    public String type;
    boolean alive;
    PositionedImage elementImage;
    public final int imageSize = 72;
    public int level;


    abstract void move(int deltaX, int deltaY);
    abstract void fight();
    abstract void setElementImage();
    abstract void setStartingStats();
    abstract ArrayList<GameElement> inspectNeighbors();

    abstract Integer getXPosition();
    abstract Integer getYPosition();
    abstract Integer getHealthPoint();
    abstract Integer getDefensePoint();
    abstract Integer getStrikePoint();
    abstract GameElement getNeighbor();
    abstract  PositionedImage getTileImage();
}
