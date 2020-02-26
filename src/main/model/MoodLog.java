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

    // EFFECTS: constructs an empty mood log
    public MoodLog(String name, MoodEntry me) {
        //log = ml;
        this.entry = me;
        weekDay = name;
        id = nextAccountId++;
        //entry = new MoodEntry();
    }

    public MoodLog(String weekDay, int id, MoodEntry me) {
        this.weekDay = weekDay;
        //this.am = am;
        //this.pm = pm;
        this.entry = me;
        //nextAccountId = nextId;
        //moodString = ms;
        this.id = id;
        this.average = entry.getAverageMood();

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
        average = entry.getAverageMood();
        return average;
    } ////???

    // MODIFIES: this
    // EFFECTS: adds a mood entry to a mood log where a mood entry is an array of am ratings and/or pm ratings
//    public void addMoodEntry(MoodEntry entry) {
//        log.add(entry);
//    }


    // EFFECTS: returns a string representing the overall mood log
    @Override
    public String toString() {
        return weekDay + " Mood log: " + entry;
    }

    @Override
    public void save(PrintWriter printWriter) {
        //MoodEntry entry = new MoodEntry();

        //printWriter.print(nextAccountId);
        printWriter.print(weekDay);
        printWriter.print(Reader.DELIMITER);
        printWriter.print(id);
        printWriter.print(Reader.DELIMITER);
        printWriter.print(entry.getAmMood());
        printWriter.print(Reader.DELIMITER);
        printWriter.print(entry.getPmMood());
        printWriter.print("\n");
        //printWriter.print(log);
//        printWriter.print(amMood);
//        printWriter.print(Reader.DELIMITER);
//        printWriter.print(pmMood);
//        printWriter.print(Reader.DELIMITER);

//        for (int i = 0; i < log.size(); i++) {
//                printWriter.print(log.get(i).getAmMood());
//                printWriter.print(Reader.DELIMITER);
//                printWriter.print(log.get(i).getPmMood());
//                //printWriter.print(Reader.DELIMITER);
//                printWriter.print("\n");
//            }
//        }


        //printWriter.print("\n");

        //need to change to string in reader
        //printWriter.print(); ///not loading average****


    }
}






