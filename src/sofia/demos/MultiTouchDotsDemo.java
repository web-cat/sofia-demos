package sofia.demos;

import static sofia.graphics.Anchor.CENTER;

import java.util.HashMap;

import sofia.app.ShapeScreen;
import sofia.graphics.Color;
import sofia.graphics.OvalShape;
import sofia.graphics.Shape;
import android.view.MotionEvent;

public class MultiTouchDotsDemo extends ShapeScreen
{
    private HashMap<Integer, Shape> fingerDots;

    private static final Color[] DOT_COLORS = {
        Color.red,
        Color.blue,
        Color.green,
        Color.yellow,
        Color.orange
    };


    // ----------------------------------------------------------
    public void initialize()
    {
        fingerDots = new HashMap<Integer, Shape>();
    }


    // ----------------------------------------------------------
    public boolean onFling(MotionEvent e1, MotionEvent e2,
        float velocityX, float velocityY)
    {
        return false;
    }


    // ----------------------------------------------------------
    public void onTouchDown(MotionEvent e)
    {
        int index = e.getActionIndex();
        int finger = e.getPointerId(e.getActionIndex());
        float x = e.getX(index);
        float y = e.getY(index);
        Color color = DOT_COLORS[finger % DOT_COLORS.length];

        OvalShape dot = new OvalShape(CENTER.anchoredAt(x, y).sized(80, 80));
        add(dot);
        dot.setColor(color);
        dot.setFilled(true);

        fingerDots.put(finger, dot);
    }


    // ----------------------------------------------------------
    public void onTouchMove(MotionEvent e)
    {
        for (int i = 0; i < e.getPointerCount(); i++)
        {
            float x = e.getX(i);
            float y = e.getY(i);

            Shape dot = fingerDots.get(e.getPointerId(i));
            dot.setPosition(CENTER.anchoredAt(x, y));
        }
    }


    // ----------------------------------------------------------
    public void onTouchUp(MotionEvent e)
    {
        int index = e.getActionIndex();
        float x = e.getX(index);
        float y = e.getY(index);

        Shape dot = fingerDots.remove(e.getPointerId(index));

        dot.animate(750)
            .delay(250)
            .bounds(CENTER.anchoredAt(x, y).sized(500, 500))
            .alpha(0)
            .rotation(180)
            .removeWhenComplete()
            .play();
    }
}
