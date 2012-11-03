package sofia.demos;

import sofia.app.Screen;
import sofia.widget.ListView;
import sofia.widget.Spinner;
import android.widget.TextView;

public class ListDemo extends Screen
{
    //~ Fields ................................................................

    private ListView<String> listView;
    private Spinner<String> spinner;
    private TextView label;


    //~ Methods ...............................................................

    // ----------------------------------------------------------
    public void initialize()
    {
        listView.add("List 1");
        listView.add("List 2");
        listView.add("List 3");

        spinner.add("Spinner 1");
        spinner.add("Spinner 2");
        spinner.add("Spinner 3");
    }


    // ----------------------------------------------------------
    public void listViewItemClicked(String item, int position)
    {
        label.setText("List item " + position + " = " + item);
    }


    // ----------------------------------------------------------
    public void spinnerItemSelected(String item, int position)
    {
        label.setText("Spinner item " + position + " = " + item);
    }


    // ----------------------------------------------------------
    public void spinnerNothingSelected()
    {
        label.setText("Spinner nothing selected");
    }
}
