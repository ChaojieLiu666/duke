import java.util.ArrayList;

public class TaskList {
    private ArrayList<Task> tasks;

    public TaskList() {
        tasks = new ArrayList<Task>(100);
    }

    public void addToDo(String description) {
        tasks.add(new ToDo(description));
    }

    public void addDeadline(String description, String ddl){
        tasks.add(new Deadline(description, ddl));
    }

    public void addEvent(String description, String timePiece) {
        tasks.add(new Event(description, timePiece));
    }

    public void done(int index) { // 0-based
        tasks.get(index).markAsDone();
    }

    public void delete(int index) { // 0-based
        tasks.remove(index);
    }


    public String getTaskInfo(int index) {
        return tasks.get(index).toString();
    }

    public int getSize(){
        return tasks.size();
    }
}