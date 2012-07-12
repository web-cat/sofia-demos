package sofia.demos.breakout;

import sofia.demos.breakout.Ball;
import sofia.demos.breakout.Paddle;
import sofia.graphics.TextShape;
import android.view.MotionEvent;
import sofia.graphics.Color;
import android.graphics.RectF;
import sofia.graphics.ViewEdges;
import sofia.app.ShapeScreen;
import static sofia.graphics.Anchor.*;

//-------------------------------------------------------------------------
/**
 * An implementation of the classic Breakout game, using Sofia shapes,
 * animation, and collision detection.
 *
 * @author  Tony Allevato
 * @version 2012.02.03
 */
public class BreakoutScreen extends ShapeScreen
{
    //~ Instance/static variables .............................................

    private int livesRemaining;
    private int score;

    private Paddle paddle;
    private Ball ball;
    private TextShape scoreLabel;

    private static final float BRICK_HEIGHT = 20f;

    private static final Color[] BRICK_COLORS = {
        Color.red, Color.blue, Color.green, Color.yellow,
        Color.orange, Color.cyan, Color.magenta
    };


    //~ Methods ...............................................................

    // ----------------------------------------------------------
    /**
     * Initializes the shapes for the game.
     */
    public void initialize()
    {
        livesRemaining = 3;
        score = 0;

        for (int rows = 0; rows < 10; rows++)
        {
            for (int cols = 0; cols < 10; cols++)
            {
                RectF bounds = new RectF(
                    cols / 10f * getWidth(), rows * BRICK_HEIGHT,
                    (cols + 1) / 10f * getWidth() - 2,
                    (rows + 1) * BRICK_HEIGHT - 2);

                Brick brick = new Brick(bounds);
                brick.setColor(BRICK_COLORS[rows % BRICK_COLORS.length]);
                add(brick);
            }
        }

        final float PADDLE_WIDTH = getWidth() / 8;

        paddle = new Paddle(new RectF(
             0, getHeight() - 60, PADDLE_WIDTH, getHeight() - 40));

        ball = new Ball();

        scoreLabel = new TextShape(
            "", BOTTOM_LEFT.anchoredAt(BOTTOM_RIGHT.ofView()));
        scoreLabel.setTypeSize(8f);

        add(paddle);
        add(ball);
        add(scoreLabel);

        updateLabel();
        ball.reset(paddle);
    }


    // ----------------------------------------------------------
    /**
     * Moves the paddle when the user touches down on the screen.
     *
     * @param e the motion event
     */
    public void onTouchDown(MotionEvent e)
    {
        float x = e.getX();
        float y = e.getY();

        if (y > paddle.getY() - 80)
        {
            paddle.movePaddleTo(x);
        }
    }


    // ----------------------------------------------------------
    /**
     * Moves the paddle when the user moves his or her finger on the screen.
     *
     * @param e the motion event
     */
    public void onTouchMove(MotionEvent e)
    {
        float x = e.getX();
        paddle.movePaddleTo(x);
    }


    // ----------------------------------------------------------
    /**
     * Called when the ball has collided with bottom edge of the view, to
     * subtract a life from the player. If any of the other edges are hit,
     * then that handling occurs in the {@link Ball} class itself.
     *
     * @param theBall the ball that collided
     * @param edges the view edges that were involved in the collision
     */
    public void onCollisionBetween(Ball theBall, ViewEdges edges)
    {
        if (edges.bottom())
        {
            livesRemaining--;

            if (livesRemaining == 0)
            {
                gameOver();
            }
            else
            {
                ball.reset(paddle);
            }
        }
    }


    // ----------------------------------------------------------
    /**
     * Called when the ball has collided with a brick to update the score. The
     * changing of the ball's velocity actually occurs in the {@link Ball}
     * class itself.
     *
     * @param theBall the ball that collided
     * @param brick the brick that collided
     */
    public void onCollisionBetween(Ball theBall, Brick brick)
    {
        remove(brick);

        score++;
        updateLabel();
    }


    // ----------------------------------------------------------
    /**
     * Updates the score label.
     */
    private void updateLabel()
    {
        scoreLabel.setText("Balls: " + livesRemaining + ", Score: " + score);
    }


    // ----------------------------------------------------------
    /**
     * Called when the game is over (because the player ran out of balls).
     */
    private void gameOver()
    {
        // TODO do something cool here
    }
}
