package wanderer;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;

/**
 * Created by Söp on 2016.12.07..
 */
class AudioPlayer {
    static void play(String wavSource){
        try {
            Clip clip = AudioSystem.getClip();
            clip.open(AudioSystem.getAudioInputStream(new File(wavSource)));
            clip.start();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
    }
}
