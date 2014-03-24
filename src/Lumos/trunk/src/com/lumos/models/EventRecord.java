package com.lumos.models;

import java.util.Date;


/**
 * This class is the base class for all 'EventRecords' that are recorded to the SelfManagementDiary
 * 
 * An example subclass would be MedicationRecord, which is created every time the client confirms
 * that they have taken their medicine, or which can be created by the self-management diary when 
 * the application requests data from the database.
 * 
 * @author Daniel
 *
 */
public abstract class EventRecord {
	
	private Date time;
	
	/**
	 * Creates an EventRecord object and initializes the time field to the current system time.
	 */
	public EventRecord()
	{
		time = new Date();
	}
	
	/**
	 * Returns the time that the EventRecord was created.
	 * @return
	 */
	public Date getTime()
	{
		return time;
	}

}
