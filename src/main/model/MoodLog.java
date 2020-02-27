package model;

import java.io.PrintWriter;
import java.util.ArrayList;

import persistence.Reader;
import persistence.Saveable;

//ABSTRACT CLASS?????

//Represents an mood log which is an array of mood entries
public class MoodLog implements Saveable {
    private static int nextAccountId = 1;  // tracks id of next account created
    private String weekDay;
    private int id;                        // account id
    private Double am;
    private Double pm;
    private double average;                // the current average of the account
    private MoodEntry entry;
    private String moodString;

    ArrayList<MoodEntry> log;

    // REQUIRES: name has a non-zero length and has a valid mood entry
    // EFFECTS: weekDay on mood log is set to name; mood log id is a positive
    // integer not assigned to any other mood log; mood entry in mood log is set to me
    public MoodLog(String name, MoodEntry me) {
        this.entry = me;
        weekDay = name;
        id = nextAccountId++;
    }

    // REQUIRES: weekDay has a non-zero length, id >=1, and mood entry is valid
    // EFFECTS: weekDay on mood log is set to name; mood log id is a positive
    //    // integer not assigned to any other mood log; mood entry in mood log is set to me
    public MoodLog(String weekDay, int id, MoodEntry me) {
        this.weekDay = weekDay;
        this.entry = me;
        this.id = id;
    }

    public int getId() {
        return id;
    } ///????

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
        printWriter.print(id);
        printWriter.print(Reader.DELIMITER);
        printWriter.print(entry.getAmMood());
        printWriter.print(Reader.DELIMITER);
        printWriter.print(entry.getPmMood());
        printWriter.print("\n");
    }
}






