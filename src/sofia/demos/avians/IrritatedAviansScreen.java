package sofia.demos.avians;

import static sofia.graphics.Anchor.TOP;

import java.util.Random;

import sofia.app.ShapeScreen;
import sofia.demos.R;
import sofia.graphics.BitmapShape;
import sofia.graphics.Color;
import sofia.graphics.RectangleShape;
import android.graphics.PointF;
import android.graphics.RectF;

//-------------------------------------------------------------------------
/**
 * The main screen for the totally not copyright infringing Irritated Avians
 * game.
 *
 * @author  Tony Allevato
 * @author  Last changed by $Author$
 * @version $Revision$, $Date$
 */
public class IrritatedAviansScreen extends ShapeScreen
{
	//~ Instance/static variables .............................................

	private Bird bird;


	//~ Methods ...............................................................

	// ----------------------------------------------------------
	public void initialize()
	{
		BitmapShape background = new BitmapShape(R.drawable.meadow,
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
		Random random = new Random();

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
