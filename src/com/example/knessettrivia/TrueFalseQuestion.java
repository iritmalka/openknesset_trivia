package com.example.knessettrivia;

import android.util.Log;


public class TrueFalseQuestion {
	
	public static enum Answer {
		False,
		True
	}
	
	public static enum QuestionType {
		TRUE_OR_FALSE,
	}
	
	private QuestionType questionType = QuestionType.TRUE_OR_FALSE;
	private String question;
	private int answer;
	
	
	public TrueFalseQuestion(String name, String gender, String role, int ans){
		String genderQuest  = (gender.equals("נקבה")) ? " היא " : " הוא ";
		question = " האם " + name + genderQuest + role + "?";
		answer = ans;
	}

	public static int generateAnswer(){
		RandomHelper randomAnswer = new RandomHelper(Answer.values().length);
		return randomAnswer.next();
	}
	
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
