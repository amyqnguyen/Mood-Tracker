package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MoodLogs {
    private Map<String, ArrayList<MoodLog>> moodLogs;

    public MoodLogs() {
        moodLogs = new HashMap<>();
    }

    public void addWeekName(String weekDay) {
        moodLogs.put(weekDay,new ArrayList<>());
    }

    public void addMoodLog(String weekDay, MoodLog log) {
        //check log getname = weekday???
        ArrayList<MoodLog> logs = moodLogs.get(weekDay);
        logs.add(log);
    }

    public String printMapLogs(String weekDay) {
        ArrayList<MoodLog> logs = moodLogs.get(weekDay);
        String output = "";
        for (MoodLog log : logs) {
            output += String.format("%s", log);
        }
        return output;
    }
}
