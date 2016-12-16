package wanderer.view;

import wanderer.core.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Arrays;

class Board extends JFrame implements GameGUI {
    private final String fontFamily = "Courier New";
    private static int imageSize = 40;
    private int mapWidth, mapHeight, textX, textY, areaLevel;
    private Tile[][] map;
    private ArrayList<GameObject> players;
    private Hero hero;

    Board(Tile[][] map, ArrayList<GameObject> players, KeyListener gameKeyListener) {
        this.map = map;
        this.players = players;
        this.addKeyListener(gameKeyListener);
        initProperties();
    }

    public void initProperties() {
        hero = (Hero) players.get(0);
        areaLevel = 1;
        setMapWidth(map.length);
        setMapHeight(map[0].length);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setUndecorated(true);
    }

    public void showDisplay() {
        this.setVisible(true);
    }

    @Override
    public GameImage getImage(String source, int x, int y) {
        return new PositionedImage(source, x, y);
    }

    @Override
    public void setPlayers(ArrayList<GameObject> players) {
        this.players = players;
    }

    @Override
    public GameAudioPlayer getAudioPlayer() {
        return new AudioPlayer();
    }

    @Override
    public void update() {
        repaint();
    }

    @Override
    public void showMessage(String message) {
        JOptionPane.showMessageDialog(this, message);
    }

    @Override
    public void setMapWidth(int width) {
        mapWidth = width;
    }

    @Override
    public void setMapHeight(int height) {
        mapHeight = height;
    }

    @Override
    public void setAreaLevel(int areaLevel) {
        this.areaLevel = areaLevel;
    }

    @Override
    public void setMap(Tile[][] map) {
        this.map = map;
    }

    @Override
    public void paint(Graphics graphics) {
        drawTiles(graphics);
        textX = mapWidth * imageSize;
        textY = 50;
        int statsPanelWidth = 300;
        drawPanel(graphics, statsPanelWidth);
        drawTextOnPanel(graphics);
        drawPlayers(graphics);
    }

    private void drawTiles(Graphics graphics) {
        for (Tile[] tileRow : map) {
            for (Tile tile : tileRow) {
                drawImage(graphics, tile);
            }
        }
    }

    private void drawPanel(Graphics graphics, int statsPanelWidth) {
        int statsPanelHeight = mapHeight * imageSize;
        graphics.setColor(Color.BLACK);
        graphics.fillRect(textX, 0, statsPanelWidth, statsPanelHeight);
    }

    private void drawTextOnPanel(Graphics graphics) {
        graphics.setColor(Color.YELLOW);
        graphics.setFont(new Font(fontFamily, Font.BOLD, 18));
        String levelIndicator = String.format("Area %d", areaLevel);
        graphics.drawString(levelIndicator, textX, 20);
    }

    private void drawPlayers(Graphics graphics) {
        graphics.setFont(new Font(fontFamily, Font.BOLD, 12));
        players.stream().filter(GameObject::isAlive).forEach(player ->
                drawImage(graphics, player));
        drawPlayerStats(graphics, hero);
        if (hero.getCurrentOpponent() != null) {
            drawPlayerStats(graphics, hero.getCurrentOpponent());
        }
    }

    private void drawPlayerStats(Graphics graphics, GameObject player) {
        ArrayList<String> stats = new ArrayList<>(Arrays.asList(player.getName(),
                player.levelToString(), player.statsToString()));
        if (player.isAlive()) {
            for (String stat : stats) {
                graphics.drawString(stat, textX, textY);
                textY += (stat.equals("")) ? 0 : 15;
            }
        }
    }

    private void drawImage(Graphics graphics, GameObject gameObject) {
        PositionedImage imageToDraw = (PositionedImage) gameObject.getGameObjectImage();
        graphics.drawImage(imageToDraw.getImage(), imageToDraw.getXPos(), imageToDraw.getYPos(), imageSize, imageSize, null);
    }
}