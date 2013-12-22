package com.example.knessettrivia;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;


public class TrueFalseQuestionActivity extends Activity{
	
	Button trueButton;
	Button falseButton;
	TextView questionView;
	RawFileReader reader;
	OnClickListener answerEvent;
	TrueFalseQuestionsGenerator questionGenerator;
	Question question;
		
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_question_1);
		trueButton = (Button)findViewById(R.id.button2);
		falseButton = (Button)findViewById(R.id.button3);	
		questionView = (TextView)findViewById(R.id.questionText);
		
		reader = new RawFileReader(getApplicationContext(), R.raw.members);
		questionGenerator = new TrueFalseQuestionsGenerator(reader.toJson());
		question = questionGenerator.getNextQuestion(); 
		questionView.setText(question.getBody());
		
		answerEvent = new OnClickListener() {
			@Override
			public void onClick(View v) {
				Button pressedButton = (trueButton.getId() == v.getId()) ? trueButton : falseButton;
				checkAnswer(pressedButton);
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}		
				question = questionGenerator.getNextQuestion(); 
				questionView.setText(question.getBody());
				pressedButton.setBackgroundColor(Color.GRAY);
			}	
		};
		
		trueButton.setOnClickListener(answerEvent);
		falseButton.setOnClickListener(answerEvent);
	}
	
	private void checkAnswer(Button pressedButton){
		int userAnswer = (trueButton == pressedButton) ? 0 : 1;
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
