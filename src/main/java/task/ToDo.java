package task;

/**
 * Represents a specified task by extending the <code>Task</code> class
 * without adding any extra information.
 */
public class ToDo extends Task {

    /**
     * Constructs the task with description.
     *
     * @param description Description of task.
     */
    public ToDo(String description) {
        super(description);
    }

    /**
     * Overrides the <code>toString()</code> method in parent class <code>Task</code>,
     * and returns information of the task to be printed by UI.
     * e.g. "[T][✓] attend the party"
     *
     * @return Information of the task to be printed by UI.
     */
    @Override
    public String toString() {
        return "[T]" + super.toString();
    }

    /**
     * Returns information of the task in storage format.
     * e.g. "T | 1 | attend the party"
     *
     * @return Information of the task to be stored in storage.
     */
    @Override
    public String toStorageString() {
        return "T | " + super.toStorageString();
    }
}
