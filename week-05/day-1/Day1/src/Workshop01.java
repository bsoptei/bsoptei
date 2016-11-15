import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Söp on 2016.11.13..
 */
public class Workshop01 {

    public static void main(String[] args) {
//        ArrayList<Car> lsCars = new ArrayList<>();
//        Random r = new Random();
//        String[] colors = {"white", "blue", "red", "silver", "black", "green", "banana"};
//        String[] makes = {"toyota", "mazda", "bmw", "vw", "opel", "suzuki", "ford", "mercedes"};
//        int[] engineSizes = {1100, 1400, 1600, 1800, 2500};
//
//        for (int i = 0; i < 40; i++) {
//            lsCars.add(new Car(makes[r.nextInt(makes.length)], colors[r.nextInt(colors.length)]));
//            lsCars.get(i).setSizeEngine(engineSizes[r.nextInt(4)]);
//            if (i < 2) {
//                lsCars.get(i).drive(r.nextInt(30000));
//                System.out.println(lsCars.get(i).toString());
//            }
//        }
//
//
//        for(Car thisCar : lsCars) System.out.println(thisCar.toString());

//        Car myCar05 = new Car("Opel", "white", 1400, 25);
//        Car myCar06 = new Car("VW", "grey"); // defaults to 1600 cc, 10 kms
//        Car myCar07 = new Car(1100, 15); // defaults to a red Mazda
//
//
//        System.out.println(myCar05.toString());
//        System.out.println(myCar06.toString());
//        System.out.println(myCar07.toString());
        System.out.println("Number of cars available = " + Car.getCount());
        Car car1 = new Car("Mazda", "red", 1600, 12312);
        System.out.println("Number of cars available = " + Car.getCount());
        System.out.println(car1.toString());
        Car car2 = new Car("Ford", "silver", 2500, 152312);
        System.out.println(car2.toString());
        Car car3 = new Car("Beamer", "green", 1600, 42521);
        System.out.println(car3.toString());
        System.out.println("Number of cars available = " + Car.getCount());
    }
}
