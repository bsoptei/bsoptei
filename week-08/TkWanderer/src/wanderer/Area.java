package wanderer;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Söp on 2016.12.05..r
 */
public class Area {
    public GameElement[][] tiles = new GameElement[10][10];
    public ArrayList<GameElement> enemies = new ArrayList();
    public Hero hero;
    public static int level = 0;

    public Area() {
        generateMap();
        level++;
    }

    public void generateMap() {
        Maze gameMaze = new Maze(10, 10);
        tiles = gameMaze.generate();
    }

    public GameElement[][] getTiles() {
        return tiles;
    }

    public void setHero(Hero hero){
        this.hero = hero;
    }

    public Hero getHero() {
        return hero;
    }
}
