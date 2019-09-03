import storage.Storage;
import ui.Ui;
import task.TaskList;
import exception.DukeException;
import command.Command;
import parser.Parser;

public class Duke {

    public static void main(String[] args) {
        Ui ui = new Ui();
        // System.out.println(System.getProperty("user.dir") + "/data/TaskListStorage.txt");

        Storage storage = new Storage(System.getProperty("user.dir") + "/data/TaskListStorage.txt");
        TaskList tasks;
        try {
            tasks = new TaskList(storage.load());
        } catch (DukeException e) {
            ui.showError(e);
            tasks = new TaskList();
        }

        ui.showWelcome();
        boolean isExit = false;
        while (!isExit) {
            String fullCommand = ui.readCommand();
            try {
                Command packagedCommand = Parser.parse(fullCommand);
                packagedCommand.execute(tasks, ui, storage);
                isExit = packagedCommand.isExit();
            } catch (DukeException e) {
                ui.showError(e);
            }
        }


    }

}
