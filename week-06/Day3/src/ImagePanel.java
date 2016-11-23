import javax.swing.*;
import java.awt.*;

/**
 * Created by Söp on 2016.11.23. Decorate Hasselhoff :D
 */

class ImagePanel extends JPanel {
    private Image image;

    ImagePanel() {
        image = this.getToolkit().createImage("src/David-Hasselhoff-face.jpg/");
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
    }
}