package model;

import java.io.PrintWriter;
import java.util.ArrayList;

import persistence.Reader;
import persistence.Saveable;



//Represents an mood log which is an array of mood entries
public class MoodLog implements Saveable {
    private static int nextAccountId = 1;  // tracks id of next account created
    private int id;                        // account id
    private String name;                   // the account owner name
    private double average;                // the current average of the account

    ArrayList<MoodEntry> log;

    // EFFECTS: constructs an empty mood log
    public MoodLog() {
        log = new ArrayList<>();
        id = nextAccountId++;
    }

    public MoodLog(int nextId, int id, double average) {
        nextAccountId = nextId;
        this.id = id;
        this.average = average;

    }

    public int getId() {
        return id;
    } ///????

    public String getName() {
        return name;
    } ///????

    public double getAverage(MoodEntry entry) {
        return entry.getAverageMood();
    } ////???

    // MODIFIES: this
    // EFFECTS: adds a mood entry to a mood log where a mood entry is an array of am ratings and/or pm ratings
    public void addMoodEntry(MoodEntry entry) {
        log.add(entry);
    }

    // EFFECTS: returns a string representing the overall mood log
    @Override
    public String toString() {
        return "Mood log: " + log;
    }

    @Override
    public void save(PrintWriter printWriter) {
        printWriter.print(nextAccountId);
        printWriter.print(Reader.DELIMITER);
        printWriter.print(id);
        printWriter.print(Reader.DELIMITER);
        printWriter.print(average);


    }


}

