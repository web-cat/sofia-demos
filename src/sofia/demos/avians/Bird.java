package sofia.demos.avians;

import static sofia.graphics.Anchor.CENTER;
import sofia.demos.R;
import sofia.graphics.ImageShape;
import sofia.graphics.Color;
import sofia.graphics.Geometry;
import sofia.graphics.OvalShape;
import sofia.graphics.Shape;
import sofia.graphics.ShapeAnimationAdapter;
import sofia.graphics.Timings;
import sofia.graphics.ViewEdges;
import android.graphics.PointF;
import android.view.MotionEvent;

//-------------------------------------------------------------------------
/**
 * Represents a bird in the Irritated Avians game.
 *
 * @author  Tony Allevato
 * @author  Last changed by $Author: edwards $
 * @version $Date: 2012/08/04 16:34 $
 */
public class Bird extends ImageShape
{
	//~ Instance/static variables .............................................

	private final static float GRAVITY = 9.8f / 5;

	private PointF startingPosition;


	//~ Constructors ..........................................................

	// ----------------------------------------------------------
	public Bird(PointF start)
	{
		super(R.drawable.bird, CENTER.anchoredAt(start).sized(40, 26));

		startingPosition = start;
	}


	//~ Methods ...............................................................

	// ----------------------------------------------------------
	public void reset()
	{
		stopAnimation();
		setPosition(CENTER.anchoredAt(startingPosition));
	}


	// ----------------------------------------------------------
	public void onCollisionWith(ViewEdges edges)
	{
		if (edges.bottom())
		{
			reset();
		}
	}


	// ----------------------------------------------------------
	public void onCollisionWith(Pig pig)
	{
		reset();
	}


	// ----------------------------------------------------------
	public void onTouchMove(MotionEvent e)
	{
		float distance = Geometry.distanceBetween(
				startingPosition.x, startingPosition.y, e.getX(), e.getY());
		float angle = Geometry.angleBetween(
				startingPosition.x, startingPosition.y, e.getX(), e.getY());

		distance = Math.min(distance, 30.0f);

		PointF newPosition = Geometry.polarShift(
				startingPosition, angle, distance);

		setPosition(CENTER.anchoredAt(newPosition));
	}


	// ----------------------------------------------------------
	public void onTouchUp(MotionEvent e)
	{
		float dx = e.getX() - startingPosition.x;
		float dy = e.getY() - startingPosition.y;

		fling(-dx, -dy);
	}


	// ----------------------------------------------------------
	public void fling(float vx, float vy)
	{
		animate(250)
			.timing(Timings.linear())
			.repeat()
			.moveBy(vx / 2, vy / 2, 0, GRAVITY)
			.listener(new FlightTrailListener())
			.play();
	}


	//~ Inner classes .........................................................

	// ----------------------------------------------------------
	private class FlightTrailListener extends ShapeAnimationAdapter
	{
		// ----------------------------------------------------------
		@Override
		public void onAnimationRepeat(Shape shape, boolean backward)
		{
			OvalShape dot = new OvalShape(CENTER.of(Bird.this).sized(5, 5));
			dot.setFillColor(Color.white);
			dot.setColor(Color.rgb(232, 232, 232));
			dot.setFilled(true);
			dot.setZIndex(-100);
			addOther(dot);

			dot.animate(500).delay(1000).alpha(0).removeWhenComplete().play();
		}
	}
}
