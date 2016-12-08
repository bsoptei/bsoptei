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
    private int posX, posY;

    PositionedImage(String filename, int posX, int posY) {
        this.posX = posX;
        this.posY = posY;
        try {
            image = ImageIO.read(new File(filename));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void draw(Graphics graphics) {
        if (image != null) {
            graphics.drawImage(image, posX, posY, imageSize, imageSize, null);
        }
    }

    void setPosX(int posX) {
        this.posX = posX;
    }

    void setPosY(int posY) {
        this.posY = posY;
    }
}