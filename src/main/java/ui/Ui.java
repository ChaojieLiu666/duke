package ui;

import exception.DukeException;

import java.util.Scanner;

public class Ui {
    private Scanner dukeIn;

    public Ui(){
        dukeIn = new Scanner(System.in);
    }

    public void showWelcome() {
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello from\n" + logo);
        System.out.println("I am Duke. What can I do for you?");
    }

    public String readCommand() {
        return dukeIn.nextLine();
    }

    public void println(String s) {
        System.out.println(s);
    }

    public void showError(DukeException e) {
        System.out.println(e.getMessage());
    }
}
