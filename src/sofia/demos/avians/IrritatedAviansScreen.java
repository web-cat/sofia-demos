package sofia.demos.avians;

import sofia.app.ShapeScreen;
import sofia.demos.R;
import static sofia.graphics.Anchor.TOP;
import sofia.graphics.ImageShape;
import sofia.graphics.Color;
import sofia.graphics.RectangleShape;
import sofia.util.Random;
import android.graphics.PointF;
import android.graphics.RectF;

//-------------------------------------------------------------------------
/**
 * The main screen for the totally not copyright infringing Irritated Avians
 * game.
 *
 * @author  Tony Allevato
 * @author  Last changed by $Author: edwards $
 * @version $Date: 2012/08/06 11:12 $
 */
public class IrritatedAviansScreen extends ShapeScreen
{
	//~ Instance/static variables .............................................

	private Bird bird;


	//~ Methods ...............................................................

	// ----------------------------------------------------------
	public void initialize()
	{
		ImageShape background = new ImageShape(R.drawable.meadow,
				new RectF(0, 0, getWidth(), getHeight()));
		background.setZIndex(-200);
		add(background);

		PointF birdStart = new PointF(100, getHeight() - 100);

		RectangleShape pole = new RectangleShape(
				TOP.anchoredAt(birdStart).sized(20, 100));
		pole.setColor(Color.white);
		pole.setFilled(true);
		add(pole);

		bird = new Bird(birdStart);
		add(bird);

		placePigs();
	}


	// ----------------------------------------------------------
	private void placePigs()
	{
		Random random = Random.generator();

		for (int i = 0; i < 4; i++)
		{
			int hwidth = (int) (getWidth() / 2);
			int x = random.nextInt(hwidth) + hwidth;
			int y = random.nextInt((int) getHeight());

			Pig pig = new Pig(x, y);
			add(pig);
		}
	}
}
