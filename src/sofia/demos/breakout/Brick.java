package sofia.demos.breakout;

import sofia.graphics.Color;
import android.graphics.RectF;
import sofia.graphics.RectangleShape;

//-------------------------------------------------------------------------
/**
 * A brick in the Breakout game.
 *
 * @author  Tony Allevato
 * @version 2012.02.03
 */
public class Brick
    extends RectangleShape
{
    //~ Constructor ...........................................................

    // ----------------------------------------------------------
    /**
     * Creates a new brick.
     * @param bounds The size and location of the brick.
     */
    public Brick(RectF bounds)
    {
        super(bounds);

        setFilled(true);
        setColor(Color.red);
    }
}
