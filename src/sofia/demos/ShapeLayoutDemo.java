package sofia.demos;

import java.util.Set;

import sofia.app.*;
import sofia.graphics.*;

public class ShapeLayoutDemo extends ShapeScreen
{
    private RectangleShape shape1;
    private RectangleShape shape2;
    private RectangleShape shape3;
    private RectangleShape shape4;

    // ----------------------------------------------------------
    public void initialize()
    {
        shape1 = new RectangleShape(100, 100, 200, 200);
        shape1.setColor(Color.red);
        shape1.setFilled(true);

        shape2 = new RectangleShape(50, 50, 150, 150);
        shape2.setColor(Color.yellow);
        shape2.setFilled(true);

        shape3 = new RectangleShape(25, 125, 125, 225);
        shape3.setColor(Color.blue);
        shape3.setFilled(true);

        add(shape1);
        add(shape2);
        add(shape3);

        printShapesInOrder();
    }


    // ----------------------------------------------------------
    public void onTouchDown(float x, float y)
    {
        RectangleShape shape = getShapeAt(x, y, RectangleShape.class);

        if (shape != null)
        {
            shape.remove();
        }
        else
        {
            shape1.setZIndex(1000);

            shape4 = new RectangleShape(50, 50, 250, 250);
            shape4.setColor(Color.green);
            shape4.setFilled(true);
            shape4.setZIndex(-500);
            add(shape4);
        }

        printShapesInOrder();
    }


    // ----------------------------------------------------------
    private void printShapesInOrder()
    {
        System.out.println("----");

        for (Shape shape : getShapes())
        {
            System.out.println(shape);
        }
    }
}
