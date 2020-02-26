package model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

class MoodTest {
    MoodEntry testMood1;
    MoodEntry testMood2;
    MoodLog testLog1;
    MoodLog testLog2;
    MoodLog testLog3;
    ArrayList amMood1;
    ArrayList pmMood1;

    @BeforeEach
    void runBefore() {
        testMood1 = new MoodEntry(0.0,0.0);
        testMood2 = new MoodEntry(0.0,0.0);
        testLog1 = new MoodLog("Monday", testMood1);
        testLog2 = new MoodLog("Tuesday", testMood2);
        testLog3 = new MoodLog("Wednesday",1, testMood2);
    }

    @Test
    void testConstructorML1() { ///????
        //testMood1.addRatingAM(4.0);
        //testLog1.addMoodEntry(testMood1);
        assertEquals("Monday", testLog1.getName());
        //assertEquals(testMood1, testLog1.getMoodEntry());
    }

    @Test
    void testConstructorML2() {
        assertEquals("Wednesday", testLog3.getName());
        //assertEquals(testMood2, testLog3.getMoodEntry());
        assertEquals(1, testLog3.getId());
    }


    @Test
    void testGetAverageRatingLog() {
        testMood1.setAMmood(3.0);
        testMood1.setPMmood(7.0);
        assertEquals(5.0, testMood1.getAverageMood());

        //one entry
//        testMood1.addRatingAM(4.0);
//        assertEquals(4.0, testMood1.getTotalAMMood());
//        assertEquals(4.0, testMood1.getAverageMood());
//        testMood2.addRatingAM(10.0);
//        testMood2.addRatingPM(7.0);
//        assertEquals(10.0, testMood2.getTotalAMMood());
//        assertEquals(7.0, testMood2.getTotalPMMood());
//        assertEquals((10.0 + 7.0) / 2.0, testMood2.getAverageMood());

    }

    @Test
    void testToStringMoodEntry() {
        testMood2.setAMmood(6.0);
        testMood2.setPMmood(5.0);
        assertEquals("AM Mood log: 6.0, PM Mood log: 5.0 \n" , testMood2.toString());
    }

    @Test
    void testToStringMoodLog() {
        testMood2.setAMmood(6.0);
        testMood2.setPMmood(5.0);
        assertEquals("Tuesday AM Mood log: 6.0, PM Mood log: 5.0 \n" , testLog2.toString());
 }
}

//    @Test
//    void testAddAmMood() {
//        //one entry
//        testMood1.addRatingAM(4.0);
//        assertEquals(4.0, testMood1.getTotalAMMood());
//
//        //two entry
//        testMood2.addRatingAM(10.0);
//        testMood2.addRatingAM(7.0);
//        assertEquals(17.0, testMood2.getTotalAMMood());
//    }
//
//    @Test
//    void testAddPmMood() {
//        //one entry
//        testMood2.addRatingPM(5.0);
//        assertEquals(5.0, testMood2.getTotalPMMood());
//
//        //two entry
//        testMood1.addRatingPM(10.0);
//        testMood1.addRatingPM(7.0);
//        assertEquals(17.0, testMood1.getTotalPMMood());
//    }
//
//    @Test
//    void testGetTotalAMMood() {
//        testMood2.addRatingAM(8.0);
//        testMood2.addRatingAM(6.0);
//        assertEquals(14.0, testMood2.getTotalAMMood());
//    }
//
//    @Test
//    void testGetTotalPMMood() {
//        testMood2.addRatingPM(7.0);
//        testMood2.addRatingPM(3.0);
//        assertEquals(10.0, testMood2.getTotalPMMood());
//    }
//
//    @Test
//    void testAddMoodEntry() {
//        testMood2.addRatingPM(6.0);
//        testLog1.addMoodEntry(testMood2);
//        assertEquals(1, testLog1.log.size());
//        }
//
//
//
