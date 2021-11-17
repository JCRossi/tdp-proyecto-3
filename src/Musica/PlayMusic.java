package Musica;

import java.io.File;
import javax.sound.sampled.*;

public class PlayMusic{
	
	private Clip clip;
	public PlayMusic( File archiv ) {
		
		try{
			 AudioInputStream audioStream = AudioSystem.getAudioInputStream(archiv);
			 clip = AudioSystem.getClip();
			 clip.open(audioStream);
			 clip.loop(clip.LOOP_CONTINUOUSLY);
		}
		catch(Exception ex)	{  
			ex.printStackTrace();
		}
	}
	
	public void activarYDesactivar() {
		if(clip.isActive())
			clip.stop();
		else
			clip.loop(clip.LOOP_CONTINUOUSLY);
	}

	
}