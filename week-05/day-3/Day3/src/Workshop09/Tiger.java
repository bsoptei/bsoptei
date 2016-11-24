package Workshop09;

/**
 * Created by Söp on 2016.11.16..
 */
public class Tiger extends Animal {

    Tiger() {
        this.species = "Tiger";
        this.canFly = false;
        this.canRun = true;
        this.canSwim = true;
    }

    @Override
    void run() {
        System.out.printf("%s runs \n", species);
    }

    @Override
    void fly() { }

    @Override
    void swim() {
        System.out.printf("%s swims \n", species);
    }

    @Override
    void eat() {
        System.out.printf("%s eats herbivores. \n", species);
    }
}
