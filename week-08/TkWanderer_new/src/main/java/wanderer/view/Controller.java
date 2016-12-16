package wanderer.view;

import wanderer.core.GameLogic;
import wanderer.core.Hero;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import static java.awt.event.KeyEvent.*;

/**
 * Created by Söp on 2016.12.05.. Tracks user key events
 */
class Controller implements KeyListener {
    private GameLogic gameLogic;

    Controller(GameLogic gameLogic) {
        this.gameLogic = gameLogic;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        switch (key) {
            case VK_F1:
                gameLogic.showHelp();
                break;
            case VK_F2:
                gameLogic.startNewGame();
                break;
            case VK_ESCAPE:
                System.exit(0);
                break;
            case VK_SPACE:
                gameLogic.heroStrike();
                break;
            case VK_LEFT:
                gameLogic.heroMove(-1, 0);
                break;
            case VK_RIGHT:
                gameLogic.heroMove(1, 0);
                break;
            case VK_UP:
                gameLogic.heroMove(0, -1);
                break;
            case VK_DOWN:
                gameLogic.heroMove(0, 1);
                break;
        }
        gameLogic.update();
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

}