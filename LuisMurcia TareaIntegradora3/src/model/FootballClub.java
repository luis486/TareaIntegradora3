package model;

import java.util.ArrayList;

public class FootballClub {
    private final static int ORDER_OFFICE = 6;
    private final static int DR_ROW_A = 7, DR_COLUMNS_A = 6;
    private final static int ORDER_DR_B = 7;
    private String name;
    private int nit;
    private String foundationDate;
    private ArrayList<Employee> employee;
    private Team teamA;
    private Team teamB;
    private Trainer[][] office;
    private Player[][] dressingRoomA;
    private Player[][] dressingRoomB;

    public FootballClub(String name, int nit, String foundationDate) {
        this.name = name;
        this.nit = nit;
        this.foundationDate = foundationDate;
        this.employee = new ArrayList<Employee>();
        this.office = new Trainer[ORDER_OFFICE][ORDER_OFFICE];
        this.dressingRoomA = new Player[DR_ROW_A][DR_COLUMNS_A];
        this.dressingRoomB = new Player[ORDER_DR_B][ORDER_DR_B];

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNit() {
        return nit;
    }

    public void setNit(int nit) {
        this.nit = nit;
    }

    public String getFoundationDate() {
        return foundationDate;
    }

    public void setFoundationDate(String foundationDate) {
        this.foundationDate = foundationDate;
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

    public String addEmployee(int yearsExperience, String name, String id, double salary, int numbersTeams,
            int championships) {
        String message = "";
        boolean addPl = false;

        Employee objSearch = findEmployee(name);
        if (objSearch != null)
            message = "Lo sentimos, el empleado ya existe";
        else {
            MainTrainer mainTrainer = new MainTrainer(name);
            employee.add(mainTrainer);
            addPl = true;
            message = "El empleado ha sido registrado";
        }
        if (addPl == false) {
            message = "El empleado no puede ser registrado, ya estamos llenos";
        }
        return message;
    }

    public String addEmployee(int yearsExperience, String name, String id, double salary, String exPlayer,
            String expertise) {
        String message = "";
        boolean addPl = false;

        Employee objSearch = findEmployee(name);
        if (objSearch != null) {
            message = "Error. the employee already exist";
        } else {
            AssistantCoach assistant = new AssistantCoach(name);
            employee.add(player);
            addPl = true;
            addPl = true;
            message = "El empleado ha sido registrado";
            if (addPl == false) {
                message = "El empleado no puede ser registrado, ya estamos llenos";
            }
            return message;
        }
    }

    public String addEmployee(String name, String id, double salary, int dorsal, int goals, double rating, String position){
		String message="";
		boolean addPl=false;
		Employee objSearch=findEmployee(name);
		if(objSearch!=null){
			message="Error. the employee already exist";
		}
		else{
			Player player = new Player(name);
			employee.add(player);
            addPl=true;
            message = "El empleado ha sido registrado";
            if (addPl == false) {
                message = "El empleado no puede ser registrado, ya estamos llenos";
            }
            return message;
	}

    public String hireEmployee(String name) {
        String message = "";
        boolean addPl = false;

        Employee objSearch = findEmployee(name);
        if (objSearch == null) {
            message = "El empleado no existe";
        } else {
            this.employee.remove(objSearch);
            message = "El empleado ha sido despedido con exito";
        }
        return message;
    }
    /*
     * public String addPlayer(String playerName, String teamName){ String msg="";
     * if(this.teamA.getName().equalsIgnoreCase(teamName)){ for (int
     * i=0;this.teamA.getPlayers().length;i++){ if(this.teamA.getPlayers()[i]!=null
     * && this.teamA.getPlayers()[i].equalsIgnoreCase(playerName))
     * msg="El jugador ya existe en el equipo"; }else
     * if(this.teamA.getPlayers()[i]!=null){ if(this.employee[i].getName) } }else
     * if(this.teamB.getName().equalsIgnoreCase(teamName)){ this.teamB.getPlayers();
     * }
     * 
     * }
     */
}
}
