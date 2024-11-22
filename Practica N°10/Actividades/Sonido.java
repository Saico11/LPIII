import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class Sonido {
    private Clip clip;

    public Sonido(String rutaArchivo) {
        try {
            File archivoSonido = new File(rutaArchivo);
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(archivoSonido);
            clip = AudioSystem.getClip();
            clip.open(audioStream);
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            e.printStackTrace();
        }
    }

    public void reproducir() {
        if (clip != null) {
            clip.stop(); // Detiene cualquier reproducción en curso
            clip.setFramePosition(0); // Reinicia al inicio del audio
            clip.start();
        }
    }
}
