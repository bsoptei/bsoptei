package wanderer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import static java.awt.event.KeyEvent.*;

public class Board extends JFrame {
    public Integer xPos = 0;
    public Integer yPos = 0;
    public Area gameArea = new Area();

    public Board() {
        JPanel statPanel = new JPanel();
        this.setPreferredSize(new Dimension(720, 720));
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.add(statPanel);
        xPos = 0;
        yPos = 0;
        addKeyListenerToBoard();
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setUndecorated(true);
        this.setVisible(true);
    }

    private void addKeyListenerToBoard() {
        this.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }
            @Override
            public void keyPressed(KeyEvent e) {
                int key = e.getKeyCode();
                switch (key) {
                    case VK_ESCAPE:
                        System.exit(0);
                    case VK_SPACE:
                        break;
                    case VK_LEFT:
                        xPos -= 72;
                        break;
                    case VK_RIGHT:
                        xPos += 72;
                        break;
                    case VK_UP:
                        yPos -= 72;
                        break;
                    case VK_DOWN:
                        yPos += 72;
                        break;
                }
                repaint();
            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });
    }

    @Override
    public void paint(Graphics graphics) {
        for( GameElement gameElement : gameArea.getGameElements()) {
            gameElement.getTileImage().draw(graphics);
        }
        PositionedImage hero = new PositionedImage("src/wanderer/image/hero-down.png", xPos, yPos);
        hero.draw(graphics);
    }
}