package sofia.demos;

import android.view.MotionEvent;
import sofia.view.RotateGestureDetector;
import android.view.ScaleGestureDetector;
import android.graphics.*;
import sofia.app.*;
import sofia.graphics.*;
import static sofia.graphics.Anchor.*;

public class GestureDemo extends ShapeScreen
{
    private TextShape text;
    private ImageShape image;

    private boolean didRotate;


    // ----------------------------------------------------------
    public void initialize(Bitmap bitmap)
    {
        text = new TextShape("", TOP_LEFT.ofView());
        text.setTypeSize(16);
        add(text);

        if (bitmap == null)
        {
            image = new ImageShape(R.drawable.kitten,
                CENTER.anchoredAt(CENTER.ofView()).sized(320, 320));
        }
        else
        {
            image = new ImageShape(bitmap,
                CENTER.anchoredAt(CENTER.ofView()).sized(320, 320));
        }

        add(image);

        enableScaleGestures();
        enableRotateGestures();
    }


    // ----------------------------------------------------------
    public boolean onRotate(RotateGestureDetector gesture)
    {
        float oldRot = image.getRotation();
        float rot = gesture.getRotation();

        image.setRotation(oldRot + rot);

        didRotate = true;

        return true;
    }


    // ----------------------------------------------------------
    public boolean onScale(ScaleGestureDetector gesture)
    {
        float width = image.getWidth();
        float height = image.getHeight();
        float scale = gesture.getScaleFactor();

        image.setBounds(CENTER.anchoredAt(CENTER.ofView()).sized(
            width * scale, height * scale));

        return true;
    }


    // ----------------------------------------------------------
    /*public boolean onTouchMove(MotionEvent e)
    {
        float px = rect.getX();
        float py = rect.getY();
        float cx = e.getX();
        float cy = e.getY();

        rect.move(cx - px, cy - py);

        return true;
    }*/


    // ----------------------------------------------------------
    public boolean onTouchDown(MotionEvent e)
    {
        didRotate = false;
        return true;
    }


    // ----------------------------------------------------------
    public boolean onTouchUp(MotionEvent e)
    {
        if (!didRotate)
        {
            boolean inside = image.contains(e.getX(), e.getY());

            text.setText(inside ? "Inside" : "Outside");
        }

        return true;
    }
}
