package model;

public abstract class Coach extends Employee {

	private int yearsExperience;
	
	
	/**
	 * constructor method <br>
	 * <b> pre: we need the atributes </b> 
	 * @param name, id, salary, yearsExperience= name String, id String, double salary, int yearsExperience
	 */
	public Coach(String name, String id, double salary, int yearsExperience) {
		super(name, id, salary);
		this.yearsExperience = yearsExperience;
	}

	public int getYearsExperience() {
		return this.yearsExperience;
	}

	public void setExperienceYears(int years) {
		this.yearsExperience += years;
	}

	@Override
	public abstract String showInfo();

}