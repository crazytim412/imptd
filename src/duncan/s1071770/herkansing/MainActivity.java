package duncan.s1071770.herkansing;

import com.example.androidtablayout.R;
import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.GestureDetector.OnGestureListener;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;

//Main klasse van mijn app, hier worden de tabs aangemaakt en toegevoegd aan Tabhost

public class MainActivity extends TabActivity implements OnGestureListener
{
	private GestureDetector gestureScanner;
	private static final int SWIPE_MIN = 120;
    private static final int SWIPE_MAX_PAD = 250;
    private static final int SWIPE_LIMIET = 200;
    private TabHost tabHost;
    private TabSpec gevspec;
	private GegevensActivity ga;
   
	//Opstart, wordt aangeroepen als gebruiker app start
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        gestureScanner = new GestureDetector(this);
        
        //maak de tabHost aan
        tabHost = getTabHost();
        
        // Tab voor gegevens
        gevspec = tabHost.newTabSpec("Gegevens");
        gevspec.setIndicator("Gegevens", getResources().getDrawable(R.drawable.gegevens_tab));
        Intent gegevensIntent = new Intent(this, GegevensActivity.class);
        gevspec.setContent(gegevensIntent);
        
        // Tab voor opdrachten
        TabSpec lijstspec = tabHost.newTabSpec("Lijst");
        lijstspec.setIndicator("Lijst", getResources().getDrawable(R.drawable.lijst_tab));
        Intent lijstIntent = new Intent(this, LijstActivity.class);
        lijstspec.setContent(lijstIntent);

        
        // Adding all TabSpec to TabHost
        tabHost.addTab(gevspec); // gegevens tab
        tabHost.addTab(lijstspec); // Adding lijst tab
               
    }
        
    public boolean onTouchEvent(MotionEvent me)
    {
    	return gestureScanner.onTouchEvent(me);
    }
    
	public boolean onDown(MotionEvent e) {
		// niets
		return false;
	}

	public boolean onFling(MotionEvent e1, MotionEvent e2, float snelX,
			float snelY) 
	{
		if (Math.abs(e1.getY() - e2.getY()) > SWIPE_MAX_PAD)
            return false;
        // right to left swipe
        if(e1.getX() - e2.getX() > SWIPE_MIN && Math.abs(snelX) > SWIPE_LIMIET) 
        {
        	tabHost.setCurrentTab(1);
        	
        	// debug Toast.makeText(getApplicationContext(), "links", Toast.LENGTH_SHORT).show();
        }  
        else if (e2.getX() - e1.getX() > SWIPE_MIN && Math.abs(snelX) > SWIPE_LIMIET) 
        {
        	tabHost.setCurrentTab(0);
        	
        	// debug Toast.makeText(getApplicationContext(), "rechts", Toast.LENGTH_SHORT).show();
        }
        return false;
	}

	public void onLongPress(MotionEvent e) {
		// niets
		
	}

	public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX,
			float distanceY) {
		// niets
		return false;
	}

	public void onShowPress(MotionEvent e) {
		// niets
		
	}

	public boolean onSingleTapUp(MotionEvent e) {
		// niets
		return false;
	}

	public void buttonPress() {
		tabHost.setCurrentTab(0);
		ga.verstuur();
		
	}
}