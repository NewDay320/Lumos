package com.lumos.models;

public class WeightRecord extends EventRecord{
	
	private double weight;
	private String unit;
	
	public WeightRecord(double weight, String unit)
	{
		super();
		this.weight = weight;
		this.unit = unit;
	}
	
	public double getWeight()
	{
		return weight;
	}
	
	public String getUnits()
	{
		return unit;
	}

}
