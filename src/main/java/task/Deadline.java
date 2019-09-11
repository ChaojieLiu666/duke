package task;

import exception.DukeException;
import parser.TimeParser;

import java.util.Date;

/**
 * Represents a specified task as Deadline by extending the <code>Task</code> class
 * with due <code>Date</code>.
 */
public class Deadline extends Task {
    private String ddl;
    private Date by;

    /**
     * Constructs the <code>Deadline</code> object with description and due time.
     * The due time is stored as <code>Date</code>.
     *
     * @param description Description of the task
     * @param ddl Deadline of the task in <code>String</code> type.
     * @throws DukeException If string ddl has incorrect time format.
     */
    public Deadline(String description, String ddl) throws DukeException {
        super(description);
        this.ddl = ddl;
        by = TimeParser.parse(ddl);
    }

    /**
     * Overrides the <code>toString()</code> method in parent class <code>Task</code>,
     * and returns information of the task to be printed by UI.
     * e.g. "[D][✓] attend the party (by: 02/05/2019 1800)"
     *
     * @return Information of the task to be printed by UI.
     */
    @Override
    public String toString() {
        return "[D]" + super.toString() + " (by: " + ddl + ")";
    }

    /**
     * Returns information of the task in storage format.
     * e.g. "D | 1 | attend the party | 02/05/2019 1800"
     *
     * @return Information of the task to be stored in storage.
     */
    @Override
    public String toStorageString() {
        return "D | " + super.toStorageString() + " | " + ddl;
    }
}
