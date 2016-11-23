import javax.swing.*;
import java.awt.*;

public class ImageAppNew extends JFrame {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(ImageAppNew::new);
    }

    private ImageAppNew(){
        this.setTitle("DrawApp - New");
        this.setSize(400,400);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setResizable(true);
        Toolkit tk = Toolkit.getDefaultToolkit();
        Dimension dim = tk.getScreenSize();
        int xPos = (dim.width / 2) - (this.getWidth() / 2);
        int yPos = (dim.height / 2) - (this.getHeight() / 2);
        this.setLocation(xPos, yPos);
        ImagePanel iPanel = new ImagePanel();
        this.add(iPanel);
        this.setVisible(true);
    }
}