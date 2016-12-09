package wanderer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

/**
 * Created by Söp on 2016.12.05.. Virtual map of the game
 */
class Area {
//    private Hero hero = Creator.hero;
    private int width, height;
    private Tile[][] tiles;
    private Random dice = new Random();
    private ArrayList<GameObject> enemies = new ArrayList();
    private Hero hero;
    private ArrayList<GameObject> players = new ArrayList();
    private StringBuilder[][] playerPositions;
    private GameObject battleEnemy;
    static int level = 0;

    Area(int width, int height, Hero hero) {
        this.width = width;
        this.height = height;
        this.hero = hero;
        hero.setGameArea(this);
        tiles = new Tile[width][height];
        playerPositions = new StringBuilder[width][height];
        generateMap();
        AudioPlayer.play("src/wanderer/wav/321937__pel2na__two-kazoo-fanfare.wav");
    }

    void reset() {
        level++;
        hero.reset();
        enemies.clear();
        players.clear();
        initPlayerPositions();
        generateEnemies();
        administerPlayers();
    }

    private void administerPlayers() {
        players.add(hero);
        players.addAll(enemies);
    }

    private void generateEnemies() {
        int numberOfEnemies = dice.nextInt(4) + 3;
        while (enemies.size() < numberOfEnemies) {
            updatePlayerPositions();
            int xPos = dice.nextInt(width - 1) + 1;
            int yPos = dice.nextInt(height - 1) + 1;
            if (!tiles[xPos][yPos].isObstacle()) {
                if (enemies.size() == numberOfEnemies - 1) {
                    enemies.add(new Boss(xPos, yPos, level));
                } else if (enemies.size() == numberOfEnemies - 2) {
                    enemies.add(new Skeleton(xPos, yPos, level, true));
                } else {
                    enemies.add(new Skeleton(xPos, yPos, level, false));
                }
            }
        }
    }

    void generateMap() {
        Maze gameMaze = new Maze(width, height);
        tiles = gameMaze.generate();
    }

    boolean isInSamePosition() {
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

    private void identifyEnemy(int i) {
        battleEnemy = enemies.get(i);
    }

    void updatePlayerPositions() {
        playerPositions = new StringBuilder[width][height];
        initPlayerPositions();
        players.forEach(player ->
                playerPositions[player.getX()][player.getY()].append(player.getType()));
    }

    private void initPlayerPositions() {
        for (int i = 0; i < playerPositions.length; i++) {
            for (int j = 0; j < playerPositions[i].length; j++) {
                playerPositions[i][j] = new StringBuilder("");
            }
        }
    }

    StringBuilder[][] getPlayerPositions() {
        return playerPositions;
    }

    Tile[][] getTiles() {
        return tiles;
    }

    ArrayList<GameObject> getEnemies() {
        return enemies;
    }

    ArrayList<GameObject> getPlayers() {
        return players;
    }

    GameObject getBattleEnemy() {
        return battleEnemy;
    }

    GameObject getBoss() {
        return enemies.get(enemies.size() - 1);
    }

    GameObject getKeyHolder() {
        return enemies.get(enemies.size() - 2);
    }

    int getWidth() {
        return width;
    }

    int getHeight() {
        return height;
    }
}