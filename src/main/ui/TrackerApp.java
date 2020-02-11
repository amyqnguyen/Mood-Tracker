package ui;

import model.MoodEntry;
import java.util.ArrayList;
import java.util.Scanner;

//Mood tracker application
public class TrackerApp {
    private ArrayList<MoodEntry> userLog;
    private Scanner scanner;

    // EFFECTS:
    public TrackerApp() {
        userLog = new ArrayList<>();
        scanner = new Scanner(System.in);
        runTracker();
    }

    public void runTracker() {
        String time = "";

        while (true) {
            System.out.println("Please select an time (AM, PM or Quit):");
            time = scanner.nextLine();
            System.out.println("You selected: " + time);

            if (time.equals("quit")) {
                break;
            }
            int rating = processRating(time);
            System.out.println("Mood rating: " + rating);
        }
        System.out.println("Mood log: " + userLog);
    }

    private int processRating(String time) {
        int rating = 0;
        System.out.println("Please enter your " + time + " mood:");
        int rate = scanner.nextInt();
        scanner.nextLine();
        //int rate = Integer.parseInt(scanner.nextLine());

        if (time.equals("AM") || time.equals("PM")) {
            rating = rate;
        }

        logResult(time, rate, rating);

        return rate;
    }

    private void logResult(String time, int rate, int rating) {
        MoodEntry moodEntry = new MoodEntry();
        moodEntry.setTime(time);
        moodEntry.addRatingAM(rate);
        moodEntry.addRatingPM(rate);
        moodEntry.setRating(rating);
        userLog.add(moodEntry);
    }


}