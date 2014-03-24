package com.lumos.models;

public class SurveyRecord extends EventRecord {
	
	private int score;
	private String name;
	
	public SurveyRecord(String name, int score)
	{
		super();
		this.score = score;
		this.name = name;
	}
	
	public int getScore()
	{
		return score;
	}
	
	public String getName()
	{
		return name;
	}

}
