import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;

public class Storage {
    private String filePath;
    private File file;

    public Storage(String filePath){

        this.filePath = filePath;
        file = new File(filePath);

    }

    public ArrayList<String> load() throws DukeException {
        try {
            if (!file.exists()) {
                file.createNewFile();
            }
            ArrayList<String> taskStrings = new ArrayList<String>(100);
            Scanner fileReader = new Scanner(file);
            while (fileReader.hasNext()) {
                taskStrings.add(fileReader.nextLine());
            }
            return taskStrings;
        } catch (IOException e) {
            throw new DukeException("☹ OOPS!!! Errors occurred in loading porcess.");
        }
    }

    public void update(ArrayList<String> taskStrings) throws DukeException {
        try {
            file.delete();
            file.createNewFile();
            PrintWriter writer = new PrintWriter(file);
            for(String line : taskStrings) {
                writer.println(line);
            }
            writer.close();
        } catch (IOException e) {
            throw new DukeException("☹ OOPS!!! Errors occurred when updating storage.");
        }
    }

}
