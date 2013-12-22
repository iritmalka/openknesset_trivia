package com.example.knessettrivia;

import android.util.Log;

public class ImageQuestion extends Question{
	
	public static enum Answer {
		One,
		Two,
		Three,
		Four
	}
	
	public static enum QuestionType {
		IMAGE,
	}
	
	private QuestionType questionType = QuestionType.IMAGE;
	private String question;
	private int answer;
	
	
	public ImageQuestion(String name, int ans){
		super();
		question = "זהה את " + name;
		answer = ans;
	}

	/*public static int generateAnswer(){
		RandomHelper randomAnswer = new RandomHelper(Answer.values().length);
		Log.d("+++++", "answer  " + randomAnswer.next());
		return randomAnswer.next();
	}
	*/
	public String getBody(){
		return question;
	}
	
	public int getAnswer(){
		return answer;
	}
	
	public boolean isCorrect(int ans){
		return answer == ans;
	}	
}
