package Workshop09;

/**
 * Created by Söp on 2016.11.16..
 */
public class Pigeon extends Animal {
    Pigeon() {
        this.species = "Pigeon";
        this.canFly = true;
        this.canRun = true;
        this.canSwim = false;
    }

    @Override
    void run() {
        System.out.printf("%s runs \n", species);
    }

    @Override
    void fly() {
        System.out.printf("%s flies \n", species);
    }

    @Override
    void swim() { }

    @Override
    void eat() {
        System.out.printf("%s eats vegan trash. \n", species);
    }
}
