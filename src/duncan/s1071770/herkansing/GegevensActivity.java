package duncan.s1071770.herkansing;

import com.example.androidtablayout.R;
import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class GegevensActivity extends Activity 
{

	EditText naamedit, ipedit, portedit, vraagedit;
	String naamstuur, ipstuur, portstuur, vraagstuur;
	LijstActivity la;
	
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gevlo);   
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