package model;

import java.util.ArrayList;


//Represents an mood log which is an array of mood entries
public class MoodLog {
    ArrayList<MoodEntry> log;

    // EFFECTS: constructs an empty mood log
    public MoodLog() {
        log = new ArrayList<>();
    }

    // MODIFIES: this
    // EFFECTS: adds a mood entry to a mood log where a mood entry is an array of am ratings and/or pm ratings
    public void addMoodEntry(MoodEntry entry) {
        log.add(entry);
    }

    // EFFECTS: returns a string representing the overall mood log
    public String toString() {
        return "Mood log: " + log;
    }
}

