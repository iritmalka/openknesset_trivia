package com.example.knessettrivia;

import android.util.Log;

public class Question {

	private String questionType;
	private String body;
	private int answer;
	
	public Question() {
	}

	public String getBody(){
		return body;
	}
	
	public int getAnswer(){
		return answer;
	}
	
	public boolean isCorrect(int ans){
		return answer == ans;
	}
}
