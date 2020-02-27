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
// Class adapted from CPSC 210/TellerAPP/2020
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
            //issue
            moodLogs.add(parseMood(lineComponents));
        }
        return moodLogs;
    }

    // EFFECTS: returns a list of strings obtained by splitting line on DELIMITER
    private static ArrayList<String> splitString(String line) {
        String[] splits = line.split(DELIMITER);
        return new ArrayList<>(Arrays.asList(splits));
    }

    // REQUIRES: components has size 4 where element 0 represents the name of the week day
    // of the mood log, element 1 represents the id, element 2 is the am mood to
    // be used to construct a new mood entry, element 3 is the pm mood to be used to
    // construct a new mood entry
    // EFFECTS: returns an mood log constructed from components
    private static MoodLog parseMood(List<String> components) {
        String weekDay = components.get(0);
        int id = Integer.parseInt(components.get(1));
        double ratingAM  = Double.parseDouble(components.get(2));
        double ratingPM = Double.parseDouble(components.get(3));
        MoodEntry me = new MoodEntry(ratingAM, ratingPM);
        return new MoodLog(weekDay, id, me);
    }
}
