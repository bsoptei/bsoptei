import javax.swing.*;
import java.awt.*;

/**
 * Created by Söp on 2016.11.23.. Image App :)
 */
public class ImageApp extends JFrame {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(ImageApp::new);
    }

    private ImageApp() {
        Toolkit.getDefaultToolkit().createImage("image.jpg");


    }




}
