package model;

public class MoodEntry {
    private int amMood;
    private int pmMood;

    public MoodEntry(int amMood, int pmMood) {
        this.amMood = amMood;
        this.pmMood = pmMood;
    }

    public int getAMMood() {
        return amMood;
    }

    public int getPMMood() {
        return pmMood;
    }

//    public void addRatingAM(Integer amRate) {
//        inputCount++;
//        //ratings.add(amRate);
//        sumAMRating += amRate;
//    }
//
//    public void addRatingPM(Integer pmRate) {
//        inputCount++;
//        //ratings.add(pmRate);
//        sumPMRating += pmRate;
//    }

}

