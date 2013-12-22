package com.example.knessettrivia;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONObject;

import android.util.Log;


public class HttpGetter{
	
	public HttpEntity responseEntity;

	public HttpGetter(final String url){
		new Thread() {
			@Override
			public void run() {
				HttpClient httpclient = new DefaultHttpClient();
		        HttpGet httpget = new HttpGet(url); 
		        HttpResponse response;
		        try {
		            response = httpclient.execute(httpget);
		            Log.i("HttpGetter", response.getStatusLine().toString());
		            responseEntity = response.getEntity();
		            Log.i("HttpGetter", "response entity " +responseEntity.toString());
		        } catch (Exception e) {}
			}	    	  
		}.start();
	}
	
	public JSONObject toJson(){
		return null;
	}
 
}
