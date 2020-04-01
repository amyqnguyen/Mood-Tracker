package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

//Represents a MoodLogs which is a map where mood logs can be added
public class MoodLogs {
    private Map<String, ArrayList<MoodLog>> moodLogs;

    //EFFECTS: creates a moodLogs with a hashmap
    public MoodLogs() {
        moodLogs = new HashMap<>();

        addWeekName("Monday");
        addWeekName("Tuesday");
        addWeekName("Wednesday");
        addWeekName("Thursday");
        addWeekName("Friday");
        addWeekName("Saturday");
        addWeekName("Sunday");
    }

    //EFFECTS: adds week name to map
    public void addWeekName(String weekDay) {
        moodLogs.put(weekDay,new ArrayList<>());
    }

    //EFFECTS: adds a mood log to the map's array list
    public void addMoodLog(String weekDay, MoodLog log) {
        ArrayList<MoodLog> logs = moodLogs.get(weekDay);
        logs.add(log);
    }

    //EFFECTS: prints all the mood logs in the map
    public String printMapLogs(String weekDay) {
        ArrayList<MoodLog> logs = moodLogs.get(weekDay);
        String output = "";
        for (MoodLog log : logs) {
            output += String.format("%s", log);
        }
        return output;
    }
}
