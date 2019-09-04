package parser;

import exception.DukeException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeParser {
    private static SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy HHmm") ;

    public static Date parse(String timeStr) throws DukeException {
        try {
            return sdf.parse(timeStr);
        } catch (ParseException e) {
            throw new DukeException("☹ OOPS!!! Incorrect time format.");
        }
    }
    
}
