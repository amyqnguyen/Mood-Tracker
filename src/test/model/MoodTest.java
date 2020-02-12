package model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MoodTest {
    MoodEntry testMood1;
    MoodEntry testMood2;
    MoodLog testLog1;
    MoodLog testLog2;

    @BeforeEach
    void runBefore() {
        testMood1 = new MoodEntry();
        testMood2 = new MoodEntry();
        testLog1 = new MoodLog();
        testLog2 = new MoodLog();
    }

    @Test
    void testConstructor() { ///????
        testMood1.addRatingAM(4);
        testLog1.addMoodEntry(testMood1);
    }

    @Test
    void testAddAmMood() {
        //one entry
        testMood1.addRatingAM(4);
        assertEquals(4, testMood1.getTotalAMMood());

        //two entry
        testMood2.addRatingAM(10);
        testMood2.addRatingAM(7);
        assertEquals(17, testMood2.getTotalAMMood());
    }

    @Test
    void testGetPmMood() {
        //one entry
        testMood2.addRatingPM(5);
        assertEquals(5, testMood2.getTotalPMMood());

        //two entry
        testMood1.addRatingPM(10);
        testMood1.addRatingPM(7);
        assertEquals(17, testMood1.getTotalPMMood());
    }


    @Test
    void testGetAverageAMRating() {
        //one entry
        testMood1.addRatingAM(4);
        assertEquals(4, testMood1.getTotalAMMood());
        assertEquals(4, testMood1.getAverageMood());


        //two entries
        testMood2.addRatingAM(10);
        testMood2.addRatingPM(7);
        assertEquals(10, testMood2.getTotalAMMood());
        assertEquals(7, testMood2.getTotalPMMood());
        assertEquals((10+7) / 2 , testMood2.getAverageMood());

    }



//    @Test
//    void testAddMoodEntry() {
//        //one entry
//        testMood1.addRatingAM(4);
//        testLog1.addMoodEntry(testMood1);
//        assertEquals(4, testMood1.getTotalAMMood());
//        assertEquals(4, testMood1.getAverageMood());
//
//        //two entry
//        testMood2.addRatingPM(5);
//        testMood2.addRatingAM(7);
//        assertEquals(4, testLog1);
//    }


}
//    @Test
//    void testGetAverageRating() {
//        //one entry
//        testLog1.addMoodEntry(testMood1);
//        assertEquals(4, testMood1.getAMMood());
//        assertEquals(10, testMood1.getPMMood());
//        assertEquals((4 + 10) / 2, testLog1.getMoodAverage());
//
//        //two entries
//        testLog2.addMoodEntry(testMood1);
//        testLog2.addMoodEntry(testMood2);
//        assertEquals((4 + 10 + 5 + 7) / 4, testLog2.getMoodAverage());