package command;

import task.TaskList;
import ui.Ui;
import storage.Storage;
import exception.DukeException;

public class DoneCommand extends Command {
    private int index;

    public DoneCommand(int index) {
        super("done");
        this.index = index;
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws DukeException {
        try {
            tasks.done(index);
        } catch (IndexOutOfBoundsException e) {
            throw new DukeException("☹ OOPS!!! The index should be in range.");
        }
        storage.update(tasks.toStorageStrings());

        ui.println("Nice! I've marked this task as done:");
        ui.println(tasks.getTaskInfo(index));
    }

}
