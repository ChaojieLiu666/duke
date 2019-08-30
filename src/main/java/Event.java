import java.util.Date;

public class Event extends Task {
    private String timePiece;
    private Date start;
    private Date end;

    public Event(String description, String timePiece) throws DukeException {
        super(description);
        this.timePiece = timePiece;
        String[] tokens = timePiece.split("-");
        if(tokens.length < 2) throw new DukeException("☹ OOPS!!! Cannot only show start or end time.");
        for(int i = 0; i < tokens.length; i++) {
            tokens[i] = tokens[i].trim();
        }
        try {
            start = TimeParser.parse(tokens[0]);
            end = TimeParser.parse(tokens[1]);
        } catch (DukeException e) {
            throw e;
        }
    }

    @Override
    public String toString() {
        return "[E]" + super.toString() + " (at: " + timePiece + ")";
    }

    @Override
    public String toStorageString() {
        return "E | " + super.toStorageString() + " | " + timePiece;
    }
}