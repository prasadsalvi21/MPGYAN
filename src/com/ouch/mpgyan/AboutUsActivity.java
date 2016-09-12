package com.ouch.mpgyan;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;

import com.ouch.mpgyan.util.MPGUtility;

public class AboutUsActivity extends ActionBarActivity{
	private static final String STATE_SELECTED_NAVIGATION_ITEM = "selected_navigation_item";
	protected Object context;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.fragment_about_us);
		setTitle("About Us");
		
		
		ScrollView sView = (ScrollView)findViewById(R.id.ScrollView01);
        sView.setVerticalScrollBarEnabled(true);
        sView.setHorizontalScrollBarEnabled(false);
        
        
    	ImageView imgView;
		imgView = (ImageView) findViewById(R.id.manual_image);
		imgView.setImageResource(R.drawable.manuel);
		
        TextView about_manual = (TextView) findViewById(R.id.about_manual);
        about_manual.setText("\nManuel Fernandes\n"
        		+ "Developer\n\n");
        
        ImageView imgView1;
		imgView1 = (ImageView) findViewById(R.id.prasad_image);
		imgView1.setImageResource(R.drawable.prasad);
		
        TextView about_prasad = (TextView) findViewById(R.id.about_prasad);
        about_prasad.setText("\nPrasad Salvi\n"
        		+ "Developer"
        		+ "\n\n");
        TextView about_mayuresh = (TextView) findViewById(R.id.about_mayuresh);
        about_mayuresh.setText("\nMayuresh Ghorpade\n"
        		+ "Designer\n\n\n");
				
		ImageView imgView2;
		imgView2 = (ImageView) findViewById(R.id.ouch_it_image);
		imgView2.setImageResource(R.drawable.ouch_it);
		
		TextView about_mp_gyan = (TextView) findViewById(R.id.about_mp_gyan);
        about_mp_gyan.setText("\nMP Gyan\n"
        		+ "Build Version: 1.2\n"
        		+ "Date: 14th May 2014\n"
        		+ "\n\n\n\n");
        
        TextView about_mp_gyan_link = (TextView) findViewById(R.id.about_mp_gyan_link);
        about_mp_gyan_link.setText("Ouch IT\n");
        TextView feedback = (TextView) findViewById(R.id.feedback);
        feedback.setText("For any queries, feedback or suggestions do write to us at \n support@ouch-it.com \n\n");
        TextView about_mp_gyan_copyright = (TextView) findViewById(R.id.about_mp_gyan_copyright);
        about_mp_gyan_copyright.setText("Copyright \u00a9 2014 Ouch IT\n");
		
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
		getMenuInflater().inflate(R.menu.about_us, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		return MPGUtility.createMenu(this,item);
		}
}
