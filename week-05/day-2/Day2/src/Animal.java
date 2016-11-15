/**
 * Created by Söp on 2016.11.15..
 */
public class Animal {
    int lifeExpectancy = 10;
    boolean isCarnivore = false;

    public boolean isCarnivore() {
        return isCarnivore;
    }

    public int getLifeExpectancy() {
        return lifeExpectancy;
    }

    public Animal() {
        output();
    }

    public Animal(String animalType) {
        System.out.printf("new %s\n", animalType);
    }

    public Animal(int lifeExpectancy, boolean isCarnivore) {
        this.lifeExpectancy = lifeExpectancy;
        this.isCarnivore = isCarnivore;
        output();
    }

    private void output() {
        System.out.println("created animal");
    }

    public void sleep() {
        System.out.println("Animal is sleeping");
    }

    public void eat() {
        System.out.println("Animal is eating");
    }

    public void speak() {
        System.out.println("speaks");
    }

    public String toString(){
        return String.format("isCarnivore: %b, lifeExpectancy: %d", isCarnivore, lifeExpectancy);
    }


}
