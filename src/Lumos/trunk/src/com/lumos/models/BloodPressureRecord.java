package com.lumos.models;

public class BloodPressureRecord extends EventRecord{
	
	private int systolic;
	private int diastolic;
	
	public BloodPressureRecord(int systolic, int diastolic)
	{
		super();
		this.systolic = systolic;
		this.diastolic = diastolic;
	}
	
	public int getSystolic()
	{
		return systolic;
	}
	
	public int getDiastolic()
	{
		return diastolic;
	}

}
