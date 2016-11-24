package Workshop09;

/**
 * Created by Söp on 2016.11.16..
 */
public class Shark extends Animal {
    Shark() {
        this.species = "Shark";
        this.canFly = false;
        this.canRun = false;
        this.canSwim = true;
    }

    @Override
    void run() { }

    @Override
    void fly() { }

    @Override
    void swim() {
        System.out.printf("%s swims \n", species);
    }

    @Override
    void eat() {
        System.out.printf("%s eats animals swimming in the sea. \n", species);
    }
}
