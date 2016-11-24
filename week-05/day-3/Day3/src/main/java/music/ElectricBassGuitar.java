package main.java.music;

/**
 * Created by Söp on 2016.11.16..
 */
public class ElectricBassGuitar extends StringedInstrument {

    public ElectricBassGuitar() {
        this(4);
    }

    public ElectricBassGuitar(int numberOfStrings) {
        this.numberOfStrings = numberOfStrings;
        this.name = "Electric bass guitar";
    }

    @Override
    public void play() {
        System.out.printf(formatForPlay, name, numberOfStrings, "Duum-duum-duum");
    }
}
