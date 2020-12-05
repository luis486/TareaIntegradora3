package model;

import java.util.ArrayList;

public class FootballClub {

	// Attribute
	private final static int ORDER_OFFICE = 6;
	private final static int DR_ROWA = 7, DR_COLUMNSA = 6;
	private final static int ORDER_DRB = 7;
	private String name;
	private String nit;
	private String foundationDate;
	private ArrayList<Employee> employee;
	private ProfessionalTeam teamA;
	private ProfessionalTeam teamB;
	private Coach[][] office;
	private Player[][] dressingRoomA;
	private Player[][] dressingRoomB;

	public FootballClub(String name, String nit, String foundationDate) {
		this.name = name;
		this.nit = nit;
		this.foundationDate = foundationDate;
		this.employee = new ArrayList<Employee>();
		this.office = new Coach[ORDER_OFFICE][ORDER_OFFICE];
		this.dressingRoomA = new Player[DR_ROWA][DR_COLUMNSA];
		this.dressingRoomB = new Player[ORDER_DRB][ORDER_DRB];
		this.teamA = null;
		this.teamB = null;
	}

	public String getName() {
		return name;
	}

	public String getNit() {
		return nit;
	}

	public String getFoundationDate() {
		return foundationDate;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setNit(String nit) {
		this.nit = nit;
	}

	public void setFoundationDate(String foundationDate) {
		this.foundationDate = foundationDate;
	}

	public String showInstallationsInfo() {
		String msg = "";
		int dra = 0;
		int drb = 0;
		int office = 0;
		for (int i = 0; i < ORDER_OFFICE; i++) {
			for (int j = 0; j < ORDER_OFFICE; j++) {
				if (this.office[i][j] != null) {
					office++;
				}
			}
		}
		for (int k = 0; k < DR_ROWA; k++) {
			for (int l = 0; l < DR_COLUMNSA; l++) {
				if (this.dressingRoomA[k][l] != null) {
					dra++;
				}
			}
		}
		for (int m = 0; m < ORDER_DRB; m++) {
			for (int n = 0; n < ORDER_DRB; n++) {
				if (this.dressingRoomB[m][n] != null) {
					drb++;
				}
			}
		}
		msg += "***************INSTALACIONES****************" + "/n" + "Hay " + dra + " jugadores del equipo "
				+ this.teamA.getName() + " en el camerino A" + "/n" + "Hay " + drb + " jugadores del equipo "
				+ this.teamB.getName() + " en el camerino B" + "/n" + "Hay " + office + " entrenadores en las oficinas"
				+ "/n";
		return msg;
	}

	public Employee findEmployee(String name) {
		Employee objSearch = null;
		boolean findPl = false;
		for (int i = 0; i < employee.size() && !findPl; i++) {
			if (employee.get(i).getName().equalsIgnoreCase(name)) {
				objSearch = employee.get(i);
				findPl = true;
			}
		}
		return objSearch;

	}

	public String employeeLocation(String name) {
		Employee objSearch = findEmployee(name);
		String msg = "";
		boolean found = false;
		if (objSearch != null) {
			for (int i = 0; i < ORDER_OFFICE && !found; i++) {
				for (int j = 0; j < ORDER_OFFICE && !found; j++) {
					if (this.office[i][j] != null) {
						if (this.office[i][j].getName().equalsIgnoreCase(name)) {
							msg = "El entrenador " + this.office[i][j].getName() + " se encuentra en la oficina " + i
									+ ", " + j;
						}
					}
				}
			}
			for (int k = 0; k < DR_ROWA; k++) {
				for (int l = 0; l < DR_COLUMNSA; l++) {
					if (this.dressingRoomA[k][l] != null) {
						if (this.dressingRoomA[k][l].getName().equalsIgnoreCase(name)) {
							msg = "El jugador " + this.dressingRoomA[k][l].getName()
									+ " se encuentra en el vestuario del equipo " + this.teamA.getName()
									+ " en la ubicacion" + k + ", " + l;
						}
					}
				}
			}
			for (int m = 0; m < ORDER_DRB; m++) {
				for (int n = 0; n < ORDER_DRB; n++) {
					if (this.dressingRoomB[m][n] != null) {
						if (this.dressingRoomB[m][n].getName().equalsIgnoreCase(name)) {
							msg = "El jugador " + this.dressingRoomB[m][n].getName()
									+ " se encuentra en el vestuario del equipo " + this.teamB.getName()
									+ " en la ubicacion" + m + ", " + n;
						}
					}
				}
			}
		} else {
			msg = "El empleado no se encuentra en las oficinas o en los camerinos";
		}
		return msg;
	}

	// ________________________principal
	// coach_____________________________________________________________
	public String addEmployee(int yearsExperience, String name, String id, double salary, int numbersTeams,
			int championships) {
		String message = "";
		boolean addPl = false;

		Employee objSearch = findEmployee(name);
		if (objSearch != null) {
			message = "Error. the employee already exist";
		} else {
			HeadCoach headcoach = new HeadCoach(yearsExperience, name, id, salary, numbersTeams, championships);
			employee.add(headcoach);
			addPl = true;
			message = "El empleado ha sido registrado";
		}
		if (addPl == false) {
			message = "All employee are already created";
		}
		return message;
	}

	public String updateEmployeesInfo(int yearsExperience, String name, double salary, int championships, String status,
			int attribute) {
		String msg = "Se ha actualizado la informacion del entrenador principal exitosamente" + "\n";
		boolean found = false;
		for (int i = 0; i < employee.size() && !found; i++) {
			if (employee.get(i) instanceof HeadCoach && employee.get(i).getName().equalsIgnoreCase(name)) {
				found = true;
				HeadCoach thisHeadCoach = (HeadCoach) employee.get(i);
				switch (attribute) {
					case 1:
						thisHeadCoach.setSalary(salary);
						break;
					case 2:
						thisHeadCoach.setStatus(status);
						break;
					case 3:
						thisHeadCoach.setExperienceYears(yearsExperience);
						break;
					case 4:
						thisHeadCoach.setChampionships(championships);
						break;
					default:
						msg = "Opcion invalida" + "\n";
						break;
				}
				if (teamA.getHeadCoach().getName().equalsIgnoreCase(name)) {
					teamA.setHeadCoach(thisHeadCoach);
				} else if (teamB.getHeadCoach().getName().equalsIgnoreCase(name)) {
					teamB.setHeadCoach(thisHeadCoach);
				}
				employee.add(i, thisHeadCoach);
			}
		}
		if (found == false) {
			msg = "El empleado con ID " + name + " no es un entrenador principal o no esta registrado en el Club"
					+ "\n";
		}
		return msg;
	}

	// ________________________Asistent
	// coach_____________________________________________________________
	public String addEmployee(int yearsExperience, String name, String id, double salary, int exPlayer,
			String expertise) {
		String message = "";
		boolean addPl = false;

		Employee objSearch = findEmployee(name);
		if (objSearch != null) {
			message = "Error. the employee already exist";
		} else {
			AssistantCoach assistant = new AssistantCoach(yearsExperience, name, id, salary, exPlayer, expertise);
			employee.add(assistant);
			addPl = true;
			message = "The employee has been registered";
		}
		if (addPl == false) {
			message = "All employee are already created";
		}

		return message;
	}

	public String updateEmployeesInfo(int yearsExperience, int attribute, String name, double salary, String status) {
		String msg = "Se ha actualizado la informacion del entrenador asistente exitosamente" + "\n";
		boolean found = false;
		for (int i = 0; i < employee.size() && !found; i++) {
			if (employee.get(i) instanceof AssistantCoach && employee.get(i).getName().equalsIgnoreCase(name)) {
				found = true;
				AssistantCoach thisAssistantCoach = (AssistantCoach) employee.get(i);
				switch (attribute) {
					case 1:
						thisAssistantCoach.setSalary(salary);
						break;
					case 2:
						thisAssistantCoach.setStatus(status);
						break;
					case 3:
						thisAssistantCoach.setExperienceYears(yearsExperience);
						break;
					default:
						msg = "Opcion invalida" + "\n";
						break;
				}
				boolean found2 = false;
				for (int j = 0; j < 3 && !found2; j++) {
					if (teamA.getAssistants()[j].getName().equalsIgnoreCase(name)) {
						teamA.setAssistants(thisAssistantCoach, j);
					} else if (teamB.getAssistants()[j].getName().equalsIgnoreCase(name)) {
						teamB.setAssistants(thisAssistantCoach, j);
					}
				}
				employee.add(i, thisAssistantCoach);
			}
		}
		if (found == false) {
			msg = "El empleado " + name + " no es un entrenador asistente o no esta registrado en el Club" + "\n";
		}
		return msg;
	}

	// ________________________soccer
	// player_____________________________________________________________
	public String addEmployee(String name, String id, double salary, int dorsal, int rating, String position) {
		String message = "";
		boolean addPl = false;
		Employee objSearch = findEmployee(name);
		if (objSearch != null) {
			message = "Error. the employee already exist";
		} else {
			Player player = new Player(name, id, salary, dorsal, position);
			player.setRating(rating);
			employee.add(player);
			addPl = true;
			message = "The employee has been registered";
		}
		if (addPl == false) {
			message = "All employee are already created";
		}

		return message;
	}

	public String updateEmployeesInfo(String name, double salary, String status, int dorsal, int goals, int rating,
			int attribute) {
		String msg = "Se ha actualizado la informacion del jugador exitosamente" + "\n";
		boolean found = false;
		for (int i = 0; i < this.employee.size() && !found; i++) {
			if (employee.get(i) instanceof Player && employee.get(i).getName().equalsIgnoreCase(name)) {
				found = true;
				Player thisPlayer = (Player) employee.get(i);
				switch (attribute) {
					case 1:
						thisPlayer.setSalary(salary);
						break;
					case 2:
						thisPlayer.setStatus(status);
						break;
					case 3:
						thisPlayer.setDorsal(dorsal);
						break;
					case 4:
						thisPlayer.setGoals(goals);
						break;
					case 5:
						thisPlayer.setRating(rating);
						break;
					default:
						msg = "Opcion invalida" + "\n";
						break;
				}
				if (teamA.findPlayer(name) != 30) {
					int index = teamA.findPlayer(name);
					teamA.getPlayers()[index] = thisPlayer;
				} else if (teamB.findPlayer(name) != 30) {
					int index = teamB.findPlayer(name);
					teamB.getPlayers()[index] = thisPlayer;
				}
				employee.add(i, thisPlayer);
			}
		}
		if (found == false) {
			msg = "El empleado " + name + " no es un jugador o no esta registrado en el Club" + "\n";
		}
		return msg;
	}

	public int[] findInMatriz(String name) {
		int[] location = new int[3];
		Employee newEmployee = findEmployee(name);
		if (newEmployee != null) {
			for (int i = 0; i < ORDER_OFFICE; i++) {
				for (int j = 0; j < ORDER_OFFICE; j++) {
					if (this.office[i][j].getName().equalsIgnoreCase(name)) {
						location[0] = 1;
						location[1] = i;
						location[2] = j;
					}
				}
			}
			for (int k = 0; k < DR_ROWA; k++) {
				for (int l = 0; l < DR_COLUMNSA; l++) {
					if (this.dressingRoomA[k][l].getName().equalsIgnoreCase(name)) {
						location[0] = 2;
						location[1] = k;
						location[2] = l;
					}
				}
			}
			for (int m = 0; m < ORDER_DRB; m++) {
				for (int n = 0; n < ORDER_DRB; n++) {
					if (this.dressingRoomB[m][n].getName().equalsIgnoreCase(name)) {
						location[0] = 3;
						location[1] = m;
						location[2] = n;
					}
				}
			}
		}
		return location;
	}

	public String dismiss(String name) {
		String message = "";
		Employee objSearch = findEmployee(name);
		if (objSearch == null) {
			message = "El empleado no existe";
		} else {
			this.employee.remove(objSearch);
			message = "Empleado fue despedido con exito";
			for (int i = 0; i < this.teamA.getPlayers().length; i++) {
				if (this.teamA.getPlayers()[i].getName().equalsIgnoreCase(name)) {
					this.teamA.getPlayers()[i] = null;
					message += " y eliminado del equipo al que pertenecia";
				} else if (this.teamB.getPlayers()[i].getName().equalsIgnoreCase(name)) {
					this.teamB.getPlayers()[i] = null;
					message += " y eliminado del equipo al que pertenecia";
				}
			}
			for (int j = 0; j < this.teamA.getAssistants().length; j++) {
				if (this.teamA.getAssistants()[j].getName().equalsIgnoreCase(name)) {
					this.teamA.getAssistants()[j] = null;
					message += " y eliminado del equipo al que pertenecia";
				} else if (this.teamB.getAssistants()[j].getName().equalsIgnoreCase(name)) {
					this.teamB.getAssistants()[j] = null;
					message += " y eliminado del equipo al que pertenecia";
				}
			}
			if (this.teamA.getHeadCoach().getName().equalsIgnoreCase(name)) {
				HeadCoach headCoach = null;
				this.teamA.setHeadCoach(headCoach);
				message += " y eliminado del equipo al que pertenecia";
			} else if (this.teamB.getHeadCoach().getName().equalsIgnoreCase(name)) {
				HeadCoach headCoach = null;
				this.teamB.setHeadCoach(headCoach);
				message += " y eliminado del equipo al que pertenecia";
			}
			if (findInMatriz(name)[0] == 0) {
				message += "/n" + "El empleado no estaba registrado en alguna oficina o camerino";
			}
			if (findInMatriz(name)[0] == 1) {
				int a = findInMatriz(name)[1];
				int b = findInMatriz(name)[2];
				this.office[a][b] = null;
				message += "/n" + "Empleado eliminado de la oficina";
			}
			if (findInMatriz(name)[0] == 2) {
				int c = findInMatriz(name)[1];
				int d = findInMatriz(name)[2];
				this.dressingRoomA[c][d] = null;
				message += "/n" + "Empleado eliminado del camerino del equipo " + this.teamA.getName();
			}
			if (findInMatriz(name)[0] == 3) {
				int e = findInMatriz(name)[1];
				int f = findInMatriz(name)[2];
				this.dressingRoomB[e][f] = null;
				message += "/n" + "Empleado eliminado del camerino del equipo " + this.teamB.getName();
			}
		}
		return message;
	}

	public String playerToTeam(String playerName, String teamName) {
		String msg = "";
		boolean added = false;
		if (this.teamA.getName().equalsIgnoreCase(teamName)) {
			for (int i = 0; i < this.teamA.getPlayers().length && !added; i++) {
				if (this.teamA.getPlayers()[i] != null
						&& this.teamA.getPlayers()[i].getName().equalsIgnoreCase(playerName)) {
					msg = "El jugador ya existe en el equipo";
				} else if (this.teamA.getPlayers()[i] != null) {
					if (findEmployee(playerName).getName().equalsIgnoreCase(playerName)) {
						this.teamA.getPlayers()[i] = (Player) findEmployee(playerName);
						msg = "Jugador agregado exitosamente";
						added = true;
					} else {
						msg = "El jugador no existe";
					}
				} else {
					msg = "El equipo se encuentra lleno";
				}
			}
		} else if (this.teamB.getName().equalsIgnoreCase(teamName)) {
			for (int k = 0; k < this.teamB.getPlayers().length && !added; k++) {
				if (this.teamB.getPlayers()[k] != null
						&& this.teamB.getPlayers()[k].getName().equalsIgnoreCase(playerName)) {
					msg = "El jugador ya existe en el equipo";
				} else if (this.teamB.getPlayers()[k] != null) {
					if (findEmployee(playerName).getName().equalsIgnoreCase(playerName)) {
						this.teamB.getPlayers()[k] = (Player) findEmployee(playerName);
						msg = "Jugador agregado exitosamente";
					} else {
						msg = "El jugador no existe";
					}
				} else {
					msg = "El equipo se encuentra lleno";
				}
			}
		} else {
			msg = "El equipo no existe";
		}
		return msg;
	}

	public String assistantToTeam(String assistantName, String teamName) {
		String msg = "";
		boolean added = false;
		if (this.teamA.getName().equalsIgnoreCase(teamName)) {
			for (int i = 0; i < this.teamA.getAssistants().length && !added; i++) {
				if (this.teamA.getAssistants()[i] != null
						&& this.teamA.getAssistants()[i].getName().equalsIgnoreCase(assistantName)) {
					msg = "El Asistente ya existe en el equipo";
					added = true;
				} else if (this.teamA.getAssistants()[i] != null) {
					if (findEmployee(assistantName).getName().equalsIgnoreCase(assistantName)) {
						this.teamA.getAssistants()[i] = (AssistantCoach) findEmployee(assistantName);
						msg = "Asistente agregado exitosamente";
					} else {
						msg = "El asistente no existe";
					}
				} else {
					msg = "El equipo llego al limite de asistentes";
				}
			}
		} else if (this.teamB.getName().equalsIgnoreCase(teamName)) {
			for (int k = 0; k < this.teamB.getAssistants().length && !added; k++) {
				if (this.teamB.getAssistants()[k] != null
						&& this.teamB.getAssistants()[k].getName().equalsIgnoreCase(assistantName)) {
					msg = "El Asistente ya existe en el equipo";
				} else if (this.teamB.getAssistants()[k] != null) {
					if (findEmployee(assistantName).getName().equalsIgnoreCase(assistantName)) {
						this.teamB.getAssistants()[k] = (AssistantCoach) findEmployee(assistantName);
						msg = "Asistente agregado exitosamente";
					} else {
						msg = "El asistente no existe";
					}
				} else {
					msg = "El equipo llego al limite de asistentes";
				}
			}
		} else {
			msg = "El equipo no existe";
		}
		return msg;
	}

	public String headcoachToTeam(String coachName, String teamName) {
		String msg = "";
		HeadCoach coach = (HeadCoach) findEmployee(coachName);
		if (coach != null) {
			if (this.teamA.getName().equalsIgnoreCase(teamName)) {
				if (this.teamA.getHeadCoach().getName().equalsIgnoreCase(coachName)) {
					msg = "El entrenador esta dirigiendo el equipo actualmente";
				} else {
					this.teamA.setHeadCoach(coach);
					coach.setNumbersTeams();
					msg = "El entrenador ha sido cambiado correctamente";
				}
			} else if (this.teamB.getName().equalsIgnoreCase(teamName)) {
				if (this.teamB.getHeadCoach().getName().equalsIgnoreCase(coachName)) {
					msg = "El entrenador esta dirigiendo el equipo actualmente";
				} else {
					this.teamB.setHeadCoach(coach);
					coach.setNumbersTeams();
					msg = "El entrenador ha sido cambiado correctamente";
				}
			} else {
				msg = "El equipo no existe";
			}
		} else {
			msg = "El empleado no existe";
		}
		return msg;
	}

	public String playerToDressingRoom(String teamName, String playerName) {
		Player newplayer = (Player) findEmployee(playerName);
		String msg = "";
		boolean added = false;
		boolean found = false;
		if (newplayer == null) {
			msg = "El jugador no existe";
		} else if (this.teamA.getName().equalsIgnoreCase(teamName) || this.teamB.getName().equalsIgnoreCase(teamName)) {
			for (int k = 0; k < 25 && !found; k++) {
				if (this.teamA.getPlayers()[k].getName().equalsIgnoreCase(playerName)) {
					found = true;
					for (int i = 0; i < DR_ROWA && !added; i++) {
						for (int j = 0; j < DR_COLUMNSA && !added; j++) {
							if (i == 0 && j == 0 && dressingRoomA[i][j] == null) {
								dressingRoomA[i][j] = newplayer;
								added = true;
								msg = "Jugador agregado al vestuario A";
							} else if (i == 0 && j > 0 && dressingRoomA[i][j - 1] == null) {
								dressingRoomA[i][j] = newplayer;
								added = true;
								msg = "Jugador agregado al vestuario A";
							} else if (i > 0 && j == 0 && dressingRoomA[i - 1][j] == null) {
								dressingRoomA[i][j] = newplayer;
								added = true;
								msg = "Jugador agregado al vestuario A";
							} else if (i > 0 && j > 0 && dressingRoomA[i - 1][j - 1] != null) {
								dressingRoomA[i][j] = newplayer;
								added = true;
								msg = "Jugador agregado al vestuario A";
							} else {
								msg = "El vestuario A se encuentra lleno";
							}

						}
					}
				} else if (this.teamB.getPlayers()[k].getName().equalsIgnoreCase(playerName)) {
					found = true;
					for (int i = 0; i < ORDER_DRB && !added; i++) {
						for (int j = 0; j < ORDER_DRB && !added; j++) {
							if (i == 0 && j == 0 && dressingRoomB[i][j] == null) {
								dressingRoomB[i][j] = newplayer;
								added = true;
								msg = "Jugador agregado al vestuario B";
							} else if (i == 0 && j > 0 && dressingRoomB[i][j - 1] == null) {
								dressingRoomB[i][j] = newplayer;
								added = true;
								msg = "Jugador agregado al vestuario B";
							} else if (i > 0 && j == 0 && dressingRoomB[i - 1][j] == null) {
								dressingRoomB[i][j] = newplayer;
								added = true;
								msg = "Jugador agregado al vestuario B";
							} else if (i > 0 && j > 0 && dressingRoomB[i - 1][j - 1] != null) {
								dressingRoomB[i][j] = newplayer;
								added = true;
								msg = "Jugador agregado al vestuario B";
							} else {
								msg = "El vestuario B se encuentra lleno";
							}

						}
					}
				} else {
					msg = "El jugador no pertenece a algún equipo";
				}
			}
		} else {
			msg = "El equipo no existe";
		}
		return msg;
	}

	public String coachToOffice(String coachName) {
		String msg = "";
		boolean added = false;
		if (findEmployee(coachName) instanceof HeadCoach) {
			HeadCoach newCoach = (HeadCoach) findEmployee(coachName);
			if (newCoach == null) {
				msg = "El entrenador no existe";
			} else {
				for (int i = 0; i < ORDER_OFFICE && !added; i++) {
					for (int j = 0; j < ORDER_OFFICE && !added; j++) {
						if (i == 0 && j == 0 && office[i][j] == null) {
							office[i][j] = newCoach;
							added = true;
							msg = "Entrenador agregado a las oficinas";
						} else if (i == 0 && j > 0 && office[i][j - 1] == null) {
							office[i][j] = newCoach;
							added = true;
							msg = "Entrenador agregado a las oficinas";
						} else if (i > 0 && j == 0 && office[i - 1][j] == null) {
							office[i][j] = newCoach;
							added = true;
							msg = "Entrenador agregado a las oficinas";
						} else if (i > 0 && j > 0 && office[i - 1][j - 1] != null) {
							office[i][j] = newCoach;
							added = true;
							msg = "Entrenador agregado a las oficinas";
						} else {
							msg = "Las oficinas se encuentra llenas";
						}
					}
				}
			}
		}
		if (findEmployee(coachName) instanceof AssistantCoach) {
			AssistantCoach newCoach = (AssistantCoach) findEmployee(coachName);
			if (newCoach == null) {
				msg = "El entrenador no existe";
			} else {
				for (int i = 0; i < ORDER_OFFICE && !added; i++) {
					for (int j = 0; j < ORDER_OFFICE && !added; j++) {
						if (i == 0 && j == 0 && office[i][j] == null) {
							office[i][j] = newCoach;
							added = true;
							msg = "Entrenador agregado a las oficinas";
						} else if (i == 0 && j > 0 && office[i][j - 1] == null) {
							office[i][j] = newCoach;
							added = true;
							msg = "Entrenador agregado a las oficinas";
						} else if (i > 0 && j == 0 && office[i - 1][j] == null) {
							office[i][j] = newCoach;
							added = true;
							msg = "Entrenador agregado a las oficinas";
						} else if (i > 0 && j > 0 && office[i - 1][j - 1] != null) {
							office[i][j] = newCoach;
							added = true;
							msg = "Entrenador agregado a las oficinas";
						} else {
							msg = "Las oficinas se encuentra llenas";
						}
					}
				}
			}
		}
		return msg;
	}

	public String createTeam(String teamName, String team) {
		String msg = "Opcion de equipo invalida" + "\n";
		if (team.equalsIgnoreCase("A")) {
			this.teamA = new ProfessionalTeam(teamName);
			msg += "El equipo " + teamName + " ha sido creado" + "\n";
		} else if (team.equalsIgnoreCase("B")) {
			this.teamB = new ProfessionalTeam(teamName);
			msg += "El equipo " + teamName + " ha sido creado" + "\n";
		}
		return msg;
	}

	public String updateTeamInfo(String teamName, String newName, String date, String tactic, String formation,
			int choice) {
		String msg = "El equipo no existe" + "/n";
		if (this.teamA.getName().equalsIgnoreCase(teamName)) {
			switch (choice) {
				case 1:
					this.teamA.setName(newName);
					msg = "El nombre del equipo actualizado" + "/n";
					break;
				case 2:
					msg = this.teamA.lineUpToTeam(date, tactic, formation);
					break;
				default:
					msg = "Opcion invalida" + "/n";
			}
		} else if (this.teamB.getName().equalsIgnoreCase(teamName)) {
			switch (choice) {
				case 1:
					this.teamB.setName(newName);
					msg = "El nombre del equipo actualizado" + "/n";
					break;
				case 2:
					msg = this.teamB.lineUpToTeam(date, tactic, formation);
					break;
				default:
					msg = "Opcion invalida" + "/n";
					break;
			}
		}
		return msg;
	}

	public String showTeamMatriz(String teamName, int choice) {
		String msg = "Opcion Invalida";
		if (choice == 1) {
			if (this.teamA.getName().equalsIgnoreCase(teamName)) {
				msg = this.teamA.showMatrizLineup();
			} else if (this.teamB.getName().equalsIgnoreCase(teamName)) {
				msg = this.teamB.showMatrizLineup();
			} else {
				msg = "El equipo no existe";
			}
		} else if (choice == 2) {
			msg = this.teamA.showMatrizLineup();
			msg += this.teamB.showMatrizLineup();
		}
		return msg;
	}

	public String showEmployeesInfo() {
		String msg = "";
		for (int i = 0; i < this.employee.size(); i++) {
			msg = this.employee.get(i).showInfo() + "/n";
		}
		return msg;
	}

	public String showTeamsInfo() {
		String msg = this.teamA.showTeamInfo();
		msg += this.teamB.showTeamInfo();
		return msg;
	}

	public String showClubInfo() {
		int teamsAmount = 0;
		String msg = "******************CLUB****************" + "/n" + "Nombre: " + this.name + "/n" + "Nit: "
				+ this.nit + "/n" + "Fecha de fundacion: " + this.foundationDate + "/n" + "Cantidad de empleados: "
				+ this.employee.size() + "/n";
		if (this.teamA != null) {
			teamsAmount++;
		}
		if (this.teamB != null) {
			teamsAmount++;
		}
		msg += "Cantidad de equipos: " + teamsAmount + "/n" + "Equipo A: " + this.teamA.getName() + "/n" + "Equipo B: "
				+ this.teamB.getName() + "/n";
		return msg;
	}
}