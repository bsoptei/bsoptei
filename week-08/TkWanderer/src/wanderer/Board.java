package wanderer;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;

class Board extends JFrame implements GameMeetingPoint{
    private Hero hero;

    Board() {
        setProperties();
        this.setVisible(true);
    }

    private void setProperties() {
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setUndecorated(true);
    }

    void setHero(Hero hero) {
        this.hero = hero;
    }

    @Override
    public void paint(Graphics graphics) {

        for (int i = 0; i < gameArea.getTiles().length; i++) {
            for (int j = 0; j < gameArea.getTiles()[i].length; j++) {
                gameArea.getTiles()[i][j].getTileImage().draw(graphics);
            }
        }
        int textX = gameArea.getWidth() * imageSize;
        int statsPanelWidth = 300;
        int statsPanelHeight = gameArea.getHeight() * imageSize;

        graphics.setColor(Color.WHITE);

        graphics.fillRect(textX, 0, statsPanelWidth, statsPanelHeight);

        graphics.setColor(Color.BLACK);
        graphics.setFont(new Font("Arial", Font.BOLD, 18));
        String levelIndicator = String.format("Area %d", Area.level);
        graphics.drawString(levelIndicator, textX, 20);
        graphics.setFont(new Font("Arial", Font.BOLD, 14));

        int textY = 50;
        for (GameObject character : gameArea.getCharacters()) {
            if (character.isAlive()) {
                ArrayList<String> stats = new ArrayList<>(Arrays.asList(character.getName(),
                        character.getLevelToString(), character.getStats()));
                character.getTileImage().draw(graphics);
                for (String stat:stats) {
                    graphics.drawString(character.getName(), textX, textY);
                    textY += (stat.equals(""))? 0: 30;
                }
            }
        }
    }
}