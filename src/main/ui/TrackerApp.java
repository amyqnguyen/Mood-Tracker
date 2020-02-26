package ui;

import model.MoodEntry;
import model.MoodLog;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import persistence.Reader;
import persistence.Writer;

//Mood tracker application
public class TrackerApp {
    private static final String MOODS_FILE = "./data/moods.txt";
    //private final int nextId;

    private MoodLog userLog;
    private MoodEntry userEntry;
    private Scanner scanner;
    private double amRating;
    private double pmRating;
    private String weekDay;
    private static int nextId;  // tracks id of next account created
    private int id;                        // account id
    private Double am;
    private Double pm;

    //ArrayList<MoodEntry> a = new ArrayList<MoodEntry>();

    private MoodLog monday;
    private MoodLog tuesday;
    private MoodLog wednesday;
    private MoodLog thursday;
    private MoodLog friday;
    private MoodLog saturday;
    private MoodLog sunday;


    // EFFECTS: runs the tracker app
    public TrackerApp() {
        scanner = new Scanner(System.in);
        userLog = new MoodLog(null, userEntry);
        runTracker();
    }

    // MODIFIES: this
    // EFFECTS: processes user input
    // method adapted from CPSC 210/TellerAPP/2020
    public void runTracker() {
        String option = null;

        loadMoodLog();

        while (true) {
            System.out.println("Please select an option (AM, PM, Average, Save, Print, or Quit):");
            option = scanner.next();
            option = option.toLowerCase();
            System.out.println("You selected: " + option);
            //int rate = Integer.parseInt(scanner.nextLine());

            if (option.equals("quit")) {
                break;
            } else {
                processRating(option);
            }
        }
        System.out.println("Current Mood log: AM-" + amRating + ", PM-" + pmRating); //???
        //System.out.println(userLog);
        //printAverage(userLog); //???
    }

    // MODIFIES: this
    // EFFECTS: loads accounts from MOOD_FILE, if that file exists;
    // otherwise initializes accounts with default values
    private void loadMoodLog() {
        try {
            List<MoodLog> moodLogs = Reader.readMoods(new File(MOODS_FILE));
            monday = moodLogs.get(0);
            tuesday = moodLogs.get(1);
            wednesday = moodLogs.get(2);
            thursday = moodLogs.get(3);
            friday = moodLogs.get(4);
            saturday = moodLogs.get(5);
            sunday = moodLogs.get(6);
        } catch (IOException e) {
            //MoodLog newLog = new MoodLog();
            init(); ////multiple mood logs????
        }
    }

    // EFFECTS: saves state of moods to MOODS_FILE
    private void saveMoodLogs() {
        try {
            Writer writer = new Writer(new File(MOODS_FILE));
            writer.write(monday);
            writer.write(tuesday);
            writer.write(wednesday);
            writer.write(thursday);
            writer.write(friday);
            writer.write(saturday);
            writer.write(sunday);
            writer.close();
            System.out.println("Mood logs saved to file " + MOODS_FILE);
        } catch (FileNotFoundException e) {
            System.out.println("Unable to save mood logs to " + MOODS_FILE);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            // this is due to a programming error
        }
    }

    // MODIFIES: this
    // EFFECTS: processes user command
    // method adapted from CPSC 210/TellerAPP/2020
    //        userEntry.getPmMood();
//        userEntry.getAmMood();
//        userEntry.setAMmood(amRating);
//        userEntry.setPMmood(pmRating);
    private void processRating(String time) {
        MoodEntry userEntry = new MoodEntry(amRating, pmRating);;
        userEntry.getAverageMood();

        if (time.equals("am")) {
            doAmMood();
            scanner.nextLine();
        } else if (time.equals("pm")) {
            doPmMood();
            scanner.nextLine();
        } else if (time.equals("average")) { ///????
            printAverage(userEntry);
            scanner.nextLine();
        } else if (time.equals("save")) {
            saveMoodLogs();
            scanner.nextLine();
        } else if (time.equals("print")) {
            printMoodLog();
            scanner.nextLine();
        } else {
            System.out.println("Selection not valid.");
        }
        logResult(amRating, pmRating);
    }

    private void init() {
        monday = new MoodLog("Monday", new MoodEntry(0.0,0.0));
        tuesday = new MoodLog("Tuesday", new MoodEntry(0.0,0.0));
        wednesday = new MoodLog("Wednesday", new MoodEntry(0.0,0.0));
        thursday = new MoodLog("Thursday", new MoodEntry(0.0,0.0));
        friday = new MoodLog("Friday", new MoodEntry(0.0,0.0));
        saturday = new MoodLog("Saturday", new MoodEntry(0.0,0.0));
        sunday = new MoodLog("Sunday", new MoodEntry(0.0,0.0));
    }

    private void doAmMood() {
        MoodLog selected = selectMoodLog();
        System.out.println("Please enter your am mood:");
        amRating = scanner.nextInt();
        System.out.println("AM Mood: " + amRating);
        //userEntry.setAMmood(amRating);
        MoodEntry entry = new MoodEntry(amRating, pmRating);
        entry.setAMmood(amRating);
        //entry.addRatingAM(amRating);
        //selected.addMoodEntry(entry);
        //System.out.println(selected);

    }

    private void doPmMood() {
        MoodLog selected = selectMoodLog();
        System.out.println("Please enter your pm mood:");
        pmRating = scanner.nextInt();
        System.out.println("PM Mood: " + pmRating);
        //userEntry.setPMmood(pmRating);
        MoodEntry entry = new MoodEntry(amRating, pmRating);
        //entry.setAMmood(amRating);
        entry.setPMmood(pmRating);

        //entry.addRatingPM(pmRating);
        //selected.addMoodEntry(entry);
        //System.out.println(selected);
    }


    // EFFECTS: prints mood average to the screen
    private void printAverage(MoodEntry entry) {
        double average = entry.getAverageMood();
        System.out.println("Average: " + average);
    }

    @SuppressWarnings("checkstyle:MethodLength")
    private MoodLog selectMoodLog() {
        String weekDay = "";

        while (!(weekDay.equals("monday") || weekDay.equals("tuesday") || weekDay.equals("wednesday")
                || weekDay.equals("thursday") || weekDay.equals("friday") || weekDay.equals("saturday")
                || weekDay.equals("sunday"))) {
            System.out.println("Select a weekday");
            weekDay = scanner.next();
            weekDay = weekDay.toLowerCase();


        }

        if (weekDay.equals("monday")) {
            return monday = new MoodLog("Monday", new MoodEntry(amRating, pmRating));
        } else if (weekDay.equals("tuesday")) {
            return tuesday = new MoodLog("Tuesday", new MoodEntry(amRating, pmRating));
        } else if (weekDay.equals("wednesday")) {
            return wednesday =  new MoodLog("Wednesday", new MoodEntry(amRating, pmRating));
        } else if (weekDay.equals("thursday")) {
            return thursday = new MoodLog("Thursday", new MoodEntry(amRating, pmRating));
        } else if (weekDay.equals("friday")) {
            return friday = new MoodLog("Friday", new MoodEntry(amRating, pmRating));
        } else if (weekDay.equals("saturday")) {
            return saturday = new MoodLog("Saturday", new MoodEntry(amRating, pmRating));
        } else {
            return sunday = new MoodLog("Sunday", new MoodEntry(amRating, pmRating));
        }
    }

    // EFFECTS: prompts user to select an account and prints account to screen
    private void printMoodLog() {
        MoodLog selected = selectMoodLog();
        System.out.println("Id: " + selected.getId());
        System.out.println(selected.toString()); //get week day name????
        //printAverage(); ////????
    }


    // EFFECTS: creates a mood entry from user input
    // method adapted from CPSC 210/SimpleCalculator/2020
    private void logResult(double amRating, double pmRating) {
        MoodEntry userEntry = new MoodEntry(amRating, pmRating);
        //userEntry.addRatingAM(amRating);
        //userEntry.addRatingPM(pmRating);
        //userEntry.getTotalAMMood();
        //userEntry.getTotalPMMood();
        userEntry.getAmMood();
        userEntry.getPmMood();
        userEntry.getAverageMood();
        userEntry.setAMmood(amRating);
        userEntry.setPMmood(pmRating);
        //userLog.addMoodEntry(userEntry);
    }
}


