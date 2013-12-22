package com.example.knessettrivia;

import java.util.HashMap;
import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;

import android.util.Log;

public class TrueFalseQuestionsGenerator {

	private List objects;
	private RandomHelper randomIndex1;
	private RandomHelper randomIndex2;
	private int MAX_QUESTIONS = 20;
	private int cursor = 0;
	
	public TrueFalseQuestionsGenerator(JSONObject jsonData){
		try {
			objects = JsonHelper.toList(jsonData.getJSONArray("objects"));
		} catch (JSONException e) {
			e.printStackTrace();
		}
		randomIndex1 = new RandomHelper(objects.size());
		randomIndex2 = new RandomHelper(objects.size());
	}
	
	private HashMap<String, Object> getNextWithRole(RandomHelper randomHelper){
		HashMap<String, Object> object;
		Object role = null;
		do {
			object = (HashMap<String, Object>)objects.get(randomHelper.next());
			role = object.get("current_role_descriptions");
		} while ( role == null);
		return object;
	}
	
	public Question getNextQuestion(){
		HashMap<String, Object> object = getNextWithRole(randomIndex1);
		
		String name = (String) object.get("name");
		String gender = (String) object.get("gender");
		String role;
		Question question;
		int answer = 1; //debug
		
		if (answer == 1){//debug
			role = (String) object.	get("current_role_descriptions");
//			question = new Question(name, gender, role, answer);			
		}else{
			HashMap<String, Object> objectRole = getNextWithRole(randomIndex2);
			role = (String) objectRole.get("current_role_descriptions");
//			question = new Question(name, gender, role, answer);
		}
		return null; //question;
	}
}