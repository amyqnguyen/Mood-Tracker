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

    // EFFECTS: constructs an empty am and pm mood entry having a list of doubles
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
    // EFFECTS: returns the average of all mood entries
    public double getAverageMood() {
        totalAllMoodRating = totalAMMoodRating + totalPMMoodRating;
        averageMood = totalAllMoodRating / (amMood.size() + pmMood.size());
        return averageMood;
    }

    // EFFECTS: returns sum of all am mood entries
    public double getTotalAMMood() {
        for (int i = 0; i < amMood.size(); i++) {
            totalAMMoodRating += amMood.get(i);
        }
        return totalAMMoodRating;
    }

    // EFFECTS: returns sum of all pm mood entries
    public double getTotalPMMood() {
        for (int i = 0; i < pmMood.size(); i++) {
            totalPMMoodRating += pmMood.get(i);
        }
        return totalPMMoodRating;
    }

    // EFFECTS: returns a string representing the overall am and pm mood entries
    public String toString() {
        return "\nOverall AM Mood log: " + amMood + "\nOverall PM Mood log: " + pmMood;
    }


}

