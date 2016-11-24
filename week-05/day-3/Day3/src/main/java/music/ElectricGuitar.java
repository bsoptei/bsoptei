package main.java.music;

/**
 * Created by Söp on 2016.11.16..
 */
public class ElectricGuitar extends StringedInstrument {

    public ElectricGuitar(int numberOfStrings) {
        this.numberOfStrings = numberOfStrings;
        this.name = "Electric guitar";
    }

    public ElectricGuitar() {
        this(6);
    }

    @Override
    public void play() {
        System.out.printf(formatForPlay, name, numberOfStrings, "Twang");
    }
}
