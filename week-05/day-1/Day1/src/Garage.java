import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Söp on 2016.11.14..
 */
public class Garage {

    
    public ArrayList<Car> carsInGarage = new ArrayList<>();

    public Garage() {
        for (int n = 1; n <= 5; n++) {
            this.addRandomCar();
        }
    }
    
    public void addRandomCar() {
        Random random = new Random();
        this.carsInGarage.add(new Car(Car.MAKES[random.nextInt(Car.MAKES.length)],Car.COLORS[random.nextInt(Car.COLORS.length)],
                Car.ENGINE_SIZES[random.nextInt(Car.ENGINE_SIZES.length)], 10));
    }

    public void addCar(String brand, String color, int engine, int kms) {
        this.carsInGarage.add(new Car(brand, color, engine, kms));
    }

    public int getSize() {
        return carsInGarage.size();
    }

    public String toString() {
        return carsInGarage.toString();
    }

}
