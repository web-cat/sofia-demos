package sofia.demos;

import static sofia.graphics.Anchor.*;
import sofia.app.ShapeScreen;
import sofia.graphics.DirectionalPad;
import sofia.graphics.RectangleShape;
import android.view.KeyEvent;
import android.view.MotionEvent;

//-------------------------------------------------------------------------
/**
 * Demonstrates the use of the joystick and directional pads.
 *
 * @author  Tony Allevato
 * @author  Last changed by $Author$
 * @version $Date$
 */
public class JoystickDemo extends ShapeScreen
{
	//~ Fields ................................................................

	private RectangleShape player;


	//~ Public methods ........................................................

	// ----------------------------------------------------------
	/**
	 * Initializes the screen.
	 */
	public void initialize()
	{
		player = new RectangleShape(
				CENTER.anchoredAt(CENTER.ofView()).sized(50, 50));
		add(player);

		float width = getWidth() / 4;

		DirectionalPad dpad = new DirectionalPad(
				BOTTOM_LEFT.anchoredAt(
						BOTTOM_LEFT.ofView().shiftBy(10, -10)).sized(width, width));
		add(dpad);

		/*Thumbstick stick = new Thumbstick(
				BOTTOM_RIGHT.anchoredAt(
						BOTTOM_RIGHT.ofView().shiftBy(-10, -10)).sized(width, width));
		add(stick);*/
	}
	
	
	// ----------------------------------------------------------
	/**
	 * Handles the key events from the directional pad.
	 * 
	 * TODO Modify ShapeView to support sending separate events for each key.
	 * 
	 * @param e a {@code KeyEvent} describing the key press
	 */
	public void onKeyDown(KeyEvent e)
	{
		switch (e.getKeyCode())
		{
		case KeyEvent.KEYCODE_DPAD_RIGHT:
			player.move(10, 0);
			break;

		case KeyEvent.KEYCODE_DPAD_DOWN:
			player.move(0, 10);
			break;

		case KeyEvent.KEYCODE_DPAD_LEFT:
			player.move(-10, 0);
			break;

		case KeyEvent.KEYCODE_DPAD_UP:
			player.move(0, -10);
			break;
		}
	}
	
	
	// ----------------------------------------------------------
	/**
	 * Handles the trackball events from the thumbstick.
	 * 
	 * @param e a {@code MotionEvent} describing the motion
	 */
	/*public boolean onTrackballEvent(MotionEvent e)
	{
		float x = e.getX();
		float y = e.getY();

		player.move(x * 10, y * 10);

		return true;
	}*/
}
