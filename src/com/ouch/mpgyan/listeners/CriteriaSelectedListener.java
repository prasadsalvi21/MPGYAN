package com.ouch.mpgyan.listeners;
import java.util.List;

import android.content.res.Resources;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Spinner;

import com.ouch.mpgyan.HistoricalSearchActivity;
import com.ouch.mpgyan.NewMpActivity;
import com.ouch.mpgyan.R;
	public class CriteriaSelectedListener implements OnItemSelectedListener {
		private AutoCompleteTextView textView;
		private ArrayAdapter<String> textadapter;
		private Resources resource;
		private HistoricalSearchActivity HSActivity;
		private Spinner year_spinner;
		private NewMpActivity NMpActivity;
		private Boolean isCurrentMPSearch=false;
		List<String> names;
		List<String> parties;
		List<String> constituencies;;
		public CriteriaSelectedListener(HistoricalSearchActivity HSActivity, AutoCompleteTextView textView,ArrayAdapter<String> textadapter,Resources resource, Spinner year_spinner) {
			this.textView=textView;
			this.textadapter=textadapter;
			this.resource=resource;
			this.HSActivity=HSActivity;
			this.year_spinner=year_spinner;
		}
		public CriteriaSelectedListener(NewMpActivity NMpActivity, AutoCompleteTextView textView,ArrayAdapter<String> textadapter,Resources resource,Boolean isCurrentMPSearch,List<String> names,List<String> parties,List<String> constituencies) {
			this.textView=textView;
			this.textadapter=textadapter;
			this.resource=resource;
			this.NMpActivity=NMpActivity;
			this.isCurrentMPSearch=isCurrentMPSearch;
			this.names=names;
			this.constituencies=constituencies;
			this.parties=parties;
			
		}

		public void onItemSelected(AdapterView<?> parent, View view, int pos,
				long id) {
			if(!isCurrentMPSearch){
			if(((String)year_spinner.getSelectedItem()).equals("1st (1952 to 1957)")){
				if(parent.getItemAtPosition(pos).toString().equals("MP Name")){
					String[] names = resource.getStringArray(R.array.name_1_arrays);
					textadapter = 
					        new ArrayAdapter<String>(HSActivity, android.R.layout.simple_list_item_1, names);
					textView.setAdapter(textadapter);
				}else if(parent.getItemAtPosition(pos).toString().equalsIgnoreCase("Constituency")){
					String[] constituencies = resource.getStringArray(R.array.constituency_1_arrays);
				
					textadapter = 
					        new ArrayAdapter<String>(HSActivity, android.R.layout.simple_list_item_1, constituencies);
					textView.setAdapter(textadapter);
				}else if(parent.getItemAtPosition(pos).toString().equalsIgnoreCase("Party")){
					String[] party = resource.getStringArray(R.array.party_1_arrays);
					textadapter = 
					        new ArrayAdapter<String>(HSActivity, android.R.layout.simple_list_item_1, party);
					textView.setAdapter(textadapter);
				}
				
			}else if(((String)year_spinner.getSelectedItem()).equals("2nd (1957 to 1962)")){
				if(parent.getItemAtPosition(pos).toString().equals("MP Name")){
					String[] names = resource.getStringArray(R.array.name_2_arrays);
					textadapter = 
					        new ArrayAdapter<String>(HSActivity, android.R.layout.simple_list_item_1, names);
					textView.setAdapter(textadapter);
				}else if(parent.getItemAtPosition(pos).toString().equalsIgnoreCase("Constituency")){
					String[] constituencies = resource.getStringArray(R.array.constituency_2_arrays);
				
					textadapter = 
					        new ArrayAdapter<String>(HSActivity, android.R.layout.simple_list_item_1, constituencies);
					textView.setAdapter(textadapter);
				}else if(parent.getItemAtPosition(pos).toString().equalsIgnoreCase("Party")){
					String[] party = resource.getStringArray(R.array.party_2_arrays);
					textadapter = 
					        new ArrayAdapter<String>(HSActivity, android.R.layout.simple_list_item_1, party);
					textView.setAdapter(textadapter);
				}
				
			
				
			}else if(((String)year_spinner.getSelectedItem()).equals("3rd (1962 to 1967)")){
				if(parent.getItemAtPosition(pos).toString().equals("MP Name")){
					String[] names = resource.getStringArray(R.array.name_3_arrays);
					textadapter = 
					        new ArrayAdapter<String>(HSActivity, android.R.layout.simple_list_item_1, names);
					textView.setAdapter(textadapter);
				}else if(parent.getItemAtPosition(pos).toString().equalsIgnoreCase("Constituency")){
					String[] constituencies = resource.getStringArray(R.array.constituency_3_arrays);
				
					textadapter = 
					        new ArrayAdapter<String>(HSActivity, android.R.layout.simple_list_item_1, constituencies);
					textView.setAdapter(textadapter);
				}else if(parent.getItemAtPosition(pos).toString().equalsIgnoreCase("Party")){
					String[] party = resource.getStringArray(R.array.party_3_arrays);
					textadapter = 
					        new ArrayAdapter<String>(HSActivity, android.R.layout.simple_list_item_1, party);
					textView.setAdapter(textadapter);
				}
				
			
				
			}
else if(((String)year_spinner.getSelectedItem()).equals("4th (1967 to 1970)")){

	if(parent.getItemAtPosition(pos).toString().equals("MP Name")){
		String[] names = resource.getStringArray(R.array.name_4_arrays);
		textadapter = 
		        new ArrayAdapter<String>(HSActivity, android.R.layout.simple_list_item_1, names);
		textView.setAdapter(textadapter);
	}else if(parent.getItemAtPosition(pos).toString().equalsIgnoreCase("Constituency")){
		String[] constituencies = resource.getStringArray(R.array.constituency_4_arrays);
	
		textadapter = 
		        new ArrayAdapter<String>(HSActivity, android.R.layout.simple_list_item_1, constituencies);
		textView.setAdapter(textadapter);
	}else if(parent.getItemAtPosition(pos).toString().equalsIgnoreCase("Party")){
		String[] party = resource.getStringArray(R.array.party_4_arrays);
		textadapter = 
		        new ArrayAdapter<String>(HSActivity, android.R.layout.simple_list_item_1, party);
		textView.setAdapter(textadapter);
	}
	

				
			}
else if(((String)year_spinner.getSelectedItem()).equals("5th (1971 to 1977)")){
	if(parent.getItemAtPosition(pos).toString().equals("MP Name")){
		String[] names = resource.getStringArray(R.array.name_5_arrays);
		textadapter = 
		        new ArrayAdapter<String>(HSActivity, android.R.layout.simple_list_item_1, names);
		textView.setAdapter(textadapter);
	}else if(parent.getItemAtPosition(pos).toString().equalsIgnoreCase("Constituency")){
		String[] constituencies = resource.getStringArray(R.array.constituency_5_arrays);
	
		textadapter = 
		        new ArrayAdapter<String>(HSActivity, android.R.layout.simple_list_item_1, constituencies);
		textView.setAdapter(textadapter);
	}else if(parent.getItemAtPosition(pos).toString().equalsIgnoreCase("Party")){
		String[] party = resource.getStringArray(R.array.party_5_arrays);
		textadapter = 
		        new ArrayAdapter<String>(HSActivity, android.R.layout.simple_list_item_1, party);
		textView.setAdapter(textadapter);
	}
	

	
}
else if(((String)year_spinner.getSelectedItem()).equals("6th (1977 to 1979)")){

	if(parent.getItemAtPosition(pos).toString().equals("MP Name")){
		String[] names = resource.getStringArray(R.array.name_6_arrays);
		textadapter = 
		        new ArrayAdapter<String>(HSActivity, android.R.layout.simple_list_item_1, names);
		textView.setAdapter(textadapter);
	}else if(parent.getItemAtPosition(pos).toString().equalsIgnoreCase("Constituency")){
		String[] constituencies = resource.getStringArray(R.array.constituency_6_arrays);
	
		textadapter = 
		        new ArrayAdapter<String>(HSActivity, android.R.layout.simple_list_item_1, constituencies);
		textView.setAdapter(textadapter);
	}else if(parent.getItemAtPosition(pos).toString().equalsIgnoreCase("Party")){
		String[] party = resource.getStringArray(R.array.party_6_arrays);
		textadapter = 
		        new ArrayAdapter<String>(HSActivity, android.R.layout.simple_list_item_1, party);
		textView.setAdapter(textadapter);
	}
	

}
else if(((String)year_spinner.getSelectedItem()).equals("7th (1980 to 1984)")){

	if(parent.getItemAtPosition(pos).toString().equals("MP Name")){
		String[] names = resource.getStringArray(R.array.name_7_arrays);
		textadapter = 
		        new ArrayAdapter<String>(HSActivity, android.R.layout.simple_list_item_1, names);
		textView.setAdapter(textadapter);
	}else if(parent.getItemAtPosition(pos).toString().equalsIgnoreCase("Constituency")){
		String[] constituencies = resource.getStringArray(R.array.constituency_7_arrays);
	
		textadapter = 
		        new ArrayAdapter<String>(HSActivity, android.R.layout.simple_list_item_1, constituencies);
		textView.setAdapter(textadapter);
	}else if(parent.getItemAtPosition(pos).toString().equalsIgnoreCase("Party")){
		String[] party = resource.getStringArray(R.array.party_7_arrays);
		textadapter = 
		        new ArrayAdapter<String>(HSActivity, android.R.layout.simple_list_item_1, party);
		textView.setAdapter(textadapter);
	}
	

	
}
else if(((String)year_spinner.getSelectedItem()).equals("8th (1984 to 1989)")){

	if(parent.getItemAtPosition(pos).toString().equals("MP Name")){
		String[] names = resource.getStringArray(R.array.name_8_arrays);
		textadapter = 
		        new ArrayAdapter<String>(HSActivity, android.R.layout.simple_list_item_1, names);
		textView.setAdapter(textadapter);
	}else if(parent.getItemAtPosition(pos).toString().equalsIgnoreCase("Constituency")){
		String[] constituencies = resource.getStringArray(R.array.constituency_8_arrays);
	
		textadapter = 
		        new ArrayAdapter<String>(HSActivity, android.R.layout.simple_list_item_1, constituencies);
		textView.setAdapter(textadapter);
	}else if(parent.getItemAtPosition(pos).toString().equalsIgnoreCase("Party")){
		String[] party = resource.getStringArray(R.array.party_8_arrays);
		textadapter = 
		        new ArrayAdapter<String>(HSActivity, android.R.layout.simple_list_item_1, party);
		textView.setAdapter(textadapter);
	}
	

	
}
else if(((String)year_spinner.getSelectedItem()).equals("9th (1989 to 1991)")){
	if(parent.getItemAtPosition(pos).toString().equals("MP Name")){
		String[] names = resource.getStringArray(R.array.name_9_arrays);
		textadapter = 
		        new ArrayAdapter<String>(HSActivity, android.R.layout.simple_list_item_1, names);
		textView.setAdapter(textadapter);
	}else if(parent.getItemAtPosition(pos).toString().equalsIgnoreCase("Constituency")){
		String[] constituencies = resource.getStringArray(R.array.constituency_9_arrays);
	
		textadapter = 
		        new ArrayAdapter<String>(HSActivity, android.R.layout.simple_list_item_1, constituencies);
		textView.setAdapter(textadapter);
	}else if(parent.getItemAtPosition(pos).toString().equalsIgnoreCase("Party")){
		String[] party = resource.getStringArray(R.array.party_9_arrays);
		textadapter = 
		        new ArrayAdapter<String>(HSActivity, android.R.layout.simple_list_item_1, party);
		textView.setAdapter(textadapter);
	}
	

	
}
else if(((String)year_spinner.getSelectedItem()).equals("10th (1991 to 1996)")){
	if(parent.getItemAtPosition(pos).toString().equals("MP Name")){
		String[] names = resource.getStringArray(R.array.name_10_arrays);
		textadapter = 
		        new ArrayAdapter<String>(HSActivity, android.R.layout.simple_list_item_1, names);
		textView.setAdapter(textadapter);
	}else if(parent.getItemAtPosition(pos).toString().equalsIgnoreCase("Constituency")){
		String[] constituencies = resource.getStringArray(R.array.constituency_10_arrays);
	
		textadapter = 
		        new ArrayAdapter<String>(HSActivity, android.R.layout.simple_list_item_1, constituencies);
		textView.setAdapter(textadapter);
	}else if(parent.getItemAtPosition(pos).toString().equalsIgnoreCase("Party")){
		String[] party = resource.getStringArray(R.array.party_10_arrays);
		textadapter = 
		        new ArrayAdapter<String>(HSActivity, android.R.layout.simple_list_item_1, party);
		textView.setAdapter(textadapter);
	}
	

	
}
else if(((String)year_spinner.getSelectedItem()).equals("11th (1996 to 1997")){

	if(parent.getItemAtPosition(pos).toString().equals("MP Name")){
		String[] names = resource.getStringArray(R.array.name_11_arrays);
		textadapter = 
		        new ArrayAdapter<String>(HSActivity, android.R.layout.simple_list_item_1, names);
		textView.setAdapter(textadapter);
	}else if(parent.getItemAtPosition(pos).toString().equalsIgnoreCase("Constituency")){
		String[] constituencies = resource.getStringArray(R.array.constituency_11_arrays);
	
		textadapter = 
		        new ArrayAdapter<String>(HSActivity, android.R.layout.simple_list_item_1, constituencies);
		textView.setAdapter(textadapter);
	}else if(parent.getItemAtPosition(pos).toString().equalsIgnoreCase("Party")){
		String[] party = resource.getStringArray(R.array.party_11_arrays);
		textadapter = 
		        new ArrayAdapter<String>(HSActivity, android.R.layout.simple_list_item_1, party);
		textView.setAdapter(textadapter);
	}
	

}
else if(((String)year_spinner.getSelectedItem()).equals("12th (1998 to 1999)")){

	if(parent.getItemAtPosition(pos).toString().equals("MP Name")){
		String[] names = resource.getStringArray(R.array.name_12_arrays);
		textadapter = 
		        new ArrayAdapter<String>(HSActivity, android.R.layout.simple_list_item_1, names);
		textView.setAdapter(textadapter);
	}else if(parent.getItemAtPosition(pos).toString().equalsIgnoreCase("Constituency")){
		String[] constituencies = resource.getStringArray(R.array.constituency_12_arrays);
	
		textadapter = 
		        new ArrayAdapter<String>(HSActivity, android.R.layout.simple_list_item_1, constituencies);
		textView.setAdapter(textadapter);
	}else if(parent.getItemAtPosition(pos).toString().equalsIgnoreCase("Party")){
		String[] party = resource.getStringArray(R.array.party_12_arrays);
		textadapter = 
		        new ArrayAdapter<String>(HSActivity, android.R.layout.simple_list_item_1, party);
		textView.setAdapter(textadapter);
	}
	

}
else if(((String)year_spinner.getSelectedItem()).equals("13th (1999 to 2004)")){

	if(parent.getItemAtPosition(pos).toString().equals("MP Name")){
		String[] names = resource.getStringArray(R.array.name_13_arrays);
		textadapter = 
		        new ArrayAdapter<String>(HSActivity, android.R.layout.simple_list_item_1, names);
		textView.setAdapter(textadapter);
	}else if(parent.getItemAtPosition(pos).toString().equalsIgnoreCase("Constituency")){
		String[] constituencies = resource.getStringArray(R.array.constituency_13_arrays);
	
		textadapter = 
		        new ArrayAdapter<String>(HSActivity, android.R.layout.simple_list_item_1, constituencies);
		textView.setAdapter(textadapter);
	}else if(parent.getItemAtPosition(pos).toString().equalsIgnoreCase("Party")){
		String[] party = resource.getStringArray(R.array.party_13_arrays);
		textadapter = 
		        new ArrayAdapter<String>(HSActivity, android.R.layout.simple_list_item_1, party);
		textView.setAdapter(textadapter);
	}
	

}
else if(((String)year_spinner.getSelectedItem()).equals("14th (2004 to 2009)")){

	if(parent.getItemAtPosition(pos).toString().equals("MP Name")){
		String[] names = resource.getStringArray(R.array.name_14_arrays);
		textadapter = 
		        new ArrayAdapter<String>(HSActivity, android.R.layout.simple_list_item_1, names);
		textView.setAdapter(textadapter);
	}else if(parent.getItemAtPosition(pos).toString().equalsIgnoreCase("Constituency")){
		String[] constituencies = resource.getStringArray(R.array.constituency_14_arrays);
	
		textadapter = 
		        new ArrayAdapter<String>(HSActivity, android.R.layout.simple_list_item_1, constituencies);
		textView.setAdapter(textadapter);
	}else if(parent.getItemAtPosition(pos).toString().equalsIgnoreCase("Party")){
		String[] party = resource.getStringArray(R.array.party_14_arrays);
		textadapter = 
		        new ArrayAdapter<String>(HSActivity, android.R.layout.simple_list_item_1, party);
		textView.setAdapter(textadapter);
	}
	

}else if(((String)year_spinner.getSelectedItem()).equals("15th (2009 to 2014)")){

	if(parent.getItemAtPosition(pos).toString().equals("MP Name")){
		String[] names = resource.getStringArray(R.array.name_15_arrays);
		textadapter = 
		        new ArrayAdapter<String>(HSActivity, android.R.layout.simple_list_item_1, names);
		textView.setAdapter(textadapter);
	}else if(parent.getItemAtPosition(pos).toString().equalsIgnoreCase("Constituency")){
		String[] constituencies = resource.getStringArray(R.array.constituency_15_arrays);
	
		textadapter = 
		        new ArrayAdapter<String>(HSActivity, android.R.layout.simple_list_item_1, constituencies);
		textView.setAdapter(textadapter);
	}else if(parent.getItemAtPosition(pos).toString().equalsIgnoreCase("Party")){
		String[] party = resource.getStringArray(R.array.party_15_arrays);
		textadapter = 
		        new ArrayAdapter<String>(HSActivity, android.R.layout.simple_list_item_1, party);
		textView.setAdapter(textadapter);
	}
	

}


		}else{
			
			
			if(parent.getItemAtPosition(pos).toString().equals("MP Name")){
				textadapter = 
				        new ArrayAdapter<String>(NMpActivity, android.R.layout.simple_list_item_1, names);
				textView.setAdapter(textadapter);
			}else if(parent.getItemAtPosition(pos).toString().equalsIgnoreCase("Constituency")){
			
				textadapter = 
				        new ArrayAdapter<String>(NMpActivity, android.R.layout.simple_list_item_1, constituencies);
				textView.setAdapter(textadapter);
			}else if(parent.getItemAtPosition(pos).toString().equalsIgnoreCase("Party")){
				textadapter = 
				        new ArrayAdapter<String>(NMpActivity, android.R.layout.simple_list_item_1, parties);
				textView.setAdapter(textadapter);
				}
			
		}
	}

		@Override
		public void onNothingSelected(AdapterView<?> arg0) {

		}
	}
