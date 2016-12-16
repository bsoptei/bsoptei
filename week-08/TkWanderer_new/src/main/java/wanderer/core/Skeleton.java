package wanderer.core;

/**
 * Created by Söp on 2016.12.07.. Weak enemy
 */
class Skeleton extends Enemy {

    Skeleton(int xPos, int yPos, int level, boolean hasKey) {
        super("S", xPos, yPos, level, hasKey);
        name = "Skeleton";
        swanSong = "src/main/java/wanderer/wav/348310__redafs__zombie-monster-scream.wav";
        initStats();
    }

    @Override
    void initStats() {
        defaultHealthPoint = 2 * level * (dice.nextInt(6) + 1);
        healthPoint = defaultHealthPoint;
        defensePoint = level / 2 * (dice.nextInt(6) + 1);
        strikePoint = level * (dice.nextInt(6) + 1);
    }

}
