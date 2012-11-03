package sofia.demos;

import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import sofia.app.Screen;
import sofia.app.ScreenLayout;

public class BackAndForthScreenTwo extends Screen
{
    private TextView textView;
    private EditText textField;


    // ----------------------------------------------------------
    public void initialize(int value, String text)
    {
        textView.setText("You slid to "
            + value + " on the seek bar and typed "
            + text + " in the text field.");
    }


    // ----------------------------------------------------------
    public void sendValueBack(View view)
    {
        String enteredText = textField.getText().toString();
        finish(enteredText);
    }
}
