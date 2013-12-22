package com.example.knessettrivia;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.util.Log;

public class ImageQuestionsGenerator {

	private JSONArray members;
	private RandomHelper randomIndex;
	HashMap<String, Object> questionObject;
	private JSONObject object1;


	public ImageQuestionsGenerator(JSONObject jsonData){
		try {
			members = jsonData.getJSONArray("objects");
		} catch (JSONException e) {
			e.printStackTrace();
		}
		randomIndex = new RandomHelper(members.length());
	}

	private String getMemberImage(HashMap<String, Object> member){
		return "member_" + (String)member.get("id");
	}

	public Question getNextQuestion() throws JSONException{
		JSONObject correctAnswerMember, currentMember;
		ArrayList<JSONObject> wrongAnswersMembers = new ArrayList<JSONObject>();
		
		while (true){
			correctAnswerMember = (JSONObject)members.get(randomIndex.next());
			for (int i=0; i < members.length() && wrongAnswersMembers.size() < 3; i++){
				currentMember = (JSONObject)members.get(randomIndex.next());
				if (correctAnswerMember.get("gender") != currentMember.get("gender") && 
						!wrongAnswersMembers.contains(currentMember) &&
						!correctAnswerMember.equals(currentMember)){
					wrongAnswersMembers.add(currentMember);
					Log.d("+++++", "fakeMember " + currentMember);
				}
			}
			if (wrongAnswersMembers.size() == 3){
				break;
			}
			else{
				randomIndex.initialize();
			}
		}
		return null;
	}

}
