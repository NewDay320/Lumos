package com.lumos.client;

public final class CommonConstants {
	public CommonConstants(){
		// can't instantiate me
	}
	public static final String EXTRA_MESSAGE = "com.lumos.client.pingme.EXTRA_MESSAGE";
	// snooze duration in ms (= 20 s)
	public static final int SNOOZE_DURATION = 20000;
	public static final int DEFAULT_TIMER_DURATION = 10000;
	public static final String EXTRA_TIMER = "com.lumos.client.pingme.EXTRA_TIMER";
	
	public static final String ACTION_SNOOZE="com.lumos.client.pingme.ACTION_SNOOZE";
	public static final String ACTION_PING = "com.lumos.client.pingme.ACTION_PING";
	public static final String ACTION_DISMISS = "com.lumos.client.pingme.ACTION_DISMISS";
	public static final int NOTIFICATION_ID = 001;
	
	public static final String DEBUG_TAG = "PingMe";
}