package model;

public class MainTrainer extends Trainer {

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

}
