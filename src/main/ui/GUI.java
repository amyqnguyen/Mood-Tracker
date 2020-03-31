package ui;

import javax.swing.*;
import java.awt.*;
import javax.swing.border.TitledBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.event.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.Clip;
import javax.sound.sampled.AudioSystem;


import model.MoodEntry;
import model.MoodLog;
import model.MoodLogs;
import persistence.Reader;
import persistence.Writer;
import ui.tabs.TabBar;

//Mood tracker GUI
public class GUI extends JFrame {
    private static final String MOODS_FILE = "./data/moodsGUI.txt";
//    private static final int minRating = 0;
//    private static final int maxRating = 10;
//    protected static JButton setButton;
//    protected static JButton setButton1;
//    private static JButton saveButtonAM;
//    private static JButton saveButtonPM;
//    private static JSlider amRatingSlider;
//    private static JSlider pmRatingSlider;
    private double saveNumberHereAM;
    private double saveNumberHerePM;
//    private static JComboBox comboBox1;
//    private static JComboBox comboBox2;
//    private static JComboBox amList;
//    private static JTextArea textAreaAM;
//    private static JTextArea textAreaPM;
//    private static JTextArea textAreaAverage;
//    private static JTextArea textAreaWeekLog;
    //private static String[] weekDays = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday",
     //       "Select A Day"};

    static MoodLog monday;
    static MoodLog tuesday;
    static MoodLog wednesday;
    static MoodLog thursday;
    static MoodLog friday;
    static MoodLog saturday;
    static MoodLog sunday;
    static MoodLogs logs;

    TabBar tabBar;

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
        //init();
        loadMoodLog();
        logs = new MoodLogs();
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
        } catch (IOException e) {
            init();
        }
    }

//    //EFFECTS: Returns an ImageIcon, or null if the path was invalid.
//    //Method adapted from Oracle Java Tutorials (https://docs.oracle.com/javase/tutorial/uiswing/events/intro.html)
//    protected static ImageIcon createImageIcon(String path) {
//        java.net.URL imgURL = GUI.class.getResource(path);
//        if (imgURL != null) {
//            return new ImageIcon(imgURL);
//        } else {
//            System.err.println("Couldn't find file: " + path);
//            return null;
//        }
//    }

    //EFFECTS: initialize the mood logs
    private static void init() {
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

//    //EFFECTS: updates the weekDay mood log to the current set rating
//    public void updateAMWeekDay(String weekDay) {
//        if (weekDay.equals("Monday")) {
//            MoodEntry me = monday.getMoodEntry();
//            me.setAMmood(saveNumberHereAM);
//        } else if (weekDay.equals("Tuesday")) {
//            MoodEntry me1 = tuesday.getMoodEntry();
//            me1.setAMmood(saveNumberHereAM);
//        } else if (weekDay.equals("Wednesday")) {
//            MoodEntry me2 = wednesday.getMoodEntry();
//            me2.setAMmood(saveNumberHereAM);
//        } else if (weekDay.equals("Thursday")) {
//            MoodEntry me3 = thursday.getMoodEntry();
//            me3.setAMmood(saveNumberHereAM);
//        } else if (weekDay.equals("Friday")) {
//            MoodEntry me4 = friday.getMoodEntry();
//            me4.setAMmood(saveNumberHereAM);
//        } else if (weekDay.equals("Saturday")) {
//            MoodEntry me5 = saturday.getMoodEntry();
//            me5.setAMmood(saveNumberHereAM);
//        } else if (weekDay.equals("Sunday")) {
//            MoodEntry me6 = sunday.getMoodEntry();
//            me6.setAMmood(saveNumberHereAM);
//        } else {
//            System.out.println("");
//        }
//    }

    public void updatePMWeekDay(String weekDay) {
        if (weekDay.equals("Monday")) {
            monday.setPmMoodEntry(saveNumberHerePM);
            addMoodLogToMap("Monday", monday);
        } else if (weekDay.equals("Tuesday")) {
            tuesday.setPmMoodEntry(saveNumberHerePM);
            addMoodLogToMap("Tuesday", tuesday);
        } else if (weekDay.equals("Wednesday")) {
            wednesday.setPmMoodEntry(saveNumberHerePM);
            addMoodLogToMap("Wednesday", wednesday);
        } else if (weekDay.equals("Thursday")) {
            thursday.setPmMoodEntry(saveNumberHerePM);
            addMoodLogToMap("Thursday",thursday);
        } else if (weekDay.equals("Friday")) {
            friday.setPmMoodEntry(saveNumberHerePM);
            addMoodLogToMap("Friday", friday);
        } else if (weekDay.equals("Saturday")) {
            saturday.setPmMoodEntry(saveNumberHerePM);
            addMoodLogToMap("Saturday", saturday);
        } else {
            sunday.setPmMoodEntry(saveNumberHerePM);
            addMoodLogToMap("Sunday", sunday);
        }
    }

    public void addMoodLogToMap(String weekName, MoodLog log) {
        log = new MoodLog(weekName, new MoodEntry(saveNumberHereAM, saveNumberHerePM));
        logs.addMoodLog(weekName, log);
        System.out.println(logs.printMapLogs(weekName));
    }

//    public void addMoodLogToMap(String weekName, MoodLog log) {
//        if (weekName.equals("Monday")) {
//            log = new MoodLog("Monday", new MoodEntry(saveNumberHereAM, saveNumberHerePM));
//            logs.addMoodLog("Monday", log);
//            System.out.println(logs.printMapLogs("Monday"));


    public void addSaveMoodLogToMap(String weekDay, MoodLog log) {}

    public String printAverage(String weekName) {
        if (weekName.equals("Monday")) {
            //textAreaAverage.append("Monday: " + monday.getAverageMoodLog() + "\n");
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
//                createAndShowGUI();
                new GUI();
            }
        });
    }

}












