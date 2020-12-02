package model;

public class MainTrainer extends Trainer implements WorldFootball {

    private int numberTeam;
    private int championshipAchieved;

    public MainTrainer(String name, int id, int salary, int yearsExperience, int numberTeam, int championshipAchieved) {
        super(name, id, salary, yearsExperience);
        this.numberTeam = numberTeam;
        this.championshipAchieved = championshipAchieved;
    }

    public int getNumberTeam() {
        return this.numberTeam;
    }

    public void setNumberTeam(int numberTeam) {
        this.numberTeam = numberTeam;
    }

    public int getChampionshipAchieved() {
        return this.championshipAchieved;
    }

    public void setChampionshipAchieved(int championshipAchieved) {
        this.championshipAchieved = championshipAchieved;
    }

    public double calculateMarketPrice() {
        double priceMarket = (getSalary() * 10) + (getYearsExperience() * 100) + (getChampionshipAchieved() * 50);
        return priceMarket;
    }

    public double calculateLevel() {
        double level = 5 + (getChampionshipAchieved() / 10);
        return level;
    }

    @Override
    public String showContents() {
        String message = "";
        return message;
    }
}
