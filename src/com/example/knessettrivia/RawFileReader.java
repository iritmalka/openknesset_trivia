package com.example.knessettrivia;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

import org.json.JSONException;
import org.json.JSONObject;

import android.content.Context;

public class RawFileReader {

	private Context context;
	private int resourceID;
	
	public RawFileReader(Context c, int resource){
		context = c;
		resourceID = resource;
	}
	
	public JSONObject toJson(){
		InputStream inputStream = context.getResources().openRawResource(resourceID);
		ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
		
		int i;
		try {
			i = inputStream.read();
			while (i != -1)
			{
				byteArrayOutputStream.write(i);
				i = inputStream.read();
			}
			inputStream.close();
		} catch (IOException e) {
			return null;
		}
		
		JSONObject jsonOutput = null;
		try {
			jsonOutput = new JSONObject(byteArrayOutputStream.toString());
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return jsonOutput;
	}
}
