package ui;

import model.*;

import java.util.Scanner;

public class Menu {

    private FootballClub footballClub;
    Scanner sc = new Scanner(System.in);

    public Menu() {
        this.footballClub = new FootballClub();
    }

    /**
     * Allows know what do you wanna to do in the aplication <br>
     * <b> pre: </b><br>
     * <b> post </b> The option is correct <br>
     * 
     * 
     */
    public void showMenu() {
        System.out.println(
                "Bienvenidos a la escuela de fútbol profesional FC Barcelona, a continuación usted tendrá el siguiente menú: ");
        System.out.println("Seleccione (1) si quiere contratar empleados");
        System.out.println("Seleccione (2) si quiere despedir empleados");
        System.out.println("Seleccione (3) si quiere agregar jugadores o entrenadores a un equipo");
        System.out.println("Seleccione (4) si quiere actualizar la información de un empleado");
        System.out.println("Seleccione (5) si quiere actualizar la información de un equipo");
        System.out.println("Seleccione (6) si desea agregar alineaciones a un equipo");
        System.out.println("Seleccione (7) si desea ubicar un jugador en un vestidor");
        System.out.println("Seleccione (8) si desea ubicar un entrenador en una oficina");
        System.out.println("Seleccione (9) si desea información del club");
        System.out.println("Seleccione (10) si quiere mostrar la ubicación de los entrenadores en sus oficinas");
        System.out.println("Seleccione (11) si quiere mostrar la ubicación de los jugadores en sus vestidores");
        System.out.println("Seleccione (12) si desea salir");
    }

    public void doOperation(int option) {
        switch (option) {
            case 1:
                System.out.println();
                break;

            case 2:
                System.out.println();
                break;

            case 3:
                System.out.println();
                break;

            case 4:
                System.out.println();
                break;
            case 5:
                System.out.println();
                break;
            case 6:
                System.out.println();
                break;
            case 7:
                System.out.println();
                break;
            case 8:
                System.out.println();
                break;
            case 9:
                System.out.println();
                break;
            case 10:
                System.out.println();
                break;
            case 11:
                System.out.println();
                break;
            case 12:
                System.out.println("Gracias por usar esta aplicacion, vuelva pronto");
                break;
            default:
                System.out.println("Error, opción no válida");
        }
    }

    public String hireEmployee() {
        System.out.println("Ingrese el nombre del empleado a contratar");
        String name = sc.nextLine();
        System.out.println("Ingrese el numero de identificación del usuario");
        int id = sc.nextInt();
        System.out.println("Ingrese el salario del empleado a contratar");
        int salary = sc.nextInt();
        sc.nextLine();
        String message = footballClub.hireEmployee(name);
        return message;
    }

    public String fireEmployee() {
        System.out.println("Ingrese el nombre del empleado a despedir");
        String name = sc.nextLine();
        System.out.println("Ingrese el numero de identificación del usuario");
        int id = sc.nextInt();
        sc.nextLine();
        String message = footballClub.fireEmployee(name, id);
        return message;
    }

    public void addFootballClub() {
        System.out.println("Escriba el nombre del club");
        String name = sc.nextLine();
        System.out.println("Escriba el NIT del club");
        int nit = sc.nextInt();
        System.out.println("Escriba el día de fundación ");
        String foundationDate = sc.nextLine();
        sc.nextLine();

    }

    public void registerEmployee() {
        System.out.println("********************");
        System.out.println("Registrar Informacion");
        System.out.println("********************");

        System.out.println("Escriba el nombre");
        String name = sc.nextLine();
        System.out.println("Escriba el numero de identificacion");
        String id = sc.nextLine();
        System.out.println("Escriba el salario del empleado");
        double salary = sc.nextDouble();
        sc.nextLine();

        System.out.println("Digite (1) para entrenadores, (2) para jugadores");
        int numplay = sc.nextInt();
        sc.nextLine();
        switch (numplay) {

            case 1:
                System.out.println("Escriba los años de experiencia");
                int yearsExperience = sc.nextInt();
                sc.nextLine();
                System.out.println("Escribe (1) para si es entrenador principal o (2) para entrenador asistente");
                int num = sc.nextInt();
                sc.nextLine();
                switch (num) {

                    case 1:
                        System.out.println("Numero de equipos a cargo");
                        int numberTeam = sc.nextInt();
                        sc.nextLine();
                        System.out.println("Campeonatos conseguidos");
                        int championshipsAchieved = sc.nextInt();
                        sc.nextLine();

                        break;
                    case 2:
                        System.out.println("Ex jugador de fútbol digite (1) si o (2) no");
                        boolean playerFootball = sc.nextBoolean();
                        // if(exPlayer.equalsIgnoreCase("yes"))
                        System.out.println(
                                " Escriba su experticia (OFensivo, Defensivo, Posesion, Jugadas de laboratorio)");
                        String expertise = sc.nextLine().toUpperCase();

                        break;
                    default:
                        System.out.println("Opcion invalida");
                }
                break;
            case 2:
                System.out.println("Escriba " + name + "'s numero");
                int tshirtNumber = sc.nextInt();
                sc.nextLine();
                System.out.println("Escriba " + name + " posicion, (Portero, Defensa, Volante, Delantero)");
                String position = sc.nextLine().toUpperCase();
                System.out.println("Escriba el numero de goles " + name + " anotados");
                int goalClub = sc.nextInt();
                sc.nextLine();
                System.out.println("Por favor califique al jugador");
                double averageCalification = sc.nextDouble();
                sc.nextLine();

                break;
            default:
                System.out.println("Opcion invalida");
        }
    }

    /**
     * Allows read the option <br>
     * <b> pre: </b><br>
     * <b> post </b> The option is correct <br>
     * 
     */
    public int readOption() {
        int option = sc.nextInt();
        sc.nextLine();
        return option;
    }

    /**
     * Allows start the programt <br>
     * <b> pre: </b><br>
     * <b> post </b> The program are running <br>
     * 
     */
    public void startProgram() {
        int option;
        do {
            showMenu();
            option = readOption();
            doOperation(option);
        } while (option != 12);
    }
}
