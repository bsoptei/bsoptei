package Workshop09;

/**
 * Created by Söp on 2016.11.16..
 */
class Swan extends Animal {

    Swan() {
        this.species = "Swan";
        this.canFly = true;
        this.canRun = false;
        this.canSwim = true;
    }

    @Override
    void run() { }

    @Override
    void fly() {
        System.out.printf("%s flies \n", species);
    }

    @Override
    void swim() {
        System.out.printf("%s swims \n", species);
    }

    @Override
    void eat() {
        System.out.printf("%s eats trash. \n", species);
    }
}
