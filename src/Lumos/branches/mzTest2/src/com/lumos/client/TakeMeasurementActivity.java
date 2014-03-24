package com.lumos.client;

import com.lumos.R;
import com.lumos.R.layout;
import com.lumos.R.menu;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class TakeMeasurementActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_take_measurement);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.take_measurement, menu);
		return true;
	}

}
