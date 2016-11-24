import javax.swing.*;
/**
 * Created by Söp on 2016.11.24. Wrapper
 */
public class WrapperApp extends JFrame  {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(WrapperApp::new);
    }

    private WrapperApp() {
        this.setTitle("Wrapper App");
        this.setSize(500, 500);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        JPanel myPanel = new JPanel();
        this.add(myPanel);
        JMenuBar menuBar = new JMenuBar();
        JMenu menuFile = new JMenu();
        JMenuItem menuItemExit = new JMenuItem();
        menuFile.setText("File");
        menuItemExit.setText("Exit");
        menuFile.add(menuItemExit);
        menuBar.add(menuFile);
        this.setJMenuBar(menuBar);
        menuItemExit.addActionListener(e -> System.exit(0));
        this.setVisible(true);
    }

}
