public class Task {
    private String description;
    private boolean isDone;

    Task(String description) {
        this.description = description;
        this.isDone = false;
    }

    void markAsDone() {
        isDone = true;
    }
    void markAsNotDone() {
        isDone = false;
    }

    private String getStatusIcon() {
        if(isDone) {
            return "\u2713";
        } else {
            return "\u2718";
        }
    }

    @Override
    public String toString () {
        return "[" + getStatusIcon() + "] " + description;
    }

}
