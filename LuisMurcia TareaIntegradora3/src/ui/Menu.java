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

	public Menu() {
		System.out.println("Ingrese el nombre del club");
		String name = sc.nextLine();
		System.out.println("Ingrese el NIT del club");
		String nit = sc.nextLine();
		System.out.println("Ingrese la fecha de fundacion del club");
		String foundationDate = sc.nextLine();
		this.club = new FootballClub(name, nit, foundationDate);
	}

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

	public String readCreateTeam() {
		System.out.println("Ingrese A o B segun cual equipo desee crear");
		String team = sc.nextLine();
		System.out.println("Ingrese el nombre del equipo");
		String teamName = sc.nextLine();
		String msg = this.club.createTeam(teamName, team);
		return msg;
	}

	public String readAddEmployee() {
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
		return msg;

	}

	public String readDismissEmployee() {
		System.out.println("Ingrese el nombre del empleado que desea despedir");
		String name = sc.nextLine();
		String msg = this.club.dismiss(name);
		return msg;
	}

	public String readEmployeeToTeam() {
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
		return msg;
	}

	public String readUpdateTeam() {
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
		return msg;
	}

	public String readUpdateEmployeeInfo() {
		String msg;
		System.out.println("Ingrese el tipo de empleado al que desea actualizar la informacion");
		System.out.println("(1) Entrenador (2) Jugador (3) Asistente");
		int choice = sc.nextInt();
		sc.nextLine();
		if (choice == 1) {
			msg = readUpdateCoachInfo();
		} else if (choice == 2) {
			msg = readUpdatePlayerInfo();
		} else if (choice == 3) {
			msg = readUpdateAssistantInfo();
		} else {
			msg = "Opcion invalida";
		}
		return msg;
	}

	private String readUpdatePlayerInfo() {
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
		return msg;
	}

	private String readUpdateCoachInfo() {
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
		return msg;
	}

	private String readUpdateAssistantInfo() {
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
		return msg;
	}

	public String readCoachToOffice() {
		System.out.println("Ingrese el nombre del entrenador");
		String coachName = sc.nextLine();
		String msg = this.club.coachToOffice(coachName);
		return msg;
	}

	public String readPlayerToDressingRoom() {
		System.out.println("Ingrese el nombre del jugador");
		String playerName = sc.nextLine();
		System.out.println("Ingrese el nombre del equipo al que pertenece el jugador");
		String teamName = sc.nextLine();
		String msg = this.club.playerToDressingRoom(teamName, playerName);
		return msg;
	}

	public String readEmployeeLocation() {
		System.out.println("Ingrese el nombre del empleado a buscar");
		String name = sc.nextLine();
		String msg = this.club.employeeLocation(name);
		return msg;
	}

	public String readShowTeamMatriz() {
		String msg = "";
		String teamName = "";
		System.out.println("Dese a ver las alineaciones de ");
		System.out.println("(1) Todos los equipos (2) Un unico equipo");
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
		return msg;
	}

	public void startProgram() {
		int option;
		do {
			showMenu();
			option = readOption();
			doOperation(option);
		} while (option != EXIT);
	}

	public int readOption() {
		int choice = sc.nextInt();
		sc.nextLine();
		return choice;
	}

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
