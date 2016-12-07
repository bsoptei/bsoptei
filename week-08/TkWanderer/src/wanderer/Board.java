package wanderer;

import javax.swing.*;
import java.awt.*;

public class Board extends JFrame {
    public Area gameArea = new Area();
    public Hero hero = gameArea.getHero();

    public Board() {
        setProperties();

        addKeyListenerToBoard();

        this.setVisible(true);
    }

    public void setProperties() {
        this.setPreferredSize(new Dimension(720, 720));
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setUndecorated(true);
    }

    private void addKeyListenerToBoard() {
        ListenForKeyPress boardKeyListener = new ListenForKeyPress();
        this.addKeyListener(boardKeyListener);
        boardKeyListener.setBoard(this);
        boardKeyListener.setGameObject(hero);
    }

    @Override
    public void paint(Graphics graphics) {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                gameArea.getTiles()[i][j].getTileImage().draw(graphics);
            }
        }

        hero.getTileImage().draw(graphics);

    }
}