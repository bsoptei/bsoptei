package wanderer;

import java.util.Random;

/**
 * Created by Söp on 2016.12.07. Creates the necessary objects
 */
class Creator {
    static final int imageSize = 40;
    static Hero hero = new Hero(0, 0);
    static Area gameArea = new Area(29, 18, hero);
    static Board board = new Board();
    static GameLogic controller = new GameLogic();
    private static ListenForKeyPress boardKeyListener = new ListenForKeyPress();

    static void initialize() {
        gameArea.reset();
        board.addKeyListener(boardKeyListener);
        Courier.showWelcome();
    }
}