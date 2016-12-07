package wanderer;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import static java.awt.event.KeyEvent.*;

/**
 * Created by Söp on 2016.12.05..
 */
public class ListenForKeyPress implements KeyListener {
    private Board board;
    private GameObject objectToMove;

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
                objectToMove.move(-1, 0);
                break;
            case VK_RIGHT:
                objectToMove.move(1, 0);
                break;
            case VK_UP:
                objectToMove.move(0, -1);
                break;
            case VK_DOWN:
                objectToMove.move(0, 1);
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

    public void setGameObject(GameObject objectToMove) {
        this.objectToMove = objectToMove;
    }
}
