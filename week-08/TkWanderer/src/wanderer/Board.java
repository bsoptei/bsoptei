package wanderer;

import javax.swing.*;
import java.awt.*;

class Board extends JFrame implements GameMeetingPoint{
    private Hero hero;

    Board() {
        setProperties();
        this.setVisible(true);
    }

    private void setProperties() {
        this.setPreferredSize(new Dimension(720, 720));
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
        graphics.setColor(Color.WHITE);
        graphics.fillRect(720, 0, 200, 720);

        graphics.setColor(Color.BLACK);
        graphics.setFont(new Font("Arial", Font.BOLD, 18));
        String levelIndicator = String.format("Area %d", Area.level);
        graphics.drawString(levelIndicator, 720, 20);
        graphics.setFont(new Font("Arial", Font.BOLD, 14));

        int textY = 50;
        for (GameObject character : gameArea.getCharacters()) {
            if (character.isAlive()) {

                character.getTileImage().draw(graphics);
                graphics.drawString(character.getName(), 720, textY);
                textY += 30;
                if (character.equals(hero)) {
                    graphics.drawString(String.format("Level %d", hero.getHeroLevel()), 720, textY);
                    textY += 20;
                }
                graphics.drawString(character.getStats(), 720, textY);
                textY += 30;
            }
        }
    }
}