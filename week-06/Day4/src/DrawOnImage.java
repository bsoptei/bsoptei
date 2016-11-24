import javax.swing.*;

/**
 * Created by Söp on 2016.11.24. DrawOnImage
 */
public class DrawOnImage extends JFrame {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(DrawOnImage::new);
    }

    private DrawOnImage(){
        this.setTitle("Draw On Image");
        this.setSize(500, 500);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        JPanel myPanel = new JPanel();
        this.add(myPanel);
        JMenuBar menuBar = new JMenuBar();
        JMenu menuFile = new JMenu("File");
        JMenu menuSwing = new JMenu("Swing");
        JMenu menuExtra = new JMenu("Extra");
        JMenuItem menuItemExit = new JMenuItem("Exit");
        menuFile.add(menuItemExit);
        menuBar.add(menuFile);
        menuBar.add(menuSwing);
        menuBar.add(menuExtra);
        this.setJMenuBar(menuBar);
        menuItemExit.addActionListener(e -> System.exit(0));
        ImagePanel imagePanel = new ImagePanel();
        this.add(imagePanel);


        this.setVisible(true);
    }
}
