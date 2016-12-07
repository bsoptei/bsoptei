package wanderer;

/**
 * Created by Söp on 2016.12.05..
 */
public class GameLogic {
    public static int level;
    public Area gameArea;
    public boolean keyHolderKilled;
    public boolean bossKilled;

    public boolean isKeyHolderKilled() {
        return keyHolderKilled;
    }

    public boolean isBossKilled(){return bossKilled;}

}
