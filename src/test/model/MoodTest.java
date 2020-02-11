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
        testMood1 = new MoodEntry(4, 10);
        testMood2 = new MoodEntry(5, 7);
        testLog1 = new MoodLog();
        testLog2 = new MoodLog();
    }

    @Test
    void testConstructor() { ///????
        testLog1.addMoodEntry(testMood1);
        assertEquals(4, testMood1.getAMMood());
        assertEquals(10, testMood1.getPMMood());
        assertEquals((4 + 10) / 2, testLog1.getMoodAverage());
    }

    @Test
    void testGetAMMood() {
        testLog1.addMoodEntry(testMood2);
        assertEquals(5, testMood2.getAMMood());
    }

    @Test
    void testGetPMMood() {
        testLog1.addMoodEntry(testMood2);
        assertEquals(7, testMood2.getPMMood());
    }


    @Test
    void testGetAverageRating() {
        testLog1.addMoodEntry(testMood1);
        assertEquals(4, testMood1.getAMMood());
        assertEquals(10, testMood1.getPMMood());
        assertEquals((4 + 10) / 2, testLog1.getMoodAverage());
    }

    @Test
    void testAddMoodEntry() {
        testLog1.addMoodEntry(testMood1);
        assertEquals(4, testMood1.getAMMood());
        assertEquals(10, testMood1.getPMMood());
    }


}