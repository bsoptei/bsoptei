package wanderer.core;

import lombok.Data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

/**
 * Created by Söp on 2016.12.05.. This is where all things actually happen
 */
@Data
public class GameLogic {
    private int width, height;
    private Tile[][] tiles;
    private ArrayList<GameObject> enemies = new ArrayList<>();
    private ArrayList<GameObject> players = new ArrayList<>();
    private ArrayList<GameObject> allGameObjects = new ArrayList<>();
    private Random dice = new Random();
    private Hero hero = new Hero(0, 0);
    private StringBuilder[][] playerPositions;
    private GameObject battleEnemy;
    private static int areaLevel = 1;
    private GameAudioPlayer areaAudioPlayer;
    private GameGUI viewer;

    public GameLogic(int width, int height) {
        this.width = width;
        this.height = height;
        tiles = new Tile[width][height];
        playerPositions = new StringBuilder[width][height];
    }


    public void reset() {
        hero.reset();
        generateMap();
        enemies.clear();
        players.clear();
        generateEnemies();
        administerPlayers();
        addPlayersToAllGameObjects();
    }

    private void addPlayersToAllGameObjects() {
        allGameObjects.addAll(players);
    }

    private void administerPlayers() {
        players.add(hero);
        players.addAll(enemies);
        for (GameObject player : players) {
            player.setHero(hero);
            player.setMap(tiles);
            player.setMapWidth(width);
            player.setMapHeight(height);
        }
    }

    private void generateEnemies() {
        int numberOfEnemies = dice.nextInt(4) + 3;
        while (enemies.size() < numberOfEnemies) {
            int xPos = dice.nextInt(width - 1) + 1;
            int yPos = dice.nextInt(height - 1) + 1;
            if (!tiles[xPos][yPos].isObstacle()) {
                if (enemies.size() == numberOfEnemies - 1) {
                    enemies.add(new Boss(xPos, yPos, areaLevel));
                } else if (enemies.size() == numberOfEnemies - 2) {
                    enemies.add(new Skeleton(xPos, yPos, areaLevel, true));
                } else {
                    enemies.add(new Skeleton(xPos, yPos, areaLevel, false));
                }
            }
        }
    }

    private void generateMap() {
        Maze gameMaze = new Maze(width, height);
        tiles = gameMaze.generate();
        for (Tile[] tileRow : tiles) {
            Collections.addAll(allGameObjects, tileRow);
        }
    }

    private boolean isInSamePosition() {
        boolean samePosition = false;
        for (int i = 0; i < enemies.size(); i++) {
            if (enemies.get(i).isAlive() &&
                    Arrays.equals(enemies.get(i).getCoordinates(), hero.getCoordinates())) {
                identifyEnemy(i);

                samePosition = true;
            }
        }
        return samePosition;
    }


    public void update() {
        viewer.update();

        if (hero.getNumberOfMoves() % 2 == 0) {
            moveEnemiesRandomly();
        }
        if (bossIsKilled() && keyHolderIsKilled()) {
            newArea(areaLevel + 1);
            viewer.showMessage("Congrats! You have cleared the area!\n Get ready for the next one!");
        }
        if (isInSamePosition()) {
            getBattleEnemy().strike();
            hero.setCurrentOpponent(getBattleEnemy());
        } else {
            hero.setCurrentOpponent(null);
        }
        if (!hero.isAlive()) {
            viewer.showMessage("Game Over!\n You can start new game by pressing F2");
        }
    }

    public void startNewGame() {
        hero.initHero();
        newArea(1);

    }

    private void newArea(int level) {
        areaLevel = level;
        reset();
        linkGameObjectsAndViewer();
        informViewerAboutUpdates();
    }

    private void informViewerAboutUpdates() {
        viewer.setMap(tiles);
        viewer.setPlayers(players);
        viewer.setAreaLevel(areaLevel);
    }

    private boolean keyHolderIsKilled() {
        return !getKeyHolder().isAlive();
    }

    private boolean bossIsKilled() {
        return !getBoss().isAlive();
    }

    public void heroMove(int xDirection, int yDirection) {
        if (hero.isAlive()) {
            hero.move(xDirection, yDirection);
        }
    }

    public void heroStrike() {
        if (hero.isAlive()) {
            hero.strike();
        }
    }

    private void moveEnemiesRandomly() {
        for (GameObject enemy : getEnemies()) {
            if (dice.nextInt(2) == 0) {
                enemy.move(dice.nextInt(3) - 1, 0);
            } else {
                enemy.move(0, dice.nextInt(3) - 1);
            }
        }
    }

    private void identifyEnemy(int i) {
        battleEnemy = enemies.get(i);
    }

    private GameObject getBoss() {
        return enemies.get(enemies.size() - 1);
    }

    private GameObject getKeyHolder() {
        return enemies.get(enemies.size() - 2);
    }

    public void linkGameLogicToViewer(GameGUI viewer) {
        this.viewer = viewer;
        areaAudioPlayer = viewer.getAudioPlayer();
        linkGameObjectsAndViewer();
    }

    private void linkGameObjectsAndViewer() {
        for (GameObject gameElement : allGameObjects) {
            gameElement.setViewer(viewer);
            gameElement.createElementImage();
            gameElement.setGameObjectAudioPlayer(viewer.getAudioPlayer());
        }
        hero.createDirectionImages();
    }

    public void showHelp() {
        viewer.showMessage("Help:\nYou are the green-haired fella. \n" +
                "You can move with the arrow keys.\n" +
                "When you're on the same tile with an enemy,\n" +
                "you can use spacebar to strike.\n" +
                "If you kill the keyholder and the boss, you can move to the next area.\n" +
                "F2 starts new game.\n" +
                "Esc quits.");
    }
}