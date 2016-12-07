package wanderer;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;

public class Board extends JFrame {
    public Area gameArea;
    public Hero hero;

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
//        ListenForKeyPress boardKeyListener = new ListenForKeyPress();
//        this.addKeyListener(boardKeyListener);
//        boardKeyListener.setBoard(this);
//        boardKeyListener.setHero(hero);
    }

    public void setHero(Hero hero) {
        this.hero = hero;
    }

    @Override
    public void paint(Graphics graphics) {

        for (int i = 0; i < gameArea.getTiles().length; i++) {
            for (int j = 0; j < gameArea.getTiles()[i].length; j++) {
                gameArea.getTiles()[i][j].getTileImage().draw(graphics);
            }
        }
        hero.getTileImage().draw(graphics);
        graphics.setColor(Color.WHITE);
        graphics.fillRect(720, 0, 200, 720);

        graphics.setColor(Color.BLACK);
        graphics.setFont(new Font("Arial", Font.BOLD, 18));
        String levelIndicator = String.format("Level %d", Area.level);
        graphics.drawString(levelIndicator, 720, 20);
        graphics.setFont(new Font("Arial", Font.BOLD, 14));
        ArrayList<String> heroStats = new ArrayList<>(Arrays.asList(hero.getHP(), hero.getSP(), hero.getDP()));
        int textY = 50;
        graphics.drawString("Your hero:", 720, textY);
        for (String point : heroStats) {
            textY += 20;
            graphics.drawString(point, 720, textY);
        }

    }

    public void setGameArea(Area gameArea){
        this.gameArea = gameArea;
    }
}