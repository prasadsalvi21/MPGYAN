package com.ouch.mpgyan.util;

import com.ouch.mpgyan.theads.BillInfoJSONParser;
import com.ouch.mpgyan.theads.HistoricalJSONParserThread;

import android.content.res.AssetManager;

public class ThreadControllers {
	
	public static HistoricalJSONParserThread createHistoricalThread(AssetManager assets){
	HistoricalJSONParserThread jsonParserThread= new HistoricalJSONParserThread(assets);
	jsonParserThread.setPriority(Thread.MAX_PRIORITY);
	return jsonParserThread;
	
}
	public static BillInfoJSONParser createBillInfoThread(AssetManager assets){
		BillInfoJSONParser jsonParserThread= new BillInfoJSONParser(assets);
		jsonParserThread.setPriority(Thread.MAX_PRIORITY);
		return jsonParserThread;
		
	}
	
	public static void runThread(Thread thread){
		thread.start();
	}
	@SuppressWarnings("deprecation")
	public static void stopThread(Thread thread){
		thread.stop();
	}
	public static void joinThread(Thread thread){
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
