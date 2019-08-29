import java.util.ArrayList;

public class TaskList {
    private ArrayList<Task> tasks;

    public TaskList() {
        tasks = new ArrayList<Task>(100);
    }

    public TaskList(ArrayList<String> taskStrings) {
        tasks = new ArrayList<Task>(100);
        for (String line : taskStrings) {
            String[] tokens = line.split("\\Q|\\E");
            for(int i = 0; i < tokens.length; i++) {
                tokens[i] = tokens[i].trim();
            }
            switch (tokens[0]) {
                case "T":
                    addToDo(tokens[2]);
                    if(tokens[1].equals("1")) {
                        done(tasks.size() - 1);
                    }
                    break;
                case "D":
                    addDeadline(tokens[2], tokens[3]);
                    if(tokens[1].equals("1")) {
                        done(tasks.size() - 1);
                    }
                    break;
                case "E":
                    addEvent(tokens[2], tokens[3]);
                    if(tokens[1].equals("1")) {
                        done(tasks.size() - 1);
                    }
                    break;
            }
        }
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
    /*
    public void delete(int index) { // 0-based
        tasks.remove(index);
    }
    */ // Delete Command is blocked as Level-6 is not required for Week 3 Schedule.

    public String getTaskInfo(int index) {
        return tasks.get(index).toString();
    }

    public ArrayList<String> toStorageStrings() {
        ArrayList<String> taskStrings = new ArrayList<String>(100);
        for(Task task : tasks) {
            taskStrings.add(task.toStorageString());
        }
        return taskStrings;
    }

    public int getSize(){
        return tasks.size();
    }
}