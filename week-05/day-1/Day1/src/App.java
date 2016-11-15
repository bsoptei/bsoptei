import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Söp on 2016.11.14..
 *
 */
public class App {
    public static void main(String[] args) {

        // 01
        Car myCar = new Car();
        System.out.printf("Just got a new Car, it's %s and has a %d cc Engine!\n",
                myCar.getColor(), myCar.getSizeEngine());

        // 02 & 06
        Car myCar2 = new Car("Mazda", "red", 1600, 12312);
        Car myCar3 = new Car("Ford", "Silver", 2500, 152312);
        Car myCar4 = new Car("Beamer", "green", 2800, 42521);
        System.out.printf("This %s is %s, it's engine is %d cc, and it ran %d kilometers.\n",
                myCar2.getBrand(), myCar2.getColor(), myCar2.getSizeEngine(), myCar2.getKmMeter());
        System.out.printf("This %s is %s, it's engine is %d cc, and it ran %d kilometers.\n",
                myCar3.getBrand(), myCar3.getColor(), myCar3.getSizeEngine(), myCar3.getKmMeter());
        System.out.printf("This %s is %s, it's engine is %d cc, and it ran %d kilometers.\n",
                myCar4.getBrand(), myCar4.getColor(), myCar4.getSizeEngine(), myCar4.getKmMeter());

        // 03
        Car myCar2b = new Car();
        myCar2b.setColor("red");
        myCar2b.setBrand("Mazda");
        myCar2b.setSizeEngine(1600);
        myCar2b.setKmMeter(12312);

        Car myCar3b = new Car();
        myCar3b.setColor("silver");
        myCar3b.setBrand("Ford");
        myCar3b.setSizeEngine(2500);
        myCar3b.setKmMeter(152312);

        Car myCar4b = new Car();
        myCar4b.setColor("green");
        myCar4b.setBrand("Beamer");
        myCar4b.setSizeEngine(2800);
        myCar4b.setKmMeter(42521);

        System.out.printf("This %s is %s, it's engine is %d cc, and it ran %d kilometers.\n",
                myCar2b.getBrand(), myCar2b.getColor(), myCar2b.getSizeEngine(), myCar2b.getKmMeter());
        System.out.printf("This %s is %s, it's engine is %d cc, and it ran %d kilometers.\n",
                myCar3b.getBrand(), myCar3b.getColor(), myCar3b.getSizeEngine(), myCar3b.getKmMeter());
        System.out.printf("This %s is %s, it's engine is %d cc, and it ran %d kilometers.\n",
                myCar4b.getBrand(), myCar4b.getColor(), myCar4b.getSizeEngine(), myCar4b.getKmMeter());

        System.out.println(Car.getCount());

        //04
        myCar.drive(5000);
        myCar2.drive(1);
        myCar3.drive(4984132);
        myCar4.drive(250);

        //05
        System.out.println(myCar2.toString());
        System.out.println(myCar3.toString());
        System.out.println(myCar4.toString());
        System.out.println(myCar2b.toString());
        System.out.println(myCar3b.toString());
        System.out.println(myCar4b.toString());

        //07
        ArrayList<Car> myCars = new ArrayList<>();
        Random r = new Random();


        for (int i = 1; i <= 40; i ++) {
            myCars.add(new Car(Car.MAKES[r.nextInt(Car.MAKES.length)],Car.COLORS[r.nextInt(Car.COLORS.length)],
                    Car.ENGINE_SIZES[r.nextInt(Car.ENGINE_SIZES.length)], 10));
            if (i < 3) {
                myCars.get(i - 1 ).drive(r.nextInt(10000));
                System.out.println(myCars.get(i - 1).toString());
            }
        }
        for (Car thisCar : myCars) System.out.println(thisCar.toString());

        //08
        System.out.printf("Currently the number of cars is %d.\n", Car.getCount());

        //+1
        Garage myGarage = new Garage();
        System.out.println(myGarage.carsInGarage.size());
        myGarage.addCar("Trabant", "Brown", 1000, 2352356);
        System.out.println(myGarage.carsInGarage.get(0).toString());
        myGarage.addRandomCar();
        System.out.println(myGarage.toString());
        System.out.println(myGarage.getSize());
    }

}
