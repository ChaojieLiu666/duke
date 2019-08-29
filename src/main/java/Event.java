public class Event extends Task {
    private String timePiece;

    public Event(String description, String timePiece) {
        super(description);
        this.timePiece = timePiece;
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