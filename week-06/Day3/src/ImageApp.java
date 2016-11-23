import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

/**
 * Created by Söp on 2016.11.23. Decorate Hasselhoff :D
 */

public class ImageApp {
    private static JFrame paintingFrame;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(ImageApp::createAndShowGUI);
    }

    private static void createAndShowGUI() {

        try {
            paintingFrame = new JFrame("ImageApp") {
                Image backgroundImage = ImageIO.read(new File("src/David-Hasselhoff-face.jpg/"));

                @Override
                public void paint(Graphics g) {
                    super.paint(g);
                    g.drawImage(backgroundImage, 0, 0, null);
                }
            };
        } catch (IOException e) {
            e.printStackTrace();
        }

        int boxW = 350;
        int boxH = 350;
        paintingFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        paintingFrame.setResizable(false);
        paintingFrame.setSize(boxW, boxH);
        Toolkit tk = Toolkit.getDefaultToolkit();
        Dimension dim = tk.getScreenSize();
        tk.beep();
        int xPos = (dim.width / 2) - (paintingFrame.getWidth() / 2);
        int yPos = (dim.height / 2) - (paintingFrame.getHeight() / 2);
        paintingFrame.setLocation(xPos, yPos);
        paintingFrame.add(new DrawPanel(boxW, boxH));
        paintingFrame.pack();
        paintingFrame.setVisible(true);
    }
}
