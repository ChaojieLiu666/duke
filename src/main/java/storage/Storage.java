package storage;

import exception.DukeException;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;

/**
 * Represents the storage of Duke.
 * Stores the content of taskList of Duke in a text file.
 */
public class Storage {
    private File file;

    /**
     * Constructs the storage with given filePath of text file storing the data.
     *
     * @param filePath The filePath of the storage text file.
     */
    public Storage(String filePath){
        file = new File(filePath);
    }

    /**
     * Creates new storage file if no file exists yet.
     * Reads all strings representing tasks in storage format in the file and
     * returns the list of strings.
     * Works as the parameter of the constructor of <code>taskList</code>.
     *
     * @return List of information of stored tasks in storage format.
     * @throws DukeException If errors occur in loading process.
     */
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
            throw new DukeException("☹ OOPS!!! Errors occurred in loading process.");
        }
    }

    /**
     * Updates the storage text file by replacing original content
     * with the given list of strings representing tasks.
     *
     * @param taskStrings List of strings representing tasks in storage format.
     * @throws DukeException If errors occur when updating storage.
     */
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
