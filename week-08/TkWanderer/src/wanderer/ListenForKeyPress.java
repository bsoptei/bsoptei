package wanderer;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import static java.awt.event.KeyEvent.*;

/**
 * Created by Söp on 2016.12.05.. Tracks user key events
 */
class ListenForKeyPress implements KeyListener, GameMeetingPoint {

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        if (hero.isAlive()) {
            switch (key) {
                case VK_SPACE:
                    hero.strike();
                    break;
                case VK_LEFT:
                    hero.move(-1, 0);
                    break;
                case VK_RIGHT:
                    hero.move(1, 0);
                    break;
                case VK_UP:
                    hero.move(0, -1);
                    break;
                case VK_DOWN:
                    hero.move(0, 1);
                    break;
            }
            board.repaint();
            controller.update();
        }
        if (key == VK_ESCAPE) {
            System.exit(0);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

}