package model;

import java.util.ArrayList;

public class MoodLog {
    ArrayList<MoodEntry> log;

    public MoodLog() {
        log = new ArrayList<>();
    }

    public void addMoodEntry(MoodEntry entry) {
        log.add(entry);
    }

    public String toString() {
        return "Mood log: " + log;
    }
}

