public class Deadline extends Task {
    private String ddl;

    public Deadline(String description, String ddl) {
        super(description);
        this.ddl = ddl;
    }
    // (by: June 6th)
    @Override
    public String toString() {
        return "[D]" + super.toString() + " (by: " + ddl + ")";
    }
}
