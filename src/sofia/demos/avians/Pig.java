package sofia.demos.avians;

import static sofia.graphics.Anchor.CENTER;
import sofia.demos.R;
import sofia.graphics.BitmapShape;

//-------------------------------------------------------------------------
/**
 * Represents a pig in the Irritated Avians game.
 *
 * @author  Tony Allevato
 * @author  Last changed by $Author$
 * @version $Revision$, $Date$
 */
public class Pig extends BitmapShape
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
