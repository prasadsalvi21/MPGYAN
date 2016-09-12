package com.ouch.mpgyan;

import org.json.JSONException;
import org.json.JSONObject;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ScrollView;
import android.widget.Toast;

import com.ouch.mpgyan.util.MPGUtility;
import com.ouch.mpgyan.util.ServiceHandler;

public class MainActivity extends ActionBarActivity {
	private Button btnSubmit;
	private Button getLiveFeed;
	private Button getVitalStats;
	private Button getHistoricalSearch;
	private Button getBillSearch;
	
	private static String url = "http://ouch-it.com/kym/config.json";
	protected static final String STATUS = "result_status";
	protected static final String COMMENT_1 = "comment1";
	protected static final String COMMENT_2 = "comment2";
	protected static final String COMMENT_3 = "comment3";
	protected static final String COMMENT_4 = "comment4";
	private ProgressDialog pDialog;
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.fragment_main);
		
		ScrollView sView = (ScrollView)findViewById(R.id.ScrollView01);
        sView.setVerticalScrollBarEnabled(true);
        sView.setHorizontalScrollBarEnabled(false);
     
		 btnSubmit = (Button) findViewById(R.id.goToResults);
		 getLiveFeed = (Button) findViewById(R.id.liveFeedSubmit);
		 getVitalStats = (Button) findViewById(R.id.goToVitalStats);
		 getBillSearch = (Button) findViewById(R.id.goToBillSearch);
		 getHistoricalSearch = (Button) findViewById(R.id.goToHistoricalSearch);
		 
		
	        
		btnSubmit.setOnClickListener(new OnClickListener() {
			
				@Override
				public void onClick(View v) {if(isNetworkAvailable()){
					new CheckResultDeclared().execute();
				}else{
					Toast toast = Toast.makeText(getApplicationContext(), "Oops! Network Connection problem. Please check your internet settings", Toast.LENGTH_LONG);
					toast.show();
				}
			
			}
		});
		getLiveFeed.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {if(isNetworkAvailable()){
				Intent intent= new Intent(MainActivity.this, LiveFeedActivity.class);
				startActivity(intent);
			}else{
				Toast toast = Toast.makeText(getApplicationContext(), "Oops! Network Connection problem. Please check your internet settings", Toast.LENGTH_LONG);
				toast.show();
			}
			}
		});
		getVitalStats.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent= new Intent(MainActivity.this, VitalStatsActivity.class);
				startActivity(intent);
			
			}
		});
		getHistoricalSearch.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent= new Intent(MainActivity.this, HistoricalSearchActivity.class);
				startActivity(intent);
			
			}
		});
		getBillSearch.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent= new Intent(MainActivity.this, BillInfoActivity.class);
				startActivity(intent);
			
			}
		});
	}
	private boolean isNetworkAvailable() {
	    ConnectivityManager connectivityManager 
	          = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
	    NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
	    return activeNetworkInfo != null && activeNetworkInfo.isConnected();
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main_activity_actions, menu);
		return true;
	}
	
	@Override
    public boolean onOptionsItemSelected(MenuItem item) {
		return MPGUtility.createMenu(this,item);}
	private class CheckResultDeclared extends AsyncTask<Void, Void, Void> {
private boolean isResultDeclared=false;
		@Override
		protected void onPreExecute() {
			super.onPreExecute();
			pDialog = new ProgressDialog(MainActivity.this);
			pDialog.setMessage("Election results on the way...Please wait");
			pDialog.setCancelable(false);
			pDialog.show();

		}

		@Override
		protected Void doInBackground(Void... arg0) {
			ServiceHandler sh = new ServiceHandler();
			String jsonStr = sh.makeServiceCall(url, ServiceHandler.GET);
			Log.d("Response: ", "> " + jsonStr);
			if (jsonStr != null) {
				
				JSONObject object;
				try {
					 object= new JSONObject(jsonStr);
					 if(object.getBoolean("isResultDeclared")){
						 isResultDeclared=true;
							Intent intent= new Intent(MainActivity.this, NewMpActivity.class);
							Bundle bundle= new Bundle();
							bundle.putString(STATUS, object.getString("statusText"));
							bundle.putString(COMMENT_1, object.getString("comment1"));
							bundle.putString(COMMENT_2, object.getString("comment2"));
							bundle.putString(COMMENT_3, object.getString("comment3"));
							bundle.putString(COMMENT_4, object.getString("comment4"));
							intent.putExtras(bundle);
							startActivity(intent);
							}else{
								isResultDeclared=false;
								pDialog.dismiss();
								
								
							}
				} catch (JSONException e) {
					Log.e("ServiceHandler", "--------JSONException in MainActivity:CheckResultDeclared:doInbackground-------");
				}
				
			} else {
				Log.e("ServiceHandler", "Couldn't get any data from the config file from url"+url);
			}

			return null;
		}

		@Override
		protected void onPostExecute(Void result) {
			super.onPostExecute(result);
			if (pDialog.isShowing())
				pDialog.dismiss();
			if(!isResultDeclared){
			Toast toast = Toast.makeText(getApplicationContext(), "Results not yet declared.", Toast.LENGTH_LONG);
			toast.show();
			}
		
		}

	}

}