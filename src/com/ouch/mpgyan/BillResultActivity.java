package com.ouch.mpgyan;

import java.util.ArrayList;

import org.json.JSONException;
import org.json.JSONObject;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
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

public class BillResultActivity extends ActionBarActivity {

	
	private ArrayList<String> bill_result_menu;
	private ArrayList<ArrayList<ArrayList<String>>> bill_result_details;
	String title;
	private int i=0;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.fragment_bill_result);
		
		ExpandableListView l = (ExpandableListView) findViewById(R.id.ExpandableListViewVital);
			title= loadData();
        myExpandableAdapter adapter = new myExpandableAdapter(this, bill_result_menu, bill_result_details);
		l.setAdapter(adapter);
		setTitle(title);
	}

	public class myExpandableAdapter extends BaseExpandableListAdapter {
		 
    	private ArrayList<String> bill_result_menu;
        private ArrayList<ArrayList<ArrayList<String>>> bill_result_details;
    	private Context context;
    	public myExpandableAdapter(Context context, ArrayList<String> bill_result_menu, ArrayList<ArrayList<ArrayList<String>>> bill_result_details) {
            this.context = context;
            this.bill_result_menu = bill_result_menu;
            this.bill_result_details = bill_result_details;
        }
 
 
    	@Override
        public boolean areAllItemsEnabled()
        {
            return true;
        }
 
        @Override
        public ArrayList<String> getChild(int groupPosition, int childPosition) {
            return bill_result_details.get(groupPosition).get(childPosition);
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
                	convertView = inflater.inflate(R.layout.elv_bill_info_bill_result, null);/*if bill info selected first then app stops*/
                	if(childPosition==0)
                	{
                    convertView = inflater.inflate(R.layout.elv_bill_info_bill_result, null);
                    TextView Bno = (TextView) convertView.findViewById(R.id.B_Bno);
                    Bno.setText(child);
                	}
                	else if(childPosition==1)
                	{
                		convertView = inflater.inflate(R.layout.elv_bill_info_bill_result, null);
                        TextView year = (TextView) convertView.findViewById(R.id.B_Year);
                        year.setText(child);
                	}
                	else if(childPosition==2)
                	{
                		convertView = inflater.inflate(R.layout.elv_bill_info_bill_result, null);
                        TextView title = (TextView) convertView.findViewById(R.id.B_Title);
                        title.setText(child);
                	}
                	else if(childPosition==3)
                	{
                		convertView = inflater.inflate(R.layout.elv_bill_info_bill_result, null);
                        TextView actno = (TextView) convertView.findViewById(R.id.B_Ministry);
                        actno.setText(child);
                	}
                	else if(childPosition==4)
                	{
                		convertView = inflater.inflate(R.layout.elv_bill_info_bill_result, null);
                        TextView cat = (TextView) convertView.findViewById(R.id.B_ActNo);
                        cat.setText(child);
                	}
                	else if(childPosition==5)
                	{
                		convertView = inflater.inflate(R.layout.elv_bill_info_bill_result, null);
                        TextView status = (TextView) convertView.findViewById(R.id.B_Category);
                        status.setText(child);
                	}	
                	else if(childPosition==6)
                	{
                		String s1=child.substring(7);
                		s1=s1.trim();
                        if(s1.equalsIgnoreCase("Passed"))
                        {
                        	convertView = inflater.inflate(R.layout.elv_bill_info_bill_result, null);
                            TextView status = (TextView) convertView.findViewById(R.id.B_Status_Pass);
                            status.setText(child);
                        	
                        }else if(s1.equalsIgnoreCase("Pending"))
                        {
                        convertView = inflater.inflate(R.layout.elv_bill_info_bill_result, null);
                        TextView status = (TextView) convertView.findViewById(R.id.B_Status_Pending);
                        status.setText(child);
                        	
                        }else if(s1.equalsIgnoreCase("Assented"))
                        {
                        	convertView = inflater.inflate(R.layout.elv_bill_info_bill_result, null);
                            TextView status = (TextView) convertView.findViewById(R.id.B_Status_Assent);
                            status.setText(child);
                        	
                        }
                        else if(s1.equalsIgnoreCase("Withdrawn"))
                        {
                        	convertView = inflater.inflate(R.layout.elv_bill_info_bill_result, null);
                            TextView status = (TextView) convertView.findViewById(R.id.B_Status_Withdrawn);
                            status.setText(child);
                        	status.setTextColor(Color.BLUE);
                        }
                        else if(s1.equalsIgnoreCase("Lapsed"))
                        {
                        	convertView = inflater.inflate(R.layout.elv_bill_info_bill_result, null);
                            TextView status = (TextView) convertView.findViewById(R.id.B_Status_Lapsed);
                            status.setText(child);
                        	
                        }
                        else if(s1.equalsIgnoreCase("Negatived"))
                        {
                        	convertView = inflater.inflate(R.layout.elv_bill_info_bill_result, null);
                            TextView status = (TextView) convertView.findViewById(R.id.B_Status_Negativated);
                            status.setText(child);
                        	
                        }
                        else 
                        {
                        	convertView = inflater.inflate(R.layout.elv_bill_info_bill_result, null);
                            TextView status = (TextView) convertView.findViewById(R.id.B_Status);
                            status.setText(child);
                        	
                        }
                        
                	}
                    break;

                case 1:
                	if(childPosition==0)
                	{
                		convertView = inflater.inflate(R.layout.elv_imp_dates_bill_result, null);
                        TextView drs = (TextView) convertView.findViewById(R.id.B_DateOfIntroduction);
                        drs.setText(child);
                	}
                	else if(childPosition==1)
                	{
                		convertView = inflater.inflate(R.layout.elv_imp_dates_bill_result, null);
                        TextView dls = (TextView) convertView.findViewById(R.id.B_DateOfPassingInLokSabha);
                        dls.setText(child);
                	}
                	else if(childPosition==2)
                	{
                		convertView = inflater.inflate(R.layout.elv_imp_dates_bill_result, null);
                        TextView doi = (TextView) convertView.findViewById(R.id.B_DateOfPassingInRajyaSabha);
                        doi.setText(child);
                	}
                	else if(childPosition==3)
                	{
                		convertView = inflater.inflate(R.layout.elv_imp_dates_bill_result, null);
                        TextView doa = (TextView) convertView.findViewById(R.id.B_DateOfAssent);
                        doa.setText(child);
                	}

                    break; 

                case 2:
                	if(childPosition==0)
                	{
                		convertView = inflater.inflate(R.layout.elv_more_info_bill_result, null);
                        TextView introduced = (TextView) convertView.findViewById(R.id.B_URLForBillsAsIntroduced);
                        introduced.setText(child);
                	}
                	else if(childPosition==1)
                	{
                		convertView = inflater.inflate(R.layout.elv_more_info_bill_result, null);
                        TextView passed = (TextView) convertView.findViewById(R.id.B_URLForBillsAsPassedInBothHouses);
                        passed.setText(child);
                	}
                	else if(childPosition==2)
                	{
                		convertView = inflater.inflate(R.layout.elv_more_info_bill_result, null);
                        TextView err = (TextView) convertView.findViewById(R.id.B_URLOfErrata);
                        err.setText(child);
                	}
                	
                    break;

                }
                        
            return convertView;
        }
 
        @Override
        public int getChildrenCount(int groupPosition) {
            return bill_result_details.get(groupPosition).size();
        }
 
        @Override
        public String getGroup(int groupPosition) {
            return bill_result_menu.get(groupPosition);
        }
 
        @Override
        public int getGroupCount() {
            return bill_result_menu.size();
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
    	try {
    	 	String s=(String) getIntent().getExtras().get(BillInfoActivity.FILTERED_BILL_RESULT_JSON_ARRAY);
			JSONObject jsonObject = new JSONObject(s);
   
    	bill_result_menu= new ArrayList<String>();
    	bill_result_details= new ArrayList<ArrayList<ArrayList<String>>>();
 
    	bill_result_menu.add("Bill Information");
    	bill_result_menu.add("Important Dates");
    	bill_result_menu.add("More Information");
    	 
    	bill_result_details.add(new ArrayList<ArrayList<String>>());
    	bill_result_details.get(0).add(new ArrayList<String>());
    	bill_result_details.get(0).get(0).add("Bill No:"+jsonObject.get("Bno"));
 
    	bill_result_details.add(new ArrayList<ArrayList<String>>());
    	bill_result_details.get(0).add(new ArrayList<String>());
    	bill_result_details.get(0).get(1).add("Year:"+jsonObject.get("Year"));

 
    	bill_result_details.add(new ArrayList<ArrayList<String>>());
    	bill_result_details.get(0).add(new ArrayList<String>());
    	bill_result_details.get(0).get(2).add("Title:"+jsonObject.get("Title"));
    	title=(String)jsonObject.get("Title");

    	
    	bill_result_details.add(new ArrayList<ArrayList<String>>());
    	bill_result_details.get(0).add(new ArrayList<String>());
    	bill_result_details.get(0).get(3).add("Ministry:"+jsonObject.get("Ministry"));

    	bill_result_details.add(new ArrayList<ArrayList<String>>());
    	bill_result_details.get(0).add(new ArrayList<String>());
    	bill_result_details.get(0).get(4).add("Act No:"+jsonObject.get("ActNo"));

    	
    	bill_result_details.add(new ArrayList<ArrayList<String>>());
    	bill_result_details.get(0).add(new ArrayList<String>());
    	bill_result_details.get(0).get(5).add("Category:"+jsonObject.get("Category"));
    	
   	
    	bill_result_details.add(new ArrayList<ArrayList<String>>());
    	bill_result_details.get(0).add(new ArrayList<String>());
    	bill_result_details.get(0).get(6).add("Status:"+jsonObject.get("Status"));
    	
    	bill_result_details.add(new ArrayList<ArrayList<String>>());
    	bill_result_details.get(1).add(new ArrayList<String>());
    	bill_result_details.get(1).get(0).add("Date Of Introduction"+jsonObject.get("DateOfIntroduction"));

 
    	bill_result_details.add(new ArrayList<ArrayList<String>>());
    	bill_result_details.get(1).add(new ArrayList<String>());
    	bill_result_details.get(1).get(1).add("Date Of Passing In LokSabha:"+jsonObject.get("DateOfPassingInLokSabha"));

 
    	bill_result_details.add(new ArrayList<ArrayList<String>>());
    	bill_result_details.get(1).add(new ArrayList<String>());
    	bill_result_details.get(1).get(2).add("Date Of Passing In RajyaSabha:"+jsonObject.get("DateOfPassingInRajyaSabha"));

    	
    	bill_result_details.add(new ArrayList<ArrayList<String>>());
    	bill_result_details.get(1).add(new ArrayList<String>());
    	bill_result_details.get(1).get(3).add("Date Of Assent:"+jsonObject.get("DateOfAssent"));
    	
    	bill_result_details.add(new ArrayList<ArrayList<String>>());
    	bill_result_details.get(2).add(new ArrayList<String>());
    	bill_result_details.get(2).get(0).add("URL For Bills As Introduced:"+jsonObject.get("URLForBillsAsIntroduced"));

 
    	bill_result_details.add(new ArrayList<ArrayList<String>>());
    	bill_result_details.get(2).add(new ArrayList<String>());
    	bill_result_details.get(2).get(1).add("URL For Bills As Passed In BothHouses:"+jsonObject.get("URLForBillsAsPassedInBothHouses"));

 
    	bill_result_details.add(new ArrayList<ArrayList<String>>());
    	bill_result_details.get(2).add(new ArrayList<String>());
    	bill_result_details.get(2).get(2).add("URL Of Errata:"+jsonObject.get("URLOfErrata"));
    	} catch (JSONException e)
    	{
    		Log.e("JSON", "--------JSONException in BillResultActivity:loadData-------");
		} 
    	return title;
   }
    
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.bill_result, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		return MPGUtility.createMenu(this,item);
		}
	public static class PlaceholderFragment extends Fragment {

		public PlaceholderFragment() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View rootView = inflater.inflate(R.layout.fragment_bill_result,
					container, false);
			return rootView;
		}
	}

}
