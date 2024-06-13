package apphelper;

import java.io.File;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.Clip;
import javax.sound.sampled.AudioSystem;
// possible exceptions
import java.io.IOException;
import java.net.URI;
import javax.sound.sampled.LineListener;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.sound.sampled.LineUnavailableException;

/**
 * Demonstrates how to load from file and play music
 *
 * @author ICS3U
 * @version May 2024
 */
public class Sound {

    Clip sound;
//------------------------------------------------------------------------------         

    public Sound(String musicName) {
        try {
            //URI imageurl = getClass().getResource(musicName).toURI();
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(new File(musicName));
            this.sound = AudioSystem.getClip();
            this.sound.open(audioStream);
        } catch (IOException ex) {
            System.out.println("File not found!");
        } catch (UnsupportedAudioFileException ex) {
            System.out.println("Unsupported file!");
        } catch (LineUnavailableException ex) {
            System.out.println("Audio feed already in use!");
        } catch (Exception e) {
            System.out.println("Error opening Music File, " + musicName);
        }
    }
//------------------------------------------------------------------------------         

    public void start() {
        if (sound != null) {
            this.sound.start();
        }
    }

    public void stop() {
        if (sound != null && this.sound.isRunning()) {
            this.sound.stop();
        }
    }

    public void loop() {
        if (sound != null) {
            this.sound.loop(Clip.LOOP_CONTINUOUSLY);
        }
    }

    public void loop(int count) {
        if (sound != null) {
            this.sound.loop(count);  //loop the playback certain number of times
        }
    }
        public void flush(){
        this.sound.flush();
    }
    public void setFramePosition(int frames){
        this.sound.setFramePosition(frames);
    }    
    public void addLineListener(LineListener listener){
        this.sound.addLineListener(listener);
    }
    public boolean isRunning(){
        return this.sound.isRunning();
    }
}
