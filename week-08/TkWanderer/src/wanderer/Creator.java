package wanderer;

/**
 * Created by Söp on 2016.12.07../
 */
public class Creator {
    public Board drawPad;
    public Hero hero;
    public Area gameArea;
    public static ListenForKeyPress boardKeyListener;

    public Creator() {
        createObjects();
    }

    public void createObjects() {
        hero = new Hero(0, 0);

        gameArea = new Area();
        gameArea.setHero(hero);

        hero.setGameArea(gameArea);

        boardKeyListener = new ListenForKeyPress();
        boardKeyListener.setBoard(drawPad);
        boardKeyListener.setHero(hero);

        drawPad = new Board();
        drawPad.setHero(hero);
        drawPad.setGameArea(gameArea);

        drawPad.addKeyListener(boardKeyListener);

    }

}
