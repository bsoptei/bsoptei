package wanderer;

/**
 * Created by Söp on 2016.12.07. Creates and links the necessary objects
 */
class Creator {
    static Area gameArea = new Area();
    static Board drawPad = new Board();
    static Hero hero = new Hero(0, 0);
    static GameLogic controller = new GameLogic();

    Creator() {
        createObjects();
    }

    private void createObjects() {


        gameArea.setHero(hero);
        gameArea.reset();

        hero.setGameArea(gameArea);


        ListenForKeyPress boardKeyListener = new ListenForKeyPress();
        boardKeyListener.setHero(hero);




//        boardKeyListener.setController(controller);

        controller.setHero(hero);

        drawPad.setHero(hero);

        drawPad.addKeyListener(boardKeyListener);

    }

}