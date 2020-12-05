package model;

public class AssistantCoach extends Coach {

	private boolean exPlayer;
	private Expertise expertise;

	/**
	 * constructor method <br>
	 * <b> pre: we need the atributes </b> 
	 * @param yearsExperience, name, id, salary, exPlayer, expertise= yearsExperience int, name String, id String, salary double, exPlayer int, expertise String
	 */
	public AssistantCoach(int yearsExperience, String name, String id, double salary, int exPlayer, String expertise) {
		super(name, id, salary, yearsExperience);

		if (exPlayer == 0) {
			this.exPlayer = false;
		} else {
			this.exPlayer = true;
		}
		if (expertise.equalsIgnoreCase("Ofensivo")) {
			this.expertise = Expertise.valueOf("OFFENSIVE");

		} else if (expertise.equalsIgnoreCase("Defensivo")) {
			this.expertise = Expertise.valueOf("DEFENSIVE");

		} else if (expertise.equalsIgnoreCase("Posesion")) {
			this.expertise = Expertise.valueOf("POSSESSION");

		} else if (expertise.equalsIgnoreCase("Creativo")) {
			this.expertise = Expertise.valueOf("LAB_PLAY");
		}
	}

	/**
	 * displays AssistantCoach information on screen<br>
	 * <b> pre: we need all the AssistantCoach information: name, id, salary, status, expertise </b> 
	 * @return a message showing all the information of the AssistantCoach
	 */

	@Override
	public String showInfo() {
		String msg = "***********ASISTENTE************" + "\n" + "Nombre: " + super.getName() + "\n" + "ID: "
				+ super.getId() + "\n" + "Salario: " + super.getSalary() + "\n" + "Estado: " + super.getStatus() + "\n"
				+ "Experticia: " + this.expertise.name() + "\n";
		if (this.exPlayer == true) {
			msg += "El asistente fue jugador profesional";
		} else {
			msg += "El asistente no fue jugador profesional";
		}
		return msg;
	}
}