package wanderer;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Söp on 2016.12.05..r
 */
public class Area {
    public ArrayList<GameElement> gameElements = new ArrayList<>();

    public Area() {
        generateMap();
    }

    public void generateMap() {
        Random r = new Random();
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                String currentType = (r.nextInt(10) < 7) ? "F" : "W";
                gameElements.add(new GameElement(i, j, currentType));

            }
        }
    }

    public ArrayList<GameElement> getGameElements() {
        return gameElements;
    }

    public boolean checkIfMapIsSolvable(){
        return true;
    }

}
