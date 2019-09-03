package task;

public class Task {
    protected String description;
    protected boolean isDone;

    protected Task(String description) {
        this.description = description;
        this.isDone = false;
    }

    protected void markAsDone() {
        isDone = true;
    }
    protected void markAsNotDone() {
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
    public String toString() {
        return "[" + getStatusIcon() + "] " + description;
    }

    public String toStorageString() {
        String storageString;
        if (isDone == true) {
            storageString = "1";
        } else {
            storageString = "0";
        }
        storageString += " | " + description;
        return storageString;
    }

    public boolean contains(String s) {
        return description.contains(s);
    }
}
