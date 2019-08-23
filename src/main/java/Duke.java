import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;


public class Duke {
    public static void main(String[] args) {
        dukeGreets();
        Scanner dukeIn = new Scanner(System.in);
        while (true) {
            String lineIn = dukeIn.nextLine();
            Scanner tokensProcessor = new Scanner(lineIn);
            String command = tokensProcessor.next();

            if (command.equals("bye")) {
                break;
            }
            switch (command) {
                case "list":
                    printList();
                    break;
                case "done":
                    try {
                        int index = tokensProcessor.nextInt();
                        tasks.get(index-1).markAsDone();
                        System.out.println("Nice! I've marked this task as done:");
                        System.out.println(tasks.get(index-1).toString());
                    } catch (NoSuchElementException e) {
                        System.out.println("You should indicate the numerical index!");
                    } catch (IndexOutOfBoundsException e) {
                        System.out.println("Invalid Index!");
                    }
                    break;
                default: // adding new tasks
                    tasks.add(new Task(lineIn));
                    System.out.println("added: " + lineIn);
            } // switch
        }
        System.out.println("Bye. Hope to see you again soon!");
    }

    /**
     * Prints greeting contents
     */
    private static void dukeGreets() {
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello from\n" + logo);
        System.out.println("I am Duke. What can I do for you?");
    }

    /**
     * The field storing the task list
     */
    private static ArrayList<Task> tasks = new ArrayList<Task>(100);

    /**
     * Prints the task list
     */
    private static void printList() {
        if(tasks.size() == 0) {
            System.out.println("Ops, you haven't added any task.");
            return;
        }
        System.out.println("Here are the tasks in your list:");
        for (int i = 1; i <= tasks.size(); i++) {
            System.out.print(i);
            System.out.println("." + tasks.get(i-1).toString());
        }
    }

}
