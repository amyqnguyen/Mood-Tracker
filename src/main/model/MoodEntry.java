package model;

import java.util.ArrayList;

public class MoodEntry {
    private String time;
    private ArrayList<Integer> ratings;
    private int rating;
    private int averageRating;
    private int inputCount;
    private int sumPMRating = 0;
    private int sumAMRating = 0;

    public MoodEntry() {
        time = "";
        ratings = new ArrayList<>();
        rating = 0;
    }

    public void setTime(String time) { this.time = time; }

    public void addRatingAM(Integer amRate) {
        inputCount++;
        ratings.add(amRate);
        sumAMRating += amRate;
    }

    public void addRatingPM(Integer pmRate) {
        inputCount++;
        ratings.add(pmRate);
        sumPMRating += pmRate;
    }

    public int getAverageRating() {
        averageRating = (sumAMRating + sumPMRating) / inputCount;
        return averageRating;
    }

    //????
    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public String toString() {
        return  time + " rating" + " equals " + rating;
    }

}

