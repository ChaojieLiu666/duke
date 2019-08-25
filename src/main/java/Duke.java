
public class Duke {

    public static void main(String[] args) {
        Ui ui = new Ui();
        TaskList tasks = new TaskList();

        ui.showWelcome();
        boolean isExit = false;
        while (!isExit) {
            String fullCommand = ui.readCommand();
            try {
                Command packagedCommand = Parser.parse(fullCommand);
                packagedCommand.execute(tasks, ui);
                isExit = packagedCommand.isExit();
            } catch (DukeException e) {
                ui.showError(e);
            }
        }
    }

}
