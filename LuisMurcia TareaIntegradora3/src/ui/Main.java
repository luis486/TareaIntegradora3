package ui;

public class Main {
	/*
	javac -cp src src/ui/Main.java -d bin
	java -cp bin ui.Main
	javadoc -cp src model ui -d docs/javadoc
	*/
	public static void main(String[] args) {
		Menu m;
		m = new Menu();
		m.startProgram();
	}
}