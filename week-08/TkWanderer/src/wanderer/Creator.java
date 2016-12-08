package wanderer;

import javax.swing.*;

/**
 * Created by Söp on 2016.12.07. Creates and links the necessary objects
 */
class Creator {
    static Area gameArea = new Area(28, 19);
    static Hero hero = new Hero(0, 0);
    static Board drawPad = new Board();
    static GameLogic controller = new GameLogic();

    Creator() {
        createObjects();
    }

    static void createObjects() {

        gameArea.reset();

        ListenForKeyPress boardKeyListener = new ListenForKeyPress();
        controller.setHero(hero);

        drawPad.addKeyListener(boardKeyListener);
        JOptionPane.showMessageDialog(null, "Welcome");
    }

}