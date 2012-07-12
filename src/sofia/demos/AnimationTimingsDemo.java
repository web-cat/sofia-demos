package sofia.demos;

import android.widget.TextView;
import sofia.graphics.Shape;
import android.widget.Spinner;
import android.widget.CheckBox;
import android.graphics.RectF;
import android.view.animation.Interpolator;
import android.view.View;
import sofia.app.Screen;
import sofia.graphics.*;
import static sofia.graphics.Anchor.*;
import static sofia.graphics.Timings.*;

public class AnimationTimingsDemo extends Screen
{
    private ShapeView shapeView;
    private TextView statusLabel;
    private CheckBox delayAnimation;
    private Spinner repeatMode;
    private int repeatCount;

    private RectangleShape rectangle;
    private RectF startingBounds;
    private RectF endingBounds;


    // ----------------------------------------------------------
    public void initialize()
    {
        setContentView(R.layout.animation_timings);

        shapeView = (ShapeView) findViewById(R.id.shapeView);
        repeatMode = (Spinner) findViewById(R.id.repeatMode);
        delayAnimation = (CheckBox) findViewById(R.id.delayAnimation);
        statusLabel = (TextView) findViewById(R.id.statusLabel);

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
            .delay(delayAnimation.isChecked() ? 2000 : 0)
            .timing(timing)
            .listener(new DemoListener())
            .bounds(endingBounds)
            .color(Color.red)
            .repeatMode(RepeatMode.valueOf(
                repeatMode.getSelectedItem().toString()))
            .play();
    }


    // ----------------------------------------------------------
    public class DemoListener implements ShapeAnimationListener
    {
        // ----------------------------------------------------------
        public void onAnimationStart(Shape shape)
        {
            repeatCount = 0;
            statusLabel.setText("Started");
        }


        // ----------------------------------------------------------
        public void onAnimationRepeat(Shape shape, boolean backward)
        {
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
        public void onAnimationEnd(Shape shape)
        {
            statusLabel.setText("Ended");
        }
    }
}
