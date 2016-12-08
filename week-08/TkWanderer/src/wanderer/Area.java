package wanderer;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Söp on 2016.12.05.. Virtual map of the game
 */
class Area implements GameMeetingPoint {
    private int width, height;
    private Tile[][] tiles;
    @SuppressWarnings("unchecked")
    private ArrayList<GameObject> enemies = new ArrayList();
    @SuppressWarnings("unchecked")
    private ArrayList<GameObject> characters = new ArrayList();
    private StringBuilder[][] characterPositions;
    private GameObject battleEnemy;
    static int level = 0;

    Area(int width, int height) {
        this.width = width;
        this.height = height;
        tiles = new Tile[width][height];
        characterPositions = new StringBuilder[width][height];
        generateMap();
        AudioPlayer.play("src/wanderer/wav/321937__pel2na__two-kazoo-fanfare.wav");
    }

    void reset() {
        level++;
        hero.reset();
        enemies.clear();
        characters.clear();
        initCharacterPositions();
        generateEnemies();
        fillCharacters();
    }

    private void fillCharacters() {
        characters.add(hero);
        characters.addAll(enemies);
        for (GameObject character : characters) {
            character.setGameArea(this);
        }
    }

    private void generateEnemies() {
        int numberOfEnemies = dice.nextInt(4) + 3;
        while (enemies.size() < numberOfEnemies) {
            int xPos = dice.nextInt(9) + 1;
            int yPos = dice.nextInt(9) + 1;
            if (!tiles[xPos][yPos].isObstacle() &&
                    characterPositions[xPos][yPos].toString().equals("")) {
                if (enemies.size() == numberOfEnemies - 1) {
                    enemies.add(new Boss(xPos, yPos, level));
                } else if (enemies.size() == numberOfEnemies - 2) {
                    enemies.add(new Skeleton(xPos, yPos, level, true));
                } else {
                    enemies.add(new Skeleton(xPos, yPos, level, false));
                }
                updateCharacterPositions();
            }
        }
        for (GameObject enemy : enemies) {
            enemy.setHero(hero);
        }
    }

    void generateMap() {
        Maze gameMaze = new Maze(width, height);
        tiles = gameMaze.generate();
    }

    Tile[][] getTiles() {
        return tiles;
    }

    ArrayList<GameObject> getEnemies() {
        return enemies;
    }

    ArrayList<GameObject> getCharacters() {
        return characters;
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

    GameObject getBattleEnemy() {
        return battleEnemy;
    }

    GameObject getBoss() {
        return enemies.get(enemies.size() - 1);
    }

    GameObject getKeyHolder() {
        return enemies.get(enemies.size() - 2);
    }

    void updateCharacterPositions() {
        initCharacterPositions();
        characters.forEach(character ->
                characterPositions[character.getX()][character.getY()].append(character.getType()));
    }

    private void initCharacterPositions() {
        for (int i = 0; i < characterPositions.length; i++) {
            for (int j = 0; j < characterPositions[i].length; j++) {
                characterPositions[i][j] = new StringBuilder("");
            }
        }
    }

    StringBuilder[][] getCharacterPositions() {
        return characterPositions;
    }

    int getWidth() {
        return width;
    }

    int getHeight() {
        return height;
    }
}