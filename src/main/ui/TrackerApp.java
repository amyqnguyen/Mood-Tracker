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

import Persistence.Reader;
import Persistence.Writer;

//Mood tracker application
public class TrackerApp {
    private MoodLog userLog;
    private MoodEntry userEntry;
    private Scanner scanner;
    private double amRating;
    private double pmRating;

    private static final String MOODS_FILE = "./data/accounts.txt";

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
        String time = null;

        loadMoodLog();

        while (true) {
            System.out.println("Please select an time (AM, PM or Quit):");
            time = scanner.nextLine();
            time = time.toLowerCase();
            System.out.println("You selected: " + time);
            //int rate = Integer.parseInt(scanner.nextLine());

            if (time.equals("quit")) {
                break;
            } else {
                processRating(time);
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
            List<MoodLog> accounts = Reader.readMoods(new File(MOODS_FILE));
            //cheq = accounts.get(0);
            //sav = accounts.get(1);
        } catch (IOException e) {
            MoodLog newLog = new MoodLog();
            //init(); ////multiple mood logs????
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
            System.out.println("Please enter your " + time + " mood:");
            amRating = scanner.nextInt();
            System.out.println("AM Mood: " + amRating);
            scanner.nextLine();
        } else if (time.equals("pm")) {
            System.out.println("Please enter your " + time + " mood:");
            pmRating = scanner.nextInt();
            System.out.println("PM Mood: " + pmRating);
            scanner.nextLine();
        } else if (time.equals("average")) { ///????
            printAverage(userEntry);
        } else if (time.equals("save")) {
            saveMoodLogs();
        } else if (time.equals("print")) {
            printMoodLog();
        } else {
            System.out.println("Selection not valid.");
        }
        logResult(amRating, pmRating);
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
            System.out.println(selection + " mood log: ");
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


