package com.lumos.models;

public class BloodGlucoseMeasurementRecord extends EventRecord {
	
	private int bloodGlucoseLevel;
	
	public BloodGlucoseMeasurementRecord(int reading)
	{
		super();
		bloodGlucoseLevel = reading;
	}
	
	public int getBloodGlucoseReading()
	{
		return bloodGlucoseLevel;
	}

}
