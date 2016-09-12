package com.ouch.mpgyan;

import java.util.ArrayList;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.TextView;

import com.ouch.mpgyan.util.MPGUtility;

public class VitalStatsActivity extends ActionBarActivity {
	private static final String STATE_SELECTED_NAVIGATION_ITEM = "selected_navigation_item";
	
	private ArrayList<String> vital_menu;
	private ArrayList<ArrayList<ArrayList<String>>> vital_stats_details;
	String title;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.fragment_vital_stats);
		setTitle("Vital Statistics");
		ExpandableListView l = (ExpandableListView) findViewById(R.id.ExpandableListViewVital);
		 
      loadData();
 
        myExpandableAdapter adapter = new myExpandableAdapter(this, vital_menu, vital_stats_details);
		l.setAdapter(adapter);
		
	}

	 public class myExpandableAdapter extends BaseExpandableListAdapter {
		 
	    	private ArrayList<String> vital_menu;
	        private ArrayList<ArrayList<ArrayList<String>>> vital_stats_details;
	    	private Context context;
	    	public myExpandableAdapter(Context context, ArrayList<String> vital_menu, ArrayList<ArrayList<ArrayList<String>>> vital_stats_details) {
	            this.context = context;
	            this.vital_menu = vital_menu;
	            this.vital_stats_details = vital_stats_details;
	        }
	 
	 
	    	@Override
	        public boolean areAllItemsEnabled()
	        {
	            return true;
	        }
	 
	        @Override
	        public ArrayList<String> getChild(int groupPosition, int childPosition) {
	            return vital_stats_details.get(groupPosition).get(childPosition);
	        }
	 
	        @Override
	        public long getChildId(int groupPosition, int childPosition) {
	            return childPosition;
	        }
	 
	        @Override
	        public View getChildView(int groupPosition, int childPosition, boolean isLastChild,View convertView, ViewGroup parent) {
	        	
	        	String child = (String) ((ArrayList<String>)getChild(groupPosition, childPosition)).get(0);
	        	 LayoutInflater inflater =  (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

	               	switch (groupPosition){

	                case 0:
	                    convertView = inflater.inflate(R.layout.elv_budget_vital_stats, null);
	                    TextView tvPlayerName = (TextView) convertView.findViewById(R.id.TextViewChild01);
	                    tvPlayerName.setText(child);
	                    break;

	                case 1:
	                    convertView = inflater.inflate(R.layout.elv_bill_passed_vital_stats, null);
	                    TextView tvPlayerName1 = (TextView) convertView.findViewById(R.id.TextViewChild02);
	                    tvPlayerName1.setText(child);
	                    break; 

	                case 2:
	                    convertView = inflater.inflate(R.layout.elv_productive_hour_vital_stats, null);
	                    TextView tvPlayerName2 = (TextView) convertView.findViewById(R.id.TextViewChild03);
	                    tvPlayerName2.setText(child);
	                    break;

	                case 3:             
	                    convertView = inflater.inflate(R.layout.elv_productive_time_vital_stats, null);
	                    TextView tvPlayerName3 = (TextView) convertView.findViewById(R.id.TextViewChild04);
	                    tvPlayerName3.setText(child);
	                    break;
	                case 4:             
	                    convertView = inflater.inflate(R.layout.elv_women_mps_vital_stats, null);
	                    TextView tvPlayerName4 = (TextView) convertView.findViewById(R.id.TextViewChild05);
	                    tvPlayerName4.setText(child);
	                    break;
	                case 5:             
	                    convertView = inflater.inflate(R.layout.elv_mp_education_vital_stats, null);
	                    TextView tvPlayerName5 = (TextView) convertView.findViewById(R.id.TextViewChild06);
	                    tvPlayerName5.setText(child);
	                    break;

	                }
	                        
	            return convertView;
	        }
	 
	        @Override
	        public int getChildrenCount(int groupPosition) {
	            return vital_stats_details.get(groupPosition).size();
	        }
	 
	        @Override
	        public String getGroup(int groupPosition) {
	            return vital_menu.get(groupPosition);
	        }
	 
	        @Override
	        public int getGroupCount() {
	            return vital_menu.size();
	        }
	 
	        @Override
	        public long getGroupId(int groupPosition) {
	            return groupPosition;
	        }
	 
	        @Override
	        public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
	 
	        	String group = (String) getGroup(groupPosition);
	 
	        	if (convertView == null) {
	                LayoutInflater infalInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	                convertView = infalInflater.inflate(R.layout.expandablelistview_vital_menu, null);
	            }
	 
	            TextView grouptxt = (TextView) convertView.findViewById(R.id.TextViewGroup);
	            grouptxt.setText(group);
	            return convertView;
	        }
	 
	        @Override
	        public boolean hasStableIds() {
	            return true;
	        }
	 
	        @Override
	        public boolean isChildSelectable(int arg0, int arg1) {
	            return true;
	        }
	 
	    }
	 
	 
	    private void loadData(){
	    	vital_menu= new ArrayList<String>();
	    	//vital_graphs= new ArrayList<ArrayList<ArrayList<Integer>>>();
	    	vital_stats_details= new ArrayList<ArrayList<ArrayList<String>>>();
	 
	    	vital_menu.add("Time spent on Budget");
	    	vital_menu.add("Bill Status'");
	    	vital_menu.add("Productivity");
	    	vital_menu.add("Productive Hours");
	    	vital_menu.add("Women MPs in Loksabha");
	    	vital_menu.add("Education Level of MPs");
	 
	    	vital_stats_details.add(new ArrayList<ArrayList<String>>());
	    	vital_stats_details.get(0).add(new ArrayList<String>());
	    	vital_stats_details.get(0).get(0).add("\nScrutiny and Discussion of the Budget has been lacking in the 15 th Lok Sabha\n\n\n"
	    			+ "Over the years, Parliament has been spending lesser time on discussing the Budget and the 15 th Lok Sabha has "
	    			+ "witnessed several instances where the financial proposals of the government were passed without scrutiny and debate."
	    			+ " In the last five years, 29 % of total productive time was spent on discussing the Budget."
	    			+ "\n\nThe Interim Budget in 2014 was passed without discussion. In 2013, the Finance Bill and Demands for Grants "
	    			+ "amounting to Rs 16.6 lakh crore were voted and passed without any discussion."
	    			+ " In 2011 and 2012, 81% and 92 % of total demands by ministries were voted on together, without any discussion."
	    			+ "\n\nDuring the tenure of the 15 th Lok Sabha, in 2011 Budget was "
	    			+ "passed without standing committees scrutinising the demands for grants from various ministries.\n\n");
	 
	    	vital_stats_details.add(new ArrayList<ArrayList<String>>());
	    	vital_stats_details.get(1).add(new ArrayList<String>());
	    	vital_stats_details.get(1).get(0).add("\n15 th Lok Sabha passed 179 Bills; 68 Bills will lapse upon its dissolution\n\n\n"
	    			+ "The 15 th Lok Sabha passed 179 Bills of the 328 to be considered and passed during its five year tenure. "
	    			+ "This is the least number of Bills passed by a full five year term Lok Sabha."
	    			+ " In comparison, the 13 th and 14 th Lok Sabhas had passed 297 and 248 Bills, respectively."
	    			+ "\n\n228 Bills, other than finance and appropriation Bills, were introduced in the 15 th Lok Sabha."
	    			+ " With the last session of the 15 th Lok Sabha having ended, a total of 68 Bills will lapse. "
	    			+ "These include the Women’s Reservation Bill, Direct Taxes Code, Micro Finance Bill, "
	    			+ "Judicial Standards and Accountability Bill and the Bill enabling the introduction of Goods and Services Tax."
	    			+ "\n\nThe Constitution provides that if a Bill has been introduced in the Rajya Sabha and not passed by it, "
	    			+ "the Bill shall not lapse on the dissolution of the Lok Sabha."
	    			+ "\n\n With the conclusion of the 15 th Lok Sabha, 60 such Bills will continue "
	    			+ "to be pending before the 16 th Lok Sabha. In comparison, the 15 th Lok Sabha inherited 37 Bills that were "
	    			+ "pending when the 14 th Lok Sabha ended.\n\n");
	 
	    	vital_stats_details.add(new ArrayList<ArrayList<String>>());
	    	vital_stats_details.get(2).add(new ArrayList<String>());
	    	vital_stats_details.get(2).get(0).add("\n60% of the time for Question Hour was lost to disruptions during the 15 th Lok Sabha\n\n\n"
	    			+ "During the 15 th Lok Sabha, Question Hour was a major casualty to disruptions."
	    			+ "Question Hour is the first hour of every Parliamentary sitting, devoted to questions posed by"
	    			+ "MPs, to be orally answered by Ministers.\n\n"
	    			+ "Lok Sabha lost 61% of the time scheduled for Question Hour and Rajya Sabha lost 59%.\n\n"
	    			+ "A total 6,479 questions were scheduled for oral answers in"
	    			+ "Lok Sabha and 6,512 in Rajya Sabha during the 15 th Lok Sabha."
	    			+ " Of these, only 10% of questions were answered in Lok Sabha and 12% in Rajya Sabha,"
	    			+ "No question in the Rajya Sabha could be answered orally during three sessions of the 15 th Lok Sabha.\n\n");
	    	
	    	
	    	vital_stats_details.add(new ArrayList<ArrayList<String>>());
	    	vital_stats_details.get(3).add(new ArrayList<String>());
	    	vital_stats_details.get(3).get(0).add("\nProductivity of the 15 th Lok Sabha has been the worst in the last fifty years\n\n\n"
	    			+ "The productive time of the Lok Sabha in the past five years "
	    			+ "stands at 61%. This has been the worst performance of the lower house in more than fifty years."
	    			+ " In comparison, the 13 th and 14 th Lok Sabhas worked for 91% and 87%, respectively."
	    			+ "\n\nDuring the 15 th Lok Sabha, frequent disruptions of Parliamentary proceedings have "
	    			+ "resulted in the Lok Sabha working for 61% and Rajya Sabha for 66% of its scheduled time."
	    			+ "\n\nThe first five sessions of the 15 th Lok Sabha worked for anaverage of 81%, "
	    			+ "despite some disruptions. Disruptions in Parliament escalated since the Winter Session 2010 with the"
	    			+ " demand for a Joint Parliamentary Committee to examine the 2G spectrum scam. "
	    			+ "Since then, the Lok Sabha has worked for an average of 52% and Rajya Sabha for 55%.\n\n");
	    	
	    	vital_stats_details.add(new ArrayList<ArrayList<String>>());
	    	vital_stats_details.get(4).add(new ArrayList<String>());
	    	vital_stats_details.get(4).get(0).add("\nThe Women's Reservation Bill, currently pending in the Rajya Sabha, proposes to reserve one-"+
	    	"third of the seats in the Lok Sabha and legislative assemblies for women."
	        +"The 15th Lok Sabha has 58 women MPs and this is the first time their representation has crossed 10%."
	    	+"Women constitute 11% of the 15th Loksabh House. \n\n\n");
	    	
	    	vital_stats_details.add(new ArrayList<ArrayList<String>>());
	    	vital_stats_details.get(5).add(new ArrayList<String>());
	    	vital_stats_details.get(5).get(0).add("\nThe percentage of MPs without secondary education has decreased from 23 per cent in 1952 to 3 per cent in 2009.\n"
+"The percentage of graduates has increased from 58 per cent in 1952 to 79 per cent in 2009 (This includes MPs with post-graduate and doctorate degrees).\n"
+"More MPs have post-graduate degrees than in 1952. The percentage of post-graduates has increased from 18 per cent to 29 per cent. \n\n\n");
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
			getMenuInflater().inflate(R.menu.vital_stats, menu);
			return true;
		}

		@Override
		public boolean onOptionsItemSelected(MenuItem item) {
			return MPGUtility.createMenu(this,item);
			}

	}
