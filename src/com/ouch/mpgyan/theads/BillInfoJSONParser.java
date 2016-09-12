package com.ouch.mpgyan.theads;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.json.JSONArray;
import org.json.JSONException;

import android.content.res.AssetManager;

public class BillInfoJSONParser extends Thread {

	private StringBuilder builder = new StringBuilder();
	private InputStream is = null;
	private AssetManager manager;
	private JSONArray jarray;
	private Logger logger;
	public JSONArray getJarray() {
		return jarray != null ? jarray : new JSONArray();
	}

	public BillInfoJSONParser(AssetManager manager) {
		this.manager = manager;
	}

	@Override
	public void run() {

		try {
			is = manager.open("billInfo.json");
			BufferedReader reader = new BufferedReader(new InputStreamReader(is));
			String line;
			while ((line = reader.readLine()) != null) {
				builder.append(line);
			}
			jarray = new JSONArray(builder.toString());
		} catch (IOException e1) {
			logger.log(Level.SEVERE, "Ouch: master.json file not found---BillInfoJSONParser:run()");
		} catch (JSONException e) {
			logger.log(Level.WARNING, "Ouch: jobject not created---BillInfoJSONParser:run()");
		}

	}

}
