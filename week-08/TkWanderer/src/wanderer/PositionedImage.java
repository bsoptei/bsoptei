package wanderer;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by Söp on 2016.12.05. Image manager for game objects
 */
class PositionedImage implements GameMeetingPoint {
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

    void draw(Graphics graphics) {
        if (image != null) {
            graphics.drawImage(image, xPos, yPos, imageSize, imageSize, null);
        }
    }

    void setXPos(int xPos) {
        this.xPos = xPos;
    }

    void setYPos(int yPos) {
        this.yPos = yPos;
    }
}