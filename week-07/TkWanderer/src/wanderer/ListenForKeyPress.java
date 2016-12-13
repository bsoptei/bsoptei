package wanderer;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import static java.awt.event.KeyEvent.*;

/**
 * Created by Söp on 2016.12.05.. Tracks user key events
 */
class ListenForKeyPress implements KeyListener {
    private GameLogic controller = Creator.controller;
    private Board board = Creator.board;
    private Hero hero = Creator.hero;

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        switch (key) {
            case VK_F1:
                Courier.showHelp();
                break;
            case VK_F2:
                controller.startNewGame();
                break;
            case VK_ESCAPE:
                System.exit(0);
                break;
        }
        if (hero.isAlive()) {
            switch (key) {
                case VK_SPACE:
                    controller.heroStrike();
                    break;
                case VK_LEFT:
                    controller.heroMove(-1, 0);
                    break;
                case VK_RIGHT:
                    controller.heroMove(1, 0);
                    break;
                case VK_UP:
                    controller.heroMove(0, -1);
                    break;
                case VK_DOWN:
                    controller.heroMove(0, 1);
                    break;
            }
            board.repaint();
            controller.update();
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

}