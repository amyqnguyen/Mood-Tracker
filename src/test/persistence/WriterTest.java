package persistence;

import model.MoodEntry;
import model.MoodLog;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class WriterTest {
    private static final String MOODS_TEST = "./data/testMoodsFile3.txt";
    private Writer testWriter;
    private MoodLog ML1;
    private MoodLog ML2;
    private MoodEntry ME1;
    private MoodEntry ME2;


    @BeforeEach
    void runBefore() throws FileNotFoundException,UnsupportedEncodingException {
        testWriter = new Writer(new File(MOODS_TEST));
        ML1 = new MoodLog("Monday", new MoodEntry(1.0, 2.0));
        ML2 = new MoodLog("Tuesday", new MoodEntry(5.0, 6.0));


    }

    @Test
    void testWriteMoodLogs() {
        //saves ML1 and ML2 mood logs to file
        testWriter.write(ML1);
        testWriter.write(ML2);
        testWriter.close();

        // now read them back in and verify that the accounts have the expected values
        try {
            List<MoodLog> moods = Reader.readMoods(new File(MOODS_TEST));
            MoodLog ML1 = moods.get(0);
            assertEquals(1, ML1.getId());
            assertEquals("Monday", ML1.getName());


            MoodLog ML2 = moods.get(1);
            assertEquals(2, ML2.getId());
            assertEquals("Tuesday", ML2.getName());

            // verify that ID of next mood log created is 3 (checks that nextId was restored)
            MoodLog next = new MoodLog("Wednesday", ME1);
            assertEquals(3, next.getId());

        } catch (IOException e) {
            fail("IOException should not have been thrown");
        }
    }
}
