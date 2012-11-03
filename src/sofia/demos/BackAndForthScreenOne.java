package sofia.demos;

import sofia.app.Screen;
import sofia.app.ScreenLayout;
import android.view.View;
import android.widget.EditText;
import android.widget.SeekBar;

// -------------------------------------------------------------------------
/**
 *  Write a one-sentence summary of your class here.
 *  Follow it with additional details about its purpose, what abstraction
 *  it represents, and how to use it.
 *
 *  @author  Tony Allevato
 *  @version 2011.12.17
 */
public class BackAndForthScreenOne extends Screen
{
    private SeekBar seekBar;
    private EditText textField;


    // ----------------------------------------------------------
    public void openScreenTwo(View view)
    {
        presentScreen(BackAndForthScreenTwo.class,
                seekBar.getProgress(), textField.getText().toString());
    }


    // ----------------------------------------------------------
    public void backAndForthScreenTwoFinished(String result)
    {
        showConfirmationDialog("Result", "You entered " + result);
    }
}
