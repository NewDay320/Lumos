package com.lumos.models;

public class MedicationRecord extends EventRecord {
	
	private String name;
	
	private double amount;
	
	private double dosage;
	
	private String units;
	
	/**
	 * Creates a Medication Record Object that describes an event where the client took a medication.
	 * Name of the medication, how many doses of what dose size and unit are recorded, as well as 
	 * the time when the event was recorded.
	 * 
	 * @param name
	 * @param amount
	 * @param dosage
	 * @param dosageUnits
	 */
	public MedicationRecord(String name, double amount, double dosage, String dosageUnits)
	{
		super();
		this.name = name;
		this.amount = amount;
		this.dosage = dosage;
		this.units = dosageUnits;
	}
	
	public MedicationRecord(Medication m)
	{
		super();
		throw new UnsupportedOperationException("Constructor not yet implemented!");
	}

	/**
	 * Returns the name of the medication which corresponds to the name prescribed in the database.
	 * @return
	 */
	public String getName() {
		return name;
	}

	/**
	 * Returns the number of units taken
	 * @return
	 */
	public double getAmount() {
		return amount;
	}

	/**
	 * Returns the size of the unit taken
	 * @return
	 */
	public double getDosage() {
		return dosage;
	}

	
	/**
	 * Returns the unit that the dosage expresses (ex. mg for milligrams)
	 * @return
	 */
	public String getUnits() {
		return units;
	}
	
	

}
