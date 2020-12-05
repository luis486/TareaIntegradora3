package model;

	public class HeadCoach extends Coach implements PriceAndLevel {
		private int numbersTeams;
		private int championships;
		private double level;
		private double price;

	/**
	 * constructor method <br>
	 * <b> pre: we need the atributes </b> 
	 * @param yearsExperience, name, id, salary, numbersTeams, championships= yearsExperience int, name String, id String, salary double, numbersTeams int, championships int
	 */
	public HeadCoach(int yearsExperience, String name, String id, double salary, int numbersTeams, int championships) {
		super(name, id, salary, yearsExperience);
		this.numbersTeams = numbersTeams;
		this.championships = championships;
		this.price = 0;
		this.level = 0;
	}

	/**
	 * set constructor <br>
	 * <b> pre: constructor method </b> 
	 */
	public void setNumbersTeams() {
		this.numbersTeams++;
	}

	/**
	 * set constructor <br>
	 * <b> pre: constructor method </b> 
	 * @param number= HeadCoach number
	 */

	public void setChampionships(int number) {
		this.championships += number;
	}

	/**
	 * calculates the market price of the HeadCoach<br>
	 * <b> pre: salary, yearsExperience, championships </b>
	 * @return the market price of the HeadCoach
	 */
	public double calculateMarket() {
		price = (getSalary() * 10) + (getYearsExperience() * 100) + (championships * 50);
		return price;
	}

	/**
	 * calculates the level of the HeadCoach based on the championship he has won<br>
	 * <b> pre: championships </b>
	 * @return HeadCoach level
	 */
	public double calculateLevel() {
		level = 5 + (championships / 10);
		return level;
	}


	/**
	 * displays HeadCoach information on screen<br>
	 * <b> pre: we need all the HeadCoach information: name, id, salary, status, numbersTeams, championship, level, marketPrice </b> 
	 * @return a message showing all the information of the HeadCoach
	 */
	@Override
	public String showInfo() {
		String msg = "***********ENTRENADOR PRINCIPAL************" + "\n" + "Nombre: " + super.getName() + "\n" + "ID: "
				+ super.getId() + "\n" + "Salario: " + super.getSalary() + "\n" + "Estado: " + super.getStatus() + "\n"
				+ "Equipos que ha tenido a su cargo: " + this.numbersTeams + "\n" + "Campeonatos ganados: "
				+ this.championships + "\n" + "Nivel: " + calculateLevel() + "\n" + "Precio en el mercado: "
				+ calculateMarket() + "\n";
		return msg;
	}
}
