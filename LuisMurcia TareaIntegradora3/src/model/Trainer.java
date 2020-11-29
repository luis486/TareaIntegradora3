package model;

public abstract class Trainer extends Employee {
    private int yearsExperience;

    public Trainer(String name, int id, int salary, int yearsExperience) {
        super(name, id, salary);
        this.yearsExperience = yearsExperience;
    }

    public int getYearsExperience() {
        return this.yearsExperience;
    }

    public void setYearsExperience(int yearsExperience) {
        this.yearsExperience = yearsExperience;
    }

}
