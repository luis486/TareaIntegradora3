package ui;

import java.util.*;
import model.*;

public class Menu {

	private static Scanner sc = new Scanner(System.in);
	private FootballClub club;
	private final static int CREATE_TEAM = 1;
	private final static int ADD_EMPLOYEE = 2;
	private final static int DISMISS_EMPLOYEE = 3;
	private final static int ADD_EMPLOYEE_TEAM = 4;
	private final static int UPDATE_TEAM_INFO = 5;
	private final static int UPDATE_EMPLOYEE_INFO = 6;
	private final static int ADD_COACH_OFFICE = 7;
	private final static int ADD_PLAYER_DR = 8;
	private final static int SHOW_CLUB_INFO = 9;
	private final static int SHOW_TEAM_INFO = 10;
	private final static int SHOW_INSTALATIONS_INFO = 11;
	private final static int SHOW_EMPLOYEE_INFO = 12;
	private final static int SHOW_EMPLOYEE_LOCATION = 13;
	private final static int SHOW_TEAM_LINEUPS = 14;
	private final static int EXIT = 15;

	/**
	 * constructor method <br>
	 * <b> pre: we need a relationship with the FootballClub class </b> 
	 */
	public Menu() {
		System.out.println("Ingrese el nombre del club");
		String name = sc.nextLine();
		System.out.println("Ingrese el NIT del club");
		String nit = sc.nextLine();
		System.out.println("Ingrese la fecha de fundacion del club");
		String foundationDate = sc.nextLine();
		this.club = new FootballClub(name, nit, foundationDate);
	}

	/** 
	* Main menu of the application<br>
	* <b> pre: The user cant choose an option that's not on the menu</b> 
	* <b> post: The user choose an option</b> 
	*/
	public void showMenu() {
		System.out.println("(1) Crear equipo");
		System.out.println("(2) Contratar un empleado");
		System.out.println("(3) Despedir un empleado");
		System.out.println("(4) Agregar un empleado a un equipo");
		System.out.println("(5) Actualizar informacion del equipo");
		System.out.println("(6) Actualizar informacion de un empleado");
		System.out.println("(7) Agregar entrenador a las oficinas");
		System.out.println("(8) Agregar jugador al vestuario");
		System.out.println("(9) Mostrar la informacion del club");
		System.out.println("(10) Mostrar la informacion de los equipos");
		System.out.println("(11) Mostrar la informacion de las instalaciones");
		System.out.println("(12) Mostrar la informacion de los empleados");
		System.out.println("(13) Ver la ubicacion de un empleado en las oficinas o en los vestuarios");
		System.out.println("(14) Ver las alineaciones de un/los equipo(s) en forma de matriz");
		System.out.println("(15) Salir ");
	}

	/**
	 * user enter the team they want to create and the team name <br>
	 * <b> pre: the user has to enter team A or team B    </b> 
	 * <b> post: Shows a message  con el type of team and the team name 
	 */
	public void readCreateTeam() {
		System.out.println("Ingrese A o B segun cual equipo desee crear");
		String team = sc.nextLine();
		System.out.println("Ingrese el nombre del equipo");
		String teamName = sc.nextLine();
		String msg = this.club.createTeam(teamName, team);
		System.out.println(msg);
	}

	/**
	 * user enters all the information of the employee that he chooses <br>
	 * <b> post: Shows a message with all the information of the employee that the user chooses
	 */
	public void readAddEmployee() {
		String msg;
		System.out.println("Ingrese el tipo de empleado que desea agregar");
		System.out.println("(1) Entrenador (2) Jugador (3) Asistente");
		int choice = sc.nextInt();
		sc.nextLine();
		System.out.println("Ingrese el nombre");
		String name = sc.nextLine();
		System.out.println("Ingrese el ID");
		String id = sc.nextLine();
		System.out.println("Ingrese el salario");
		double salary = sc.nextDouble();
		sc.nextLine();
		if (choice == 1) {
			System.out.println("Ingrese los años de experiencia del entrenador");
			int yearsExperience = sc.nextInt();
			sc.nextLine();
			System.out.println("Ingrese el numero de equipos que ha tenido a su cargo el entrenador");
			int numbersTeams = sc.nextInt();
			sc.nextLine();
			System.out.println("Ingrese el numero de campeonatos ganados hasta ahora");
			int championships = sc.nextInt();
			sc.nextLine();
			msg = this.club.addEmployee(yearsExperience, name, id, salary, numbersTeams, championships);
		} else if (choice == 2) {
			System.out.println("Ingrese el numero de camiseta del jugador");
			int dorsal = sc.nextInt();
			sc.nextLine();
			System.out.println("Calificacion del jugador");
			int rating = sc.nextInt();
			sc.nextLine();
			System.out.println("Ingrese la posicion del jugador (Portero,Defensa,Mediocampista,Delantero)");
			String position = sc.nextLine();
			msg = this.club.addEmployee(name, id, salary, dorsal, rating, position);
		} else if (choice == 3) {
			System.out.println("Ingrese los años de experiencia del Asistente");
			int yearsExperience1 = sc.nextInt();
			sc.nextLine();
			System.out.println("El asistente fue jugador profesional, ingrese 0(NO)/1(SI)");
			int exPlayer = sc.nextInt();
			sc.nextLine();
			System.out.println("Ingrese la experticia del asistente (Ofensivo, Defensivo, Posesion, Creativo)");
			String expertise = sc.nextLine();
			msg = this.club.addEmployee(yearsExperience1, name, id, salary, exPlayer, expertise);
		} else {
			msg = "Opcion invalida";
		}
		System.out.println(msg);

	}

	/**
	 * user enter the employee's name that he wants to dismiss <br>
	 * <b> pre: the user has to been created   </b> 
	 * <b> post: Shows a message with the employee's name that the user wants to dismiss
	 */
	public void readDismissEmployee() {
		System.out.println("Ingrese el nombre del empleado que desea despedir");
		String name = sc.nextLine();
		String msg = this.club.dismiss(name);
		System.out.println(msg);
	}

	/**
	 * user enter the type of employee that wants to add a Team A or Team B and the employee's name <br>
	 * <b> pre: the teams has to been created    </b> 
	 * <b> post: Shows a message with the name of the employee and the type of employee that was added to team A or team B 
	 */
	public void readEmployeeToTeam() {
		String msg = "";
		System.out.println("Ingrese el tipo de empleado que desea agregar al equipo");
		System.out.println("1 Entrenador 2 Jugador 3 Asistente");
		int choice = sc.nextInt();
		sc.nextLine();
		System.out.println("Ingrese el nombre del equipo del cual sera parte");
		String teamName = sc.nextLine();
		switch (choice) {
			case 1:
				System.out.println("Ingrese el nombre del jugador");
				String playerName = sc.nextLine();
				msg = this.club.playerToTeam(playerName, teamName);
				break;
			case 2:
				System.out.println("Ingrese el nombre del entrenador");
				String coachName = sc.nextLine();
				msg = this.club.headcoachToTeam(coachName, teamName);
				break;
			case 3:
				System.out.println("Ingrese el nombre del asistente");
				String assistantName = sc.nextLine();
				msg = this.club.assistantToTeam(assistantName, teamName);
				break;
			default:
		}
		System.out.println(msg);
	}

	/**
	 * user chooses what information updates team A or team B  <br>
	 * <b> pre: team A and team B has to been created    </b> 
	 * <b> post: Shows a message with the updates in team A or team B  
	 */
	public void readUpdateTeam() {
		String msg = "";
		String newName = "xyz";
		String date = "01/01/1900";
		String tactic = "Por defecto";
		String formation = "4-4-2";
		System.out.println("Ingrese el nombre del equipo");
		String teamName = sc.nextLine();
		System.out.println("Ingrese: " + "\n" + "(1) Actualizar el nombre del equipo" + "\n"
				+ " (2) Agregar una nueva alineacion al equipo");
		int choice = sc.nextInt();
		sc.nextLine();
		if (choice == 1) {
			System.out.println("Ingrese el nuevo nombre del equipo");
			newName = sc.nextLine();
			msg = this.club.updateTeamInfo(teamName, newName, date, tactic, formation, choice);
		} else if (choice == 2) {
			System.out.println("Ingrese la fecha de uso de la alineacion");
			date = sc.nextLine();
			System.out
					.println("Ingrese la tactica de la alineacion (Posesion, Contraataque, Presion alta, Por defecto)");
			tactic = sc.nextLine();
			System.out.println("Ingrese la formacion del equipo SIN ESPACIOS (ej:4-4-2, 4-1-2-1-2-1)");
			System.out.println(
					"Recuerde que debe tener 10 jugadores en la formacion, 3 lineas de jugadores como MINIMO y 6 como MAXIMO");
			formation = sc.nextLine();
			msg = this.club.updateTeamInfo(teamName, newName, date, tactic, formation, choice);
		} else {
			msg = this.club.updateTeamInfo(teamName, newName, date, tactic, formation, choice);
		}
		System.out.println(msg);
	}

	/**
	 * user chooses what information updates in some type of employees  <br>
	 * <b> pre: employees has to been created     </b> 
	 * <b> post: Shows a message with the updates in some type of employees
	 */
	public void readUpdateEmployeeInfo() {
		String msg="";
		System.out.println("Ingrese el tipo de empleado al que desea actualizar la informacion");
		System.out.println("(1) Entrenador (2) Jugador (3) Asistente");
		int choice = sc.nextInt();
		sc.nextLine();
		if (choice == 1) {
			readUpdateCoachInfo();
		} else if (choice == 2) {
			readUpdatePlayerInfo();
		} else if (choice == 3) {
			readUpdateAssistantInfo();
		} else {
			msg = "Opcion invalida";
		}
		System.out.println(msg);
	}

	/**
	 * user update the player information and choose what update  <br>
	 * <b> pre: player has to been created  </b> 
	 * <b> post: Shows a message with the updates of the player 
	 */
	private void readUpdatePlayerInfo() {
		String msg = "";
		int dorsal = 0;
		System.out.println("Ingrese nombre del jugador");
		String name = sc.nextLine();
		double salary = 0.0;
		int goals = 0;
		int rating = 0;
		String status = "Activo";
		System.out.println("Ingrese que atributo desea actualizar");
		System.out.println("(1) Salario (2) Estado (3) Dorsal (4) Goles (5) Calificacion");
		int attribute = sc.nextInt();
		sc.nextLine();
		switch (attribute) {
			case 1:
				System.out.println("Ingrese nuevo salario");
				salary = sc.nextDouble();
				sc.nextLine();
				msg = this.club.updateEmployeesInfo(name, salary, status, dorsal, goals, rating, attribute);
				break;
			case 2:
				System.out.println("Ingrese nuevo estado(Activo o Inactivo)");
				status = sc.nextLine();
				msg = this.club.updateEmployeesInfo(name, salary, status, dorsal, goals, rating, attribute);
				break;
			case 3:
				System.out.println("Ingrese el nuevo numero de camiseta del jugador");
				dorsal = sc.nextInt();
				sc.nextLine();
				msg = this.club.updateEmployeesInfo(name, salary, status, dorsal, goals, rating, attribute);
			case 4:
				System.out.println("Ingrese la cantidad de nuevos goles que ha marcado");
				goals = sc.nextInt();
				sc.nextLine();
				msg = this.club.updateEmployeesInfo(name, salary, status, dorsal, goals, rating, attribute);
				break;
			case 5:
				System.out.println("Ingrese la calificacion");
				rating = sc.nextInt();
				sc.nextLine();
				msg = this.club.updateEmployeesInfo(name, salary, status, dorsal, goals, rating, attribute);
				break;
		}
		System.out.println(msg);
	}
	
	
	/**
	 * user update the HeadCoach information and choose what update  <br>
	 * <b> pre: HeadCoach has to been created  </b> 
	 * <b> post: Shows a message with the updates of the HeadCoach
	 */
	private void readUpdateCoachInfo() {
		String msg = "";
		int yearsExperience = 0;
		double salary = 0.0;
		int championships = 0;
		String status = "Activo";
		System.out.println("Ingrese nombre del Entrenador");
		String name = sc.nextLine();
		System.out.println("Ingrese que atributo desea actualizar");
		System.out.println("(1) Salario (2) Estado (3) Experiencia (4) Campeonatos ganados");
		int attribute = sc.nextInt();
		sc.nextLine();
		switch (attribute) {
			case 1:
				System.out.println("Ingrese nuevo salario");
				salary = sc.nextDouble();
				sc.nextLine();
				msg = this.club.updateEmployeesInfo(yearsExperience, name, salary, championships, status, attribute);
				break;
			case 2:
				System.out.println("Ingrese nuevo estado(Activo o Inactivo)");
				status = sc.nextLine();
				msg = this.club.updateEmployeesInfo(yearsExperience, name, salary, championships, status, attribute);
				break;
			case 3:
				System.out.println("Ingrese la cantidad de años de experiencia a agregar");
				yearsExperience = sc.nextInt();
				sc.nextLine();
				msg = this.club.updateEmployeesInfo(yearsExperience, name, salary, championships, status, attribute);
				break;
			case 4:
				System.out.println("Ingrese la cantidad de nuevos campeonatos que ha ganado");
				championships = sc.nextInt();
				sc.nextLine();
				msg = this.club.updateEmployeesInfo(yearsExperience, name, salary, championships, status, attribute);
				break;
		}
		System.out.println(msg);
	}

	/**
	 * user update the AssitantCoach information and choose what update  <br>
	 * <b> pre: AssistantCoach has to been created  </b> 
	 * <b> post: Shows a message with the updates of the AssistantCoach
	 */
	private void readUpdateAssistantInfo() {
		String msg = "";
		int yearsExperience = 0;
		double salary = 0.0;
		String status = "Activo";
		System.out.println("Ingrese nombre del Asistente");
		String name = sc.nextLine();
		System.out.println("Ingrese que atributo desea actualizar");
		System.out.println("(1) Salario (2) Estado (3) Experiencia");
		int attribute = sc.nextInt();
		sc.nextLine();
		switch (attribute) {
			case 1:
				System.out.println("Ingrese nuevo salario");
				salary = sc.nextDouble();
				sc.nextLine();
				msg = this.club.updateEmployeesInfo(yearsExperience, attribute, name, salary, status);
				break;
			case 2:
				System.out.println("Ingrese nuevo estado(Activo o Inactivo)");
				status = sc.nextLine();
				msg = this.club.updateEmployeesInfo(yearsExperience, attribute, name, salary, status);
				break;
			case 3:
				System.out.println("Ingrese la cantidad de años de experiencia a agregar");
				yearsExperience = sc.nextInt();
				sc.nextLine();
				msg = this.club.updateEmployeesInfo(yearsExperience, attribute, name, salary, status);
				break;
		}
		System.out.println(msg);
	}

	/**
	 * user sends a coach to an office  <br>
	 * <b> pre: HeadCoach has to been created  </b> 
	 * <b> post: Shows a message with the location(office) of the HeadCoach
	 */
	public void readCoachToOffice() {
		System.out.println("Ingrese el nombre del entrenador");
		String coachName = sc.nextLine();
		String msg = this.club.coachToOffice(coachName);
		System.out.println(msg);
	}

	/**
	 * user sends a player to a dressing room depending if the player is in team A or team B  <br>
	 * <b> pre: Player has to been created  </b> 
	 * <b> post: Shows a message with the location(dressing room) of the Player
	 */
	public void readPlayerToDressingRoom() {
		System.out.println("Ingrese el nombre del jugador");
		String playerName = sc.nextLine();
		System.out.println("Ingrese el nombre del equipo al que pertenece el jugador");
		String teamName = sc.nextLine();
		String msg = this.club.playerToDressingRoom(teamName, playerName);
		System.out.println(msg);
	}

	/**
	 * the user enters the name of the employee who wants to find in the offices or in the dressing rooms  <br>
	 * <b> pre: employees, offices and dressing rooms has to been created  </b> 
	 * <b> post: Shows a message with the employee in the office or in the dressing rooms
	 */
	public void readEmployeeLocation() {
		System.out.println("Ingrese el nombre del empleado a buscar");
		String name = sc.nextLine();
		String msg = this.club.employeeLocation(name);
		System.out.println(msg);
	}

	/**
	 *  the user enters if he wants to see the lineUp of a team or of both teams<br>
	 * <b> pre: the LineUp of the Team A and Team B has to be already created  </b> 
	 * <b> post: Shows a message  with the team A or team B LineUps
	 */
	public void readShowTeamMatriz() {
		String msg = "";
		String teamName = "";
		System.out.println("Desea a ver las alineaciones de ");
		System.out.println("(1) Un unico equipo (2) Todos los equipos");
		int choice = sc.nextInt();
		sc.nextLine();
		if (choice == 1) {
			System.out.println("Ingrese el nombre del equipo");
			teamName = sc.nextLine();
			msg = this.club.showTeamMatriz(teamName, choice);
			;
		} else if (choice == 2) {
			msg = this.club.showTeamMatriz(teamName, choice);
		} else {
			msg = "Opcion invalida";
		}
		System.out.println(msg);
	}

	/** 
	*  Run the whole application<br>
	* <b> pre: The option has to be an integer</b> 
	* <b> post: Run the program</b> 
	*/
	public void startProgram() {
		int option;
		do {
			showMenu();
			option = readOption();
			doOperation(option);
		} while (option != EXIT);
	}

	/** 
	*  Read and save an option that the user chose<br>
	* <b> pre: The option has to be representated by an integer</b> 
	* <b> post: Return the integer choice</b> 
	*/
	public int readOption() {
		int choice = sc.nextInt();
		sc.nextLine();
		return choice;
	}

	/** 
	*  Call the method that run the option chose by the user<br>
	* <b> pre: The choice has to be an integer</b> 
	* <b> post: </b> 
	*/
	public void doOperation(int choice) {
		switch (choice) {
			case CREATE_TEAM:
				readCreateTeam();
				break;
			case ADD_EMPLOYEE:
				readAddEmployee();
				break;
			case DISMISS_EMPLOYEE:
				readDismissEmployee();
				break;
			case ADD_EMPLOYEE_TEAM:
				readEmployeeToTeam();
				break;
			case UPDATE_TEAM_INFO:
				readUpdateTeam();
				break;
			case UPDATE_EMPLOYEE_INFO:
				readUpdateEmployeeInfo();
				break;
			case ADD_COACH_OFFICE:
				readCoachToOffice();
				break;
			case ADD_PLAYER_DR:
				readPlayerToDressingRoom();
				break;
			case SHOW_CLUB_INFO:
				System.out.println(this.club.showClubInfo());
				break;
			case SHOW_TEAM_INFO:
				System.out.println(this.club.showTeamsInfo());
				break;
			case SHOW_INSTALATIONS_INFO:
				System.out.println(this.club.showInstallationsInfo());
				break;
			case SHOW_EMPLOYEE_INFO:
				System.out.println(this.club.showEmployeesInfo());
				break;
			case SHOW_EMPLOYEE_LOCATION:
				readEmployeeLocation();
				break;
			case SHOW_TEAM_LINEUPS:
				readShowTeamMatriz();
				break;
			case EXIT:
				break;
			default:
				System.out.println("Opcion invalida, repita nuevamente");
		}
	}
}
