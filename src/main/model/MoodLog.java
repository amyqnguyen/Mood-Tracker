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
    private MoodEntry entry;

    ArrayList<MoodEntry> log;

    // EFFECTS: constructs an empty mood log
    public MoodLog() {
        log = new ArrayList<>();
        id = nextAccountId++;
        entry = new MoodEntry();
    }

    public MoodLog(int nextId, int id, double average) {
        nextAccountId = nextId;
        this.id = id;
        this.average = entry.getAverageMood();

    }

    public int getId() {
        return id;
    } ///????

    //public String getName() {return name;} ///????

    public double getAverageMoodLog() {
        average = entry.getAverageMood();
        return average;
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
        //MoodEntry entry = new MoodEntry();

        printWriter.print(nextAccountId);
        printWriter.print(Reader.DELIMITER);
        printWriter.print(id);
        printWriter.print(Reader.DELIMITER);
        printWriter.print(log); //need to change to string in reader
        printWriter.print(entry.getAverageMood()); ///not loading average****



    }


}

