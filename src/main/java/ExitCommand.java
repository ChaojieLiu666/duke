public class ExitCommand extends Command {
    public ExitCommand() {
        super("exit");
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) {
    ui.println("Bye. Hope to see you again soon!");
    }

}
