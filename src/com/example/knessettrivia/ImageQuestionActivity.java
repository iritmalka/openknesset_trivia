package com.example.knessettrivia;

import org.json.JSONException;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.TextView;

public class ImageQuestionActivity extends Activity {
	
	TextView questionView;
	ImageButton imageButton1;
	ImageButton imageButton2;
	ImageButton imageButton3;
	ImageButton imageButton4;
	ImageButton pressedButton;
	ImageQuestionsGenerator questionGenerator;
	Question question;
	OnClickListener answerEvent;
	RawFileReader reader;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_question_2);
		
		imageButton1 = (ImageButton) findViewById(R.id.imageButton1);
		imageButton2 = (ImageButton) findViewById(R.id.imageButton2);
		imageButton3 = (ImageButton) findViewById(R.id.imageButton3);
		imageButton4 = (ImageButton) findViewById(R.id.imageButton4);
		
		reader = new RawFileReader(getApplicationContext(), R.raw.members);
		questionGenerator = new ImageQuestionsGenerator(reader.toJson());
		try {
			question = questionGenerator.getNextQuestion();
		} catch (JSONException e) {
			Log.d("+++", "json error ");
			e.printStackTrace();
		}
	}
	
	private void checkAnswer(ImageButton pressedButton){
		int userAnswer = 0; //(trueButton == pressedButton) ? Answer.True.ordinal() : Answer.False.ordinal();
		Log.d("---", "user answer is "+ userAnswer);
		if (question.isCorrect(userAnswer)){
			pressedButton.setBackgroundColor(Color.GREEN);
			Log.d("---", "user was right");
		}
		else{
			pressedButton.setBackgroundColor(Color.RED);
			Log.d("---", "user was wrong");
		}
	}
}
