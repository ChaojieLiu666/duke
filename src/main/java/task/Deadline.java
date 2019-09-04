package task;

import exception.DukeException;
import parser.TimeParser;

import java.util.Date;

public class Deadline extends Task {
    private String ddl;
    private Date by;

    public Deadline(String description, String ddl) throws DukeException {
        super(description);
        this.ddl = ddl;
        by = TimeParser.parse(ddl);
    }

    @Override
    public String toString() {
        return "[D]" + super.toString() + " (by: " + ddl + ")";
    }

    @Override
    public String toStorageString() {
        return "D | " + super.toStorageString() + " | " + ddl;
    }
}
