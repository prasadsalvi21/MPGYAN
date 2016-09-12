package com.ouch.mpgyan;


import java.util.ArrayList;
import java.util.HashMap;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.ListActivity;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListAdapter;
import android.widget.SimpleAdapter;

import com.ouch.mpgyan.util.MPGUtility;
import com.ouch.mpgyan.util.ServiceHandler;

public class LiveFeedActivity extends ListActivity {
	private ProgressDialog pDialog;

	private static String url = "http://ouch-it.com/kym/feeds.json";

	private static final String TAG_DATE = "date";
	private static final String TAG_TITLE = "title";
	private static final String TAG_SDESC = "sdesc";

	private JSONArray feeds = null;

	private ArrayList<HashMap<String, String>> feedsList;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.fragment_live_feed);
		feedsList = new ArrayList<HashMap<String, String>>();

		new GetFeeds().execute();
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.live_feed, menu);
		return true;
	}
	
	@Override
    public boolean onOptionsItemSelected(MenuItem item) {
		return MPGUtility.createMenu(this,item);}
	
	
	private class GetFeeds extends AsyncTask<Void, Void, Void> {

		@Override
		protected void onPreExecute() {
			super.onPreExecute();
			pDialog = new ProgressDialog(LiveFeedActivity.this);
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
					feeds = new JSONArray(jsonStr);
					for (int i = 0; i < feeds.length(); i++) {
						JSONObject c = (JSONObject)feeds.get(i);
						
						String date = c.getString(TAG_DATE);
						String title = c.getString(TAG_TITLE);
						String sdesc = c.getString(TAG_SDESC);

						HashMap<String, String> feed = new HashMap<String, String>();
						feed.put(TAG_DATE, date);
						feed.put(TAG_TITLE, title);
						feed.put(TAG_SDESC, sdesc);

						feedsList.add(feed);
					}
				} catch (JSONException e) {
					e.printStackTrace();
				}
			} else {
				Log.e("ServiceHandler", "Couldn't get any feeds from the url"+url);
			}

			return null;
		}


		@Override
		protected void onPostExecute(Void result) {
			super.onPostExecute(result);
			if (pDialog.isShowing())
				pDialog.dismiss();
			ListAdapter adapter = new SimpleAdapter(
					LiveFeedActivity.this, feedsList,
					R.layout.list_item, new String[] { TAG_TITLE, TAG_DATE,
							TAG_SDESC}, new int[] { R.id.title,
							R.id.date, R.id.sdesc });
			setListAdapter(adapter);
		}

	}
}
