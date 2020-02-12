package model;

import java.util.ArrayList;

//Represents a mood entry in a mood log that can be an AM or PM mood entry
public class MoodEntry {
    private ArrayList<Double> amMood;
    private ArrayList<Double> pmMood;
    private double totalAMMoodRating;
    private double totalPMMoodRating;
    private double totalAllMoodRating;
    private double averageMood;

    public MoodEntry() {
        amMood = new ArrayList<>();
        pmMood = new ArrayList<>();
    }

    // REQUIRES: amRate > 0.0
    // MODIFIES: this
    // EFFECTS: adds rating to amMood list
    public void addRatingAM(Double amRate) {
        amMood.add(amRate);
    }

    // REQUIRES: pmRate > 0.0
    // MODIFIES: this
    // EFFECTS: adds rating to pmMood list
    public void addRatingPM(Double pmRate) {
        pmMood.add(pmRate);
    }

    // MODIFIES: this
    // EFFECTS: adds rating to amMood
    public double getAverageMood() {
        totalAllMoodRating = totalAMMoodRating + totalPMMoodRating;
        averageMood = totalAllMoodRating / (amMood.size() + pmMood.size());
        return averageMood;
    }

    public double getTotalAMMood() {
        for (int i = 0; i < amMood.size(); i++) {
            totalAMMoodRating += amMood.get(i);
        }
        return totalAMMoodRating;
    }

    public double getTotalPMMood() {
        for (int i = 0; i < pmMood.size(); i++) {
            totalPMMoodRating += pmMood.get(i);
        }
        return totalPMMoodRating;
    }

    public String toString() {
        return "\nOverall AM Mood log: " + amMood + "\nOverall PM Mood log: " + pmMood;
    }


}

