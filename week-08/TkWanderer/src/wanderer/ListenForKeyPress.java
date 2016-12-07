package wanderer;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import static java.awt.event.KeyEvent.*;

/**
 * Created by Söp on 2016.12.05.. n
 */
class ListenForKeyPress implements KeyListener {
    private Board board;
    private Hero hero;
    private GameLogic controller;

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

    @Override
    public void keyReleased(KeyEvent e) {
    }

    void setBoard(Board board) {
        this.board = board;
    }

    void setHero(Hero hero) {
        this.hero = hero;
    }

    void setController(GameLogic controller) {this.controller = controller;}
}