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

public class HistoricalJSONParserThread extends Thread {

	private StringBuilder builder = new StringBuilder();
	private InputStream is = null;
	private AssetManager manager;
	private JSONObject jobject;
	private Logger logger;
	public JSONObject getJobject() {
		return jobject != null ? jobject : new JSONObject();
	}

	public HistoricalJSONParserThread(AssetManager manager) {
		this.manager = manager;
	}

	@Override
	public void run() {
		try {
			is = manager.open("master.json");
			BufferedReader reader = new BufferedReader(new InputStreamReader(is));
			String line;
			while ((line = reader.readLine()) != null) {
				builder.append(line);
			}
			jobject = new JSONObject(builder.toString());
		} catch (IOException e1) {
			logger.log(Level.SEVERE, "Ouch: master.json file not found---JSONParserThread:run()");
		} catch (JSONException e) {
			logger.log(Level.WARNING, "Ouch: jobject not created---JSONParserThread:run()");
		}
	}
}
