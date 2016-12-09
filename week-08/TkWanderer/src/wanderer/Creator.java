package wanderer;

/**
 * Created by Söp on 2016.12.07. Creates the necessary objects
 */
class Creator {
    static Area gameArea = new Area(5, 5);
    static Hero hero = new Hero(0, 0);
    static Board board = new Board();
    static GameLogic controller = new GameLogic();
    private static ListenForKeyPress boardKeyListener = new ListenForKeyPress();

    static void initialize() {
        gameArea.reset();
        board.addKeyListener(boardKeyListener);
        board.showWelcome();
    }
}