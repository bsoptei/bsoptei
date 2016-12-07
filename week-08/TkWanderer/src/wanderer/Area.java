package wanderer;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Söp on 2016.12.05..r
 */
public class Area {
    public ArrayList<GameElement> tiles = new ArrayList<>();
    public ArrayList<GameElement> enemies = new ArrayList();
    public Hero hero = new Hero(0, 0);
    public static int level = 0;


    public Area() {
        generateMap();
        level++;
    }

    public void generateMap() {
        Random r = new Random();
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                String currentType = (r.nextInt(10) < 7) ? "F" : "W";
                tiles.add(new GameElement(i, j, currentType));

            }
        }
    }

    public ArrayList<GameElement> getTiles() {
        return tiles;
    }

    public boolean checkIfMapIsSolvable(){

        return true;
    }

    public Hero getHero() {
        return hero;
    }
}
