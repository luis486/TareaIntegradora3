package model;

import java.util.ArrayList;

public class Team {
    private final static int ASSISTANT_TRAINER = 3;
    private final static int PLAYER = 25;
    private String name;
    ArrayList<LineUp> lineUp;
    private MainTrainer mainTrainer;
    private AssistantTrainer[] assistantTrainer;
    private Player[] player;

    public Team(String name, MainTrainer mainTrainer) {
        this.name = name;
        player = new Player[PLAYER];
        assistantTrainer = new AssistantTrainer[ASSISTANT_TRAINER];
        this.mainTrainer = mainTrainer;
        this.lineUp = new ArrayList<>();
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String playersPosition(String formation) {
        String message = "";
        for (int i = 0; i < lineUp.size(); i++) {
            if (this.lineUp[i].getFormation().equalsIgnoreCase(formation)) {
                LineUp teamFormation = this.lineUp[i];
                int defender = defenteamFormation.getLine()[0];
                int midfielder = defenteamFormation.getLine()[1];
                int forward = defenteamFormation.getLine()[2];
                message += "En la formacion " + formation + " hay: " + "/n" + defender + " Defensas" + "/n" + midfielder
                        + " Mediocampistas" + "/n" + forward + " Delanteros";
            }
        }
        return message;
    }

}
