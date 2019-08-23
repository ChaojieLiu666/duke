import java.util.Scanner;
import java.util.ArrayList;

public class Duke {
    public static void main(String[] args) {
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello from\n" + logo);
        System.out.println("Hello! I'm Duke");
        System.out.println("What can I do for you?");

        ArrayList<String> tasks = new ArrayList<String>(100);
        Scanner dukeIn = new Scanner(System.in);
        while (true) {
            String line = dukeIn.nextLine();
            if (line.equals("bye")) {
                System.out.println("Bye. Hope to see you again soon!");
                break;
            } else if (line.equals("list")) {
                if(tasks.size() == 0) {
                    System.out.println("Ops, you haven't added any task!");
                } else {
                    for (int i = 0; i < tasks.size(); i++) {
                        System.out.print(i + 1);
                        System.out.println(". " + tasks.get(i));
                    }
                }
            } else {
                tasks.add(line);
                System.out.println("added: " + line);
            }
        }

    }
}
