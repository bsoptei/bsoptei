package main.java.music;

/**
 * Created by Söp on 2016.11.16..
 */
public class Violin extends StringedInstrument {

    public Violin() {
        this.numberOfStrings = 4;
        this.name = "Violin";
    }

    @Override
    public void play() {
        System.out.printf(formatForPlay, name, numberOfStrings, "Screech");
    }
}
