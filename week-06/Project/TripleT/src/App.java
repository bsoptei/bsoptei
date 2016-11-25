import triplet.Display;
import javax.swing.*;

/**
 * Created by Söp on 2016.11.24. Triple T
 */
public class App {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(App::new);
    }

    private App() {
        new Display();
    }
}
