package com.lumos.models;

public class ActivityRecord extends EventRecord {
	
	private int steps;
	private double distance;
	private String distanceUnits;
	private double calories;
	
	public ActivityRecord(int steps)
	{
		super();
		this.steps = steps;
	}
	
	public ActivityRecord(double distance, String distanceUnits)
	{
		super();
		this.distance = distance;
		this.distanceUnits = distanceUnits;
	}
	
	public ActivityRecord(double calories)
	{
		super();
		this.calories = calories;
	}
	
	public int getSteps()
	{
		return steps;
	}
	
	public double getDistance()
	{
		return distance;
	}
	
	public String getDistanceUnits()
	{
		return distanceUnits;
	}
	
	public double getCalories()
	{
		return calories;
	}

}
