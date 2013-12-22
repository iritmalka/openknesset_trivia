package com.example.knessettrivia;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity {

	Button startButton;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		startButton = (Button)findViewById(R.id.button1);
		
		OnClickListener startListener =	new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent imageQuestionIntent = new Intent(v.getContext(), ImageQuestionActivity.class);
				startActivity(imageQuestionIntent);
			}
		};
		startButton.setOnClickListener(startListener);
	}
}
