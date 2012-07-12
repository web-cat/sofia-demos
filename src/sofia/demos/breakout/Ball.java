package sofia.demos.breakout;

import static sofia.graphics.Anchor.*;
import sofia.graphics.Color;
import sofia.graphics.ViewEdges;
import java.util.Random;
import sofia.graphics.Timings;
import sofia.graphics.OvalShape;

//-------------------------------------------------------------------------
/**
 * A paddle in the Breakout game.
 *
 * @author  Tony Allevato
 * @version 2012.02.03
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

        setFilled(true);
        setColor(Color.green);
    }


    //~ Methods ...............................................................

    // ----------------------------------------------------------
    /**
     * Resets the ball: positions it atop the specified paddle, gives it a
     * random initial velocity, and after 0.5 seconds, starts it moving.
     *
     * @param paddle the paddle to start the ball atop
     */
    public void reset(Paddle paddle)
    {
        // TODO How can we improve this?
        setBounds(BOTTOM.anchoredAt(TOP.of(paddle)).sized(20, 20));

        Random random = new Random();

        xVel = (float) (random.nextDouble() * 10);
        if (random.nextBoolean())
        {
            xVel *= -1.0f;
        }
        yVel = -8.0f - (float) (random.nextDouble() * 20);

        doAnimation(500);
    }


    // ----------------------------------------------------------
    /**
     * Called when the ball has collided with a paddle to cause it to bounce
     * off (by inverting its horizontal velocity) and restarting the animation.
     *
     * @param paddle the paddle that the ball collided with
     */
    public void onCollisionWith(Paddle paddle)
    {
        yVel = -yVel;
        doAnimation(0);
    }


    // ----------------------------------------------------------
    /**
     * Called when the ball collides with a brick to cause it to bounce off
     * (by modifying its velocity, depending on the angle of the collision)
     * and restarting the animation.
     *
     * @param brick the brick that the ball collided with
     */
    public void onCollisionWith(Brick brick)
    {
        // TODO check angle between ball and brick

        yVel = -yVel;
        doAnimation(0);
    }


    // ----------------------------------------------------------
    /**
     * Called when the ball has collided with an edge of the screen. If the
     * edge involved was the left, right, or top, then the ball will bounce
     * off. Otherwise, if the edge was the bottom, false will be returned so
     * that the screen has an opportunity to handle it (to subtract a life).
     *
     * @param edges the edges of the view involved in the collision
     */
    public void onCollisionWith(ViewEdges edges)
    {
        if (edges.left() || edges.right())
        {
            xVel = -xVel;
            doAnimation(0);
        }
        else if (edges.top())
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
