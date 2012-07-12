package sofia.demos;

import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import sofia.app.Screen;

public class BackAndForthScreenTwo extends Screen
{
    private TextView textView;
    private EditText textField;


    // ----------------------------------------------------------
    public void initialize(int value, String text)
    {
        setContentView(R.layout.back_and_forth_2);

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
