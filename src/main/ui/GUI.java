package ui;

import javax.swing.*;
import java.awt.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

import model.MoodEntry;
import model.MoodLog;
import model.MoodLogs;
import persistence.Reader;
import persistence.Writer;
import ui.tabs.TabBar;

//Mood tracker GUI
public class GUI extends JFrame {
    private static final String MOODS_FILE = "./data/moodsGUI.txt";

    private double saveNumberHereAM;
    private double saveNumberHerePM;

    private MoodLog monday;
    private MoodLog tuesday;
    private MoodLog wednesday;
    private MoodLog thursday;
    private MoodLog friday;
    private MoodLog saturday;
    private MoodLog sunday;
    private MoodLogs logs;

    private TabBar tabBar;

    //EFFECTS: constructs the GUI with 4 tabs each representing a new panel
    //Method adapted from Oracle Java Tutorials (https://docs.oracle.com/javase/tutorial/uiswing/events/intro.html)
    public GUI() {
        super("Mood Tracker");
        setMinimumSize(new Dimension(400,400));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setVisible(true);
        tabBar = new TabBar(this);
        add(tabBar);
        logs = new MoodLogs();
        loadMoodLog();
    }

    // MODIFIES: this
    // EFFECTS: loads accounts from MOOD_FILE, if that file exists;
    // otherwise initializes accounts with default values
    // Method adapted from CPSC 210/TellerAPP/2020
    private void loadMoodLog() {
        try {
            List<MoodLog> moodLogs = Reader.readMoods(new File(MOODS_FILE));
            monday = moodLogs.get(0);
            tuesday = moodLogs.get(1);
            wednesday = moodLogs.get(2);
            thursday = moodLogs.get(3);
            friday = moodLogs.get(4);
            saturday = moodLogs.get(5);
            sunday = moodLogs.get(6);
            addSaveMoodLogToMap();
        } catch (IOException e) {
            init();
        }
    }


    //EFFECTS: initialize the mood logs
    private void init() {
        monday = new MoodLog("Monday", new MoodEntry(0.0, 0.0));
        tuesday = new MoodLog("Tuesday", new MoodEntry(0.0, 0.0));
        wednesday = new MoodLog("Wednesday", new MoodEntry(0.0, 0.0));
        thursday = new MoodLog("Thursday", new MoodEntry(0.0, 0.0));
        friday = new MoodLog("Friday", new MoodEntry(0.0, 0.0));
        saturday = new MoodLog("Saturday", new MoodEntry(0.0, 0.0));
        sunday = new MoodLog("Sunday", new MoodEntry(0.0, 0.0));
    }

    public void setMoodAM(Double saveNumberHereAM) {
        this.saveNumberHereAM = saveNumberHereAM;
    }

    public void setMoodPM(Double saveNumberHerePM) {
        this.saveNumberHerePM = saveNumberHerePM;
    }

    //EFFECTS: updates the weekDay mood log to the current set rating
    public void updateAMWeekDay(String weekDay) {
        if (weekDay.equals("Monday")) {
            monday.setAmMoodEntry(saveNumberHereAM);
        } else if (weekDay.equals("Tuesday")) {
            tuesday.setAmMoodEntry(saveNumberHereAM);
        } else if (weekDay.equals("Wednesday")) {
            wednesday.setAmMoodEntry(saveNumberHereAM);
        } else if (weekDay.equals("Thursday")) {
            thursday.setAmMoodEntry(saveNumberHereAM);
        } else if (weekDay.equals("Friday")) {
            friday.setAmMoodEntry(saveNumberHereAM);
        } else if (weekDay.equals("Saturday")) {
            saturday.setAmMoodEntry(saveNumberHereAM);
        } else if (weekDay.equals("Sunday")) {
            sunday.setAmMoodEntry(saveNumberHereAM);
        } else {
            System.out.println(" ");
        }
    }

    public void updatePMWeekDay(String weekDay) {
        if (weekDay.equals("Monday")) {
            monday.setPmMoodEntry(saveNumberHerePM);
            addMoodLogToMap("Monday");
        } else if (weekDay.equals("Tuesday")) {
            tuesday.setPmMoodEntry(saveNumberHerePM);
            addMoodLogToMap("Tuesday");
        } else if (weekDay.equals("Wednesday")) {
            wednesday.setPmMoodEntry(saveNumberHerePM);
            addMoodLogToMap("Wednesday");
        } else if (weekDay.equals("Thursday")) {
            thursday.setPmMoodEntry(saveNumberHerePM);
            addMoodLogToMap("Thursday");
        } else if (weekDay.equals("Friday")) {
            friday.setPmMoodEntry(saveNumberHerePM);
            addMoodLogToMap("Friday");
        } else if (weekDay.equals("Saturday")) {
            saturday.setPmMoodEntry(saveNumberHerePM);
            addMoodLogToMap("Saturday");
        } else {
            sunday.setPmMoodEntry(saveNumberHerePM);
            addMoodLogToMap("Sunday");
        }
    }

    public void addMoodLogToMap(String weekName) {
        MoodLog newLog = new MoodLog(weekName, new MoodEntry(saveNumberHereAM, saveNumberHerePM));
        logs.addMoodLog(weekName, newLog);
        System.out.println(logs.printMapLogs(weekName));
    }


    public void addSaveMoodLogToMap() {
        try {
            List<MoodLog> moodLogs = Reader.readMoods(new File(MOODS_FILE));
            MoodLog oldMonday = moodLogs.get(0);
            MoodLog oldTuesday = moodLogs.get(1);
            MoodLog oldWednesday = moodLogs.get(2);
            MoodLog oldThursday = moodLogs.get(3);
            MoodLog oldFriday = moodLogs.get(4);
            MoodLog oldSaturday = moodLogs.get(5);
            MoodLog oldSunday = moodLogs.get(6);
            logs.addMoodLog("Monday", oldMonday);
            logs.addMoodLog("Tuesday", oldTuesday);
            logs.addMoodLog("Wednesday", oldWednesday);
            logs.addMoodLog("Thursday", oldThursday);
            logs.addMoodLog("Friday", oldFriday);
            logs.addMoodLog("Saturday", oldSaturday);
            logs.addMoodLog("Sunday", oldSunday);
        } catch (IOException e) {
            init();
        }
    }

    public String printAverage(String weekName) {
        if (weekName.equals("Monday")) {
            return "Monday: " + monday.getAverageMoodLog() + "\n";
        } else if (weekName.equals("Tuesday")) {
            return "Tuesday: " + tuesday.getAverageMoodLog() + "\n";
        } else if (weekName.equals("Wednesday")) {
            return "Wednesday: " + wednesday.getAverageMoodLog() + "\n";
        } else if (weekName.equals("Thursday")) {
            return "Thursday: " + thursday.getAverageMoodLog() + "\n";
        } else if (weekName.equals("Friday")) {
            return "Friday: " + friday.getAverageMoodLog() + "\n";
        } else if (weekName.equals("Saturday")) {
            return "Saturday: " + saturday.getAverageMoodLog() + "\n";
        } else if (weekName.equals("Sunday")) {
            return "Sunday: " + sunday.getAverageMoodLog() + "\n";
        } else {
            return "";
        }
    }

    public String printMoodLog(String weekName) {
        if (weekName.equals("Monday")) {
            return monday.toString();
        } else if (weekName.equals("Tuesday")) {
            return tuesday.toString();
        } else if (weekName.equals("Wednesday")) {
            return wednesday.toString();
        } else if (weekName.equals("Thursday")) {
            return thursday.toString();
        } else if (weekName.equals("Friday")) {
            return friday.toString();
        } else if (weekName.equals("Saturday")) {
            return saturday.toString();
        } else if (weekName.equals("Sunday")) {
            return sunday.toString();
        } else {
            return "";
        }
    }

    // EFFECTS: saves state of moods to MOODS_FILE
    // method adapted from CPSC 210/TellerAPP/2020
    public void saveMoodLogs() {
        try {
            Writer writer = new Writer(new File(MOODS_FILE));
            writer.write(monday);
            writer.write(tuesday);
            writer.write(wednesday);
            writer.write(thursday);
            writer.write(friday);
            writer.write(saturday);
            writer.write(sunday);
            writer.close();
            System.out.println("Mood logs saved to file " + MOODS_FILE);
        } catch (FileNotFoundException e) {
            System.out.println("Unable to save mood logs to " + MOODS_FILE);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            // this is due to a programming error
        }
    }

    public static void main(String[] args) {
        //Schedule a job for the event dispatch thread:
        //creating and showing this application's GUI.
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                //Turn off metal's use of bold fonts
                UIManager.put("swing.boldMetal", Boolean.FALSE);
                new GUI();
            }
        });
    }

}












