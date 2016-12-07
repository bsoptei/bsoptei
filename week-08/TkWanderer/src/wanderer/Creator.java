package wanderer;

/**
 * Created by Söp on 2016.12.07../
 */
class Creator {

    Creator() {
        createObjects();
    }

    private void createObjects() {
        Hero hero = new Hero(0, 0);

        Area gameArea = new Area();
        gameArea.setHero(hero);

        hero.setGameArea(gameArea);
        Board drawPad = new Board();

        ListenForKeyPress boardKeyListener = new ListenForKeyPress();
        boardKeyListener.setBoard(drawPad);
        boardKeyListener.setHero(hero);

        drawPad.setHero(hero);
        drawPad.setGameArea(gameArea);

        drawPad.addKeyListener(boardKeyListener);

    }

}