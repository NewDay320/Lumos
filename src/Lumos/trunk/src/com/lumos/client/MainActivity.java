package com.lumos.client;

import com.lumos.R;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;

//for notifications
import android.app.NotificationManager;
import android.support.v4.app.NotificationCompat;
import android.app.PendingIntent;
import android.app.TaskStackBuilder;
import android.content.Context;
import android.util.Log;
import android.widget.Button; //temporary

// Notifications tutorial: http://www.tutorialspoint.com/android/android_notifications.htm
// TODO get alarm(s) working (stuff crashes right now)
// FIXME clean up layouts (i.e. all the schedule-related stuff is confusing)
// FIXME fix UI--everything is too right (in a bad way) :'(

public class MainActivity extends FragmentActivity implements ScheduleFragment.OnScheduleItemSelectedListener{//, DietLogFragment.OnDietLogItemSelectedListener {
	public final static String EXTRA_MESSAGE = "com.lumos.client.MESSAGE";
	
	/* for notifications */
	private NotificationManager mNotificationManager;
	private int notificationID = 100;
	private int numMessages = 0;

	@Override
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		/* for notifications */
		Button startBtn = (Button) findViewById(R.id.start);
		startBtn.setOnClickListener(new View.OnClickListener() {
			public void onClick(View view) {
				displayNotification();
			}
		});
		
		Button cancelBtn = (Button) findViewById(R.id.cancel);
		cancelBtn.setOnClickListener(new View.OnClickListener(){
			public void onClick(View view) {
				cancelNotification();
			}
		});
		
		Button updateBtn = (Button) findViewById(R.id.update);
		updateBtn.setOnClickListener(new View.OnClickListener(){
			public void onClick(View view){
				updateNotification();
			}
		});
		
		/* schedule and diet log fragments */
		if (findViewById(R.id.schedule_fragment_container) != null) {
			if (savedInstanceState != null) {
				return;
			}
			ScheduleFragment firstFragment = new ScheduleFragment();
			firstFragment.setArguments(getIntent().getExtras());
			getSupportFragmentManager().beginTransaction().add(R.id.schedule_fragment_container,  firstFragment).commit();
//			DietLogFragment dietlog = new DietLogFragment();
//			dietlog.setArguments(getIntent().getExtras());
//			getSupportFragmentManager().beginTransaction().add(R.id.schedule_fragment_container, dietlog).commit();
		}
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {    
//		Intent intent = new Intent(this, MZTestActivity.class);
//		this.startActivity(intent);
		return true;
	}
	
	/** notifications 
	 * FIXME doesn't display as a big box and goes away after a few seconds, also crashes the app...
	 * TODO figure out how to make the tablet flash + vibrate if possible
	 * **/
	protected void displayNotification() {
		Log.i("Start", "notification");
		/* invoking default notification service */
		NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(this);
		mBuilder.setContentTitle("New Message");
		mBuilder.setContentText("You've received new message");
		mBuilder.setTicker("New Message Alert");
		mBuilder.setSmallIcon(R.drawable.sun);
		/* increase notification number every time a new notification arrives */
		mBuilder.setNumber(++numMessages);
		
		/* creates an explicit intent for an activity in app */
		Intent resultIntent = new Intent(this, NotificationView.class);
		TaskStackBuilder stackBuilder = TaskStackBuilder.create(this);
		stackBuilder.addParentStack(NotificationView.class);
		
		/* adds the intent that starts the activity to the top of the stack */
		stackBuilder.addNextIntent(resultIntent);
		PendingIntent resultPendingIntent = stackBuilder.getPendingIntent(0, PendingIntent.FLAG_UPDATE_CURRENT);
		mBuilder.setContentIntent(resultPendingIntent);
		mNotificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
		
		/* notificationID allows you to update the notification later on */
		mNotificationManager.notify(notificationID, mBuilder.build());
	}
	
	protected void cancelNotification(){
		Log.i("Cancel", "notification");
		mNotificationManager.cancel(notificationID);
	}
	
	protected void updateNotification(){
		Log.i("Update", "notification");
		//TODO
	}
	
	
	/** what happens when they click an item in the schedule fragment **/
	public void onScheduleItemSelected(int position){
		// user selected a schedule item from the schedule fragment
		ScheduleItemFragment item = (ScheduleItemFragment) getSupportFragmentManager().findFragmentById(R.id.scheduleitem_fragment);
		if (item != null){
			item.updateScheduleView(position);
		} else {
			ScheduleItemFragment newItem = new ScheduleItemFragment();
			Bundle args = new Bundle();
			args.putInt(ScheduleItemFragment.ARG_POSITION, position);
			newItem.setArguments(args);
			FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
			transaction.replace(R.id.schedule_fragment_container, newItem);
			transaction.addToBackStack(null);
			transaction.commit();
		}
	}

	/** diet log fragment
	 * FIXME probably need to add separate layout instead of using schedule_view.xml
	 */
	public void onDietLogItemSelected(int position){
		// user selected a schedule item from the schedule fragment
		ScheduleItemFragment item = (ScheduleItemFragment) getSupportFragmentManager().findFragmentById(R.id.scheduleitem_fragment);
		if (item != null){
			item.updateScheduleView(position);
		} else {
			ScheduleItemFragment newItem = new ScheduleItemFragment();
			Bundle args = new Bundle();
			args.putInt(ScheduleItemFragment.ARG_POSITION, position);
			newItem.setArguments(args);
			FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
			transaction.replace(R.id.schedule_fragment_container, newItem);
			transaction.addToBackStack(null);
			transaction.commit();
		}
	}
	
	public void onHowAreYouClick(View v){
		Intent intent = new Intent(this, SurveyChooserActivity.class);
    	startActivity(intent);
	}
	
	public void onTakeMeasurementClick(View v){
		Intent intent = new Intent(this, TakeMeasurementActivity.class);
		startActivity(intent);
	}
	
	public void onViewMedicationsClick(View v){
		Intent intent = new Intent(this, ViewMedicationsActivity.class);
		startActivity(intent);
	}
	
}

  
