package wanderer;

/**
 * Created by Söp on 2016.12.07../
 */
public class Creator {
    public Board drawPad;
    public  GameObject hero;
    public  Area gameArea;
    public static ListenForKeyPress boardKeyListener;

    public Creator(){
        createObjects();
    }

    public  void createObjects() {
        drawPad = new Board();
        hero = new Hero(0, 0);

    }

}
