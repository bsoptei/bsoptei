import javax.swing.*;
import java.awt.*;

/**
 * Created by Söp on 2016.11.23. Counter App
 */
public class Counter extends JFrame {
    private int count = 0;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Counter::new);
    }

    private Counter() {
        this.setTitle("Counter");
        this.setSize(200, 100);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setResizable(false);
        Toolkit tk = Toolkit.getDefaultToolkit();
        Dimension dim = tk.getScreenSize();
        int xPos = (dim.width / 2) - (this.getWidth() / 2);
        int yPos = (dim.height / 2) - (this.getHeight() / 2);
        this.setLocation(xPos, yPos);
        JPanel panel1 = new JPanel();
        this.add(panel1);
        JButton increaseCount = new JButton();
        JButton resetCount = new JButton();
        Label counterLabel = new Label();
        panel1.setBackground(Color.CYAN);
        panel1.add(increaseCount);
        panel1.add(resetCount);
        increaseCount.setText("Press me!");
        resetCount.setText("Reset");
        refreshCount(counterLabel);
        panel1.add(counterLabel);
        increaseCount.addActionListener(e -> {
            this.count++;
            refreshCount(counterLabel);
        });

        resetCount.addActionListener(e -> {
            this.count = 0;
            refreshCount(counterLabel);
        });


        this.setVisible(true);
    }

    private void refreshCount(Label label) {
        label.setText("Pressed: " + count);
    }
}
