package sofia.demos.pong;

import static sofia.graphics.Anchor.*;
import sofia.graphics.Color;
import android.graphics.RectF;
import android.view.MotionEvent;
import sofia.app.ShapeScreen;
import sofia.graphics.TextShape;
import sofia.graphics.ViewEdges;

// -------------------------------------------------------------------------
/**
 * An implementation of the classic Pong game, using Sofia shapes, animation,
 * and collision detection.
 *
 * @author  Tony Allevato
 * @version 2012.01.27
 */
public class PongScreen extends ShapeScreen
{
    //~ Instance/static variables .............................................

    private int leftScore = 0;
    private int rightScore = 0;

    private TextShape leftScoreLabel;
    private TextShape rightScoreLabel;
    private Paddle leftPaddle;
    private Paddle rightPaddle;
    private Ball ball;


    //~ Methods ...............................................................

    // ----------------------------------------------------------
    /**
     * Initializes the shapes for the game.
     */
    public void initialize()
    {
        float width = getShapeView().getWidth();
        float height = getShapeView().getHeight();

        leftScoreLabel = new TextShape("0",
            TOP.anchoredAt(TOP.ofView().shiftBy(-40, 2)));
        rightScoreLabel = new TextShape("0",
            TOP.anchoredAt(TOP.ofView().shiftBy(40, 2)));

        leftScoreLabel.setTypeface("*-bold-14");
        rightScoreLabel.setTypeface("*-bold-14");

        leftPaddle = new Paddle(new RectF(20, 20, 40, 120));
        leftPaddle.setFilled(true);

        rightPaddle = new Paddle(new RectF(
            width - 40, height - 120, width - 20, height - 20));
        rightPaddle.setFilled(true);

        ball = new Ball();
        ball.setFilled(true);
        ball.setColor(Color.green);

        add(leftScoreLabel);
        add(rightScoreLabel);
        add(leftPaddle);
        add(rightPaddle);
        add(ball);

        ball.reset();
    }


    // ----------------------------------------------------------
    /**
     * Moves the paddle when the user touches down on the screen.
     *
     * @param e the motion event
     */
    public void onTouchDown(MotionEvent e)
    {
        for (int i = 0; i < e.getPointerCount(); i++)
        {
            float x = e.getX(i);
            float y = e.getY(i);

            if (x < leftPaddle.getX2() + 20)
            {
                leftPaddle.movePaddleTo(y);
            }
            else if (x > rightPaddle.getX() - 20)
            {
                rightPaddle.movePaddleTo(y);
            }
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
        for (int i = 0; i < e.getPointerCount(); i++)
        {
            float x = e.getX(i);
            float y = e.getY(i);

            if (x < leftPaddle.getX2() + 20)
            {
                leftPaddle.movePaddleTo(y);
            }
            else if (x > rightPaddle.getX() - 20)
            {
                rightPaddle.movePaddleTo(y);
            }
        }
    }


    // ----------------------------------------------------------
    /**
     * Called when a shape of type Ball collides with one or more of the
     * edges of the view.
     */
    public void onCollisionBetween(Ball ball, ViewEdges edges)
    {
        if (edges.left())
        {
            rightScore++;
            rightScoreLabel.setText(Integer.toString(rightScore));
        }
        else if (edges.right())
        {
            leftScore++;
            leftScoreLabel.setText(Integer.toString(leftScore));
        }
    }
}
