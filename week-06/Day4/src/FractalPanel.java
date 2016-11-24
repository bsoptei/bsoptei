import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

class FractalPanel extends JPanel {
    private int radius = 500;
    private Random randomizer = new Random();

    FractalPanel() {
        this.setBackground(Color.WHITE);

        this.addMouseMotionListener(new MouseMotionListener() {
            @Override
            public void mouseDragged(MouseEvent e) {
            }
            @Override
            public void mouseMoved(MouseEvent e) {
                setRadius(e.getX());
                repaint();
            }
        });
    }

    public void setRadius(int newRadiusValue) {
        this.radius = newRadiusValue;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponents(g);
        g.setColor(Color.getHSBColor((float) randomizer.nextInt(2550),
                (float) randomizer.nextInt(2550), (float) randomizer.nextInt(2550)));
        g.fillOval(randomizer.nextInt(500) - (radius / 2), randomizer.nextInt(500) - (radius / 2), radius, radius);
        radius -= 1;
        if (radius - 10 > 0) {
            paintComponent(g);
        }

    }
}
