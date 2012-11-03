package sofia.demos;

import android.widget.Button;
import sofia.app.Screen;
import sofia.audio.SoundPlayer;

//-------------------------------------------------------------------------
/**
 * TODO document
 * 
 * @author  Tony Allevato
 * @version 2012.11.01
 */
public class SoundPlayerDemo extends Screen
{
	//~ Fields ................................................................

	private SoundPlayer soundPlayer;


	//~ Methods ...............................................................

	// ----------------------------------------------------------
	public void initialize()
	{
		soundPlayer = new SoundPlayer(this);
	}
	
	
	// ----------------------------------------------------------
	public void playClicked(Button button)
	{
		soundPlayer.play("chime");
	}
}
