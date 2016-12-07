package wanderer;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Söp on 2016.12.05..r
 */
public class Area {
    public GameElement[][] tiles = new GameElement[10][10];
    public ArrayList<GameObject> enemies = new ArrayList();
    public Hero hero;
    public ArrayList<GameObject> characters = new ArrayList();

    public static int level = 0;

    public Area() {
        generateMap();
        level++;
        generateEnemies();
    }

    public void fillCharacters() {
        characters.add(hero);
        characters.addAll(enemies);
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

    }

    public void generateMap() {
        Maze gameMaze = new Maze(10, 10);
        tiles = gameMaze.generate();
    }

    public GameElement[][] getTiles() {
        return tiles;
    }

    public ArrayList<GameObject> getEnemies() {
        return enemies;
    }

    public void setHero(Hero hero) {
        this.hero = hero;
    }

    public ArrayList<GameObject> getCharacters() {
        return characters;
    }

    public boolean isInSamePosition() {

        return true;
    }
}