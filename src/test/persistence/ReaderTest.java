package persistence;

import static org.junit.jupiter.api.Assertions.*;

import model.MoodEntry;
import model.MoodLog;


import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.fail;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class ReaderTest {
    @Test
    void testParseMoodsFile1() {
        try {
            List<MoodLog> moods = Reader.readMoods(new File("./data/testMoods1.txt"));
            MoodLog testLog1 = moods.get(0);
            assertEquals("Monday", testLog1.getName());
            MoodEntry me1 = testLog1.getMoodEntry();
            assertEquals(1.0, me1.getAmMood());
            assertEquals(2.0, me1.getPmMood());


            MoodLog testLog2 = moods.get(1);
            assertEquals("Tuesday", testLog2.getName());
            MoodEntry me2 = testLog2.getMoodEntry();
            assertEquals(3.0, me2.getAmMood());
            assertEquals(4.0, me2.getPmMood());

        } catch (IOException e) {
            fail("IOException should not have been thrown");
        }
    }

    @Test
    void testParseMoodsFile2() {
        try {
            List<MoodLog> moods = Reader.readMoods(new File("./data/testMoods2.txt"));
            MoodLog testLog3 = moods.get(0);
            assertEquals("Wednesday", testLog3.getName());
            MoodEntry me3 = testLog3.getMoodEntry();
            assertEquals(5.0, me3.getAmMood());
            assertEquals(6.0, me3.getPmMood());

            MoodLog testLog4 = moods.get(1);
            assertEquals("Thursday", testLog4.getName());
            MoodEntry me4 = testLog4.getMoodEntry();
            assertEquals(7.0, me4.getAmMood());
            assertEquals(8.0, me4.getPmMood());

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
