package com.lumos.client;

import com.lumos.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.view.View;

public class ResultActivity extends Activity {
	
	@Override
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_result);
		String message = getIntent().getStringExtra(CommonConstants.EXTRA_MESSAGE);
		TextView text = (TextView) findViewById(R.id.result_message);
		text.setText(message);
	}
	
	public void onSnoozeClick(View v){
		Intent intent = new Intent(getApplicationContext(), PingService.class);
		intent.setAction(CommonConstants.ACTION_SNOOZE);
		startService(intent);
	}
	
	public void onDimissClick(View v){
		Intent intent = new Intent(getApplicationContext(), PingService.class);
		intent.setAction(CommonConstants.ACTION_DISMISS);
		startService(intent);
	}

}
