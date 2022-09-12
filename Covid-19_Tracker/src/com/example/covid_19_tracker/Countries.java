package com.example.covid_19_tracker;

import org.json.JSONException;
import org.json.JSONObject;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.os.Build;

public class Countries extends ActionBarActivity {

	//String[] country = {"India", "Germany", "USA", "China", "Japan", "France"};
	TextView t1,t2,t3,t4,t5,title;
	String value;
	//ArrayAdapter<String>adapter;
	Bundle extras;
	String value1;
	String url;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_countries);

        /*Spinner spin = (Spinner) findViewById(R.id.spin1);  
		
		adapter = new ArrayAdapter(this,android.R.layout.simple_spinner_item,country);  
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);  
        //Setting the ArrayAdapter data on the Spinner  
        spin.setAdapter(adapter); */ 
        t1=(TextView)findViewById(R.id.cases);
        t2=(TextView)findViewById(R.id.heal);
        t3=(TextView)findViewById(R.id.dead);
        t4=(TextView)findViewById(R.id.active);
        t5=(TextView)findViewById(R.id.serious);
        //spin.setOnItemSelectedListener(this);
        
		title=(TextView)findViewById(R.id.title);
		extras=getIntent().getExtras();
		value1=extras.getString("value1");
		title.setText(value1);
		//url="https://corona.lmao.ninja/v2/countries/"+value1;
		//Toast.makeText(this, url, Toast.LENGTH_LONG).show();
		data();
		
	}
private void data() {
    	
	    url="https://corona.lmao.ninja/v2/countries/"+value1;
    	StringRequest request = new StringRequest(com.android.volley.Request.Method.GET,url,
    			new Response.Listener<String>() {
    		       @Override
    		        public void onResponse(String Responce){
    		        	
    		        	
						try {
							JSONObject js;
							js = new JSONObject(Responce.toString());
							t1.setText(js.getString("cases"));
							t2.setText(js.getString("recovered"));
							t3.setText(js.getString("deaths"));
							t4.setText(js.getString("active"));
							t5.setText(js.getString("critical"));
							
						} catch (JSONException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
    		        	
    		        	
    		        }
				},new Response.ErrorListener() {
					public void onErrorResponse(VolleyError error){
						
					}
				});
    	
    	RequestQueue rq = Volley.newRequestQueue(this);
    	rq.add(request);
		
	}


/*@Override
public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
	// TODO Auto-generated method stub
	value=adapter.getItem(arg2);
}

@Override
public void onNothingSelected(AdapterView<?> arg0) {
	// TODO Auto-generated method stub
	
}*/
public void show(View v) {
	//Toast.makeText(this, value, Toast.LENGTH_LONG).show();
	Intent i=new Intent(getApplicationContext(),MainActivity.class);
	//i.putExtra("value1", value);
	startActivity(i);
}

}
