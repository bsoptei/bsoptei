import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * Created by Söp on 2016.11.24. Complex Layout
 */
public class ComplexLayout extends JFrame {
    private ArrayList<JButton> rightTop = new ArrayList<>();
    private ArrayList<JButton> rightOthers = new ArrayList<>();

    public static void main(String[] args) {
        SwingUtilities.invokeLater(ComplexLayout::new);
    }

    private ComplexLayout() {
        Container pane = getContentPane();
        pane.setLayout(new FlowLayout());

        ArrayList<JButton> leftButtons = new ArrayList<>();
        leftButtons.add(new JButton("1.1"));
        leftButtons.add(new JButton("1.2"));
        leftButtons.add(new JButton("1.3"));
        pane.add(getGridPanel(leftButtons, 3, 1));
        pane.add(getRightPanel());
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setSize(300, 300);
        this.setVisible(true);
    }

    private JComponent getGridPanel(ArrayList<JButton> buttonsToAdd, int rows, int columns) {
        JPanel inner = new JPanel();
        inner.setLayout(new GridLayout(rows, columns, 10, 50));
        buttonsToAdd.forEach(inner::add);
        return inner;
    }

    private JComponent getRightPanel() {
        JPanel inner = new JPanel();
        inner.setLayout(new BorderLayout(10, 50));
        rightTop.add(new JButton("2. Top"));
        rightOthers.add(new JButton("2. Left"));
        rightOthers.add(new JButton("2. Right"));
        inner.add(getGridPanel(rightTop, 1, 1), BorderLayout.NORTH);
        inner.add(getGridPanel(rightOthers, 1, 2), BorderLayout.SOUTH);
        return inner;
    }
}