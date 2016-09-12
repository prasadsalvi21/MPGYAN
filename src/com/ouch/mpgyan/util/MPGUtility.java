package com.ouch.mpgyan.util;

import java.util.Locale;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.ouch.mpgyan.AboutUsActivity;
import com.ouch.mpgyan.BillInfoActivity;
import com.ouch.mpgyan.HelpActivity;
import com.ouch.mpgyan.HistoricalSearchActivity;
import com.ouch.mpgyan.MainActivity;
import com.ouch.mpgyan.R;
import com.ouch.mpgyan.VitalStatsActivity;
@SuppressWarnings("rawtypes")
public class MPGUtility {
	
	public static void passJSONArrayChangeActivity2(Activity context,Class openActivity,int year,JSONArray array,String year_key,String key){
		Intent intent= new Intent(context,openActivity);
		Bundle bundle=new Bundle();
		bundle.putString(key, array.toString());
		bundle.putInt(year_key, year);
		intent.putExtras(bundle);
		context.startActivity(intent);
	}
	public static void passJSONArrayChangeActivity(Activity context,Class openActivity,JSONArray array,String key){
		Intent intent= new Intent(context,openActivity);
		Bundle bundle=new Bundle();
		bundle.putString(key, array.toString());
		intent.putExtras(bundle);
		context.startActivity(intent);
	}
	public static void passJSONArrayChangeActivity(Activity context,Class openActivity,JSONObject object,String key){
		Intent intent= new Intent(context,openActivity);
		Bundle bundle=new Bundle();
		bundle.putString(key, object.toString());
		intent.putExtras(bundle);
		context.startActivity(intent);
	}
	public static void createStaticActivity(Activity context,Class openActivity, int resource){
		Intent intent= new Intent(context,openActivity);
		context.startActivity(intent);
	}
	public static boolean createMenu(Activity context, MenuItem item){
        switch (item.getItemId()) {
            case R.id.action_history:
            	MPGUtility.createStaticActivity(context,HistoricalSearchActivity.class ,R.layout.fragment_historical_search);
                return true;
            case R.id.action_about_us:
            	MPGUtility.createStaticActivity(context,AboutUsActivity.class ,R.layout.fragment_about_us);
                return true;
            case R.id.action_help:
            	MPGUtility.createStaticActivity(context,HelpActivity.class ,R.layout.fragment_help);
                return true;
            case R.id.action_main:
            	MPGUtility.createStaticActivity(context,MainActivity.class ,R.layout.fragment_main);
                return true;
            case R.id.action_vital_stats:
            	MPGUtility.createStaticActivity(context,VitalStatsActivity.class ,R.layout.fragment_vital_stats);
                return true;
            case R.id.action_bill_info:
            	MPGUtility.createStaticActivity(context,BillInfoActivity.class ,R.layout.fragment_bill_info);
                return true;
       }
		return false;
    
	}
	public static JSONArray getJSONArray(int criteriaPosition,JSONArray unfilteredArray, String filterCriteria){
		JSONArray array=new JSONArray();
		for(int i=0;i<unfilteredArray.length();i++){
			try {
				String s=((String)((JSONArray) unfilteredArray.get(i)).get(criteriaPosition)).toLowerCase(new Locale("en","GB"));
				if((s).contains(filterCriteria.toLowerCase(new Locale("en","GB")))){
					array.put(unfilteredArray.get(i));
				}
			} catch (JSONException e) {
				e.printStackTrace();
			}
		}
		return array;
	}
	public static JSONArray getJSONArrayForParty(int criteriaPosition,JSONArray unfilteredArray, String filterCriteria){
		JSONArray array=new JSONArray();
		for(int i=0;i<unfilteredArray.length();i++){
			try {
				String s=((String)((JSONArray) unfilteredArray.get(i)).get(criteriaPosition)).toLowerCase(new Locale("en","GB"));
				if((s.trim()).equalsIgnoreCase(filterCriteria.toLowerCase(new Locale("en","GB")).trim())){
					array.put(unfilteredArray.get(i));
				}
			} catch (JSONException e) {
				e.printStackTrace();
			}
		}
		return array;
	}
	public static JSONArray getFilteredJSONArray(String criteria,JSONArray unfilteredArray, String filterCriteria){
		JSONArray array=new JSONArray();
		for(int i=0;i<unfilteredArray.length();i++){
			try {
				if((((JSONObject) unfilteredArray.get(i)).get(criteria).toString().toLowerCase(new Locale("en","GB"))).contains(filterCriteria.toLowerCase(new Locale("en","GB")))){
					array.put(unfilteredArray.get(i));
				}
			} catch (JSONException e) {
				e.printStackTrace();
			}
		}
		return array;
	}
}
