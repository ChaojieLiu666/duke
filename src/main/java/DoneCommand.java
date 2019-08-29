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
        try {
            storage.update(tasks.toStorageStrings());
        } catch (DukeException e) {
            throw e;
        }
        ui.println("Nice! I've marked this task as done:");
        ui.println(tasks.getTaskInfo(index));
    }

}
