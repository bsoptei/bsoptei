package wanderer.core;

/**
 * Created by Söp on 2016.12.10.. Interface for images
 */
public interface GameImage {

    void setSource(String source);

    void setXPos(int xPos);

    void setYPos(int yPos);

    int getXPos();

    int getYPos();

    void showImage();

}
