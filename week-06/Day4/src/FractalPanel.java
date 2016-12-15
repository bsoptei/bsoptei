import javax.swing.*;
import javax.swing.Timer;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

class FractalPanel extends JPanel {
    private int radius = 500;
    private Random randomizer = new Random();
    private int maxRandomInt = 1;

    FractalPanel() {
        this.setBackground(Color.WHITE);
        this.addMouseMotionListener(new MouseMotionListener() {
            @Override
            public void mouseDragged(MouseEvent e) {

            }

            @Override
            public void mouseMoved(MouseEvent e) {
                maxRandomInt = e.getX();
            }
        });
        createTimer();
    }

    private void setRadius(int newRadiusValue) {
        this.radius = newRadiusValue;
    }


    public void createTimer() {
        java.util.Timer gameTimer = new java.util.Timer();
        gameTimer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                setRadius(randomizer.nextInt(maxRandomInt));
                repaint();
            }
        }, 0, 50);
    }

    @Override
    public void paintComponent(Graphics g) {
//        super.paintComponents(g);
        g.setColor(Color.getHSBColor((float) Math.random(), 1, (float) Math.random()));
        g.fillOval(randomizer.nextInt(getParent().getWidth()) - (radius / 2),
                randomizer.nextInt(getParent().getHeight()) - (radius / 2), radius, radius);
        radius /= 10;
        if (radius  > 10) {
            paintComponent(g);
        }
    }
}
