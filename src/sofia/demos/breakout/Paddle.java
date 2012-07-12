package sofia.demos.breakout;

import static sofia.graphics.Anchor.*;
import sofia.graphics.Color;
import android.graphics.RectF;
import sofia.graphics.RectangleShape;

//-------------------------------------------------------------------------
/**
 * A paddle in the Breakout game.
 *
 * @author  Tony Allevato
 * @version 2012.02.03
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

        setFilled(true);
        setColor(Color.white);
    }


    //~ Methods ...............................................................

    // ----------------------------------------------------------
    /**
     * Moves the paddle to the specified x-coordinate.
     *
     * @param x the x-coordinate of the center of the paddle
     */
    public void movePaddleTo(float x)
    {
        setPosition(CENTER.anchoredAt(x, CENTER.of(this).y));
    }
}
