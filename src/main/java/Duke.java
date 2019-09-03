import storage.Storage;
import ui.Ui;
import task.TaskList;
import exception.DukeException;
import command.Command;
import parser.Parser;

public class Duke {

    private Storage storage;
    private TaskList tasks;
    private Ui ui;

    public Duke(String filePath) {
        ui = new Ui();
        storage = new Storage(filePath);
        try {
            tasks = new TaskList(storage.load());
        } catch (DukeException e) {
            ui.showError(e);
            tasks = new TaskList();
        }
    }

    public void run() {
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

    public static void main(String[] args) {
        new Duke(System.getProperty("user.dir") + "/data/TaskListStorage.txt").run();
    }

}
