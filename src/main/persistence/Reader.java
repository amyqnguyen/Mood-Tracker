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
            //System.out.println(lineComponents);
//            System.out.println(lineComponents.get(0));
//            System.out.println(lineComponents.get(1));
//            System.out.println(lineComponents.get(2));
//            System.out.println(lineComponents.get(3));
            //issue
            moodLogs.add(parseMood(lineComponents));
        }
        return moodLogs;
    }

    private static ArrayList<String> splitString(String line) {
        String[] splits = line.split(DELIMITER);
        return new ArrayList<>(Arrays.asList(splits));
    }

//    private static MoodEntry createMoodEntry() {
//        for (int i = 0; i < string.size(); i++) {
//    }

    private static MoodLog parseMood(List<String> components) {
        //int nextId = Integer.parseInt(components.get(0));
        String weekDay = components.get(0);
        int id = Integer.parseInt(components.get(1));
        double ratingAM  = Double.parseDouble(components.get(2));
        double ratingPM = Double.parseDouble(components.get(3));
        MoodEntry me = new MoodEntry(ratingAM, ratingPM);
        //ArrayList<MoodEntry> log = new ArrayList<MoodEntry>();
        //log.add(me);
        return new MoodLog(weekDay, id, me);

        //Double am = Double.parseDouble(components.get(2));
        //Double pm = Double.parseDouble(components.get(3));
        //ArrayList<MoodEntry> ml =
        //String ms = Arrays.toString(new String[]{components.get(2)});
        //double average = Double.parseDouble(components.get(2));

    }
}
