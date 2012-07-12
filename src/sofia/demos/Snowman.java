package sofia.demos;

import android.graphics.RectF;
import sofia.graphics.*;
import static sofia.graphics.Anchor.*;

public class Snowman extends CompositeShape
{
    // ----------------------------------------------------------
    public Snowman(RectF bounds)
    {
        super(bounds);

        OvalShape head = new OvalShape(
            TOP.anchoredAt(TOP.of(this)).sizedProportionalTo(this, 0.20, 0.20));
        head.setFilled(true);
        head.setFillColor(Color.white);

        OvalShape middle = new OvalShape(
            BOTTOM.anchoredAt(CENTER.of(this)).sizedProportionalTo(this, 0.30, 0.30));
        middle.setFilled(true);
        middle.setFillColor(Color.white);

        OvalShape bottom = new OvalShape(
            BOTTOM.anchoredAt(BOTTOM.of(this)).sizedProportionalTo(this, 0.50, 0.50));
        bottom.setFilled(true);
        bottom.setFillColor(Color.white);

        add(head);
        add(middle);
        add(bottom);
    }
}
