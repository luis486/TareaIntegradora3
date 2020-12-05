package model;

public class Player extends Employee implements PriceAndLevel {

	private int dorsal;
	private int goals;
	private double rating;
	private int cantRatings;
	private Position position;
	private double level;
	private double price;

	/**
	 * constructor method <br>
	 * <b> pre: we need the atributes </b> 
	 * @param  name, id, salary, dorsal, position= name String, id String, salary double, dorsal int, position String  
	 */
	public Player(String name, String id, double salary, int dorsal, String position) {
		super(name, id, salary);
		this.dorsal = dorsal;
		this.goals = 0;
		this.rating = 0;
		if (position.equalsIgnoreCase("Portero")) {
			this.position = Position.valueOf("GOALKEEPER");
		} else if (position.equalsIgnoreCase("Defensa")) {
			this.position = Position.valueOf("DEFENDER");
		} else if (position.equalsIgnoreCase("Mediocampista")) {
			this.position = Position.valueOf("MIDFIELDER");
		} else if (position.equalsIgnoreCase("Delantero")) {
			this.position = Position.valueOf("FORWARD");
		}
	}

	/**
	 * set constructor <br>
	 * <b> pre: constructor method </b> 
	 * @param rating= Player raiting 
	 */
	public void setRating(int rating) {
		this.cantRatings++;
		this.rating = (this.rating + rating) / cantRatings;
	}

	/**
	 * set constructor <br>
	 * <b> pre: constructor method </b> 
	 * @param goals= Player goals 
	 */
	public void setGoals(int goals) {
		this.goals += goals;
	}

	/**
	 * set constructor <br>
	 * <b> pre: constructor method </b> 
	 * @param dorsal= Player dorsal
	 */
	public void setDorsal(int dorsal) {
		this.dorsal = dorsal;
	}

	/**
	 * calculates the market price of the player <br>
	 * <b> pre: we need to know the Player type </b> 
	 * @return the market price of the player
	 */
	public double calculateMarket() {
		switch (position) {
			case GOALKEEPER:
				price = (getSalary() * 12) + (rating * 150);
				break;
			case DEFENDER:
				price = (getSalary() * 13) + (rating * 125) + (goals * 100);
				break;
			case MIDFIELDER:
				price = (getSalary() * 14) + (rating * 135) + (goals * 125);
				break;
			case FORWARD:
				price = (getSalary() * 15) + (rating * 145) + (goals * 150);
				break;
			default:
		}
		return price;
	}


	/**
	 * calculates the level of the player <br>
	 * <b> pre: we need to know the Player type </b> 
	 * @return the level of the player
	 */
	public double calculateLevel() {
		switch (position) {
			case GOALKEEPER:
				level = (rating * 0.9);
				break;
			case DEFENDER:
				level = (rating * 0.9) + (goals / 100);
				break;
			case MIDFIELDER:
				level = (rating * 0.9) + (goals / 90);
				break;
			case FORWARD:
				level = (rating * 0.9) + (goals / 80);
				break;
			default:
		}
		return level;

	}

	/**
	 * displays basic player information on screen<br>
	 * <b> pre: we need the basic player information: name, dorsal, position </b> 
	 * @return a message showing all the basic player information
	 */
	public String showHalfInfo() {
		String msg = "********JUGADOR************" + "\n" + "Nombre: " + super.getName() + "\n" + "Camiseta: "
				+ this.dorsal + "\n" + "Posicion: " + this.position.name() + "\n";
		return msg;
	}

	/**
	 * displays all the player information on screen<br>
	 * <b> pre: we need all the player information: name, id, salary, status, dorsal, goals, position, level and marketPrice </b> 
	 * @return a message showing all the player information
	 */
	@Override
	public String showInfo() {
		String msg = "********JUGADOR************" + "\n" + "Nombre: " + super.getName() + "\n" + "ID: " + super.getId()
				+ "\n" + "Salario: " + super.getSalary() + "\n" + "Estado: " + super.getStatus() + "\n" + "Camiseta: "
				+ this.dorsal + "\n" + "Goles: " + this.goals + "\n" + "Posicion: " + this.position.name() + "\n"
				+ "Nivel: " + calculateLevel() + "\n" + "Precio en el mercado: " + calculateMarket() + "\n";
		return msg;
	}

}