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
    private BitmapShape bitmap;

    private boolean didRotate;


    // ----------------------------------------------------------
    public void initialize(Bitmap image)
    {
        text = new TextShape("", TOP_LEFT.ofView());
        text.setTypeSize(16);
        add(text);

        if (image == null)
        {
            bitmap = new BitmapShape(R.drawable.kitten,
                CENTER.anchoredAt(CENTER.ofView()).sized(320, 320));
        }
        else
        {
            bitmap = new BitmapShape(image,
                CENTER.anchoredAt(CENTER.ofView()).sized(320, 320));
        }

        add(bitmap);

        enableScaleGestures();
        enableRotateGestures();
    }


    // ----------------------------------------------------------
    public boolean onRotate(RotateGestureDetector gesture)
    {
        float oldRot = bitmap.getRotation();
        float rot = gesture.getRotation();

        bitmap.setRotation(oldRot + rot);

        didRotate = true;

        return true;
    }


    // ----------------------------------------------------------
    public boolean onScale(ScaleGestureDetector gesture)
    {
        float width = bitmap.getWidth();
        float height = bitmap.getHeight();
        float scale = gesture.getScaleFactor();

        bitmap.setBounds(CENTER.anchoredAt(CENTER.ofView()).sized(
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
            boolean inside = bitmap.contains(e.getX(), e.getY());

            text.setText(inside ? "Inside" : "Outside");
        }

        return true;
    }
}
