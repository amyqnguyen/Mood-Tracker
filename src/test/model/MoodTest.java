package model;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

class MoodTest {
    private MoodEntry testMood;
    private ArrayList<Integer> testRatings;

    @BeforeEach
    void runBefore() {
        testMood = new MoodEntry();
    }

    @Test
    void testConstructor() {
        assertEquals(0, testMood.getAverageRating());
    }


    @Test
    void testAddRatingAm() {
        testMood.addRatingAM(10);
        assertEquals(10, testMood.getAverageRating());
    }

    @Test
    void testAddRatingPm() {
        testMood.addRatingPM(5);
        assertEquals(5, testMood.getAverageRating());
    }

    @Test
    void testGetAverageRating() {
        testMood.addRatingAM(4);
        testMood.addRatingPM(9);
        assertEquals((4+9)/2, testMood.getAverageRating());
    }


}