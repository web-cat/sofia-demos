package sofia.demos.pong;

import static sofia.graphics.Anchor.*;
import android.graphics.RectF;
import sofia.graphics.RectangleShape;

// -------------------------------------------------------------------------
/**
 * A paddle in the Pong game.
 *
 * @author  Tony Allevato
 * @version 2012.01.27
 */
public class Paddle extends RectangleShape
{
    //~ Constructors ..........................................................

    // ----------------------------------------------------------
    /**
     * Creates a new Paddle with the specified bounds.
     *
     * @param bounds the bounds
     */
    public Paddle(RectF bounds)
    {
        super(bounds);
    }


    //~ Methods ...............................................................

    // ----------------------------------------------------------
    /**
     * Moves the paddle to the specified y-coordinate.
     *
     * @param y the y-coordinate of the center of the paddle
     */
    public void movePaddleTo(float y)
    {
        setPosition(CENTER.anchoredAt(CENTER.of(this).x, y));
    }
}
