package ui;

import model.MoodEntry;
import model.MoodLog;

import java.util.Scanner;

//Mood tracker application
public class TrackerApp {
    private MoodLog userLog;
    private MoodEntry userEntry;
    private Scanner scanner;
    private String time;
    private int amRating;
    private int pmRating;

    // EFFECTS:
    public TrackerApp() {
        //userLog = new ArrayList<>();
        scanner = new Scanner(System.in);
        runTracker();
    }

    public void runTracker() {
        Boolean keeprunning = true;
        String time = null;

        initialize();

        while (keeprunning) {
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
        //System.out.println("Mood rating: " + rating);

        System.out.println("Mood log: " + userLog); //???
        //printAverage(userLog); //???
    }

    private void processRating(String time) {
        amRating = 0;
        pmRating = 0;
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
            userLog.getMoodAverage();
            printAverage(userLog);
            scanner.nextLine();
        } else {
            System.out.println("Selection not valid.");
        }
        //??MoodEntry userEntry = new MoodEntry(amRating, pmRating);
        //???userLog.addMoodEntry(userEntry);
        //logResult(amRating, pmRating);
    }
    //printLogResult(userLog);
    //logResult(time, rate, rating);

    //return rate;

    private void initialize() {
        userEntry = new MoodEntry(0, 0);
        scanner = new Scanner(System.in);
    }


    private void printAverage(MoodLog userLog) {
        System.out.println("Mood log: " + userLog.getMoodAverage());
        System.out.println(time + "");
    }
}





//    private void logResult(int amRating, int pmRating) {
//        MoodEntry moodEntry = new MoodEntry(amRating, pmRating);
////        MoodLog.setTime(time);
////        moodEntry.getAMMood();
////        moodEntry.getPMMood();
////        //MoodLog.setRating(rating);
//        userLog.addMoodEntry(moodEntry);
//    }
//}