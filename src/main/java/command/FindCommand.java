package command;
import task.TaskList;
import ui.Ui;
import storage.Storage;
import java.util.ArrayList;

public class FindCommand extends Command {
    private String target;

    public FindCommand(String target) {
        super("find");
        this.target = target;
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) {
        ArrayList<Integer> matchedList = tasks.find(target);
        if (matchedList.size() == 0) {
            ui.println("No results found.");
            return;
        }
        ui.println("Here are the matching tasks in your list:");
        int count = 1;
        for (int i : matchedList) {
            ui.println(count + "." + tasks.getTaskInfo(i));
            count ++;
        }
    }
}
