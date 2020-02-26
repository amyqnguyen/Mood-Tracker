package persistence;

import static org.junit.jupiter.api.Assertions.*;

import model.MoodEntry;
import model.MoodLog;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.ArrayList;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class ReaderTest {
    @Test
    void testParseMoodsFile1() {
        try {
            List<MoodLog> moods = Reader.readMoods(new File("./data/testMoods1.txt"));
            MoodLog testLog1 = moods.get(0);
            assertEquals(3, testLog1.getId());
            assertEquals("Monday", testLog1.getName());
           // MoodEntry me = new MoodEntry(1.0, 2.0);
            //Assertions.assertEquals(me , testLog1.getMoodEntry());

            MoodLog testLog2 = moods.get(1);
            assertEquals(4, testLog2.getId());
            assertEquals("Tuesday", testLog2.getName());
            //MoodEntry me1 = new MoodEntry(3.0, 4.0);
            //assertEquals(me1, testLog2.getMoodEntry());

            // check that nextAccountId has been set correctly
            //MoodLog nextMoodLog = new MoodLog("Wednesday", me1);
            //assertEquals(5, nextMoodLog.getId());


        } catch (IOException e) {
            fail("IOException should not have been thrown");
        }
    }

    @Test
    void testParseMoodsFile2() {
        try {
            List<MoodLog> moods = Reader.readMoods(new File("./data/testMoods2.txt"));
            MoodLog testLog3 = moods.get(0);
            assertEquals(4, testLog3.getId());
            assertEquals("Wednesday", testLog3.getName());
            //MoodEntry me2 = new MoodEntry(5.0, 6.0);
            //assertEquals(me2, testLog3.getMoodEntry());

            MoodLog testLog4 = moods.get(1);
            assertEquals(5, testLog4.getId());
            assertEquals("Thursday", testLog4.getName());
            //MoodEntry me3 = new MoodEntry(7.0, 8.0);
            //assertEquals(me3, testLog4.getMoodEntry());

            // check that nextAccountId has been set correctly
            //MoodLog nextMoodLog = new MoodLog("Friday", me2);
            //assertEquals(6, nextMoodLog.getId());


        } catch (IOException e) {
            fail("IOException should not have been thrown");
        }
    }
    @Test
    void testIOException() {
        try {
            Reader.readMoods(new File("./path/does/not/exist/testAccount.txt"));
        } catch (IOException e) {
            // expected
        }
    }
}
