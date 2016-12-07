package wanderer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

/**
 * Created by Söp on 2016.12.05.. Virtual map of the game
 */
class Area implements GameMeetingPoint {
    private GameElement[][] tiles = new GameElement[10][10];
    private ArrayList<GameObject> enemies = new ArrayList();
    private Hero hero;
    private ArrayList<GameObject> characters = new ArrayList();
    private GameObject battleEnemy;

    static int level = 0;

    Area() {
        generateMap();
        level++;
        generateEnemies();
    }

    void reset() {
        level++;
        hero.reset();
        enemies.clear();
        characters.clear();
        generateEnemies();
        fillCharacters();
    }

    void fillCharacters() {
        characters.add(hero);
        characters.addAll(enemies);
        for (GameObject character : characters) {
            character.setGameArea(this);
        }
    }

    private void generateEnemies() {
        Random superDice = new Random();
        int numberOfEnemies = superDice.nextInt(4) + 3;
        while (enemies.size() < numberOfEnemies) {
            int xPos = superDice.nextInt(9) + 1;
            int yPos = superDice.nextInt(9) + 1;
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
        for (GameObject enemy: enemies) {
            enemy.setHero(hero);
        }
    }

    private void generateMap() {
        Maze gameMaze = new Maze(10, 10);
        tiles = gameMaze.generate();
    }

    GameElement[][] getTiles() {
        return tiles;
    }

    ArrayList<GameObject> getEnemies() {
        return enemies;
    }

    void setHero(Hero hero) {
        this.hero = hero;
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

}