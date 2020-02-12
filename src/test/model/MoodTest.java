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
    ArrayList amMood1;
    ArrayList pmMood1;

    @BeforeEach
    void runBefore() {
        testMood1 = new MoodEntry();
        testMood2 = new MoodEntry();
        testLog1 = new MoodLog();
        testLog2 = new MoodLog();
    }

    @Test
    void testConstructor() { ///????
        testMood1.addRatingAM(4.0);
        testLog1.addMoodEntry(testMood1);
    }

    @Test
    void testAddAmMood() {
        //one entry
        testMood1.addRatingAM(4.0);
        assertEquals(4.0, testMood1.getTotalAMMood());

        //two entry
        testMood2.addRatingAM(10.0);
        testMood2.addRatingAM(7.0);
        assertEquals(17.0, testMood2.getTotalAMMood());
    }

    @Test
    void testAddPmMood() {
        //one entry
        testMood2.addRatingPM(5.0);
        assertEquals(5.0, testMood2.getTotalPMMood());

        //two entry
        testMood1.addRatingPM(10.0);
        testMood1.addRatingPM(7.0);
        assertEquals(17.0, testMood1.getTotalPMMood());
    }


    @Test
    void testGetAverageAMRating() {
        //one entry
        testMood1.addRatingAM(4.0);
        assertEquals(4.0, testMood1.getTotalAMMood());
        assertEquals(4.0, testMood1.getAverageMood());


        //two entries
        testMood2.addRatingAM(10.0);
        testMood2.addRatingPM(7.0);
        assertEquals(10.0, testMood2.getTotalAMMood());
        assertEquals(7.0, testMood2.getTotalPMMood());
        assertEquals((10.0 + 7.0) / 2.0, testMood2.getAverageMood());

    }

    @Test
    void testGetTotalAMMood() {
        testMood2.addRatingAM(8.0);
        testMood2.addRatingAM(6.0);
        assertEquals(14.0, testMood2.getTotalAMMood());
    }

    @Test
    void testGetTotalPMMood() {
        testMood2.addRatingPM(7.0);
        testMood2.addRatingPM(3.0);
        assertEquals(10.0, testMood2.getTotalPMMood());
    }

    @Test
    void testAddMoodEntry() {
        testMood2.addRatingPM(6.0);
        testLog1.addMoodEntry(testMood2);
        assertEquals(1, testLog1.log.size());


    }

    @Test
    void testToStringMoodEntry() {
        testMood2.addRatingPM(6.0);
        testMood2.addRatingAM(5.0);
        ArrayList<Double> test1 = new ArrayList<>();
        test1.add(5.0);
        assertEquals("\nOverall AM Mood log: " + test1 + "\nOverall PM Mood log: [" + 6.0 +"]",
                testMood2.toString());
    }

    @Test
    void testToStringMoodLog() {
        testMood2.addRatingPM(6.0);
        testMood2.addRatingAM(5.0);
        testLog1.addMoodEntry(testMood2);
        ArrayList<Double> test1 = new ArrayList<>();
        test1.add(5.0);
        assertEquals("Mood log: [\nOverall AM Mood log: " + test1 + "\nOverall PM Mood log: [" + 6.0 +"]]",
                testLog1.toString());
    }
}

