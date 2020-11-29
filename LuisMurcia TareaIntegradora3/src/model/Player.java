package model;

public class Player extends Employee {

    private int tshirtNumber;
    private int goalClub;
    private double averageCalification;

    public Player(String name, int id, int salary, int tshirtNumber, int goalClub, double averageCalification) {
        super(name, id, salary);
        this.tshirtNumber = tshirtNumber;
        this.goalClub = goalClub;
        this.averageCalification = averageCalification;
    }

    public int getTshirtNumber() {
        return this.tshirtNumber;
    }

    public void setTshirtNumber(int tshirtNumber) {
        this.tshirtNumber = tshirtNumber;
    }

    public int getGoalClub() {
        return this.goalClub;
    }

    public void setGoalClub(int goalClub) {
        this.goalClub = goalClub;
    }

    public double getAverageCalification() {
        return this.averageCalification;
    }

    public void setAverageCalification(double averageCalification) {
        this.averageCalification = averageCalification;
    }

}
