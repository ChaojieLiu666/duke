public class Command {
    protected String commandType;

    protected Command(String commandType){
        this.commandType = commandType;
    }

    protected void execute(TaskList tasks, Ui ui, Storage storage) {
        // to be overridden
    }

    public boolean isExit() {
        if (commandType.equals("exit")) {
            return true;
        } else {
            return false;
        }
    }
}
