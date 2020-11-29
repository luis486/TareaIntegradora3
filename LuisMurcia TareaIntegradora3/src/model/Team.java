package model;

import java.util.ArrayList;

public class Team {
    private String name;
    ArrayList<LineUp> lineUp = new ArrayList<>();

    public Team(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
