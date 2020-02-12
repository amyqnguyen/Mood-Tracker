package model;

import com.sun.xml.internal.ws.resources.UtilMessages;

import java.util.ArrayList;

public class MoodLog {
    private ArrayList<MoodEntry> log;
    private int totalAMMoodRating;
    private int totalPMMoodRating;
    private int totalAllMoodRating;
    private MoodEntry entry;

    public MoodLog() {
        log = new ArrayList<>();
    }

    public void addMoodEntry(MoodEntry rating) {
        log.add(rating);
    }


    public String toString() {
        return "Mood log: " + log;
    }
}

