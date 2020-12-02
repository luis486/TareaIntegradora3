package model;

public class LineUp {
    private final static int FORMATION_ROWS = 10;
    private final static int FORMATION_COLUMNS = 7;
    private String date;
    private String fieldTraining;
    private Tactic tactic;
    private int[][] formationTeam;
    private int[] line;

    public LineUp(String date, String fieldTraining) {
        this.date = date;
        this.fieldTraining = fieldTraining;
        this.tactic = Tactic.valueOf(tactic);
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

    public int[][] convertToMatriz() {
        this.formationTeam = new int[FORMATION_ROWS][FORMATION_COLUMNS];
        String[] playerParts = this.fieldTraining.split("-");
        this.line = new int[playerParts.length];
        for (int i = 0; i < playerParts.length; i++) {
            line[i] = Integer.parseInt(playerParts[i]);
        }
        for (int k = 0; k < FORMATION_ROWS; k++) {
            for (int l = 0; l < FORMATION_COLUMNS; l++) {
                formationTeam[k][l] = 0;
            }
        }
        for (int m = 0; m < line.length; m++) {
            int row = 0;
            if (m == 0) {
                row = 8;
            }
            if (m == 1) {
                row = 5;
            }
            if (m == 2) {
                row = 2;
            }
            if (line[m] == 1) {
                formationTeam[row][3] = 1;
            }
            if (line[m] == 2) {
                formationTeam[row][1] = 1;
                formationTeam[row][5] = 1;
            }
            if (line[m] == 3) {
                formationTeam[row][1] = 1;
                formationTeam[row][3] = 1;
                formationTeam[row][5] = 1;
            }
            if (line[m] == 4) {
                formationTeam[row][1] = 1;
                formationTeam[row][2] = 1;
                formationTeam[row][4] = 1;
                formationTeam[row][5] = 1;
            }
            if (line[m] == 5) {
                formationTeam[row][1] = 1;
                formationTeam[row][2] = 1;
                formationTeam[row][3] = 1;
                formationTeam[row][4] = 1;
                formationTeam[row][5] = 1;
            }
        }
        return this.formationTeam;
    }
}
