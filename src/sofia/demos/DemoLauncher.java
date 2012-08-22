package sofia.demos;

import java.util.ArrayList;

import sofia.app.OptionsMenu;
import sofia.app.Persistent;
import sofia.app.Screen;
import sofia.app.ScreenLayout;
import sofia.content.MediaChooser;
import sofia.content.PhotoCamera;
import sofia.data.InspectorScreen;
import sofia.demos.avians.IrritatedAviansScreen;
import sofia.demos.breakout.BreakoutScreen;
import sofia.demos.pong.PongScreen;
import sofia.graphics.Color;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.maps.GeoPoint;

// -------------------------------------------------------------------------
/**
 * Write a one-sentence summary of your class here.
 * Follow it with additional details about its purpose, what abstraction
 * it represents, and how to use it.
 *
 * @author  Tony Allevato
 * @version 2011.12.04
 */
@ScreenLayout(R.layout.launcher)
@OptionsMenu(R.menu.launcher)
public class DemoLauncher extends Screen
{
	private Button helloWorld;


    // ----------------------------------------------------------
    public void helloWorldClicked()
    {
        presentScreen(HelloWorldDemo.class);
    }


    // ----------------------------------------------------------
    public void dotsClicked()
    {
        presentScreen(MultiTouchDotsDemo.class);
    }


    // ----------------------------------------------------------
    public void gesturesClicked()
    {
    	//MediaChooser chooser = new MediaChooser();
    	//chooser.start(this);
		presentScreen(GestureDemo.class, (Object) null);
    }

    
    // ----------------------------------------------------------
    public void mediaWasChosen(MediaChooser chooser)
    {
    	if (!chooser.wasCanceled())
    	{
    		presentScreen(GestureDemo.class, chooser.getBitmap());
    	}
    }


    // ----------------------------------------------------------
    public void photoWasTaken(PhotoCamera chooser)
    {
    	if (!chooser.wasCanceled())
    	{
    		presentScreen(GestureDemo.class, chooser.getBitmap());
    	}
    }


    // ----------------------------------------------------------
    public void animationTimingsClicked(View view)
    {
        presentScreen(AnimationTimingsDemo.class);
    }


    // ----------------------------------------------------------
    public void shapeLayoutClicked(View view)
    {
        presentScreen(ShapeLayoutDemo.class);
    }


    // ----------------------------------------------------------
    public void connectFourClicked(View view)
    {
        presentScreen(ConnectFour.class);
    }


    // ----------------------------------------------------------
    public void mapClicked(View view)
    {
        presentScreen(MarkerDemo.class);
    }


    // ----------------------------------------------------------
    public void backAndForthClicked(View view)
    {
        presentScreen(BackAndForthScreenOne.class);
    }


    // ----------------------------------------------------------
    public void compositeShapesClicked(View view)
    {
        presentScreen(CompositeShapeDemo.class);
    }


    // ----------------------------------------------------------
    public void pongClicked(View view)
    {
        presentScreen(PongScreen.class);
    }


    // ----------------------------------------------------------
    public void breakoutClicked(View view)
    {
        presentScreen(BreakoutScreen.class);
    }


    // ----------------------------------------------------------
    public void irritatedAviansClicked(View view)
    {
        presentScreen(IrritatedAviansScreen.class);
    }


    // ----------------------------------------------------------
    public void inspectorClicked(View view)
    {
    }
    
    
    // ----------------------------------------------------------
    public void joystickDemoClicked(View view)
    {
    	presentScreen(JoystickDemo.class);
    }
}
