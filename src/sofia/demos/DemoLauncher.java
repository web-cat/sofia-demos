package sofia.demos;

import java.util.ArrayList;
import java.util.List;

import sofia.app.ListScreen;
import sofia.app.OptionsMenu;
import sofia.content.MediaChooser;
import sofia.content.PhotoCamera;
import sofia.demos.avians.IrritatedAviansScreen;
import sofia.demos.breakout.BreakoutScreen;
import sofia.demos.pong.PongScreen;
import android.app.Activity;

// -------------------------------------------------------------------------
/**
 * A launcher for the other demos in the project. The demos are presented in a
 * full screen list view.
 *
 * @author  Tony Allevato
 * @version 2011.12.04
 */
@OptionsMenu("launcher")
public class DemoLauncher extends ListScreen<DemoClass>
{
	//~ Fields ................................................................

	private static final List<DemoClass> demoList;
	static 
	{
		demoList = new ArrayList<DemoClass>();
		demoList.add(new DemoClass(HelloWorldDemo.class));
		demoList.add(new DemoClass(ShapeLayoutDemo.class));
		demoList.add(new DemoClass(MultiTouchDotsDemo.class));
		demoList.add(new DemoClass(GestureDemo.class));
		demoList.add(new DemoClass(ConnectFour.class));
		demoList.add(new DemoClass(AnimationTimingsDemo.class));
		demoList.add(new DemoClass(MarkerDemo.class));
		demoList.add(new DemoClass(BackAndForthScreenOne.class));
		demoList.add(new DemoClass(PongScreen.class));
		demoList.add(new DemoClass(BreakoutScreen.class));
		demoList.add(new DemoClass(IrritatedAviansScreen.class));
		demoList.add(new DemoClass(CompositeShapeDemo.class));
		demoList.add(new DemoClass(JoystickDemo.class));
		demoList.add(new DemoClass(ListDemo.class));
	}


	//~ Methods ...............................................................

	// ----------------------------------------------------------
	public void initialize()
	{
		addAll(demoList);
	}


	// ----------------------------------------------------------
	public void listViewItemClicked(DemoClass demoToLaunch)
	{
		if (demoToLaunch.getType().equals(GestureDemo.class))
		{
			presentScreen(GestureDemo.class, (Object) null);			
		}
		else
		{
			presentScreen(demoToLaunch.getType());
		}
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
}


//-------------------------------------------------------------------------
/**
 * Wraps an activity class with a nice toString method so that it can be
 * displayed in the list view.
 */
class DemoClass
{
	//~ Fields ................................................................

	private Class<? extends Activity> type;

	
	//~ Constructors ..........................................................
	
	// ----------------------------------------------------------
	public DemoClass(Class<? extends Activity> type)
	{
		this.type = type;
	}


	//~ Methods ...............................................................

	// ----------------------------------------------------------
	public Class<? extends Activity> getType()
	{
		return type;
	}


	// ----------------------------------------------------------
	public String toString()
	{
		return type.getSimpleName();
	}
}
