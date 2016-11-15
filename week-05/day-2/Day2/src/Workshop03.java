/**
 * Created by Söp on 2016.11.15..
 */
public class Workshop03 {
    public static void main(String[] args) {
        Animal animal = new Animal();
        Bird bird = new Bird();
        Dog dog = new Dog();

        System.out.println("Testing Animal");
        // how does it speak, sleep, and tell me about its lifeExpectancy and if its a carnivore
        animal.sleep();
        animal.speak();
        System.out.println(animal.toString());
        System.out.println("\nTesting Bird");
        // how does it speak, sleep, what else it can do and tell me about its lifeExpectancy and if its a carnivore
        bird.speak();
        bird.fly();
        bird.sleep();
        System.out.println(bird.toString());

        System.out.println("\nTesting Dog");
        // how does it speak, sleep, what else it can do and tell me about its lifeExpectancy and if its a carnivore, and what about the tail?
        dog.speak();
        dog.sleep();
        dog.beg();
        System.out.println(dog.toString() + " hasTail = " + dog.getHasTail());

        System.out.println("\nTesting Dog2");
        Animal dog2 = new Dog();
        dog2.speak();
        dog2.sleep();
        ((Dog)dog2).setHasTail(false);
        System.out.println(dog2.toString());
        System.out.println("hasTail = " + ((Dog) dog2).getHasTail());

        // how does it speak, sleep, what else it can do and tell me about its lifeExpectancy and if its a carnivore, and what about the tail?

        System.out.println("\nTesting Dog 'd'");
        Animal d = new Dog();
        d.speak();
        d.sleep();

        System.out.println(d.toString());
        // how does it speak, sleep, what else it can do and tell me about its lifeExpectancy and if its a carnivore, and what about the tail?
        System.out.println("hasTail = " + ((Dog) d).getHasTail());

    }
}
