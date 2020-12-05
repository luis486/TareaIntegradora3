package model;

import java.util.ArrayList;

public class ProfessionalTeam {

	private final int MAX_ASSISTANTCOACH = 3, MAX_PLAYERS = 25;
	private String name;
	private HeadCoach headCoach;
	private AssistantCoach[] assistants;
	private Player[] players;
	private ArrayList<Lineup> lineUp;

	/**
	 * constructor method <br>
	 * <b> pre: we need the atributes and relationships </b> 
	 * @param  name= name String
	 */
	public ProfessionalTeam(String name) {
		this.name = name;
		this.players = new Player[MAX_PLAYERS];
		this.assistants = new AssistantCoach[MAX_ASSISTANTCOACH];
		this.headCoach = null;
		this.lineUp = new ArrayList<Lineup>();
	}

	public void setHeadCoach(HeadCoach headCoach) {
		this.headCoach = headCoach;
	}

	/**
	 * get method <br>
	 * <b> pre: constructor method </b> 
	 * @return headCoach= HeadCoach information 
	 */
	public HeadCoach getHeadCoach() {
		return this.headCoach;
	}

	/**
	 * get method <br>
	 * <b> pre: constructor method </b> 
	 * @return players= Players information
	 */
	public Player[] getPlayers() {
		return this.players;
	}

	/**
	 * get method <br>
	 * <b> pre: constructor method </b> 
	 * @return name= ProfessionalTeam name
	 */
	public String getName() {
		return this.name;
	}
	
	
	/**
	 * set constructor <br>
	 * <b> pre: constructor method </b> 
	 * @param name= ProfessionalTeam name 
	 */
	public void setName(String name) {
		this.name = name;
	}


	/**
	 * get method <br>
	 * <b> pre: constructor method </b> 
	 * @return assistants= Assistants information 
	 */

	public AssistantCoach[] getAssistants() {
		return this.assistants;
	}

	/**
	 * set constructor <br>
	 * <b> pre: constructor method </b> 
	 * @param assistants and index
	 */
	public void setAssistants(AssistantCoach assistants, int index) {
		this.assistants[index] = assistants;
	}


	public int findPlayer(String name) {
		int index = 30;
		boolean found = false;
		for (int i = 0; i < MAX_PLAYERS && !found; i++) {
			if (this.players[i].getName().equalsIgnoreCase(name)) {
				index = i;
				found = true;
			}
		}
		return index;
	}

	/**
	 * takes all alignments from the team's arraylist and displays the matrix as simulation<br>
	 * <b> pre: there must be at leats one alignment created  </b> 
	 * @return a message with the ProfessionalTeam name and all the alignment of the ProfessionalTeam in matrix form
	 */
	public String showMatrizLineup() {
		String msg = "*******************Equipo: " + name + "++++++++++++++++++++" + "\n";
		for (int i = 0; i < this.lineUp.size(); i++) {
			msg += this.lineUp.get(i).showMatriz();
		}
		return msg;
	}

	/**
	 * adds a new ProfessionalTeam LineUp<br>
	 * <b> pre: two alignments can't be created for the same date   </b> 
	 * @param date, tactic, formation= date string, tactic String, formation String
	 * @return a message informing if the alignment is create or if there is one created for that date 
	 */
	public String lineUpToTeam(String date, String tactic, String formation) {
		String msg = "NO ha sido posible agregar la alineacion";
		boolean added=false;
		for (int i = 0; i < this.lineUp.size() && !added; i++) {
			if(this.lineUp.get(i).getDate().equalsIgnoreCase(date)) {
			added = true;
			}
		}
		if(added == false) {
			Lineup newLineUp = new Lineup(date, tactic);
			newLineUp.convertToMatriz(formation);
			this.lineUp.add(newLineUp);
			msg = "La alineacion se agrego correctamente"+"\n";
		}
		else {
			msg += "ya existe una alineacion en esa fecha"+"\n";
		}
		return msg;
	}

	/**
	 * displays team information on screen<br>
	 * <b> pre: we need all the Team information: name, headCoach, assistants, players and LineUp </b> 
	 * @return a message showing all the information of the Team 
	 */
	public String showTeamInfo() {
		String msg = "**************EQUIPO**************" + "\n" + "Nombre: " + this.name + "\n" + "DT: "
				+ this.headCoach.getName() + "\n" + "Asistentes: ";
		for (int i = 0; i < MAX_ASSISTANTCOACH; i++) {
			if (this.assistants[i] != null) {
				msg += this.assistants[i].getName() + ", ";
			}
		}
		for (int j = 0; j < MAX_PLAYERS; j++) {
			if (this.players[j] != null) {
				msg += "\n" + "Jugadores: " + this.players[j].showHalfInfo() + "\n";
			}
		}
		for (int k = 0; k < this.lineUp.size(); k++) {
			msg += "Alineaciones: " + this.lineUp.get(k).showLineUpInfo();
		}
		return msg;
	}
}