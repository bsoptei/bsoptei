import javax.swing.*;
import java.awt.*;


/**
 * Created by Söp on 2016.11.23.. UI Controls
 */
public class UIControls extends JFrame {
    private String memory = "";
    private String actual = "";
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
        resetMemory.setEnabled(false);

        writeYourText.addActionListener(e -> {
            if (!writeYourText.getText().equals("")) {
                this.memory = actual;
                this.actual = writeYourText.getText();
            }
            if (!memory.equals("")) {
                resetMemory.setEnabled(true);
            }
            refreshFields();
            writeYourText.setText("");
        });

        resetMemory.addActionListener(e -> {
            actual = "";
            memory = "";
            refreshFields();
            resetMemory.setEnabled(false);
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
        container.add(Box.createRigidArea(new Dimension(10, 20)));
        component.setFont(new Font("Courier New", Font.ITALIC, 12));
    }

    private void refreshFields() {
        this.actualInput.setText("Text: " + actual);
        this.previousInput.setText("Memory: " + memory);
    }
}
