package sofia.demos.pong;

import android.graphics.RectF;
import java.util.Random;
import static sofia.graphics.Anchor.*;
import sofia.graphics.OvalShape;
import sofia.graphics.Timings;
import sofia.graphics.ViewEdges;

// -------------------------------------------------------------------------
/**
 * The ball in the Pong game.
 *
 * @author  Tony Allevato
 * @version 2012.01.27
 */
public class Ball extends OvalShape
{
    //~ Instance/static variables .............................................

    private float xVel;
    private float yVel;


    //~ Constructors ..........................................................

    // ----------------------------------------------------------
    /**
     * Creates a new Ball.
     */
    public Ball()
    {
        super();
    }


    //~ Methods ...............................................................

    // ----------------------------------------------------------
    /**
     * Resets the ball: centers it on the screen, gives it a random initial
     * velocity, and after 0.5 seconds, starts it moving.
     */
    public void reset()
    {
        setBounds(
            CENTER.anchoredAt(CENTER.ofView()).sized(
                0.08f * getParentView().getWidth(),
                0.08f * getParentView().getWidth()));

        Random random = new Random();

        xVel = 6.0f + (float)(random.nextDouble() * 12);
        if (random.nextBoolean())
        {
            xVel *= -1.0f;
        }
        yVel = 1.0f + (float) (random.nextDouble() * 5);
        if (random.nextBoolean())
        {
            yVel *= -1.0f;
        }

        doAnimation(500);
    }


    // ----------------------------------------------------------
    /**
     * Called when the ball has collided with a paddle to cause it to bounce
     * off (by inverting its horizontal velocity) and restarting the animation.
     * @param paddle The object we collided with.
     */
    public void onCollisionWith(Paddle paddle)
    {
        xVel = -xVel;
        doAnimation(0);
    }


    // ----------------------------------------------------------
    /**
     * Called when the ball collides with one or more of the edges
     * of the view.
     * @param on The edges "on" which the ball has touched.
     *
     */
    public void onCollisionWith(ViewEdges on)
    {
        if (on.left() || on.right())
        {
            reset();
        }
        else if (on.top() || on.bottom())
        {
            yVel = -yVel;
            doAnimation(0);
        }
    }


    // ----------------------------------------------------------
    /**
     * Helper method used to control the ball's animation.
     *
     * @param delay the number of milliseconds to delay starting the animation
     */
    private void doAnimation(long delay)
    {
        animate(100)
            .delay(delay)
            .repeat()
            .timing(Timings.linear())
            .moveBy(xVel, yVel)
            .play();
    }
}
