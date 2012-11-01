package sofia.demos;

import android.widget.TextView;
import sofia.app.Screen;
import sofia.app.ScreenLayout;
import sofia.widget.ListView;
import sofia.widget.Spinner;

@ScreenLayout("list_demo")
public class ListDemo extends Screen
{
	private ListView listView;
	private Spinner spinner;
	private TextView label;
	
	
	public void initialize()
	{
		listView.add("List 1");
		listView.add("List 2");
		listView.add("List 3");

		spinner.add("Spinner 1");
		spinner.add("Spinner 2");
		spinner.add("Spinner 3");
	}
	
	
	public void listViewItemClicked(int position, String item)
	{
		label.setText("List item " + position + " = " + item);
	}


	public void spinnerItemSelected(int position, String item)
	{
		label.setText("Spinner item " + position + " = " + item);
	}


	public void spinnerNothingSelected()
	{
		label.setText("Spinner nothing selected");
	}
}
