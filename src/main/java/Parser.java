import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Parser {
    private static String commandType;
    private static String description;
    private static String ddl;
    private static String timePiece;
    private static Matcher m;
    private static int index;

    private static Command packageCommand(String commandType, String[] tokens) throws DukeException {
        switch(commandType) {
            case "todo":
                if (tokens.length > 1) {
                    throw new DukeException("Please use other command to store time.");
                } else if (tokens[0].equals("")) {
                    throw new DukeException("☹ OOPS!!! The description of a todo cannot be empty.");
                }
                description = tokens[0];
                return new AddCommand(commandType, description,"","");

            case "deadline":
                if (tokens.length == 1 && !tokens[0].equals("")) {
                    throw new DukeException("☹ OOPS!!! The time of a deadline cannot be empty.");
                } else if(tokens[0].equals("")) {
                    throw new DukeException("☹ OOPS!!! The description of a deadline cannot be empty.");
                }
                description = tokens[0];
                ddl = tokens[1];
                return new AddCommand(commandType, description, ddl, "");

            case "event":
                if (tokens.length == 1 && !tokens[0].equals("")) {
                    throw new DukeException("☹ OOPS!!! The time of an event cannot be empty.");
                } else if(tokens[0].equals("")) {
                    throw new DukeException("☹ OOPS!!! The description of an event cannot be empty.");
                }
                description = tokens[0];
                timePiece= tokens[1];
                return new AddCommand(commandType, description, "", timePiece);
            case "list":
                if(!tokens[0].equals("")) {
                    throw new DukeException("☹ OOPS!!! I'm sorry, but I don't know what that means :-(");
                }
                return new ListCommand();
            case "done":
                if (tokens[0].equals("")) {
                    throw new DukeException("☹ OOPS!!! The index cannot be empty.");
                }
                try {
                    index = Integer.parseInt(tokens[0]);
                } catch(NumberFormatException e) {
                    throw new DukeException("☹ OOPS!!! The index should be numerical.");
                }
                return new DoneCommand(index-1); // 0-based
            /*
            case "delete":
                if (tokens[0].equals("")) {
                    throw new DukeException("☹ OOPS!!! The index cannot be empty.");
                }
                try {
                    index = Integer.parseInt(tokens[0]);
                } catch(NumberFormatException e) {
                    throw new DukeException("☹ OOPS!!! The index should be numerical.");
                }
                return new DeleteCommand(index-1); // 0-based
             */ // Delete Command is blocked as Level-6 is not required for Week 3 Schedule.
            case "bye":
                if(!tokens[0].equals("")) {
                    throw new DukeException("☹ OOPS!!! I'm sorry, but I don't know what that means :-(");
                }
                return new ExitCommand();
            default:
                throw new DukeException("Unknow error!");
        }

    }

    public static Command parse(String fullCommand) throws DukeException {
        String regex = "todo|deadline|event|list|done|bye";
        m = Pattern.compile(regex).matcher(fullCommand); // AddCommmand
        if(m.find()) {
            commandType = m.group();
            fullCommand = m.replaceFirst("").trim();
            String[] tokens = fullCommand.split("/by|/at");
            for(int i = 0; i < tokens.length; i++) {
                tokens[i] = tokens[i].trim();
            }
            try {
                return packageCommand(commandType, tokens);
            } catch (DukeException e) {
                throw e;
            }
        } else {
            throw new DukeException("☹ OOPS!!! I'm sorry, but I don't know what that means :-(");
        }
    }
}
