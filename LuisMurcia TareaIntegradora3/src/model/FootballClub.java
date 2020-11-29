package model;

public class FootballClub {
    private final static int ASSISTANT_TRAINER = 3;
    private final static int PLAYER = 25;
    private String name;
    private int nit;
    private String date;
    private MainTrainer mainTrainerA;
    private AssistantTrainer[] assistantTrainerA;
    private Player[] playerA;

    public FootballClub(String name, int nit, String date) {
        this.name = name;
        this.nit = nit;
        this.date = date;
        playerA = new Player[PLAYER];
        assistantTrainerA = new AssistantTrainer[ASSISTANT_TRAINER];

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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

}
