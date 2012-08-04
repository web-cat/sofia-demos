package sofia.demos.avians;

import sofia.demos.R;
import static sofia.graphics.Anchor.CENTER;
import sofia.graphics.ImageShape;

//-------------------------------------------------------------------------
/**
 * Represents a pig in the Irritated Avians game.
 *
 * @author  Tony Allevato
 * @author  Last changed by $Author: edwards $
 * @version $Date: 2012/08/04 16:34 $
 */
public class Pig extends ImageShape
{
	//~ Constructors ..........................................................

	// ----------------------------------------------------------
	public Pig(float x, float y)
	{
		super(R.drawable.pig, CENTER.anchoredAt(x, y).sized(40, 31));
	}


	//~ Methods ...............................................................

	// ----------------------------------------------------------
	public void onCollisionWith(Bird bird)
	{
		die();
	}


	// ----------------------------------------------------------
	public void die()
	{
		animate(400).alpha(0).rotation(720).removeWhenComplete().play();
	}
}
