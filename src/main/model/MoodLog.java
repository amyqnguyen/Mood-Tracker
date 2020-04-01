package model;

import java.io.PrintWriter;

import persistence.Reader;
import persistence.Saveable;


//Represents an mood log which is an string and a mood entry
public class MoodLog implements Saveable {
    private String weekDay;
    private double average;                // the current average of the account
    private MoodEntry entry;


    // REQUIRES: name has a non-zero length and has a valid mood entry
    // EFFECTS: weekDay on mood log is set to name; mood log id is a positive
    // integer not assigned to any other mood log; mood entry in mood log is set to me
    public MoodLog(String name, MoodEntry me) {
        this.entry = me;
        weekDay = name;
        //id = nextAccountId++;
    }

    public String getName() {
        return weekDay;
    } ///????

    public String setName(String name) {
        weekDay = name;
        return name;
    }

    public MoodEntry getMoodEntry() {
        return entry;
    } ///????

    public void setAmMoodEntry(Double am) {
        entry.setAMmood(am);
    }

    public void setPmMoodEntry(Double pm) {
        entry.setPMmood(pm);
    }

    public double getAverageMoodLog() {
        average = entry.averageMoodEntry();
        return average;
    }


    // EFFECTS: returns a string representing the overall mood log for the week day
    @Override
    public String toString() {
        return weekDay + " Mood log: " + entry;
    }

    @Override
    public void save(PrintWriter printWriter) {
        printWriter.print(weekDay);
        printWriter.print(Reader.DELIMITER);
        printWriter.print(entry.getAmMood());
        printWriter.print(Reader.DELIMITER);
        printWriter.print(entry.getPmMood());
        printWriter.print("\n");
    }
}






