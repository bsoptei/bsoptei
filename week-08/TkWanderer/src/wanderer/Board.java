package wanderer;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;

class Board extends JFrame {
    private final String fontFamily = "Courier New";
    private static int imageSize = Creator.imageSize;
    private Area gameArea = Creator.gameArea;

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
        int textX = gameArea.getWidth() * imageSize;
        int textY = 50;
        int statsPanelWidth = 300;
        drawPanel(graphics, textX, statsPanelWidth);
        drawTextOnPanel(graphics, textX, textY);
        drawPlayers(graphics, textX, textY);
    }

    private void drawTiles(Graphics graphics) {
        for (int i = 0; i < gameArea.getTiles().length; i++) {
            for (int j = 0; j < gameArea.getTiles()[i].length; j++) {
                gameArea.getTiles()[i][j].getGameObjectImage().draw(graphics);
            }
        }
    }

    private void drawPanel(Graphics graphics, int textX, int statsPanelWidth) {
        int statsPanelHeight = gameArea.getHeight() * imageSize;
        graphics.setColor(Color.BLACK);
        graphics.fillRect(textX, 0, statsPanelWidth, statsPanelHeight);
    }

    private void drawTextOnPanel(Graphics graphics, int textX, int textY) {
        graphics.setColor(Color.YELLOW);
        graphics.setFont(new Font(fontFamily, Font.BOLD, 18));
        String levelIndicator = String.format("Area %d", Area.level);
        graphics.drawString(levelIndicator, textX, 20);
    }

    private void drawPlayers(Graphics graphics, int textX, int textY) {
        graphics.setFont(new Font(fontFamily, Font.BOLD, 12));
        for (GameObject player : gameArea.getPlayers()) {
            if (player.isAlive()) {
                drawPlayerImage(graphics, player);
                ArrayList<String> stats = new ArrayList<>(Arrays.asList(player.getName(),
                        player.levelToString(), player.statsToString()));
                for (String stat : stats) {
                    graphics.drawString(stat, textX, textY);
                    textY += (stat.equals("")) ? 0 : 15;
                }
            }
        }
    }

    private void drawPlayerImage(Graphics graphics, GameObject player) {
        player.getGameObjectImage().draw(graphics);
    }
}