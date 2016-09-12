package com.ouch.mpgyan;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.ListActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.ouch.mpgyan.util.MPGUtility;

public class BillListActivity extends ListActivity{

	JSONArray jsonArray;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.fragment_bill_list);

		String s=(String) getIntent().getExtras().get(BillInfoActivity.FILTERED_BILL_LIST_JSON_ARRAY);
		ArrayList<String> values=new ArrayList<String>();
			try {
					jsonArray = new JSONArray(s);
					for(int i=0;i<jsonArray.length();i++){
						values.add((String) ((JSONObject) jsonArray.get(i)).get("Title"));
					} 
				}catch (JSONException e) {
					Log.e("JSON", "--------JSONException in BillListActivity:onCreate-------");
				}
		
			setTitle(values.size()+" Results found");
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
		        android.R.layout.simple_list_item_1, values);
		setListAdapter(adapter); 
	}
	
	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		
		super.onListItemClick(l, v, position, id);
		   int itemPosition     = position;
		   try {
			MPGUtility.passJSONArrayChangeActivity(BillListActivity.this, BillResultActivity.class, jsonArray.getJSONObject(itemPosition), BillInfoActivity.FILTERED_BILL_RESULT_JSON_ARRAY);
		} catch (JSONException e) {
			Log.e("JSON", "--------JSONException in BillListActivity:onListItemClick-------");
		}
	}
}
