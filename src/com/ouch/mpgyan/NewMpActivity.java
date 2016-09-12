package com.ouch.mpgyan;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ScrollView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.ouch.mpgyan.listeners.CriteriaSelectedListener;
import com.ouch.mpgyan.util.MPGUtility;
import com.ouch.mpgyan.util.ServiceHandler;

public class NewMpActivity extends ActionBarActivity {
	private AutoCompleteTextView textView;
	
	private Spinner criteria_spinner;
	private ArrayAdapter<String> textadapter;
	private Button btnSubmit;
	private ProgressDialog pDialog;
	private static String url = "http://ouch-it.com/kym/election_results.json";
	private JSONObject results = null;
	private List<String> names;
	 private List<String> parties;
	 private List<String> constituencies;
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.fragment_new_mp);
		
		ScrollView sView = (ScrollView)findViewById(R.id.ScrollView01);
        sView.setVerticalScrollBarEnabled(true);
        sView.setHorizontalScrollBarEnabled(false);
		
		 TextView  resultStatus = (TextView) findViewById(R.id.result_status_text);
		 resultStatus.setSelected(true);
		 resultStatus.setText((String)getIntent().getExtras().get(MainActivity.STATUS));
		
		 TextView  comment1 = (TextView) findViewById(R.id.comment_1);
		 comment1.setText((String)getIntent().getExtras().get(MainActivity.COMMENT_1));
		 TextView  comment2 = (TextView) findViewById(R.id.comment_2);
		 comment2.setText((String)getIntent().getExtras().get(MainActivity.COMMENT_2));
		 TextView  comment3 = (TextView) findViewById(R.id.comment_3);
		 comment3.setText((String)getIntent().getExtras().get(MainActivity.COMMENT_3));
		 TextView  comment4 = (TextView) findViewById(R.id.comment_4);
		 comment4.setText((String)getIntent().getExtras().get(MainActivity.COMMENT_4));
		 textView = (AutoCompleteTextView) findViewById(R.id.main_autocomplete);
		 criteria_spinner = (Spinner) findViewById(R.id.criteria_spinner);
		 btnSubmit = (Button) findViewById(R.id.btnSubmit);
		
		btnSubmit.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {if(textView.getText().toString().equalsIgnoreCase("")){
				Toast toast = Toast.makeText(getApplicationContext(), "Oops! Please fill in some text to help us find your result", Toast.LENGTH_LONG);
				toast.show();
			}else{

				criteria_spinner = (Spinner) findViewById(R.id.criteria_spinner);
				textView = (AutoCompleteTextView) findViewById(R.id.main_autocomplete);
							
						try {JSONArray array= new  JSONArray();
						array = results.getJSONArray("results").getJSONObject(3).getJSONArray("data");
							
							 switch ((String)criteria_spinner.getSelectedItem()) {
							 case "Party":
								 array= MPGUtility.getJSONArrayForParty(4,array,textView.getText().toString());
								break;
							 case "MP Name":
								array=MPGUtility.getJSONArray(0,array,textView.getText().toString());
								break;
							 case "Constituency":
								array=MPGUtility.getJSONArray(2,array,textView.getText().toString());
								break;
							}
							if(array.length()>1){
							MPGUtility.passJSONArrayChangeActivity2(NewMpActivity.this, HistoricalListActivity.class, 16,array, HistoricalSearchActivity.YEAR,HistoricalSearchActivity.FILTERED_JSON_ARRAY);
							}else if(array.length()==0){
								Toast toast = Toast.makeText(getApplicationContext(), "Oops! No results found", Toast.LENGTH_LONG);
								toast.show();
							}
							else{
								MPGUtility.passJSONArrayChangeActivity2(NewMpActivity.this, HistoricalResultActivity.class,16, array,HistoricalSearchActivity.YEAR, HistoricalListActivity.NAME_JSON_OBJECT);
							}
						} catch (JSONException e) {
							Log.e("JSON","--------JSONException in HistoricalSearchActivity:OnClickListener:onClick-------");
						} 
						}	}
					});
			
	
			
	
		new GetResults().execute();
	}
	private void loadAutoCompleteData() {
		  names= new ArrayList<>();
		 parties= new ArrayList<>();
		constituencies= new ArrayList<>();
		JSONArray nameArray;
		JSONArray partyArray;
		JSONArray constituencyArray;
			try {
				nameArray = results.getJSONArray("results").getJSONObject(0).getJSONArray("names");
				partyArray = results.getJSONArray("results").getJSONObject(1).getJSONArray("parties");
				constituencyArray = results.getJSONArray("results").getJSONObject(2).getJSONArray("constituencies");
					 
			for(int i=0;i<nameArray.length();i++){
				names.add((String)nameArray.getString(i));
			}
			for(int i=0;i<partyArray.length();i++){
				parties.add((String)partyArray.getString(i));
			}
			for(int i=0;i<constituencyArray.length();i++){
				constituencies.add((String)constituencyArray.getString(i));
			}
				
			 textadapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, names);
			textView.setAdapter(textadapter);
			
			criteria_spinner.setOnItemSelectedListener(new CriteriaSelectedListener(NewMpActivity.this, textView, textadapter,  getResources(),true,names,parties,constituencies));
			
			} catch (JSONException e) {
				Log.e("JSON","--------JSONException in NewMpActivity:loadAutoCompleteData-------");
			}
		
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.new_mp, menu);
		return true;
	}
	
	@Override
    public boolean onOptionsItemSelected(MenuItem item) {
		return MPGUtility.createMenu(this,item);}
	private class GetResults extends AsyncTask<Void, Void, Void> {

		@Override
		protected void onPreExecute() {
			super.onPreExecute();
			pDialog = new ProgressDialog(NewMpActivity.this);
			pDialog.setMessage("Latest Updates on the way...Please wait");
			pDialog.setCancelable(true);
			pDialog.show();

		}

		@Override
		protected Void doInBackground(Void... arg0) {
			ServiceHandler sh = new ServiceHandler();
			String jsonStr = sh.makeServiceCall(url, ServiceHandler.GET);
			Log.d("Response: ", "> " + jsonStr);
			if (jsonStr != null) {
				try {
					results = new JSONObject(jsonStr);
				
				} catch (JSONException e) {
					e.printStackTrace();
				}
			} else {
				Log.e("ServiceHandler", "Couldn't get any election results from the url"+url);
			}

			return null;
		}

		@Override
		protected void onPostExecute(Void result) {
			super.onPostExecute(result);
			if (pDialog.isShowing())
				pDialog.dismiss();
			loadAutoCompleteData();
		}

	}
}

