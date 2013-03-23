package com.example.trailapp;


import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.webkit.WebView;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;


public class MainActivity extends Activity implements OnItemSelectedListener {

	public final static String EXTRA_MESSAGE = "com.example.trailapp.MESSAGE";
	Context mContext;
	String GEOCODE_BASE_URL = "http://maps.googleapis.com/maps/api/geocode/json";
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		
	Spinner spinner = (Spinner) findViewById(R.id.spinner_Station);
	ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
		        R.array.stations_array, android.R.layout.simple_spinner_item);
	adapter.setDropDownViewResource(android.R.layout.select_dialog_singlechoice);
	spinner.setAdapter(adapter);
		
	}

	@Override	
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}
	
	public void viewMap (View view){
		//Intent intent = new Intent(this, DisplayMap.class);
		EditText editText = (EditText) findViewById(R.id.edit_Destination);
		String message = editText.getText().toString();
		
		String url = GEOCODE_BASE_URL + "?address=" + message.replace(" ","+") + "&sensor=false";
		
		//intent.putExtra(EXTRA_MESSAGE, url);
		//startActivity(intent);
				
		WebView MYwebView = (WebView) findViewById(R.id.MYwebView);
		MYwebView.loadUrl(url);

	}
		
    public void onItemSelected(AdapterView<?> parent, View view, 
            int pos, long id) {
    	Spinner spinner = (Spinner) findViewById(R.id.spinner_Station);
   	    spinner.setOnItemSelectedListener(this);
    }

    public void onNothingSelected(AdapterView<?> parent) {
    }	
	
}
	


