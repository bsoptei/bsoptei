import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Created by Söp on 2016.11.24. Event Counter
 */
public class EventCounter extends JFrame {
    private int keyCount, mouseCount, windowCount;
    private JLabel keyEventCounter, mouseEventCounter, windowEventCounter;
    private JPanel panel1;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(EventCounter::new);
    }

    private EventCounter() {
        this.setTitle("Counter");
        this.setSize(400, 400);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setResizable(false);
        Toolkit tk = Toolkit.getDefaultToolkit();
        Dimension dim = tk.getScreenSize();
        int xPos = (dim.width / 2) - (this.getWidth() / 2);
        int yPos = (dim.height / 2) - (this.getHeight() / 2);
        this.setLocation(xPos, yPos);
        panel1 = new JPanel();
        this.add(panel1);

        JTextField userText = new JTextField(30);
        mouseEventCounter = new JLabel();
        keyEventCounter = new JLabel();
        windowEventCounter = new JLabel();

        panel1.add(userText);
        panel1.add(keyEventCounter);
        panel1.add(mouseEventCounter);
        panel1.add(windowEventCounter);

        ListenForKeys userTextKeyListener = new ListenForKeys();
        userText.addKeyListener(userTextKeyListener);

        ListenForMouse frameMouseListener = new ListenForMouse();
        this.addMouseListener(frameMouseListener);

        ListenForWindow frameWindowListener = new ListenForWindow();
        this.addWindowListener(frameWindowListener);

        this.setVisible(true);
        setInitialBackground();
        refreshCount();

    }

    private class ListenForKeys implements KeyListener {

        @Override
        public void keyTyped(KeyEvent e) {

        }

        @Override
        public void keyPressed(KeyEvent e) {
            keyCount++;
            refreshCount();
        }

        @Override
        public void keyReleased(KeyEvent e) {
        }
    }

    private class ListenForMouse implements MouseListener {

        public void mouseClicked(MouseEvent e) {
            mouseCount++;
            refreshCount();
        }

        public void mouseEntered(MouseEvent arg0) {
            panel1.setBackground(Color.YELLOW);
        }

        public void mouseExited(MouseEvent arg0) {
            setInitialBackground();
        }

        public void mousePressed(MouseEvent arg0) {
        }

        public void mouseReleased(MouseEvent arg0) {
        }

    }

    private class ListenForWindow implements WindowListener {

        @Override
        public void windowOpened(WindowEvent e) {
            generalWindowEvent();
        }

        @Override
        public void windowClosing(WindowEvent e) {
            generalWindowEvent();
        }

        @Override
        public void windowClosed(WindowEvent e) {
            generalWindowEvent();
        }

        @Override
        public void windowIconified(WindowEvent e) {
            generalWindowEvent();
        }

        @Override
        public void windowDeiconified(WindowEvent e) {
            generalWindowEvent();
        }

        @Override
        public void windowActivated(WindowEvent e) {
            generalWindowEvent();
        }

        @Override
        public void windowDeactivated(WindowEvent e) {
            generalWindowEvent();
        }

        void generalWindowEvent() {
            windowCount++;
            refreshCount();
        }
    }

    private void refreshCount() {
        keyEventCounter.setText("Number of key events: " + keyCount);
        mouseEventCounter.setText("Number of mouse clicks: " + mouseCount);
        windowEventCounter.setText("Number of window events: " + windowCount);
    }

    private void setInitialBackground() {
        panel1.setBackground(Color.ORANGE);
    }
}
