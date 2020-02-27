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
        assertEquals(0, testMood1.getAmMood());
        assertEquals(0, testMood1.getPmMood());
    }


    @Test
    void testGetAverageRatingLog() {
        testMood1.setAMmood(3.0);
        testMood1.setPMmood(7.0);
        assertEquals(5.0, testMood1.averageMoodEntry());
        assertEquals(5.0, testLog1.getAverageMoodLog());
        assertEquals((10.0 + 7.0) / 2.0, testMood2.averageMoodEntry());

    }

    @Test
    void testSetName() {
        testLog1.setName("Happy");
        assertEquals("Happy", testLog1.getName());
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
        assertEquals("Tuesday Mood log: AM Mood log: 6.0, PM Mood log: 5.0 \n" , testLog2.toString());
 }
}


