public class ListCommand extends Command {
    public ListCommand() {
        super("list");
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) {
        if(tasks.getSize() == 0) {
            ui.println("Ops, you haven't added any task!");
        } else {
            ui.println("Here are the tasks in your list:");
            for (int i = 0; i < tasks.getSize(); i++) {
                ui.println((i + 1) + "." + tasks.getTaskInfo(i));
            }
        }
    }
}
