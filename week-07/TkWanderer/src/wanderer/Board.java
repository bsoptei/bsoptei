package wanderer;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;

class Board extends JFrame {
    private final String fontFamily = "Courier New";
    private static int imageSize = Creator.imageSize;
    private Area gameArea = Creator.gameArea;
    private Hero hero = Creator.hero;
    private int textX, textY;

    Board() {
        initProperties();
        this.setVisible(true);
    }

    private void initProperties() {
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setUndecorated(true);
    }

    @Override
    public void paint(Graphics graphics) {
        drawTiles(graphics);
        textX = gameArea.getWidth() * imageSize;
        textY = 50;
        int statsPanelWidth = 300;
        drawPanel(graphics, statsPanelWidth);
        drawTextOnPanel(graphics);
        drawPlayers(graphics);
    }

    private void drawTiles(Graphics graphics) {
        for (int i = 0; i < gameArea.getTiles().length; i++) {
            for (int j = 0; j < gameArea.getTiles()[i].length; j++) {
                gameArea.getTiles()[i][j].getGameObjectImage().paint(graphics);
            }
        }
    }

    private void drawPanel(Graphics graphics, int statsPanelWidth) {
        int statsPanelHeight = gameArea.getHeight() * imageSize;
        graphics.setColor(Color.BLACK);
        graphics.fillRect(textX, 0, statsPanelWidth, statsPanelHeight);
    }

    private void drawTextOnPanel(Graphics graphics) {
        graphics.setColor(Color.YELLOW);
        graphics.setFont(new Font(fontFamily, Font.BOLD, 18));
        String levelIndicator = String.format("Area %d", Area.level);
        graphics.drawString(levelIndicator, textX, 20);
    }

    private void drawPlayers(Graphics graphics) {
        graphics.setFont(new Font(fontFamily, Font.BOLD, 12));
        gameArea.getPlayers().stream().filter(GameObject::isAlive).forEach(player ->
                drawPlayerImage(graphics, player));
        drawPlayerStats(graphics,hero);
        if (hero.getCurrentOpponent() != null) {
            drawPlayerStats(graphics, hero.getCurrentOpponent());
        }
    }

    private void drawPlayerStats(Graphics graphics, GameObject player) {
        ArrayList<String> stats = new ArrayList<>(Arrays.asList(player.getName(),
                player.levelToString(), player.statsToString()));
        for (String stat : stats) {
            graphics.drawString(stat, textX, textY);
            textY += (stat.equals("")) ? 0 : 15;
        }
    }

    private void drawPlayerImage(Graphics graphics, GameObject player) {
        player.getGameObjectImage().paint(graphics);
    }
}