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

    private void setRadius(int newRadiusValue) {
        this.radius = newRadiusValue;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponents(g);
        g.setColor(Color.getHSBColor((float)Math.random(),1,(float)Math.random()));
        g.fillOval(randomizer.nextInt(getParent().getWidth()) - (radius / 2),
                randomizer.nextInt(getParent().getHeight()) - (radius / 2), radius, radius);
        radius -= 1;
        if (radius - 10 > 0) {
            paintComponent(g);
        }
    }
}
