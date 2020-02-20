package persistence;

import model.MoodEntry;
import model.MoodLog;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// A reader that can read mood log data from a file
public class Reader {
    public static final String DELIMITER = ",";

    // EFFECTS: returns a list of mood logs parsed from file; throws
    // IOException if an exception is raised when opening / reading from file
    public static List<MoodLog> readMoods(File file) throws IOException {
        List<String> fileContent = readFile(file);
        return parseContent(fileContent);
    }

    // EFFECTS: returns content of file as a list of strings, each string
    // containing the content of one row of the file
    private static List<String> readFile(File file) throws IOException {
        return Files.readAllLines(file.toPath());
    }

    // EFFECTS: returns a list of mood logs parsed from list of strings
    // where each string contains data for one mood log
    private static List<MoodLog> parseContent(List<String> fileContent) {
        List<MoodLog> moodLogs = new ArrayList<>();

        for (String line : fileContent) {
            ArrayList<String> lineComponents = splitString(line);
            moodLogs.add(parseMood(lineComponents));
        }
        return moodLogs;
    }

    private static ArrayList<String> splitString(String line) {
        String[] splits = line.split(DELIMITER);
        return new ArrayList<>(Arrays.asList(splits));
    }

    private static MoodLog parseMood(List<String> components) {
        int nextId = Integer.parseInt(components.get(0));
        int id = Integer.parseInt(components.get(1));
        //ArrayList<MoodEntry> amMoods = ArrayList.parseArrayList(components.get(2));
        double average = Double.parseDouble(components.get(2));
        return new MoodLog(nextId, id, average);
    }
}
