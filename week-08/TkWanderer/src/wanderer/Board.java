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
        this.setVisible(true);
    }

    public void setProperties() {
        this.setPreferredSize(new Dimension(720, 720));
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setUndecorated(true);
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
        for (GameObject enemy: gameArea.getEnemies()){
            enemy.getTileImage().draw(graphics);
        }


        graphics.setColor(Color.WHITE);
        graphics.fillRect(720, 0, 200, 720);

        graphics.setColor(Color.BLACK);
        graphics.setFont(new Font("Arial", Font.BOLD, 18));
        String levelIndicator = String.format("Level %d", Area.level);
        graphics.drawString(levelIndicator, 720, 20);
        graphics.setFont(new Font("Arial", Font.BOLD, 14));

        int textY = 50;
        for (GameObject character: gameArea.getCharacters()) {
            ArrayList<String> stats = new ArrayList<>(Arrays.asList(character.getHP(), character.getSP(), character.getDP()));
            textY += 30;
            graphics.drawString(character.getName(), 720, textY);
            for (String point : stats) {
                textY += 20;
                graphics.drawString(point, 720, textY);
            }
        }





    }

    public void setGameArea(Area gameArea){
        this.gameArea = gameArea;
    }
}