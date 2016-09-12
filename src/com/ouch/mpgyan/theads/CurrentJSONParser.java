package com.ouch.mpgyan.theads;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.json.JSONException;
import org.json.JSONObject;

import android.content.res.AssetManager;

public class CurrentJSONParser {
	private StringBuilder builder = new StringBuilder();
	private InputStream is = null;
	private AssetManager manager;
	private Logger logger;
	public JSONObject getCurrentJSON(){
	
	try {
		is = manager.open("current.json");
		BufferedReader reader = new BufferedReader(new InputStreamReader(is));
		String line;
		while ((line = reader.readLine()) != null) {
			builder.append(line);
		}
		return new JSONObject(builder.toString());
	} catch (IOException e1) {
		logger.log(Level.SEVERE, "Ouch: current.json file not found---CurrentJSONParser.getCurrentJSON()");
	} catch (JSONException e) {
		logger.log(Level.WARNING, "Ouch: jobject not created---CurrentJSONParser.getCurrentJSON()");
	}
	return new JSONObject();
	}
}
