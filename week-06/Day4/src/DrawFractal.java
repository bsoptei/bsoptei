import javax.swing.*;

/**
 * Created by Söp on 2016.11.24. Draw a fractal
 */
public class DrawFractal extends JFrame {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(DrawFractal::new);
    }

    private DrawFractal() {
        this.setTitle("Draw Fractal");
        this.setSize(500, 500);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        JPanel myPanel = new JPanel();
        this.add(myPanel);
        FractalPanel fp = new FractalPanel();
        this.add(fp);
        this.setVisible(true);
    }
}
