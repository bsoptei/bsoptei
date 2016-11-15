import java.util.Random;

/**
 * Created by Söp on 2016.11.14..
 *
 */
public class Car {
    static final String[] COLORS = {"white", "blue", "red", "silver", "black", "green", "banana"};
    static final String[] MAKES = {"toyota", "mazda", "bmw", "vw", "opel", "suzuki", "ford", "mercedes"};
    static final int[] ENGINE_SIZES = {1100, 1400, 1600, 1800, 2500};
    private int sizeEngine;
    private int kmMeter;

    private String color;

    private String brand;
    private static int countCar = -1;
    public String getBrand() {
        return brand;
    }

    public Car() {
        this.sizeEngine = 1600;
        this.color = "red";
        incrementCount();
    }

    public Car(int sizeEngine, int kmMeter) {
        this("Mazda", "red");
        this.sizeEngine = sizeEngine;
        this.kmMeter = kmMeter;
        incrementCount();
    }

    public Car(String brand, String color) {
        this.brand = brand;
        this.color = color;
        this.sizeEngine = 1600;
        this.kmMeter = 10;
        incrementCount();
    }

    public Car(String brand, String color, int sizeEngine, int kmMeter) {
        this.brand = brand;
        this.color = color;
        this.sizeEngine = sizeEngine;
        this.kmMeter = kmMeter;
        incrementCount();
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getKmMeter() {
        return kmMeter;
    }

    public void setKmMeter(int kmMeter) {

        this.kmMeter = kmMeter;
    }

    public void setSizeEngine(int sizeEngine) {
        this.sizeEngine = sizeEngine;
    }

    public int getSizeEngine() {
        return sizeEngine;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void drive(int kms) {
        this.kmMeter += kms;
        if (kms < 20) {
            System.out.printf("brrm, %s just drove around town %d clicks.\n", brand, kms);
        } else if (kms < 50) {
            System.out.printf("brrm, screech, brrm, screech; %s commuted %d clicks.", brand, kms);
        } else {
            System.out.printf("whee, %s %d clicks", brand, kms);
        }


        System.out.printf("This car has run %d kilometres altogether.\n", kmMeter);
    }

    public String toString() {
        return String.format("This %s is %s, it's engine is %d cc, and it ran %d kilometers.",
                brand, color, sizeEngine, kmMeter);
    }

    public void incrementCount() {
        countCar++;
    }

    static int getCount() {
        return countCar;
    }

}