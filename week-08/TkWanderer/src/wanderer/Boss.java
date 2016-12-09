package wanderer;

/**
 * Created by Söp on 2016.12.07.. The strongest enemy
 */
class Boss extends Enemy {

    Boss(int xPos, int yPos, int level) {
        super("B", xPos, yPos, level, false);
        name = "Boss";
        swanSong = "src/wanderer/wav/49470__enochrooted__toni-pitchedscream.wav";
        initStats();
    }

    @Override
    void initStats() {
        defaultHealthPoint = 2 * level * (dice.nextInt(6) + 1) + (dice.nextInt(6) + 1);
        healthPoint = defaultHealthPoint;
        defensePoint = level / 2 * (dice.nextInt(6) + 1) + (dice.nextInt(6) + 1) / 2;
        strikePoint = level * (dice.nextInt(6) + 1) + level;
    }

}
