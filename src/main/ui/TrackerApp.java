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
    private int amRating;
    private int pmRating;

    // EFFECTS:
    public TrackerApp() {
        scanner = new Scanner(System.in);
        userLog = new MoodLog();
        runTracker();
    }

    public void runTracker() {
        String time = null;

        //initialize();

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

    private void processRating(String time) {
        //amRating = 0;
        //pmRating = 0;
        //scanner.nextLine();

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
            userEntry.getAverageMood();
            scanner.nextLine();
        } else {
            System.out.println("Selection not valid.");
        }
        //MoodEntry userEntry = new MoodEntry(amRating, pmRating);
        //userLog.addMoodEntry(userEntry);

        logResult(amRating, pmRating);
        //printAverage(userLog);
    }

//    private void initialize() {
//        userEntry = new MoodEntry(0, 0);
//        scanner = new Scanner(System.in);
//    }

    private void logResult(int amRating, int pmRating) {
        MoodEntry userEntry = new MoodEntry();
        userEntry.addRatingAM(amRating);
        userEntry.addRatingPM(pmRating);
        userEntry.getTotalAMMood();
        userEntry.getTotalPMMood();
        userEntry.getAverageMood();
        userLog.addMoodEntry(userEntry);
    }
}

//    private MoodLog selectMoodEntry() {
//        String time = "";
//
//        while (!(time.equals("am") || time.equals("pm"))) {
//            System.out.println("Get AM or PM mood.");
//            time = scanner.next();
//            time = time.toLowerCase();
//        }
//        if (time.equals("am")) {
//            return userLog;
//        }
//    }


//    private void printAverage(MoodLog userLog) {
//        //String time = "";
//        System.out.println("Mood log: " + userLog.getMoodAverage());
//        //System.out.println(time + "");
//    }