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
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import com.ouch.mpgyan.listeners.BillInformationListener;
import com.ouch.mpgyan.theads.BillInfoJSONParser;
import com.ouch.mpgyan.util.MPGUtility;
import com.ouch.mpgyan.util.ThreadControllers;

public class BillInfoActivity extends ActionBarActivity {
	protected static final String FILTERED_BILL_NO_INFO_JSON_ARRAY = "filtered_bill_no_info_array";
	protected static final String FILTERED_BILL_LIST_JSON_ARRAY = "filtered_bill_list_array";
	protected static final String FILTERED_BILL_RESULT_JSON_ARRAY = "filtered_bill_result_array";
	private Spinner criteria_spinner;
	private Spinner criteria_spinner2;
	private ArrayAdapter<String> textadapter;
	private Button btnSubmit;
	private BillInfoJSONParser thread;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.fragment_bill_info);
		setTitle("Bill Search");
		
		thread=ThreadControllers.createBillInfoThread(getAssets());
		ThreadControllers.runThread(thread);
		 criteria_spinner = (Spinner) findViewById(R.id.criteria_spinner);
		 criteria_spinner2 = (Spinner) findViewById(R.id.criteria_spinner2);
		 btnSubmit = (Button) findViewById(R.id.btnSubmit);
		String[] years =  getResources().getStringArray(R.array.bill_year_arrays);
		 textadapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, years);
		 criteria_spinner2.setAdapter(textadapter);
		
		criteria_spinner.setOnItemSelectedListener(new BillInformationListener(this, criteria_spinner2, textadapter,  getResources()));
		
		btnSubmit.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				ThreadControllers.joinThread(thread);
				JSONArray array=new JSONArray();
				JSONArray selectedYearArray = thread.getJarray();
				
				
					 array=MPGUtility.getFilteredJSONArray((String)criteria_spinner.getSelectedItem(),selectedYearArray,(String)criteria_spinner2.getSelectedItem());
					
				if(array.length()>1){
				MPGUtility.passJSONArrayChangeActivity(BillInfoActivity.this, BillListActivity.class, array, FILTERED_BILL_LIST_JSON_ARRAY);
				}else if(array.length()==0){
					Toast toast = Toast.makeText(getApplicationContext(), "Oops! No results found", Toast.LENGTH_LONG);
					toast.show();
				}
				else{
					try {
						MPGUtility.passJSONArrayChangeActivity(BillInfoActivity.this, BillResultActivity.class, array.getJSONObject(0), FILTERED_BILL_RESULT_JSON_ARRAY);
					} catch (JSONException e) {
						Log.e("JSON", "--------JSONException in BillInfoActivity:OnClickListener:onClick-------");
					}
				} 
				}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.bill_info, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		return MPGUtility.createMenu(this,item);
	}
}
