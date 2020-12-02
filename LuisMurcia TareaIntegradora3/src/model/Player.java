package model;

public class Player extends Employee implements WorldFootball {

    private int tshirtNumber;
    private int goalClub;
    private double averageCalification;
    private Position position;

    public Player(String name, int id, int salary, int tshirtNumber, int goalClub, double averageCalification) {
        super(name, id, salary);
        this.tshirtNumber = tshirtNumber;
        this.goalClub = goalClub;
        this.averageCalification = averageCalification;
        this.position = Position.valueOf(position);
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

    public double calculateMarketPrice() {
        double marketPrice = 0;
        switch (position) {
            case GOALKEEPER:
                marketPrice = (getSalary() * 12) + (getAverageCalification() * 150);
                break;
            case DEFENDER:
                marketPrice = (getSalary() * 13) + (getAverageCalification() * 125) + (getGoalClub() * 100);
                break;
            case STERING_WHEEL:
                marketPrice = (getSalary() * 14) + (getAverageCalification() * 135) + (getGoalClub() * 125);
                break;
            case FORWARD:
                marketPrice = (getSalary() * 15) + (getAverageCalification() * 145) + (getGoalClub() * 150);
                break;
        }
        return marketPrice;
    }

    public double calculateLevel() {

        double levelPlayer = 0;

        switch (position) {
            case GOALKEEPER:
                levelPlayer = (getAverageCalification() * 0.9);
                break;
            case DEFENDER:
                levelPlayer = (getAverageCalification() * 0.9) + (getGoalClub() / 100);
                break;
            case STERING_WHEEL:
                levelPlayer = (getAverageCalification() * 0.9) + (getGoalClub() / 90);
                break;
            case FORWARD:
                levelPlayer = (getAverageCalification() * 0.9) + (getGoalClub() / 80);
                break;
        }
        return levelPlayer;
    }

    @Override
    public String showContents() {
        String message = "";
        return message;
    }

}
