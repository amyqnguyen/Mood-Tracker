package ui;

import model.MoodEntry;
import model.MoodLog;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Scanner;

import persistence.Reader;
import persistence.Writer;

//Mood tracker application
public class TrackerApp {
    private MoodLog userLog;
    private MoodEntry userEntry;
    private Scanner scanner;
    private double amRating;
    private double pmRating;

    private static final String MOODS_FILE = "./data/moodlogs.txt";

    private MoodLog monday;
    private MoodLog tuesday;
    private MoodLog wednesday;
    private MoodLog thrusday;
    private MoodLog friday;
    private MoodLog saturday;
    private MoodLog sunday;


    // EFFECTS: runs the tracker app
    public TrackerApp() {
        scanner = new Scanner(System.in);
        userLog = new MoodLog();
        runTracker();
    }

    // MODIFIES: this
    // EFFECTS: processes user input
    // method adapted from CPSC 210/TellerAPP/2020
    public void runTracker() {
        String option = null;

        loadMoodLog();

        while (true) {
            System.out.println("Please select an option (AM, PM, Save, Print, or Quit):");
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
        System.out.println(userLog);
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
            thrusday = moodLogs.get(3);
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
            writer.write(thrusday);
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
    @SuppressWarnings("checkstyle:MethodLength")
    private void processRating(String time) {
        MoodEntry userEntry = new MoodEntry();
        userEntry.addRatingAM(amRating);
        userEntry.addRatingPM(pmRating);
        userEntry.getTotalAMMood();
        userEntry.getTotalPMMood();
        userEntry.getAverageMood();

        if (time.equals("am")) {
            //System.out.println("Please enter your " + time + " mood:");
            doAmMood();
            scanner.nextLine();
        } else if (time.equals("pm")) {
            //System.out.println("Please enter your " + time + " mood:");
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
        monday = new MoodLog();
        tuesday = new MoodLog();
        wednesday = new MoodLog();
        thrusday = new MoodLog();
        friday = new MoodLog();
        saturday = new MoodLog();
        sunday = new MoodLog();

    }

    private void doAmMood() {
        MoodLog selected = selectMoodLog();
        System.out.println("Please enter your am mood:");
        amRating = scanner.nextInt();
        System.out.println("AM Mood: " + amRating);
        MoodEntry amMoodEntry = new MoodEntry();
        amMoodEntry.addRatingAM(amRating);
        selected.addMoodEntry(amMoodEntry);
        System.out.println(selected);

    }

    private void doPmMood() {
        MoodLog selected = selectMoodLog();
        System.out.println("Please enter your pm mood:");
        pmRating = scanner.nextInt();
        System.out.println("PM Mood: " + pmRating);
        MoodEntry pmMoodEntry = new MoodEntry();
        pmMoodEntry.addRatingPM(pmRating);
        selected.addMoodEntry(pmMoodEntry);
        System.out.println(selected);
    }


    // EFFECTS: prints mood average to the screen
    private void printAverage(MoodEntry entry) {
        System.out.println("Average: " + entry.getAverageMood());
    }

    // EFFECTS: prompts user to select an account and prints account to screen
    private void printMoodLog() {
        MoodLog selected = selectMoodLog();
        System.out.println("Id: " + selected.getId());
        System.out.println("Mood log: " + selected.toString()); //get week day name????
        //printAverage(); ////????
    }

    @SuppressWarnings("checkstyle:MethodLength")
    private MoodLog selectMoodLog() {
        String selection = "";

        while (!(selection.equals("monday") || selection.equals("tuesday") || selection.equals("wednesday") ||
                selection.equals("thrusday") || selection.equals("friday") || selection.equals("saturday") ||
                selection.equals("sunday"))) {
            System.out.println("Select a weekday");
            selection = scanner.next();
            selection = selection.toLowerCase();

        }

        if (selection.equals("monday")) {
            return monday;
        } else if (selection.equals("tuesday")) {
            return tuesday;
        } else if (selection.equals("wednesday")) {
            return wednesday;
        } else if (selection.equals("thrusday")) {
            return thrusday;
        } else if (selection.equals("friday")) {
            return friday;
        } else if (selection.equals("saturday")) {
            return saturday;
        } else {
            return sunday;
        }
    }


    // EFFECTS: creates a mood entry from user input
    // method adapted from CPSC 210/SimpleCalculator/2020
    private void logResult(double amRating, double pmRating) {
        MoodEntry userEntry = new MoodEntry();
        userEntry.addRatingAM(amRating);
        userEntry.addRatingPM(pmRating);
        userEntry.getTotalAMMood();
        userEntry.getTotalPMMood();
        userEntry.getAverageMood();
        userLog.addMoodEntry(userEntry);
    }
}


