package wanderer;

import java.util.Random;

/**
 * Created by Söp on 2016.12.05..
 */
public class GameLogic {

    public Area gameArea;
    public boolean keyHolderKilled;
    public boolean bossKilled;
    private Hero hero;

    public GameLogic() {

    }

    public boolean isKeyHolderKilled() {

        return keyHolderKilled;
    }

    public boolean isBossKilled() {
        return bossKilled;
    }


    public void setGameArea(Area gameArea) {
        this.gameArea = gameArea;
    }

    public void update() {
        Random randomMove = new Random();
        if (hero.getNumberOfMoves() % 2 == 0) {
            for (GameObject enemy : gameArea.getEnemies()) {
                if (randomMove.nextInt(2) == 0) {
                    enemy.move(randomMove.nextInt(3) - 1, 0);
                } else {
                    enemy.move(0, randomMove.nextInt(3) - 1);
                }
            }
        }
    }

    public void setHero(Hero hero) {
        this.hero = hero;
    }
}
