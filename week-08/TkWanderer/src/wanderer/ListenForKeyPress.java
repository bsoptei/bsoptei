package wanderer;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import static java.awt.event.KeyEvent.*;

/**
 * Created by Söp on 2016.12.05.. n
 */
public class ListenForKeyPress implements KeyListener {
    private Board board;
    private Hero hero;

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
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public void setGameObject(Hero hero ) {
        this.hero = hero;
    }
}
