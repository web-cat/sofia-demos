package sofia.demos;

import static sofia.graphics.Anchor.*;
import static sofia.graphics.Timings.*;
import sofia.app.Screen;
import sofia.graphics.Color;
import sofia.graphics.RectangleShape;
import sofia.graphics.RepeatMode;
import sofia.graphics.Shape;
import sofia.graphics.ShapeView;
import sofia.widget.Spinner;
import android.graphics.RectF;
import android.view.View;
import android.view.animation.Interpolator;
import android.widget.CheckBox;
import android.widget.TextView;

public class AnimationTimingsDemo extends Screen
{
    private ShapeView shapeView;
    private TextView statusLabel;
    private CheckBox delayAnimation;
    private Spinner<String> repeatMode;
    private int repeatCount;

    private RectangleShape rectangle;
    private RectF startingBounds;
    private RectF endingBounds;


    // ----------------------------------------------------------
    public void initialize()
    {
        startingBounds = TOP_LEFT.ofView().shiftBy(50, 5).sized(50, 50);
        endingBounds = TOP_RIGHT.anchoredAt(
            TOP_RIGHT.ofView().shiftBy(-50, 5)).sized(50, 50);

        rectangle = new RectangleShape(startingBounds);
        rectangle.setFilled(true);
        rectangle.setColor(Color.green);
        shapeView.add(rectangle);
    }


    // ----------------------------------------------------------
    public void easeInOutClicked(View view)
    {
        doAnimation(easeInOut());
    }


    // ----------------------------------------------------------
    public void easeInClicked(View view)
    {
        doAnimation(easeIn());
    }


    // ----------------------------------------------------------
    public void easeOutClicked(View view)
    {
        doAnimation(easeOut());
    }


    // ----------------------------------------------------------
    public void linearClicked(View view)
    {
        doAnimation(linear());
    }


    // ----------------------------------------------------------
    public void backInClicked(View view)
    {
        doAnimation(backIn());
    }


    // ----------------------------------------------------------
    public void backOutClicked(View view)
    {
        doAnimation(backOut());
    }


    // ----------------------------------------------------------
    public void backInOutClicked(View view)
    {
        doAnimation(backInOut());
    }


    // ----------------------------------------------------------
    public void bounceClicked(View view)
    {
        doAnimation(bounce());
    }


    // ----------------------------------------------------------
    public void cycleClicked(View view)
    {
        doAnimation(cycle(4));
    }


    // ----------------------------------------------------------
    public void elasticInOutClicked(View view)
    {
        doAnimation(elasticInOut());
    }


    // ----------------------------------------------------------
    public void elasticInClicked(View view)
    {
        doAnimation(elasticIn());
    }


    // ----------------------------------------------------------
    public void elasticOutClicked(View view)
    {
        doAnimation(elasticOut());
    }


    // ----------------------------------------------------------
    public void stopAnimationClicked(View view)
    {
        rectangle.stopAnimation();
    }


    // ----------------------------------------------------------
    private void doAnimation(Interpolator timing)
    {
        rectangle.setBounds(startingBounds);
        rectangle.setColor(Color.green);

        rectangle.animate(2000)
            .name("test")
            .delay(delayAnimation.isChecked() ? 2000 : 0)
            .timing(timing)
            .bounds(endingBounds)
            .color(Color.red)
            .repeatMode(RepeatMode.valueOf(
                repeatMode.getSelectedItem().toString()))
            .play();
    }


    // ----------------------------------------------------------
    public void testAnimationStarted(Shape.Animator<?> animator)
    {
        repeatCount = 0;
        statusLabel.setText("Started");
    }


    // ----------------------------------------------------------
    public void testAnimationRepeated(Shape.Animator<?> animator)
    {
        boolean backward = animator.isBackward();

        String text = "";
        if (backward)
        {
            text = "Backward";
        }
        else
        {
            repeatCount++;
            text = "Forward";
        }

        text += " (repeated " + repeatCount + " times)";
        statusLabel.setText(text);
    }


    // ----------------------------------------------------------
    public void testAnimationEnded(Shape.Animator<?> animator)
    {
        statusLabel.setText("Ended");
    }
}
