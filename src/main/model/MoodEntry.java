package model;

import java.util.ArrayList;

public class MoodEntry {
    private ArrayList<Integer> amMood;
    private ArrayList<Integer> pmMood;
    private String time;
    private int totalAMMoodRating;
    private int totalPMMoodRating;
    private int totalAllMoodRating;
    int averageMood;

    public MoodEntry() {
        time = "";
        amMood = new ArrayList<>();
        pmMood = new ArrayList<>();
    }

    public void addRatingAM(Integer amRate) {
        amMood.add(amRate);
    }

    public void addRatingPM(Integer pmRate) {
        pmMood.add(pmRate);
    }

    public int getAverageMood() {
        totalAllMoodRating = totalAMMoodRating + totalPMMoodRating;
        averageMood = totalAllMoodRating / (amMood.size() + pmMood.size());
        return averageMood;
    }

    public int getTotalAMMood() {
        for (int i = 0; i < amMood.size(); i++) {
            totalAMMoodRating += amMood.get(i);
        }
        return totalAMMoodRating;
    }

    public int getTotalPMMood() {
        for (int i = 0; i < pmMood.size(); i++) {
            totalPMMoodRating += pmMood.get(i);
        }
        return totalPMMoodRating;
    }

    public String toString() {
        return "\nOverall AM Mood log: " + amMood + "\nOverall PM Mood log: " + pmMood;
    }


}

