package command;
import task.TaskList;
import ui.Ui;
import storage.Storage;
import exception.DukeException;
public class AddCommand extends Command {
    private String description;
    private String ddl;
    private String timePiece;

    public AddCommand(String commandType, String description, String ddl, String timePiece) {
        super(commandType);
        this.description = description;
        this.ddl = ddl;
        this.timePiece = timePiece;
    }
    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage){
        try {
        switch (super.commandType) {
            case "todo":
                tasks.addToDo(description);
                break;
            case "deadline":
                tasks.addDeadline(description, ddl);
                break;
            case "event":
                tasks.addEvent(description, timePiece);
                break;
        }
        storage.update(tasks.toStorageStrings());
        } catch (DukeException e) {
            throw e;
        }
        ui.println("Got it. I've added this task:");
        ui.println(tasks.getTaskInfo(tasks.getSize() - 1));
        ui.println("Now you have " + tasks.getSize() + " tasks in the list.");
    }


}
