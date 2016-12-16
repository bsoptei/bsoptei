package wanderer.core;

import java.util.ArrayList;

/**
 * Created by Söp on 2016.12.10.. Interface for GUI
 */
public interface GameGUI {

    void initProperties();

    void update();

    void showMessage(String message);

    void setMapWidth(int width);

    void setMapHeight(int height);

    void setAreaLevel(int areaLevel);

    void setMap(Tile[][] map);

    void showDisplay();

    GameImage getImage(String source, int x, int y);

    void setPlayers(ArrayList<GameObject> players);

    GameAudioPlayer getAudioPlayer();
}
