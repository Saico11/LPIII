import javax.sound.sampled.*;
import javax.swing.*;
import java.io.File;
import java.io.IOException;

public class AppAudio {
    private static Clip clip;
    private static boolean isPlaying = false;

    public static void main(String[] args) {
        JFrame frame = new JFrame("Reproducción de Audio");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);
        frame.setLayout(null);

        JButton playButton = new JButton("Reproducir");
        playButton.setBounds(50, 50, 200, 30);
        playButton.addActionListener(e -> playAudio("sample-3s.wav"));

        JButton pauseButton = new JButton("Pausar");
        pauseButton.setBounds(50, 90, 200, 30);
        pauseButton.addActionListener(e -> pauseAudio());

        JButton resumeButton = new JButton("Reanudar");
        resumeButton.setBounds(50, 130, 200, 30);
        resumeButton.addActionListener(e -> resumeAudio());

      
        frame.add(playButton);
        frame.add(pauseButton);
        frame.add(resumeButton);

        frame.setVisible(true);
    }

    //reproducir
    public static void playAudio(String filePath) {
        try {
            // Si ya hay un clip detenerlo y cargar uno nuevo
            if (clip != null && clip.isRunning()) {
                clip.stop();
            }

            File audioFile = new File(filePath);
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioFile);
            clip = AudioSystem.getClip();
            clip.open(audioStream);
            clip.start();
            isPlaying = true;
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            e.printStackTrace();
        }
    }

    // pausar 
    public static void pauseAudio() {
        if (clip != null && clip.isRunning()) {
            clip.stop();
            isPlaying = false;
        }
    }

    //  reanudar 
    public static void resumeAudio() {
        if (clip != null && !clip.isRunning() && !isPlaying) {
            clip.start();
            isPlaying = true;
        }
    }
}