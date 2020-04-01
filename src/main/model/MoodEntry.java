package model;


//Represents a mood entry in a mood log that can be an AM or PM mood entry
public class MoodEntry {
    private Double amMood;
    private Double pmMood;

    // EFFECTS: constructs an empty am and pm mood entry having a list of doubles
    public MoodEntry(Double am, Double pm) {
        this.amMood = am;
        this.pmMood = pm;
    }

    public Double getAmMood() {
        return amMood;
    }

    public Double getPmMood() {
        return pmMood;
    }

    public Double setAMmood(Double am) {
        amMood = am;
        return am;
    }

    public Double setPMmood(Double pm) {
        pmMood = pm;
        return pm;
    }

    // REQUIRES: amMood and pmMood to be non-zero
    // EFFECTS: returns average of a mood entry
    public Double averageMoodEntry() {
        Double average = (amMood + pmMood) / 2;
        return average;
    }


    // EFFECTS: returns a string representing the overall am and pm mood entries
    public String toString() {
        return "AM Mood log: " + amMood + ", PM Mood log: " + pmMood + " \n";
        //"\nOverall AM Mood log: " + amMood + "\nOverall PM Mood log: " + pmMood;
    }


}






