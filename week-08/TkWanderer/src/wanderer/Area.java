package wanderer;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Söp on 2016.12.05..r
 */
public class Area {
    public GameElement[][] tiles = new GameElement[10][10];
    public ArrayList<GameElement> enemies = new ArrayList();
    public Hero hero = new Hero(0, 0);
    public static int level = 0;


    public Area() {
        generateMap();
        level++;
        hero.setGameArea(this);
    }

    public void generateMap() {
        Random r = new Random();
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                String currentType = (r.nextInt(10) < 7) ? "F" : "W";
                tiles[i][j] = (new GameElement(i, j, currentType));
            }
        }
    }

    public GameElement[][] getTiles() {
        return tiles;
    }

    public boolean checkIfMapIsSolvable(){

        return true;
    }

    public Hero getHero() {
        return hero;
    }
}
