package ui;

import model.MoodEntry;
import model.MoodLog;

import java.util.ArrayList;
import java.util.Scanner;

//Mood tracker application
public class TrackerApp {
    private MoodLog userLog;
    private MoodEntry userEntry;
    private Scanner scanner;
    private double amRating;
    private double pmRating;

    // EFFECTS: runs the tracker app
    public TrackerApp() {
        scanner = new Scanner(System.in);
        userLog = new MoodLog();
        runTracker();
    }

    // MODIFIES: this
    // EFFECTS: processes user input
    public void runTracker() {
        String time = null;

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
    // EFFECTS: processes user command
    private void processRating(String time) {
        MoodEntry userEntry = new MoodEntry();
        userEntry.addRatingAM(amRating);
        userEntry.addRatingPM(pmRating);
        userEntry.getTotalAMMood();
        userEntry.getTotalPMMood();
        userEntry.getAverageMood();
        //userLog.addMoodEntry(userEntry);

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
            //userEntry.getAverageMood();
        } else {
            System.out.println("Selection not valid.");
        }

        logResult(amRating, pmRating);
    }

    // EFFECTS: prints mood average to the screen
    private void printAverage(MoodEntry entry) {
        System.out.println("Average: " + entry.getAverageMood());
    }

    // EFFECTS: creates a mood entry from user input
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


