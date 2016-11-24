package Workshop09;

/**
 * Created by Söp on 2016.11.16..
 */
abstract class Animal {
    String species;
    boolean canMove = true;
    boolean canFly;
    boolean canSwim;
    boolean canRun;

    void move() {
        System.out.printf("%s moves: %b, flies: %b, runs: %b, swims: %b \n", species, canMove, canFly, canRun, canSwim);
    };

    abstract void run();
    abstract void fly();
    abstract void swim();
    abstract void eat();

    void sleep() {
        System.out.printf("%s sleeps \n", species);
    };



}
