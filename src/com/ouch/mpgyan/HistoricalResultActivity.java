package com.ouch.mpgyan;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.TextView;

import com.ouch.mpgyan.util.MPGUtility;

public class HistoricalResultActivity extends ActionBarActivity {
	private ArrayList<String> hist_result_menu;
	private ArrayList<ArrayList<ArrayList<String>>> hist_result_details;
	String title;
	private int i=0;
	private int year;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		year=(int)getIntent().getExtras().get(HistoricalSearchActivity.YEAR);
		if(year>=12 && year!=16)
		{
			setContentView(R.layout.fragment_historical_result);
		ExpandableListView l = (ExpandableListView) findViewById(R.id.ExpandableListViewVital);
		 title=loadData();
   myExpandableAdapter adapter = new myExpandableAdapter(this, hist_result_menu, hist_result_details);
	l.setAdapter(adapter);
		}else if(year==16){

			setContentView(R.layout.fragment_historical_result_basic);
			String s=(String) getIntent().getExtras().get(HistoricalListActivity.NAME_JSON_OBJECT);
			try {
				JSONArray jsonArray = new JSONArray(s);
				JSONArray array=new JSONArray();
				if(jsonArray.length()==1)
				{
					array=(JSONArray)jsonArray.get(0);
				}
				else
				{
					array=jsonArray;
				}
				
				TextView H_Basic =(TextView)  findViewById(R.id.H_Basic);
				TextView H_Name =(TextView)  findViewById(R.id.H_Name);
				TextView H_Gender =(TextView)  findViewById(R.id.H_Gender);
				TextView H_Constituency =(TextView)  findViewById(R.id.H_Constituency);
				TextView H_State =(TextView)  findViewById(R.id.H_State);
				TextView H_party =(TextView)  findViewById(R.id.H_Party);
				
				H_Basic.setText("Basic Information\n");
				H_Name.setText("Name: "+(array).get(0).toString()+"\n");
				H_Gender.setText("Gender: "+array.get(1).toString()+"\n");
				H_Constituency.setText("Constituency: "+array.get(2).toString()+"\n");
				H_State.setText("State: "+array.get(3).toString()+"\n");
				H_party.setText("Party: "+array.get(4).toString()+"\n");
				title=array.get(0).toString();
				
				} 
			 catch (JSONException e)
			 {
				 Log.e("JSON","--------JSONException in HistoricalResultActivity:onCreate-------");
			} 
		
		}
		else
		{
			setContentView(R.layout.fragment_historical_result_basic);
			String s=(String) getIntent().getExtras().get(HistoricalListActivity.NAME_JSON_OBJECT);
			try {
				JSONArray jsonArray = new JSONArray(s);
				JSONArray array=new JSONArray();
				if(jsonArray.length()==1)
				{
					array=(JSONArray)jsonArray.get(0);
				}
				else
				{
					array=jsonArray;
				}
				
				TextView H_Basic =(TextView)  findViewById(R.id.H_Basic);
				TextView H_Name =(TextView)  findViewById(R.id.H_Name);
				TextView H_Gender =(TextView)  findViewById(R.id.H_Gender);
				TextView H_Constituency =(TextView)  findViewById(R.id.H_Constituency);
				TextView H_State =(TextView)  findViewById(R.id.H_State);
				TextView H_party =(TextView)  findViewById(R.id.H_Party);
				
				H_Basic.setText("Basic Information\n");
				H_Name.setText("Name: "+(array).get(0).toString()+"\n");
				H_Gender.setText("Gender: "+array.get(1).toString()+"\n");
				H_Constituency.setText("Constituency: "+array.get(2).toString()+"\n");
				H_State.setText("State: "+array.get(3).toString()+"\n");
				H_party.setText("Party: "+array.get(4).toString()+"\n");
				title=array.get(0).toString();
				
				} 
			 catch (JSONException e)
			 {
				 Log.e("JSON","--------JSONException in HistoricalResultActivity:onCreate-------");
			} 
		}
		setTitle(title);
	}
	public class myExpandableAdapter extends BaseExpandableListAdapter {
		 
    	private ArrayList<String> hist_result_menu;
        private ArrayList<ArrayList<ArrayList<String>>> hist_result_details;
    	private Context context;
    	public myExpandableAdapter(Context context, ArrayList<String> hist_result_menu, ArrayList<ArrayList<ArrayList<String>>> hist_result_details) {
            this.context = context;
            this.hist_result_menu = hist_result_menu;
            this.hist_result_details = hist_result_details;
        }
 
 
    	@Override
        public boolean areAllItemsEnabled()
        {
            return true;
        }
 
        @Override
        public ArrayList<String> getChild(int groupPosition, int childPosition) {
            return hist_result_details.get(groupPosition).get(childPosition);
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
                	convertView = inflater.inflate(R.layout.elv_hist_result_basic_info, null);/*if bill info selected first then app stops*/
                	if(childPosition==0)
                	{
                    convertView = inflater.inflate(R.layout.elv_hist_result_basic_info, null);
                    TextView Bno = (TextView) convertView.findViewById(R.id.H_Name);
                    Bno.setText(child);
                	}
                	else if(childPosition==1)
                	{
                		convertView = inflater.inflate(R.layout.elv_hist_result_basic_info, null);
                        TextView year = (TextView) convertView.findViewById(R.id.H_Gender);
                        year.setText(child);
                	}
                	else if(childPosition==2)
                	{
                		convertView = inflater.inflate(R.layout.elv_hist_result_basic_info, null);
                        TextView title = (TextView) convertView.findViewById(R.id.H_Constituency);
                        title.setText(child);
                	}
                	else if(childPosition==3)
                	{
                		convertView = inflater.inflate(R.layout.elv_hist_result_basic_info, null);
                        TextView actno = (TextView) convertView.findViewById(R.id.H_State);
                        actno.setText(child);
                	}
                	else if(childPosition==4)
                	{
                		convertView = inflater.inflate(R.layout.elv_hist_result_basic_info, null);
                        TextView cat = (TextView) convertView.findViewById(R.id.H_Party);
                        cat.setText(child);
                	}
                	
                    break;

                case 1:
                	if(childPosition==0)
                	{
                		if(year!=12)
                		{
                		convertView = inflater.inflate(R.layout.elv_hist_result_additional_info, null);
                        TextView drs = (TextView) convertView.findViewById(R.id.H_DOB);
                        
                        	drs.setText(child);
                		}
                	}
                	else if(childPosition==1)
                	{
                		convertView = inflater.inflate(R.layout.elv_hist_result_additional_info, null);
                        TextView dls = (TextView) convertView.findViewById(R.id.H_MaritalStatus);
                        dls.setText(child);
                	}
                	else if(childPosition==2)
                	{
                		convertView = inflater.inflate(R.layout.elv_hist_result_additional_info, null);
                        TextView doi = (TextView) convertView.findViewById(R.id.H_FreedomFighter);
                        doi.setText(child);
                	}
                	else if(childPosition==3)
                	{
                		convertView = inflater.inflate(R.layout.elv_hist_result_additional_info, null);
                        TextView doa = (TextView) convertView.findViewById(R.id.H_PAddress);
                        doa.setText(child);
                	}
                	else if(childPosition==4)
                	{
                		convertView = inflater.inflate(R.layout.elv_hist_result_additional_info, null);
                        TextView dls = (TextView) convertView.findViewById(R.id.H_PPhone);
                        dls.setText(child);
                	}
                	else if(childPosition==5)
                	{
                		convertView = inflater.inflate(R.layout.elv_hist_result_additional_info, null);
                        TextView doi = (TextView) convertView.findViewById(R.id.H_Profession);
                        doi.setText(child);
                	}
                	else if(childPosition==6)
                	{
                		convertView = inflater.inflate(R.layout.elv_hist_result_additional_info, null);
                        TextView doa = (TextView) convertView.findViewById(R.id.H_FName);
                        doa.setText(child);
                	}
                	else if(childPosition==7)
                	{
                		convertView = inflater.inflate(R.layout.elv_hist_result_additional_info, null);
                        TextView dls = (TextView) convertView.findViewById(R.id.H_MName);
                        dls.setText(child);
                	}
                	else if(childPosition==8)
                	{
                		convertView = inflater.inflate(R.layout.elv_hist_result_additional_info, null);
                        TextView doi = (TextView) convertView.findViewById(R.id.H_SName);
                        doi.setText(child);
                	}
                	else if(childPosition==9)
                	{
                		convertView = inflater.inflate(R.layout.elv_hist_result_additional_info, null);
                        TextView doa = (TextView) convertView.findViewById(R.id.H_POB);
                        doa.setText(child);
                	}
                	else if(childPosition==10)
                	{
                		convertView = inflater.inflate(R.layout.elv_hist_result_additional_info, null);
                        TextView dls = (TextView) convertView.findViewById(R.id.H_DOM);
                        dls.setText(child);
                	}
                	else if(childPosition==11)
                	{
                		convertView = inflater.inflate(R.layout.elv_hist_result_additional_info, null);
                        TextView doi = (TextView) convertView.findViewById(R.id.H_NOS);
                        doi.setText(child);
                	}
                	else if(childPosition==12)
                	{
                		convertView = inflater.inflate(R.layout.elv_hist_result_additional_info, null);
                        TextView doa = (TextView) convertView.findViewById(R.id.H_NOD);
                        doa.setText(child);
                	}
                	else if(childPosition==13)
                	{
                		convertView = inflater.inflate(R.layout.elv_hist_result_additional_info, null);
                        TextView dls = (TextView) convertView.findViewById(R.id.H_Education);
                        dls.setText(child);
                	}
                	else if(childPosition==14)
                	{
                		convertView = inflater.inflate(R.layout.elv_hist_result_additional_info, null);
                        TextView doi = (TextView) convertView.findViewById(R.id.H_Books);
                        doi.setText(child);
                	}
                	else if(childPosition==15)
                	{
                		convertView = inflater.inflate(R.layout.elv_hist_result_additional_info, null);
                        TextView doa = (TextView) convertView.findViewById(R.id.H_Literary);
                        doa.setText(child);
                	}
                	else if(childPosition==16)
                	{
                		convertView = inflater.inflate(R.layout.elv_hist_result_additional_info, null);
                        TextView dls = (TextView) convertView.findViewById(R.id.H_Social);
                        dls.setText(child);
                	}
                	else if(childPosition==17)
                	{
                		convertView = inflater.inflate(R.layout.elv_hist_result_additional_info, null);
                        TextView doi = (TextView) convertView.findViewById(R.id.H_Special);
                        doi.setText(child);
                	}
                	else if(childPosition==18)
                	{
                		convertView = inflater.inflate(R.layout.elv_hist_result_additional_info, null);
                        TextView doa = (TextView) convertView.findViewById(R.id.H_Hobbies);
                        doa.setText(child);
                	}
                	else if(childPosition==19)
                	{
                		convertView = inflater.inflate(R.layout.elv_hist_result_additional_info, null);
                        TextView doa = (TextView) convertView.findViewById(R.id.H_Sports);
                        doa.setText(child);
                	}
                	else if(childPosition==20)
                	{
                		convertView = inflater.inflate(R.layout.elv_hist_result_additional_info, null);
                        TextView doa = (TextView) convertView.findViewById(R.id.H_Countries);
                        doa.setText(child);
                	}
                	else if(childPosition==21)
                	{
                		convertView = inflater.inflate(R.layout.elv_hist_result_additional_info, null);
                        TextView doi = (TextView) convertView.findViewById(R.id.H_Other);
                        doi.setText(child);
                	}
                	break; 

                }
                        
            return convertView;
        }
 
        @Override
        public int getChildrenCount(int groupPosition) {
            return hist_result_details.get(groupPosition).size();
        }
 
        @Override
        public String getGroup(int groupPosition) {
            return hist_result_menu.get(groupPosition);
        }
 
        @Override
        public int getGroupCount() {
            return hist_result_menu.size();
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
                convertView = infalInflater.inflate(R.layout.expandablelistview_bill_result_menu, null);
            }
 
            TextView grouptxt = (TextView) convertView.findViewById(R.id.TextBillResultViewGroup);
 
            grouptxt.setText(group);
            
            /* To Expand first Group for First Time*/
            if(i==0)
            {
            ExpandableListView eLV = (ExpandableListView) parent;
            eLV.expandGroup(0);
            i++;
            }
            
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
 
 
    private String loadData(){

		String s=(String) getIntent().getExtras().get(HistoricalListActivity.NAME_JSON_OBJECT);
		try {
			JSONArray jsonArray = new JSONArray(s);
			JSONArray array=new JSONArray();
			if(jsonArray.length()==1)
			{
				array=(JSONArray)jsonArray.get(0);
			}
			else{
				array=jsonArray;
			}
		hist_result_menu= new ArrayList<String>();
		hist_result_details= new ArrayList<ArrayList<ArrayList<String>>>();
 
    	hist_result_menu.add("Basic Information");
    	hist_result_menu.add("Additional Information");
    	 
    	hist_result_details.add(new ArrayList<ArrayList<String>>());
    	hist_result_details.get(0).add(new ArrayList<String>());
    	hist_result_details.get(0).get(0).add("Name: "+(array).get(0).toString());
    	title=array.get(0).toString();
 
    	hist_result_details.add(new ArrayList<ArrayList<String>>());
    	hist_result_details.get(0).add(new ArrayList<String>());
    	hist_result_details.get(0).get(1).add("Gender: "+array.get(1).toString());

 
    	hist_result_details.add(new ArrayList<ArrayList<String>>());
    	hist_result_details.get(0).add(new ArrayList<String>());
    	hist_result_details.get(0).get(2).add("Constituency:"+array.get(2).toString());

    	
    	hist_result_details.add(new ArrayList<ArrayList<String>>());
    	hist_result_details.get(0).add(new ArrayList<String>());
    	hist_result_details.get(0).get(3).add("State: "+array.get(4).toString());

    	hist_result_details.add(new ArrayList<ArrayList<String>>());
    	hist_result_details.get(0).add(new ArrayList<String>());
    	hist_result_details.get(0).get(4).add("Party: "+array.get(3).toString());

    	
    	hist_result_details.add(new ArrayList<ArrayList<String>>());
    	hist_result_details.get(1).add(new ArrayList<String>());
    	hist_result_details.get(1).get(0).add("Date Of Birth: "+array.get(5).toString());
    	
   	
    	hist_result_details.add(new ArrayList<ArrayList<String>>());
    	hist_result_details.get(1).add(new ArrayList<String>());
    	hist_result_details.get(1).get(1).add("Marital Status: "+array.get(6).toString());
    	
    	hist_result_details.add(new ArrayList<ArrayList<String>>());
    	hist_result_details.get(1).add(new ArrayList<String>());
    	hist_result_details.get(1).get(2).add("Freedom Fighter: "+array.get(7).toString());

 
    	hist_result_details.add(new ArrayList<ArrayList<String>>());
    	hist_result_details.get(1).add(new ArrayList<String>());
    	hist_result_details.get(1).get(3).add("Permanent Address: "+array.get(8).toString());

 
    	hist_result_details.add(new ArrayList<ArrayList<String>>());
    	hist_result_details.get(1).add(new ArrayList<String>());
    	hist_result_details.get(1).get(4).add("Permanent Phone: "+array.get(9).toString());

    	
    	hist_result_details.add(new ArrayList<ArrayList<String>>());
    	hist_result_details.get(1).add(new ArrayList<String>());
    	hist_result_details.get(1).get(5).add("Profession: "+array.get(12).toString());
    	
    	hist_result_details.add(new ArrayList<ArrayList<String>>());
    	hist_result_details.get(1).add(new ArrayList<String>());
    	hist_result_details.get(1).get(6).add("Father Name: "+array.get(13).toString());

    	hist_result_details.add(new ArrayList<ArrayList<String>>());
    	hist_result_details.get(1).add(new ArrayList<String>());
    	hist_result_details.get(1).get(7).add("Mother Name: "+array.get(14).toString());
    	
   	
    	hist_result_details.add(new ArrayList<ArrayList<String>>());
    	hist_result_details.get(1).add(new ArrayList<String>());
    	hist_result_details.get(1).get(8).add("Spouse Name: "+array.get(15).toString());
    	
    	hist_result_details.add(new ArrayList<ArrayList<String>>());
    	hist_result_details.get(1).add(new ArrayList<String>());
    	hist_result_details.get(1).get(9).add("Place of Birth: "+array.get(16).toString());

 
    	hist_result_details.add(new ArrayList<ArrayList<String>>());
    	hist_result_details.get(1).add(new ArrayList<String>());
    	hist_result_details.get(1).get(10).add("Date of Marriage: "+array.get(17).toString());

    	
    	hist_result_details.add(new ArrayList<ArrayList<String>>());
    	hist_result_details.get(1).add(new ArrayList<String>());
    	hist_result_details.get(1).get(11).add("No. of sons: "+array.get(18).toString());
    	
    	hist_result_details.add(new ArrayList<ArrayList<String>>());
    	hist_result_details.get(1).add(new ArrayList<String>());
    	hist_result_details.get(1).get(12).add("No. of Daughters: "+array.get(19).toString());

    	hist_result_details.add(new ArrayList<ArrayList<String>>());
    	hist_result_details.get(1).add(new ArrayList<String>());
    	hist_result_details.get(1).get(13).add("Education and Institution: "+array.get(20).toString());
    	
    	hist_result_details.add(new ArrayList<ArrayList<String>>());
    	hist_result_details.get(1).add(new ArrayList<String>());
    	hist_result_details.get(1).get(14).add("Books Published: "+array.get(21).toString());

 
    	hist_result_details.add(new ArrayList<ArrayList<String>>());
    	hist_result_details.get(1).add(new ArrayList<String>());
    	hist_result_details.get(1).get(15).add("Literary Interests: "+array.get(22).toString());

 
    	hist_result_details.add(new ArrayList<ArrayList<String>>());
    	hist_result_details.get(1).add(new ArrayList<String>());
    	hist_result_details.get(1).get(16).add("Social and Cultural Activities: "+array.get(23).toString());

    	
    	hist_result_details.add(new ArrayList<ArrayList<String>>());
    	hist_result_details.get(1).add(new ArrayList<String>());
    	hist_result_details.get(1).get(17).add("Special Interests: "+array.get(24).toString());
    	
    	hist_result_details.add(new ArrayList<ArrayList<String>>());
    	hist_result_details.get(1).add(new ArrayList<String>());
    	hist_result_details.get(1).get(18).add("Hobbies: "+array.get(25).toString());

    	hist_result_details.add(new ArrayList<ArrayList<String>>());
    	hist_result_details.get(1).add(new ArrayList<String>());
    	hist_result_details.get(1).get(19).add("Sports: "+array.get(26).toString());

    	
    	hist_result_details.add(new ArrayList<ArrayList<String>>());
    	hist_result_details.get(1).add(new ArrayList<String>());
    	hist_result_details.get(1).get(20).add("Countries Visited: "+array.get(27).toString());
    	
    	hist_result_details.add(new ArrayList<ArrayList<String>>());
    	hist_result_details.get(1).add(new ArrayList<String>());
    	hist_result_details.get(1).get(21).add("Other Information: "+array.get(28).toString());

    	} catch (JSONException e) {
    		Log.e("JSON","--------JSONException in HistoricalResultActivity:loadData-------");
		} 
		return title;
   }
    
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.historical_result, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		return MPGUtility.createMenu(this,item);
		}

}
