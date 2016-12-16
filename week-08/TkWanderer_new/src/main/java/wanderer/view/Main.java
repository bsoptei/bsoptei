package wanderer.view;

import wanderer.core.GameGUI;
import wanderer.core.GameLogic;

/**
 * Created by Söp on 2016.12.05. Starts the game
 */
public class Main {

    public static void main(String[] args) {
        GameLogic gameModel = new GameLogic(29, 18);
        gameModel.reset();
        Controller boardKeyListener = new Controller(gameModel);
        GameGUI board = new Board(gameModel.getTiles(), gameModel.getPlayers(), boardKeyListener);
        board.showMessage("Welcome to my maze!\nNeed help? Press F1 any time during the game.");
        gameModel.linkGameLogicToViewer(board);
        board.showDisplay();
    }

}

