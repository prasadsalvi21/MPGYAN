package com.ouch.mpgyan;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;

import android.app.ListActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.ouch.mpgyan.util.MPGUtility;

public class HistoricalListActivity extends ListActivity {

	static final String NAME_JSON_OBJECT = "name_json_object";
	JSONArray jsonArray;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.fragment_historical_list);
		setTitle("Historical Search Result");
		String s = (String) getIntent().getExtras().get(
				HistoricalSearchActivity.FILTERED_JSON_ARRAY);
		ArrayList<String> values = new ArrayList<String>();
		try {
			jsonArray = new JSONArray(s);
			for (int i = 0; i < jsonArray.length(); i++) {
				values.add((String) ((JSONArray) jsonArray.get(i)).get(0));
			}
		} catch (JSONException e) {
			Log.e("JSON","--------JSONException in HistoricalListActivity:onCreate-------");
		}
		setTitle(values.size()+" Results found");
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1, values);
		setListAdapter(adapter);
	}

	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {

		super.onListItemClick(l, v, position, id);
		int itemPosition = position;
		try {
			MPGUtility.passJSONArrayChangeActivity2(
					HistoricalListActivity.this,
					HistoricalResultActivity.class, (Integer) getIntent()
							.getExtras().get(HistoricalSearchActivity.YEAR),
					(JSONArray) jsonArray.get(itemPosition),
					HistoricalSearchActivity.YEAR, NAME_JSON_OBJECT);
		} catch (JSONException e) {
			Log.e("JSON","--------JSONException in HistoricalListActivity:onListItemClick-------");
		}
	}
}
