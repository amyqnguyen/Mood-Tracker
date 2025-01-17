package model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MoodTest {
    MoodEntry testMood1;
    MoodEntry testMood2;
    MoodLog testLog1;
    MoodLog testLog2;
    MoodLog testLog3;
    MoodLog testLog4;
    MoodLogs moodLogs1;
    MoodLogs moodLogs2;


    @BeforeEach
    void runBefore() {
        testMood1 = new MoodEntry(0.0,0.0);
        testMood2 = new MoodEntry(4.0,5.0);
        testLog1 = new MoodLog("Monday", testMood1);
        testLog2 = new MoodLog("Tuesday", testMood2);
        testLog3 = new MoodLog("Wednesday", testMood2);
        testLog4 = new MoodLog("Wednesday", testMood1);
        moodLogs1 = new MoodLogs();
        moodLogs2 = new MoodLogs();
    }

    @Test
    void testConstructorML1() {
        assertEquals("Monday", testLog1.getName());
    }

    @Test
    void testConstructorML2() {
        assertEquals("Wednesday", testLog3.getName());
        //assertEquals(testMood2, testLog3.getMoodEntry());
        assertEquals(0, testMood1.getAmMood());
        assertEquals(0, testMood1.getPmMood());
    }


    @Test
    void testGetAverageRatingLog() {
        testMood1.setAMmood(3.0);
        testMood1.setPMmood(7.0);
        assertEquals(5.0, testMood1.averageMoodEntry());
        assertEquals(5.0, testLog1.getAverageMoodLog());
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


