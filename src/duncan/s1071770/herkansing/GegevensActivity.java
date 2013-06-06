package duncan.s1071770.herkansing;

import com.example.androidtablayout.R;
import android.app.Activity;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class GegevensActivity extends Activity 
{

	private EditText naamedit, ipedit, portedit, vraagedit;
	private String naamstuur, ipstuur, portstuur, vraagstuur;
	private LijstActivity la;
	private Button button;
	private NetworkInfo netInfo;
	private MainActivity ma;
	
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gevlo);  
		 ConnectivityManager cm =
			        (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
		netInfo = cm.getActiveNetworkInfo();
    }
	
	public void addListenerOnButton() {
    button = (Button)this.findViewById(R.id.startknop);
    button.setOnClickListener(new OnClickListener() {

	public void onClick(View arg0) {
		if (netInfo != null && netInfo.isConnectedOrConnecting() ) {
    		ma.buttonPress();
		}
		else
		{
			Toast.makeText(getApplicationContext(), "Geen Internet!", Toast.LENGTH_SHORT).show();
		}
								}
    			});
	}
	public void verstuur() {
		naamedit = (EditText)findViewById(R.id.naamveld);
		ipedit = (EditText)findViewById(R.id.ipveld);
		portedit = (EditText)findViewById(R.id.poortveld);
		vraagedit = (EditText)findViewById(R.id.vraagveld);
		
		naamstuur = naamedit.getText().toString();
		ipstuur = ipedit.getText().toString();
		portstuur = portedit.getText().toString();
		vraagstuur = vraagedit.getText().toString();
		
		la.zetGegevens(naamstuur, ipstuur, portstuur, vraagstuur);
	}
}