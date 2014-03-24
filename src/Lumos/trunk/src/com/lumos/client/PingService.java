package com.lumos.client;

import com.lumos.R;

import android.app.IntentService;
import android.app.Notification;
import android.app.NotificationManager;
import android.support.v4.app.NotificationCompat;
import android.content.Intent;
import android.app.PendingIntent;
import android.util.Log;

public class PingService extends IntentService {
	
	private NotificationManager mNotificationManager;
	private String mMessage;
	private int mMillis;
	NotificationCompat.Builder builder;
	
	public PingService(){
		super("com.lumos.client.pingme");
	}
	
	@Override
	protected void onHandleIntent(Intent intent){
		mMessage = intent.getStringExtra(CommonConstants.EXTRA_MESSAGE);
		mMillis = intent.getIntExtra(CommonConstants.EXTRA_TIMER, CommonConstants.DEFAULT_TIMER_DURATION);
		NotificationManager nm = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
		String action = intent.getAction();
		//ping, snooze, dismiss
		if (action.equals(CommonConstants.ACTION_PING)) {
			issueNotification(intent, mMessage);
		} else if (action.equals(CommonConstants.ACTION_SNOOZE)) {
			nm.cancel(CommonConstants.NOTIFICATION_ID);
			Log.d(CommonConstants.DEBUG_TAG, getString(R.string.snoozing));
//			issueNotification(intent, getString(R.string.done_snoozing));
		} else if (action.equals(CommonConstants.ACTION_DISMISS)) {
			nm.cancel(CommonConstants.NOTIFICATION_ID);
		}
	}
	
	private void issueNotification(Intent intent, String msg) {
		mNotificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
		//snooze, dismiss action buttons
		Intent dismissIntent = new Intent(this, PingService.class);
		dismissIntent.setAction(CommonConstants.ACTION_DISMISS);
		PendingIntent piDismiss = PendingIntent.getService(this, 0, dismissIntent, 0);
		
		Intent snoozeIntent = new Intent(this, PingService.class);
		snoozeIntent.setAction(CommonConstants.ACTION_SNOOZE);
		PendingIntent piSnooze = PendingIntent.getService(this,  0,  snoozeIntent,  0);
		
		// constuct builder object
		builder = 
				new NotificationCompat.Builder(this)
		.setSmallIcon(R.drawable.ic_stat_notification)
		.setContentTitle(getString(R.string.notification))
		.setContentText(getString(R.string.ping))
		.setDefaults(Notification.DEFAULT_ALL)
		.setStyle(new NotificationCompat.BigTextStyle()
			.bigText(msg))
		.addAction (R.drawable.ic_stat_dismiss, getString(R.string.dismiss), piDismiss)
		.addAction (R.drawable.ic_stat_snooze, getString(R.string.snooze), piSnooze);
		
		Intent resultIntent = new Intent(this, ResultActivity.class);
		resultIntent.putExtra(CommonConstants.EXTRA_MESSAGE, msg);
		resultIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
		
		PendingIntent resultPendingIntent =
				PendingIntent.getActivity(this, 0, resultIntent, PendingIntent.FLAG_UPDATE_CURRENT);
		
		builder.setContentIntent(resultPendingIntent);
		startTimer(mMillis);
	}
	
	private void issueNotification(NotificationCompat.Builder builder){
		mNotificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
		mNotificationManager.notify(CommonConstants.NOTIFICATION_ID, builder.build());
	}
	
	private void startTimer(int millis){
		Log.d(CommonConstants.DEBUG_TAG, getString(R.string.timer_start));
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {
			Log.d(CommonConstants.DEBUG_TAG, getString(R.string.sleep_error));
		}
		Log.d(CommonConstants.DEBUG_TAG, getString(R.string.timer_finished));
		issueNotification(builder);
	}
}
