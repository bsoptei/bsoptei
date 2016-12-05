package wanderer;

/**
 * Created by Söp on 2016.12.05..
 */
public class GameElement {
    public PositionedImage tileImage;
    public int xPos, yPos;
    public String tileType;
    public final int imageSize = 72;


    public GameElement(int xPos, int yPos, String tileType) {
        this.xPos = xPos;
        this.yPos = yPos;
        this.tileType = tileType;
        setElementImage();
    }

    public void setElementImage() {
        int x = xPos * imageSize;
        int y = yPos * imageSize;
        this.tileImage = (tileType == "F") ? new PositionedImage("src/wanderer/image/floor.png", x, y) :
                new PositionedImage("src/wanderer/image/wall.png", x, y );
    }

    public PositionedImage getTileImage() {
        return tileImage;
    }
}
