package com.ouch.mpgyan.listeners;
import android.content.res.Resources;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.ouch.mpgyan.BillInfoActivity;
import com.ouch.mpgyan.R;
	public class BillInformationListener implements OnItemSelectedListener {
		private Spinner textView;
		private ArrayAdapter<String> textadapter;
		private Resources resource;
		private BillInfoActivity activity;
		public BillInformationListener(BillInfoActivity activity, Spinner textView,ArrayAdapter<String> textadapter,Resources resource) {
			this.textView=textView;
			this.textadapter=textadapter;
			this.resource=resource;
			this.activity=activity;
		}

		public void onItemSelected(AdapterView<?> parent, View view, int pos,
				long id) {

			if(parent.getItemAtPosition(pos).toString().equals("Year")){
				String[] years = resource.getStringArray(R.array.bill_year_arrays);
				textadapter = 
				        new ArrayAdapter<String>(activity, android.R.layout.simple_list_item_1, years);
				textView.setAdapter(textadapter);
			}else if(parent.getItemAtPosition(pos).toString().equalsIgnoreCase("Title")){
				String[] titles = resource.getStringArray(R.array.bill_title_arrays);
			
				textadapter = 
				        new ArrayAdapter<String>(activity, android.R.layout.simple_list_item_1, titles);
				textView.setAdapter(textadapter);
			}
		}

		@Override
		public void onNothingSelected(AdapterView<?> arg0) {

		}

	}

