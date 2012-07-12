package sofia.demos;

import java.util.ArrayList;

import sofia.gps.LocationTracker;
import sofia.maps.MapScreen;
import sofia.maps.MarkerOverlay;
import sofia.maps.RouteOverlay;
import android.graphics.Color;
import android.graphics.Paint;
import android.location.Location;
import android.util.Log;
import android.widget.Toast;

import com.google.android.maps.GeoPoint;

public class MarkerDemo extends MapScreen
{
	private ArrayList<MapItem> items;


	// ----------------------------------------------------------
	public void initialize()
	{
		items = new ArrayList<MapItem>();
		items.add(new MapItem(31.5f, -80.75f, "Test", null));
		items.add(new MapItem(0.5f, -81.75f, "Another Test", "21 Jump Street\nHill Street Blues"));
		items.add(new MapItem(-33.5f, -82.75f, "This marker has a really long title, what should I do with it?", null));

		Paint routePaint = new Paint();
		routePaint.setColor(Color.BLUE);
		routePaint.setAlpha(224);
		routePaint.setAntiAlias(true);
		routePaint.setStrokeWidth(4.0f);
		routePaint.setStyle(Paint.Style.STROKE);

		MarkerOverlay<MapItem> overlay = new MarkerOverlay<MapItem>(
				getMapView(), items);
		RouteOverlay<MapItem> route = new RouteOverlay<MapItem>(
				getMapView(), items, routePaint);
		getMapView().getOverlays().add(route);
		getMapView().getOverlays().add(overlay);
		
		LocationTracker tracker = new LocationTracker(this);
		tracker.setTimeInterval(0);
		tracker.startTracking();
	}
	

	// ----------------------------------------------------------
	public void onLocationChanged(Location loc)
	{
		Log.i("Demo", loc.getLatitude() + ", " + loc.getLongitude());
		getMapView().getController().animateTo(new GeoPoint(
				(int) (loc.getLatitude() * 1e6),
				(int) (loc.getLongitude() * 1e6)));
	}

	
	// ----------------------------------------------------------
	public boolean onMapItemClicked(MapItem item)
	{
		// Returning true consumes the event, which prevents the pop-up balloon
		// from appearing.

		if (item.getTitle().equals("Test"))
		{
			return true;
		}
		else
		{
			return false;
		}
	}


	// ----------------------------------------------------------
	public void onMapBalloonClicked(MapItem item)
	{
		Toast.makeText(this, item.getTitle() + "'s balloon was clicked",
				Toast.LENGTH_SHORT).show();
	}
}
