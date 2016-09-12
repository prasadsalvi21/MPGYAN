package com.ouch.mpgyan;

import org.json.JSONArray;
import org.json.JSONException;

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
import android.widget.Spinner;
import android.widget.Toast;

import com.ouch.mpgyan.listeners.CriteriaSelectedListener;
import com.ouch.mpgyan.listeners.YearSelectedListener;
import com.ouch.mpgyan.theads.HistoricalJSONParserThread;
import com.ouch.mpgyan.util.MPGUtility;
import com.ouch.mpgyan.util.ThreadControllers;



public class HistoricalSearchActivity extends ActionBarActivity  {
	private Spinner criteria_spinner;
	private Spinner year_spinner;
	private AutoCompleteTextView textView;
	private ArrayAdapter<String> textadapter;
	private HistoricalJSONParserThread thread;
	
	public static int year;
	private static final String STATE_SELECTED_NAVIGATION_ITEM = "selected_navigation_item";
	protected static final String FILTERED_JSON_ARRAY = "filtered_json_array";
	protected static final String YEAR = "year";
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.fragment_historical_search);
		setTitle("Historical Search");
		thread=ThreadControllers.createHistoricalThread(getAssets());
		ThreadControllers.runThread(thread);
		addDefaultAutocompleteOutput();
		addListenerOnYearSpinnerItemSelection();
		addListenerOnCriteriaSpinnerItemSelection();
		addListenerOnButton();
	}
	public void addDefaultAutocompleteOutput() {
		year=15;
		textView = (AutoCompleteTextView) findViewById(R.id.autocomplete);
		String[] names =  getResources().getStringArray(R.array.name_15_arrays);
		textadapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1, names);
		textView.setAdapter(textadapter);
	}
	public void addListenerOnYearSpinnerItemSelection() {
		criteria_spinner = (Spinner) findViewById(R.id.criteria_spinner);
		year_spinner = (Spinner) findViewById(R.id.year_spinner);
		year_spinner.setOnItemSelectedListener(new YearSelectedListener(
				this, textView, textadapter,  getResources(),criteria_spinner));
	}
	public void addListenerOnCriteriaSpinnerItemSelection() {
		year_spinner = (Spinner) findViewById(R.id.year_spinner);
		criteria_spinner = (Spinner) findViewById(R.id.criteria_spinner);
		criteria_spinner.setOnItemSelectedListener(new CriteriaSelectedListener(
				this, textView, textadapter,  getResources(),year_spinner));
	}
	public void addListenerOnButton() {
		criteria_spinner = (Spinner) findViewById(R.id.criteria_spinner);
		textView = (AutoCompleteTextView) findViewById(R.id.autocomplete);
		Button btnSubmit = (Button) findViewById(R.id.btnSubmit);
		btnSubmit.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {if(textView.getText().toString().equalsIgnoreCase("")){
				Toast toast = Toast.makeText(getApplicationContext(), "Oops! Please fill in some text to help us find your result", Toast.LENGTH_LONG);
				toast.show();
			}else{
				try {
					ThreadControllers.joinThread(thread);
					JSONArray array=new JSONArray();
					JSONArray selectedYearArray = thread.getJobject().getJSONArray("json").getJSONObject(year).getJSONArray("data");
					
					 switch ((String)criteria_spinner.getSelectedItem()) {
					 case "Party":
						 array= year<12?MPGUtility.getJSONArrayForParty(4,selectedYearArray,textView.getText().toString()):MPGUtility.getJSONArrayForParty(3,selectedYearArray,textView.getText().toString());
						break;
					 case "MP Name":
						array=MPGUtility.getJSONArray(0,selectedYearArray,textView.getText().toString());
						break;
					 case "Constituency":
						array=MPGUtility.getJSONArray(2,selectedYearArray,textView.getText().toString());
						break;
					}
					if(array.length()>1){
					MPGUtility.passJSONArrayChangeActivity2(HistoricalSearchActivity.this, HistoricalListActivity.class, year,array, YEAR,FILTERED_JSON_ARRAY);
					}else if(array.length()==0){
						Toast toast = Toast.makeText(getApplicationContext(), "Oops! No results found", Toast.LENGTH_LONG);
						toast.show();
					}
					else{
						MPGUtility.passJSONArrayChangeActivity2(HistoricalSearchActivity.this, HistoricalResultActivity.class, year,array, YEAR,HistoricalListActivity.NAME_JSON_OBJECT);
					}
				} catch (JSONException e) {
					Log.e("JSON","--------JSONException in HistoricalSearchActivity:OnClickListener:onClick-------");
				} 
			}}
			});
	}
	@Override
	public void onRestoreInstanceState(Bundle savedInstanceState) {
		if (savedInstanceState.containsKey(STATE_SELECTED_NAVIGATION_ITEM)) {
			getSupportActionBar().setSelectedNavigationItem(
					savedInstanceState.getInt(STATE_SELECTED_NAVIGATION_ITEM));
		}
	}
	@Override
	public void onSaveInstanceState(Bundle outState) {
		outState.putInt(STATE_SELECTED_NAVIGATION_ITEM, getSupportActionBar()
				.getSelectedNavigationIndex());
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.historical_search, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		return MPGUtility.createMenu(this,item);
		}

}
