package com.ouch.mpgyan.listeners;

import android.content.res.Resources;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Spinner;

import com.ouch.mpgyan.HistoricalSearchActivity;
import com.ouch.mpgyan.MainActivity;
import com.ouch.mpgyan.R;

public class YearSelectedListener implements OnItemSelectedListener {
	private AutoCompleteTextView textView;
	private ArrayAdapter<String> textadapter;
	private Resources resource;
	private HistoricalSearchActivity HSActivity;
	private Spinner criteria_spinner;
	private MainActivity activity;
	private Boolean isCurrentMPSearch=false;
	
	public YearSelectedListener(HistoricalSearchActivity HSActivity, AutoCompleteTextView textView,ArrayAdapter<String> textadapter,Resources resource, Spinner criteria_spinner) {
		this.textView=textView;
		this.textadapter=textadapter;
		this.resource=resource;
		this.HSActivity=HSActivity;
		this.criteria_spinner=criteria_spinner;
		}
	public YearSelectedListener(MainActivity activity, AutoCompleteTextView textView,ArrayAdapter<String> textadapter,Resources resource,Boolean isCurrentMPSearch,Spinner criteria_spinner) {
		this.textView=textView;
		this.textadapter=textadapter;
		this.resource=resource;
		this.activity=activity;
		this.isCurrentMPSearch=isCurrentMPSearch;
		this.criteria_spinner=criteria_spinner;
		
	}
	public void onItemSelected(AdapterView<?> parent, View view, int pos,
			long id) {
		if(!isCurrentMPSearch){
		if(((String)criteria_spinner.getSelectedItem()).equals("MP Name")){
			if(parent.getItemAtPosition(pos).toString().equalsIgnoreCase("1st (1952 to 1957)")){
				HistoricalSearchActivity.year=0;
				String[] names = resource.getStringArray(R.array.name_1_arrays);
				textadapter = 
				        new ArrayAdapter<String>(HSActivity, android.R.layout.simple_list_item_1, names);
				textView.setAdapter(textadapter);
			}else if(parent.getItemAtPosition(pos).toString().equalsIgnoreCase("2nd (1957 to 1962)")){
				HistoricalSearchActivity.year=1;
				String[] names = resource.getStringArray(R.array.name_2_arrays);
				textadapter = 
				        new ArrayAdapter<String>(HSActivity, android.R.layout.simple_list_item_1, names);
				textView.setAdapter(textadapter);
				
			}
			else if(parent.getItemAtPosition(pos).toString().equalsIgnoreCase("3rd (1962 to 1967)")){
				HistoricalSearchActivity.year=2;
				String[] names = resource.getStringArray(R.array.name_3_arrays);
				textadapter = 
				        new ArrayAdapter<String>(HSActivity, android.R.layout.simple_list_item_1, names);
				textView.setAdapter(textadapter);
				
			}
			else if(parent.getItemAtPosition(pos).toString().equalsIgnoreCase("4th (1967 to 1970)")){
				HistoricalSearchActivity.year=3;
				String[] names = resource.getStringArray(R.array.name_4_arrays);
				textadapter = 
				        new ArrayAdapter<String>(HSActivity, android.R.layout.simple_list_item_1, names);
				textView.setAdapter(textadapter);
				
			}
			else if(parent.getItemAtPosition(pos).toString().equalsIgnoreCase("5th (1971 to 1977)")){
				HistoricalSearchActivity.year=4;
				String[] names = resource.getStringArray(R.array.name_5_arrays);
				textadapter = 
				        new ArrayAdapter<String>(HSActivity, android.R.layout.simple_list_item_1, names);
				textView.setAdapter(textadapter);
				
			}
			else if(parent.getItemAtPosition(pos).toString().equalsIgnoreCase("6th (1977 to 1979)")){
				HistoricalSearchActivity.year=5;
				String[] names = resource.getStringArray(R.array.name_6_arrays);
				textadapter = 
				        new ArrayAdapter<String>(HSActivity, android.R.layout.simple_list_item_1, names);
				textView.setAdapter(textadapter);
				
			}
			else if(parent.getItemAtPosition(pos).toString().equalsIgnoreCase("7th (1980 to 1984)")){
				HistoricalSearchActivity.year=6;
				String[] names = resource.getStringArray(R.array.name_7_arrays);
				textadapter = 
				        new ArrayAdapter<String>(HSActivity, android.R.layout.simple_list_item_1, names);
				textView.setAdapter(textadapter);
				
			}
			else if(parent.getItemAtPosition(pos).toString().equalsIgnoreCase("8th (1984 to 1989)")){
				HistoricalSearchActivity.year=7;
				String[] names = resource.getStringArray(R.array.name_8_arrays);
				textadapter = 
				        new ArrayAdapter<String>(HSActivity, android.R.layout.simple_list_item_1, names);
				textView.setAdapter(textadapter);
				
			}
			else if(parent.getItemAtPosition(pos).toString().equalsIgnoreCase("9th (1989 to 1991)")){
				HistoricalSearchActivity.year=8;
				String[] names = resource.getStringArray(R.array.name_9_arrays);
				textadapter = 
				        new ArrayAdapter<String>(HSActivity, android.R.layout.simple_list_item_1, names);
				textView.setAdapter(textadapter);
				
			}
			else if(parent.getItemAtPosition(pos).toString().equalsIgnoreCase("10th (1991 to 1996)")){
				HistoricalSearchActivity.year=9;
				String[] names = resource.getStringArray(R.array.name_10_arrays);
				textadapter = 
				        new ArrayAdapter<String>(HSActivity, android.R.layout.simple_list_item_1, names);
				textView.setAdapter(textadapter);
				
			}
			else if(parent.getItemAtPosition(pos).toString().equalsIgnoreCase("11th (1996 to 1997)")){
				HistoricalSearchActivity.year=10;
				String[] names = resource.getStringArray(R.array.name_11_arrays);
				textadapter = 
				        new ArrayAdapter<String>(HSActivity, android.R.layout.simple_list_item_1, names);
				textView.setAdapter(textadapter);
				
			}
			else if(parent.getItemAtPosition(pos).toString().equalsIgnoreCase("12th (1998 to 1999)")){
				HistoricalSearchActivity.year=11;
				String[] names = resource.getStringArray(R.array.name_12_arrays);
				textadapter = 
				        new ArrayAdapter<String>(HSActivity, android.R.layout.simple_list_item_1, names);
				textView.setAdapter(textadapter);
				
			}
			else if(parent.getItemAtPosition(pos).toString().equalsIgnoreCase("13th (1999 to 2004)")){
				HistoricalSearchActivity.year=12;
				String[] names = resource.getStringArray(R.array.name_13_arrays);
				textadapter = 
				        new ArrayAdapter<String>(HSActivity, android.R.layout.simple_list_item_1, names);
				textView.setAdapter(textadapter);
				
			}
			else if(parent.getItemAtPosition(pos).toString().equalsIgnoreCase("14th (2004 to 2009)")){
				HistoricalSearchActivity.year=13;
				String[] names = resource.getStringArray(R.array.name_14_arrays);
				textadapter = 
				        new ArrayAdapter<String>(HSActivity, android.R.layout.simple_list_item_1, names);
				textView.setAdapter(textadapter);
				
			}else if(parent.getItemAtPosition(pos).toString().equalsIgnoreCase("15th (2009 to 2014)")){
				HistoricalSearchActivity.year=14;
				String[] names = resource.getStringArray(R.array.name_15_arrays);
				textadapter = 
				        new ArrayAdapter<String>(HSActivity, android.R.layout.simple_list_item_1, names);
				textView.setAdapter(textadapter);
				
			}
			
		}else if(((String)criteria_spinner.getSelectedItem()).equals("Party")){
			if(parent.getItemAtPosition(pos).toString().equalsIgnoreCase("1st (1952 to 1957)")){
				HistoricalSearchActivity.year=0;
				String[] parties = resource.getStringArray(R.array.party_1_arrays);
				textadapter = 
				        new ArrayAdapter<String>(HSActivity, android.R.layout.simple_list_item_1, parties);
				textView.setAdapter(textadapter);
			}else if(parent.getItemAtPosition(pos).toString().equalsIgnoreCase("2nd (1957 to 1962)")){
				HistoricalSearchActivity.year=1;
				String[] parties = resource.getStringArray(R.array.party_2_arrays);
				textadapter = 
				        new ArrayAdapter<String>(HSActivity, android.R.layout.simple_list_item_1, parties);
				textView.setAdapter(textadapter);
				
			}
			else if(parent.getItemAtPosition(pos).toString().equalsIgnoreCase("3rd (1962 to 1967)")){
				HistoricalSearchActivity.year=2;
				String[] parties = resource.getStringArray(R.array.party_3_arrays);
				textadapter = 
				        new ArrayAdapter<String>(HSActivity, android.R.layout.simple_list_item_1, parties);
				textView.setAdapter(textadapter);
				
			}
			else if(parent.getItemAtPosition(pos).toString().equalsIgnoreCase("4th (1967 to 1970)")){
				HistoricalSearchActivity.year=3;
				String[] parties = resource.getStringArray(R.array.party_4_arrays);
				textadapter = 
				        new ArrayAdapter<String>(HSActivity, android.R.layout.simple_list_item_1, parties);
				textView.setAdapter(textadapter);
				
			}
			else if(parent.getItemAtPosition(pos).toString().equalsIgnoreCase("5th (1971 to 1977)")){
				HistoricalSearchActivity.year=4;
				String[] parties = resource.getStringArray(R.array.party_5_arrays);
				textadapter = 
				        new ArrayAdapter<String>(HSActivity, android.R.layout.simple_list_item_1, parties);
				textView.setAdapter(textadapter);
				
			}
			else if(parent.getItemAtPosition(pos).toString().equalsIgnoreCase("6th (1977 to 1979)")){
				HistoricalSearchActivity.year=5;
				String[] parties = resource.getStringArray(R.array.party_6_arrays);
				textadapter = 
				        new ArrayAdapter<String>(HSActivity, android.R.layout.simple_list_item_1, parties);
				textView.setAdapter(textadapter);
				
			}
			else if(parent.getItemAtPosition(pos).toString().equalsIgnoreCase("7th (1980 to 1984)")){
				HistoricalSearchActivity.year=6;
				String[] parties = resource.getStringArray(R.array.party_7_arrays);
				textadapter = 
				        new ArrayAdapter<String>(HSActivity, android.R.layout.simple_list_item_1, parties);
				textView.setAdapter(textadapter);
				
			}
			else if(parent.getItemAtPosition(pos).toString().equalsIgnoreCase("8th (1984 to 1989)")){
				HistoricalSearchActivity.year=7;
				String[] parties = resource.getStringArray(R.array.party_8_arrays);
				textadapter = 
				        new ArrayAdapter<String>(HSActivity, android.R.layout.simple_list_item_1, parties);
				textView.setAdapter(textadapter);
				
			}
			else if(parent.getItemAtPosition(pos).toString().equalsIgnoreCase("9th (1989 to 1991)")){
				HistoricalSearchActivity.year=8;
				String[] parties = resource.getStringArray(R.array.party_9_arrays);
				textadapter = 
				        new ArrayAdapter<String>(HSActivity, android.R.layout.simple_list_item_1, parties);
				textView.setAdapter(textadapter);
				
			}
			else if(parent.getItemAtPosition(pos).toString().equalsIgnoreCase("10th (1991 to 1996)")){
				HistoricalSearchActivity.year=9;
				String[] parties = resource.getStringArray(R.array.party_10_arrays);
				textadapter = 
				        new ArrayAdapter<String>(HSActivity, android.R.layout.simple_list_item_1, parties);
				textView.setAdapter(textadapter);
				
			}
			else if(parent.getItemAtPosition(pos).toString().equalsIgnoreCase("11th (1996 to 1997)")){
				HistoricalSearchActivity.year=10;
				String[] parties = resource.getStringArray(R.array.party_11_arrays);
				textadapter = 
				        new ArrayAdapter<String>(HSActivity, android.R.layout.simple_list_item_1, parties);
				textView.setAdapter(textadapter);
				
			}
			else if(parent.getItemAtPosition(pos).toString().equalsIgnoreCase("12th (1998 to 1999)")){
				HistoricalSearchActivity.year=11;
				String[] parties = resource.getStringArray(R.array.party_12_arrays);
				textadapter = 
				        new ArrayAdapter<String>(HSActivity, android.R.layout.simple_list_item_1, parties);
				textView.setAdapter(textadapter);
				
			}
			else if(parent.getItemAtPosition(pos).toString().equalsIgnoreCase("13th (1999 to 2004)")){
				HistoricalSearchActivity.year=12;
				String[] parties = resource.getStringArray(R.array.party_13_arrays);
				textadapter = 
				        new ArrayAdapter<String>(HSActivity, android.R.layout.simple_list_item_1, parties);
				textView.setAdapter(textadapter);
				
			}
			else if(parent.getItemAtPosition(pos).toString().equalsIgnoreCase("14th (2004 to 2009)")){
				HistoricalSearchActivity.year=13;
				String[] parties = resource.getStringArray(R.array.party_14_arrays);
				textadapter = 
				        new ArrayAdapter<String>(HSActivity, android.R.layout.simple_list_item_1, parties);
				textView.setAdapter(textadapter);
				
			}else if(parent.getItemAtPosition(pos).toString().equalsIgnoreCase("15th (2009 to 2014)")){
				HistoricalSearchActivity.year=14;
				String[] parties = resource.getStringArray(R.array.party_15_arrays);
				textadapter = 
				        new ArrayAdapter<String>(HSActivity, android.R.layout.simple_list_item_1, parties);
				textView.setAdapter(textadapter);
			}
						
		}else if(((String)criteria_spinner.getSelectedItem()).equals("Constituency")){
			if(parent.getItemAtPosition(pos).toString().equalsIgnoreCase("1st (1952 to 1957)")){
				HistoricalSearchActivity.year=0;
				String[] constituencies = resource.getStringArray(R.array.constituency_1_arrays);
				textadapter = 
				        new ArrayAdapter<String>(HSActivity, android.R.layout.simple_list_item_1, constituencies);
				textView.setAdapter(textadapter);
			}else if(parent.getItemAtPosition(pos).toString().equalsIgnoreCase("2nd (1957 to 1962)")){
				HistoricalSearchActivity.year=1;
				String[] constituencies = resource.getStringArray(R.array.constituency_2_arrays);
				textadapter = 
				        new ArrayAdapter<String>(HSActivity, android.R.layout.simple_list_item_1, constituencies);
				textView.setAdapter(textadapter);
				
			}
			else if(parent.getItemAtPosition(pos).toString().equalsIgnoreCase("3rd (1962 to 1967)")){
				HistoricalSearchActivity.year=2;
				String[] constituencies = resource.getStringArray(R.array.constituency_3_arrays);
				textadapter = 
				        new ArrayAdapter<String>(HSActivity, android.R.layout.simple_list_item_1, constituencies);
				textView.setAdapter(textadapter);
				
			}
			else if(parent.getItemAtPosition(pos).toString().equalsIgnoreCase("4th (1967 to 1970)")){
				HistoricalSearchActivity.year=3;
				String[] constituencies = resource.getStringArray(R.array.constituency_4_arrays);
				textadapter = 
				        new ArrayAdapter<String>(HSActivity, android.R.layout.simple_list_item_1, constituencies);
				textView.setAdapter(textadapter);
				
			}
			else if(parent.getItemAtPosition(pos).toString().equalsIgnoreCase("5th (1971 to 1977)")){
				HistoricalSearchActivity.year=4;
				String[] constituencies = resource.getStringArray(R.array.constituency_5_arrays);
				textadapter = 
				        new ArrayAdapter<String>(HSActivity, android.R.layout.simple_list_item_1, constituencies);
				textView.setAdapter(textadapter);
				
			}
			else if(parent.getItemAtPosition(pos).toString().equalsIgnoreCase("6th (1977 to 1979)")){
				HistoricalSearchActivity.year=5;
				String[] constituencies = resource.getStringArray(R.array.constituency_6_arrays);
				textadapter = 
				        new ArrayAdapter<String>(HSActivity, android.R.layout.simple_list_item_1, constituencies);
				textView.setAdapter(textadapter);
				
			}
			else if(parent.getItemAtPosition(pos).toString().equalsIgnoreCase("7th (1980 to 1984)")){
				HistoricalSearchActivity.year=6;
				String[] constituencies = resource.getStringArray(R.array.constituency_7_arrays);
				textadapter = 
				        new ArrayAdapter<String>(HSActivity, android.R.layout.simple_list_item_1, constituencies);
				textView.setAdapter(textadapter);
				
			}
			else if(parent.getItemAtPosition(pos).toString().equalsIgnoreCase("8th (1984 to 1989)")){
				HistoricalSearchActivity.year=7;
				String[] constituencies = resource.getStringArray(R.array.constituency_8_arrays);
				textadapter = 
				        new ArrayAdapter<String>(HSActivity, android.R.layout.simple_list_item_1, constituencies);
				textView.setAdapter(textadapter);
				
			}
			else if(parent.getItemAtPosition(pos).toString().equalsIgnoreCase("9th (1989 to 1991)")){
				HistoricalSearchActivity.year=8;
				String[] constituencies = resource.getStringArray(R.array.constituency_9_arrays);
				textadapter = 
				        new ArrayAdapter<String>(HSActivity, android.R.layout.simple_list_item_1, constituencies);
				textView.setAdapter(textadapter);
				
			}
			else if(parent.getItemAtPosition(pos).toString().equalsIgnoreCase("10th (1991 to 1996)")){
				HistoricalSearchActivity.year=9;
				String[] constituencies = resource.getStringArray(R.array.constituency_10_arrays);
				textadapter = 
				        new ArrayAdapter<String>(HSActivity, android.R.layout.simple_list_item_1, constituencies);
				textView.setAdapter(textadapter);
				
			}
			else if(parent.getItemAtPosition(pos).toString().equalsIgnoreCase("11th (1996 to 1997)")){
				HistoricalSearchActivity.year=10;
				String[] constituencies = resource.getStringArray(R.array.constituency_11_arrays);
				textadapter = 
				        new ArrayAdapter<String>(HSActivity, android.R.layout.simple_list_item_1, constituencies);
				textView.setAdapter(textadapter);
				
			}
			else if(parent.getItemAtPosition(pos).toString().equalsIgnoreCase("12th (1998 to 1999)")){
				HistoricalSearchActivity.year=11;
				String[] constituencies = resource.getStringArray(R.array.constituency_12_arrays);
				textadapter = 
				        new ArrayAdapter<String>(HSActivity, android.R.layout.simple_list_item_1, constituencies);
				textView.setAdapter(textadapter);
				
			}
			else if(parent.getItemAtPosition(pos).toString().equalsIgnoreCase("13th (1999 to 2004)")){
				HistoricalSearchActivity.year=12;
				String[] constituencies = resource.getStringArray(R.array.constituency_13_arrays);
				textadapter = 
				        new ArrayAdapter<String>(HSActivity, android.R.layout.simple_list_item_1, constituencies);
				textView.setAdapter(textadapter);
				
			}
			else if(parent.getItemAtPosition(pos).toString().equalsIgnoreCase("14th (2004 to 2009)")){
				HistoricalSearchActivity.year=13;
				String[] constituencies = resource.getStringArray(R.array.constituency_14_arrays);
				textadapter = 
				        new ArrayAdapter<String>(HSActivity, android.R.layout.simple_list_item_1, constituencies);
				textView.setAdapter(textadapter);
				
			}else if(parent.getItemAtPosition(pos).toString().equalsIgnoreCase("15th (2009 to 2014)")){
				HistoricalSearchActivity.year=14;
				String[] constituencies = resource.getStringArray(R.array.constituency_15_arrays);
				textadapter = 
				        new ArrayAdapter<String>(HSActivity, android.R.layout.simple_list_item_1, constituencies);
				textView.setAdapter(textadapter);
				
			}
		}
	}else{
		if(((String)criteria_spinner.getSelectedItem()).equals("MP Name")){
	
		if(parent.getItemAtPosition(pos).toString().equalsIgnoreCase("16th (Ongoing)")){
			HistoricalSearchActivity.year=15;
			String[] names = resource.getStringArray(R.array.name_16_arrays);
			textadapter = 
			        new ArrayAdapter<String>(activity, android.R.layout.simple_list_item_1, names);
			textView.setAdapter(textadapter);
			
		}
		
		}else if(((String)criteria_spinner.getSelectedItem()).equals("Constituency")){
			
			if(parent.getItemAtPosition(pos).toString().equalsIgnoreCase("16th (Ongoing)")){
				HistoricalSearchActivity.year=15;
				String[] constituencies = resource.getStringArray(R.array.constituency_16_arrays);
				textadapter = 
				        new ArrayAdapter<String>(activity, android.R.layout.simple_list_item_1, constituencies);
				textView.setAdapter(textadapter);
				
			}
			
			}else if(((String)criteria_spinner.getSelectedItem()).equals("Party")){
				
				if(parent.getItemAtPosition(pos).toString().equalsIgnoreCase("16th (Ongoing)")){
					HistoricalSearchActivity.year=15;
					String[] parties = resource.getStringArray(R.array.party_16_arrays);
					textadapter = 
					        new ArrayAdapter<String>(activity, android.R.layout.simple_list_item_1, parties);
					textView.setAdapter(textadapter);
					
				}
				
			}
		}
	}

	@Override
	public void onNothingSelected(AdapterView<?> arg0) {

	}

}