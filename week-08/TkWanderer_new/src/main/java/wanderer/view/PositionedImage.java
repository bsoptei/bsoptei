package wanderer.view;

import wanderer.core.GameImage;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by Söp on 2016.12.05. Images of game objects
 */
class PositionedImage implements GameImage {
    private static int imageSize = 40;
    private BufferedImage image;
    private int xPos, yPos;

    PositionedImage(String filename, int xPos, int yPos) {
        this.xPos = xPos;
        this.yPos = yPos;
        try {
            image = ImageIO.read(new File(filename));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void setSource(String source) {

    }

    @Override
    public void setXPos(int xPos) {
        this.xPos = xPos;
    }

    @Override
    public void setYPos(int yPos) {
        this.yPos = yPos;
    }

    @Override
    public int getXPos() {
        return xPos;
    }

    @Override
    public int getYPos() {
        return yPos;
    }

    @Override
    public void showImage() {
    }

    BufferedImage getImage() {
        return image;
    }
}