package sofia.demos;

import sofia.app.*;
import sofia.graphics.*;
import static sofia.graphics.Anchor.*;

public class ShapeLayoutDemo extends ShapeScreen
{
    // ----------------------------------------------------------
    public void initialize()
    {
        RectangleShape centerRect = new RectangleShape(
            CENTER.anchoredAt(CENTER.ofView())
                .sizedProportionalToView(0.30, 0.30));
        centerRect.setColor(Color.red);
        centerRect.setFilled(true);

        RectangleShape topRect = new RectangleShape(
            BOTTOM.anchoredAt(TOP.of(centerRect).shiftBy(0, -5))
                .sizedProportionalTo(centerRect, 0.50, 0.50));
        topRect.setColor(Color.blue);
        topRect.setFilled(true);

        RectangleShape bottomRightRect = new RectangleShape(
            BOTTOM_RIGHT.of(centerRect).shiftBy(5, 5)
                .sizedProportionalTo(centerRect, 0.50, 0.50));
        bottomRightRect.setColor(Color.green);
        bottomRightRect.setFilled(true);

        add(centerRect);
        add(topRect);
        add(bottomRightRect);
    }
}
