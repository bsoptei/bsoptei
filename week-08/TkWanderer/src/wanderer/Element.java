package wanderer;

/**
 * Created by Söp on 2016.12.05..
 */
abstract class Element {
    public Integer healthPoint, defensePoint, strikePoint, xPosition, yPosition;
    public String tileType;
    boolean alive;
    PositionedImage elementImage;

    abstract void moveUp();
    abstract void moveDown();
    abstract void moveLeft();
    abstract void moveRight();
    abstract void fight();
    abstract void setElementImage();

    abstract Integer getYPosition();
    abstract Integer getHealthPoint();
    abstract Integer getDefensePoint();
    abstract Integer getStrikePoint();
    abstract Integer getXPosition();
}
