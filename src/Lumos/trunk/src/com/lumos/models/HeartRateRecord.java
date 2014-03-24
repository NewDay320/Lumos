package com.lumos.models;

public class HeartRateRecord extends EventRecord {
	
	private int heartRate;
	
	public HeartRateRecord(int reading)
	{
		super();
		heartRate = reading;
	}
	
	public int getHeartRate()
	{
		return heartRate;
	}

}
