package model;



@SuppressWarnings("checkstyle:RightCurly")
public class MoodEntry {
    //private ArrayList<Integer> ratings;
    //private String time;
//    private int averageRating;
//    private int inputCount;
//    private int sumPMRating = 0;
//    private int sumAMRating = 0;
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

//    public int getAverageRating() {
//        averageRating = (sumAMRating + sumPMRating) / inputCount;
//        return averageRating;
//    }



}

