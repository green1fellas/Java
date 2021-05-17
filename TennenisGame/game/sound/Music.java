package game.sound;

import javax.sound.sampled.*;
import java.io.IOException;
import java.net.URL;

public class Music {

    private static Clip clip;

    public Music() {
    }

    public void playMusic(String path){

        try {
            URL url = Sound.class.getClassLoader().getResource(path);
            AudioInputStream audioIn = AudioSystem.getAudioInputStream(url);
            clip = AudioSystem.getClip();
            clip.open(audioIn);
            clip.start();
        } catch (UnsupportedAudioFileException e){
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        } catch (LineUnavailableException e){
            e.printStackTrace();
        }
    }

    public static void stopMusic(){
        clip.stop();
    }
}
