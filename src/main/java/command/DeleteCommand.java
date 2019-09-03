package command;
import task.TaskList;
import ui.Ui;
import storage.Storage;
import exception.DukeException;
public class DeleteCommand extends Command {
    private int index;

    public DeleteCommand(int index) {
        super("delete");
        this.index = index;
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) {
        String str;
        try {
            str = tasks.getTaskInfo(index);
            tasks.delete(index);
        } catch (IndexOutOfBoundsException e) {
            throw new DukeException("☹ OOPS!!! The index should be in range.");
        }
        storage.update(tasks.toStorageStrings());
        ui.println("Noted. I've removed this task:");
        ui.println(str);
        ui.println("Now you have " + tasks.getSize() + " tasks in the list.");
    }
}
