package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MoodLogsTest {
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
        testMood1 = new MoodEntry(0.0, 0.0);
        testMood2 = new MoodEntry(4.0, 5.0);
        testLog1 = new MoodLog("Monday", testMood1);
        testLog2 = new MoodLog("Tuesday", testMood2);
        testLog3 = new MoodLog("Wednesday", testMood2);
        testLog4 = new MoodLog("Wednesday", testMood1);
        moodLogs1 = new MoodLogs();
        moodLogs2 = new MoodLogs();
    }

    @Test
    void testAddWeekDay() {
        moodLogs1.addWeekName("Monday");
        moodLogs1.addMoodLog("Monday", testLog1);
        assertEquals("Monday Mood log: AM Mood log: 0.0, PM Mood log: 0.0 \n",
                moodLogs1.printMapLogs("Monday"));
    }

    @Test
    void testAddMoodLog() {
        //add one mood log
        moodLogs1.addWeekName("Wednesday");
        moodLogs1.addMoodLog("Wednesday", testLog3);
        assertEquals("Wednesday Mood log: AM Mood log: 4.0, PM Mood log: 5.0 \n",
                moodLogs1.printMapLogs("Wednesday"));

        //two different days mood logs
        moodLogs1.addWeekName("Tuesday");
        moodLogs1.addMoodLog("Tuesday", testLog2);
        assertEquals("Tuesday Mood log: AM Mood log: 4.0, PM Mood log: 5.0 \n",
                moodLogs1.printMapLogs("Tuesday"));

        // two mood logs of same day
        moodLogs1.addMoodLog("Wednesday", testLog4);
        assertEquals("Wednesday Mood log: AM Mood log: 4.0, PM Mood log: 5.0 \n" +
                        "Wednesday Mood log: AM Mood log: 0.0, PM Mood log: 0.0 \n",
                moodLogs1.printMapLogs("Wednesday"));

    }

    @Test
    void testPrintMapLogs() {
        moodLogs2.addWeekName("Friday");
        MoodLog test = new MoodLog("Friday",new MoodEntry(1.0, 2.0));
        moodLogs2.addMoodLog("Friday", test);
        assertEquals("Friday Mood log: AM Mood log: 1.0, PM Mood log: 2.0 \n",
                moodLogs2.printMapLogs("Friday"));
    }
}
