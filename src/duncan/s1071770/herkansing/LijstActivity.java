package duncan.s1071770.herkansing;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.InterruptedIOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import org.json.JSONObject;
import com.example.androidtablayout.R;
import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.EditText;

public class LijstActivity extends Activity 
	{
	
	static InputStream is = null;
	static JSONObject jObj = null;
	static String json = "";
	public int port;
	public String naam, ip, bericht, portstring; 
	
    public void onCreate(Bundle savedInstanceState) 
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.solo);    
    }
    
    public void zetGegevens(String naamstuur, String ipstuur, String portstuur, String vraagstuur)
    {
    	this.naam = naamstuur;
    	this.ip = ipstuur;
    	this.bericht = vraagstuur;
    	this.portstring = portstuur;
    	
    	port = Integer.parseInt( portstring );
    }
    
    public void stuurBericht()
    {
		Socket serverSocket = new Socket();
		try 
		{
			serverSocket.connect( new InetSocketAddress( this.ip, this.port ), 4000 );
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//verzend een bericht naar de server
		this.sendMessage( bericht, serverSocket);
    }
    
	private void sendMessage( String message, Socket serverSocket )
	{
		OutputStreamWriter outputStreamWriter = null;
		
/*		try
		{
			outputStreamWriter = new OutputStreamWriter(null);
		}
		catch(IOException e5)
		{
			//doe lekker niets, programmaatje
		}

		if( outputStreamWriter != null )
		{
			BufferedWriter bufferedWriter = new  BufferedWriter(bufferedWriter);
			PrintWriter writer = new PrintWriter( bufferedWriter, true );
		}
*/	}
	
	
	//wacht op server bericht (na versturen)
	private String waitForResponse(Socket serverSocket)
	{
		String serverMessage = null;
		
		//...
		
		return serverMessage;
	}

}