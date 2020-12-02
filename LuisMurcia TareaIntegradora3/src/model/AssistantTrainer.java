package model;

public class AssistantTrainer extends Trainer {
    private boolean playerFootball;
    private Expertise expertise;

    public AssistantTrainer(String name, int id, int salary, int yearsExperience, boolean playerFootball) {
        super(name, id, salary, yearsExperience);
        this.playerFootball = playerFootball;
        this.expertise = Expertise.valueOf(expertise);
    }

    public boolean getPlayerFootball() {
        return this.playerFootball;
    }

    public void setPlayerFootball(boolean playerFootball) {
        this.playerFootball = playerFootball;
    }

    public String showContents() {
        String message = "";
        return message;
    }
}
