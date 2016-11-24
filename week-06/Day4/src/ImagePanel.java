import javax.swing.*;
import java.awt.*;

/**
 * Created by Söp on 2016.11.24. ImagePanel of DrawOnImage
 */
class ImagePanel extends JPanel {

    private Image image;

    ImagePanel() {
        image = this.getToolkit().createImage("src/images.png/");
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
        g.setColor(Color.BLACK);
        g.setFont(new Font("Ariel", Font.BOLD, 12));
        g.drawString("This is a world of wonders", 40, 400);

        g.setColor(new Color(200, 28, 19));
        g.drawOval(100, 100, 200, 200);

        g.setColor(Color.BLUE);
        g.fillRect(40, 400, 150, 10);

        g.setColor(Color.YELLOW);
        g.fillOval(250, 210, 15, 15);
        g.fillOval(250, 260, 15, 15);
        g.fillOval(250, 310, 15, 15);
        g.fillOval(250, 360, 15, 15);
    }
}

