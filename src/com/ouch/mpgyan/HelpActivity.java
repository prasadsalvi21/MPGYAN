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

public class HelpActivity extends ActionBarActivity{
	private static final String STATE_SELECTED_NAVIGATION_ITEM = "selected_navigation_item";
	private ArrayList<String> help_menu;
	private ArrayList<ArrayList<ArrayList<String>>> help_details;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.fragment_help);
		setTitle("Help");
		ExpandableListView l = (ExpandableListView) findViewById(R.id.ExpandableListViewVital);
		 
        loadData();
 
        myExpandableAdapter adapter = new myExpandableAdapter(this, help_menu, help_details);
		l.setAdapter(adapter);
	}
	 public class myExpandableAdapter extends BaseExpandableListAdapter {
		 
	    	private ArrayList<String> help_menu;
	        private ArrayList<ArrayList<ArrayList<String>>> help_details;
	    	private Context context;
	    	public myExpandableAdapter(Context context, ArrayList<String> help_menu, ArrayList<ArrayList<ArrayList<String>>> help_details) {
	            this.context = context;
	            this.help_menu = help_menu;
	            this.help_details = help_details;
	        }
	 
	 
	    	@Override
	        public boolean areAllItemsEnabled()
	        {
	            return true;
	        }
	 
	        @Override
	        public ArrayList<String> getChild(int groupPosition, int childPosition) {
	            return help_details.get(groupPosition).get(childPosition);
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
	                    convertView = inflater.inflate(R.layout.elv_help_home, null);
	                    TextView tvPlayerName = (TextView) convertView.findViewById(R.id.TextHelpViewChild01);
	                    tvPlayerName.setText(child);
	                    break;

	                case 1:
	                    convertView = inflater.inflate(R.layout.elv_help_vital, null);
	                    TextView tvPlayerName1 = (TextView) convertView.findViewById(R.id.TextHelpViewChild02);
	                    tvPlayerName1.setText(child);
	                    break; 

	                case 2:
	                    convertView = inflater.inflate(R.layout.elv_help_bill, null);
	                    TextView tvPlayerName2 = (TextView) convertView.findViewById(R.id.TextHelpViewChild03);
	                    tvPlayerName2.setText(child);
	                    break;

	                case 3:             
	                    convertView = inflater.inflate(R.layout.elv_help_historical, null);
	                    TextView tvPlayerName3 = (TextView) convertView.findViewById(R.id.TextHelpViewChild04);
	                    tvPlayerName3.setText(child);
	                    break;
	                case 4:             
	                    convertView = inflater.inflate(R.layout.elv_help_source, null);
	                    TextView tvPlayerName4 = (TextView) convertView.findViewById(R.id.TextHelpViewChild05);
	                    tvPlayerName4.setText(child);
	                    break;

	                }
	                        
	            return convertView;
	        }
	 
	        @Override
	        public int getChildrenCount(int groupPosition) {
	            return help_details.get(groupPosition).size();
	        }
	 
	        @Override
	        public String getGroup(int groupPosition) {
	            return help_menu.get(groupPosition);
	        }
	 
	        @Override
	        public int getGroupCount() {
	            return help_menu.size();
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
	                convertView = infalInflater.inflate(R.layout.expandablelistview_help_menu, null);
	            }
	 
	            TextView grouptxt = (TextView) convertView.findViewById(R.id.TextHelpViewGroup);
	 
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
	    	help_menu= new ArrayList<String>();
	    	help_details= new ArrayList<ArrayList<ArrayList<String>>>();
	 
	    	help_menu.add("Home Page");
	    	help_menu.add("Vital Statistics Page");
	    	help_menu.add("Bills Search Page");
	    	help_menu.add("Historical Search Page");
	    	help_menu.add("Data sources and references");
	 
	    	help_details.add(new ArrayList<ArrayList<String>>());
	    	help_details.get(0).add(new ArrayList<String>());
	    	help_details.get(0).get(0).add("\nThe Home Page menu navigates you to the Home page which provides you with the current election results and latest updates about the 16th Lok Sabha Elections currently held.\n\n"
	    			+ "Both these functionalities need the internet connection of your android device to be ON. This is also the first page that opens when you open the application. On clicking the \"Get Election Results\" button you are redirected to the latest election results (announcement date 16th May 2014)\n\n"
	    			+ "On clicking \"Click for latest election updates\" you are provided with short snippets of the latest happenings during this election. The rest of the three buttons are direct links from the home page to other pages namely, Vital Statistics, Historical Search and Bills Search page.\n\n");
	 
	    	help_details.add(new ArrayList<ArrayList<String>>());
	    	help_details.get(1).add(new ArrayList<String>());
	    	help_details.get(1).get(0).add("\nThe Vital Statistics menu navigates you to the Vital Statistics page which gives you all the information you would be interested in. It's a section dedicated to provide you with facts and numbers that affect the working of the Parliament\n\n"
	    			+ "You have to just click on the topic that interests you and you would see the information pertaining to that particular topic\n\n");
	 
	    	help_details.add(new ArrayList<ArrayList<String>>());
	    	help_details.get(2).add(new ArrayList<String>());
	    	help_details.get(2).get(0).add("\nThe bill search menu navigates you to the Bill search page which bombards you with all the information pertaining to different bills addressed on the floor of the house\n\n"
	    			+ "These bills can be searched on the basis of either year or title of the bills itself.\n\n");
	    	
	    	help_details.add(new ArrayList<ArrayList<String>>());
	    	help_details.get(3).add(new ArrayList<String>());
	    	help_details.get(3).get(0).add("\nThe Historical Search menu navigates you to the Historical search page which provides all information regarding our parliamentarians in the Lok Sabha. The Member search can be filtered on the basis of either M.P name, Party or constituency during different Lok Sabha's\n\n"
	    			+ "Just select the Lok Sabha year you are looking out for and then the next criteria which will narrow down your search to a particular M.P."
	    			+ "\n\nAfter selecting the criterias, type in the text box based on the second criteria selected. For e.g. if the second criteria selected is Party, then start typing the party name you are searching for. Our Autocomplete mechanism will help you while you type, by predicting the possible word. The result would either be a list if multiple results match the criteria entered or you would be directly navigated to the results page. If you are on the page which displays the list of result, then just scroll through the list and click on the result you are searching for. You would then see the basic information of the M.P. Inorder to view more information click on the Additional Information.\n\n");
	    	help_details.add(new ArrayList<ArrayList<String>>());
	    	help_details.get(4).add(new ArrayList<String>());
	    	help_details.get(4).get(0).add("\nThe data is as obtained from open government data, www.prsindia.org and Election Commission of India\n\n");

	   
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
			getMenuInflater().inflate(R.menu.help, menu);
			return true;
		}

		@Override
		public boolean onOptionsItemSelected(MenuItem item) {
			return MPGUtility.createMenu(this,item);
			}

	}
