package wanderer.view;

import wanderer.core.GameAudioPlayer;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;

/**
 * Created by Söp on 2016.12.07.. Plays .wav files for the game
 */
class AudioPlayer implements GameAudioPlayer {

    @Override
    public void play(String wavSource) {
        try {
            Clip clip = AudioSystem.getClip();
            clip.open(AudioSystem.getAudioInputStream(new File(wavSource)));
            clip.start();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
    }
}
