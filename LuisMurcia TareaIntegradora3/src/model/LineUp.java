package model;

public class LineUp {
    private String date;
    private String fieldTraining;

    public LineUp() {
    }

    public LineUp(String date, String fieldTraining) {
        this.date = date;
        this.fieldTraining = fieldTraining;
    }

    public String getDate() {
        return this.date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getFieldTraining() {
        return this.fieldTraining;
    }

    public void setFieldTraining(String fieldTraining) {
        this.fieldTraining = fieldTraining;
    }

    public LineUp date(String date) {
        this.date = date;
        return this;
    }

}
