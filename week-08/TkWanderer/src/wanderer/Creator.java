package wanderer;

/**
 * Created by Söp on 2016.12.07. Creates and links the necessary objects
 */
class Creator {
    static Area gameArea = new Area();
    static Board drawPad = new Board();

    Creator() {
        createObjects();
    }

    private void createObjects() {
        Hero hero = new Hero(0, 0);

        gameArea.setHero(hero);
        gameArea.fillCharacters();

        hero.setGameArea(gameArea);


        ListenForKeyPress boardKeyListener = new ListenForKeyPress();
        boardKeyListener.setHero(hero);


        GameLogic controller = new GameLogic();

        boardKeyListener.setController(controller);

        controller.setHero(hero);

        drawPad.setHero(hero);

        drawPad.addKeyListener(boardKeyListener);

    }

}