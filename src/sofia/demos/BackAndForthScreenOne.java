package sofia.demos;

import android.view.View;
import android.widget.EditText;
import android.widget.SeekBar;
import sofia.app.Screen;

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
    public void initialize()
    {
        setContentView(R.layout.back_and_forth_1);
    }


    // ----------------------------------------------------------
    public void openScreenTwo(View view)
    {
        /*String result = presentScreen(
            BackAndForthScreenTwo.class, String.class,
            seekBar.getProgress(), textField.getText().toString());

        showConfirmationDialog("Result", "You entered " + result);*/
    }
}
