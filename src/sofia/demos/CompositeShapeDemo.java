package sofia.demos;

import android.view.ScaleGestureDetector;
import sofia.view.RotateGestureDetector;
import sofia.app.*;
import sofia.graphics.*;
import static sofia.graphics.Anchor.*;

public class CompositeShapeDemo extends ShapeScreen
{
    private Snowman snowman;


    // ----------------------------------------------------------
    public void initialize()
    {
        snowman = new Snowman(
            CENTER.anchoredAt(CENTER.ofView()).sized(200, 200));
        add(snowman);

        enableRotateGestures();
        enableScaleGestures();
    }


    // ----------------------------------------------------------
    public boolean onRotate(RotateGestureDetector gesture)
    {
        snowman.rotateBy(gesture.getRotation());
        return true;
    }


    // ----------------------------------------------------------
    public boolean onScale(ScaleGestureDetector gesture)
    {
        float width = snowman.getWidth();
        float height = snowman.getHeight();
        float scale = gesture.getScaleFactor();

        snowman.setBounds(CENTER.anchoredAt(CENTER.ofView()).sized(
            width * scale, height * scale));

        return true;
    }
}
