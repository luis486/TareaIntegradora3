package model;

public class AssistantTrainer extends Trainer {
    private boolean playerFootball;

    public AssistantTrainer(String name, int id, int salary, int yearsExperience, boolean playerFootball) {
        super(name, id, salary, yearsExperience);
        this.playerFootball = playerFootball;
    }

    public boolean getPlayerFootball() {
        return this.playerFootball;
    }

    public void setPlayerFootball(boolean playerFootball) {
        this.playerFootball = playerFootball;
    }
}
