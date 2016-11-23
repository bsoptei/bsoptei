import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Söp on 2016.11.23.. UI Controls
 */
public class UIControls extends JFrame {
    private String memory = "";
    private JTextField writeYourText;
    private JLabel actualInput;
    private JLabel previousInput;
    private JButton resetMemory;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(UIControls::new);
    }

    private UIControls() {
        this.setTitle("UIControls");
        this.setSize(400, 400);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setResizable(false);
        Toolkit tk = Toolkit.getDefaultToolkit();
        Dimension dim = tk.getScreenSize();
        int xPos = (dim.width / 2) - (this.getWidth() / 2);
        int yPos = (dim.height / 2) - (this.getHeight() / 2);
        this.setLocation(xPos, yPos);
        JPanel displayPanel = new JPanel();
        this.add(displayPanel);
        writeYourText = new JTextField();
        writeYourText.setColumns(20);
        actualInput = new JLabel("Text: ");
        previousInput = new JLabel("Memory: ");
        resetMemory = new JButton("Clear memory");
        writeYourText.requestFocus();

        writeYourText.addActionListener(e -> {
            refreshFields();
            memory = writeYourText.getText();
            writeYourText.setText("");
        });

        resetMemory.addActionListener(e -> {
            memory = "";
            refreshFields();
        });

        addComponentsToPane(this.getContentPane());
        this.pack();
        this.setVisible(true);

    }


    private void addComponentsToPane(Container pane) {
        pane.setLayout(new BoxLayout(pane, BoxLayout.Y_AXIS));
        addAComponent(writeYourText, pane, Component.CENTER_ALIGNMENT);
        addAComponent(actualInput, pane, Component.LEFT_ALIGNMENT);
        addAComponent(previousInput, pane, Component.LEFT_ALIGNMENT);
        addAComponent(resetMemory, pane, Component.LEFT_ALIGNMENT);
    }

    private static void addAComponent(JComponent component, Container container, float alignment) {
        component.setAlignmentX(alignment);

        container.add(component);

    }

    private void refreshFields() {
        this.actualInput.setText("Text: " + writeYourText.getText());
        this.previousInput.setText("Memory: " + memory);
    }
}
