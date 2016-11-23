import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

class DrawPanel extends JPanel {

    private int squareX = 0;
    private int squareY = 0;
    private int squareW = 0;
    private int squareH = 0;

    DrawPanel(int W, int H) {
        this.setPreferredSize(new Dimension(W, H));
        this.setBackground(Color.white);
        addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                moveSquare(e.getX(), e.getY());
            }
        });

        addMouseMotionListener(new MouseAdapter() {
            public void mouseDragged(MouseEvent e) {
                moveSquare(e.getX(), e.getY());
            }
        });
    }

    private void moveSquare(int x, int y) {
        int OFFSET = 1;
        squareH = 5;
        squareW = 5;
        if ((squareX != x) || (squareY != y)) {
            squareX = x;
            squareY = y;
            repaint(squareX, squareY, squareW + OFFSET, squareH + OFFSET);
        }
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.BLACK);
        g.fillRect(squareX, squareY, squareW, squareH);
        g.setColor(Color.BLACK);
        g.drawRect(squareX, squareY, squareW, squareH);
    }
}