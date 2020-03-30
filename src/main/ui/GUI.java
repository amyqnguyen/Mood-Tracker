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
import java.util.List;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.Clip;
import javax.sound.sampled.AudioSystem;


import model.MoodEntry;
import model.MoodLog;
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
//    private static double saveNumberHereAM;
//    private static double saveNumberHerePM;
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

    TabBar tabBar;

    //EFFECTS: constructs the GUI with 4 tabs each representing a new panel
    //Method adapted from Oracle Java Tutorials (https://docs.oracle.com/javase/tutorial/uiswing/events/intro.html)
    public GUI() {
        super("Mood Tracker");
        setMinimumSize(new Dimension(400,400));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setVisible(true);
        TabBar tabBar = new TabBar();
        add(tabBar);
        init();
        loadMoodLog();



        //JTabbedPane tabbedPane = new JTabbedPane();
        //ImageIcon icon = createImageIcon("images/middle.gif");


        //amPanel(tabbedPane,icon);
        //pmPanel(tabbedPane, icon);
        //averagePanel(tabbedPane, icon);
        //moodLogPanel(tabbedPane, icon);

        //Add the tabbed pane to this panel.
        //add(tabbedPane);
    }

//    //EFFECTS: constructs the Week Log panel with 2 components (day combobox and a text panel)
//    private void moodLogPanel(JTabbedPane tabbedPane, ImageIcon icon) {
//        JPanel panel4 = new JPanel(new GridLayout(0, 1));
//        TitledBorder title4;
//        title4 = BorderFactory.createTitledBorder("Weekly Log");
//        panel4.setBorder(title4);
//        panel4.setPreferredSize(new Dimension(410, 450));
//        tabbedPane.addTab("Week Log", icon, panel4,
//                "Does nothing at all");
//        tabbedPane.setMnemonicAt(3, KeyEvent.VK_4);
//        //combo box
//        JComboBox weekList = new JComboBox(weekDays);
//        ActionListener comboBoxListener4 = new ComboBoxActionListener4();
//        weekList.addActionListener(comboBoxListener4);
//        weekList.setSelectedIndex(7);
//        panel4.add(weekList);
//        JLabel resultLabel2 = new JLabel("Current Mood Ratings for the Week: ",
//                JLabel.LEADING); //== LEFT
//        panel4.add(resultLabel2);
//        //text panel
//        textAreaWeekLog = new JTextArea();
//        textAreaWeekLog.setEditable(false);
//        JScrollPane textAreaWeekScroll = new JScrollPane(textAreaWeekLog);
//        textAreaWeekScroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
//        textAreaWeekScroll.setMinimumSize(new Dimension(10, 10));
//        panel4.add(textAreaWeekScroll);
//    }

//    //EFFECTS: constructs the Week Log panel with 2 components (day combobox and text panel)
//    private void averagePanel(JTabbedPane tabbedPane, ImageIcon icon) {
//        JPanel panel3 = new JPanel(new GridLayout(0, 1));
//        TitledBorder title3;
//        title3 = BorderFactory.createTitledBorder("Daily Average");
//        panel3.setBorder(title3);
//        tabbedPane.addTab("Daily Average", icon, panel3,
//                "Still does nothing");
//        tabbedPane.setMnemonicAt(2, KeyEvent.VK_3);
//        //combo box
//        amList = new JComboBox(weekDays);
//        amList.setSelectedIndex(7);
//        ActionListener comboBoxListener3 = new ComboBoxActionListener3();
//        amList.addActionListener(comboBoxListener3);
//        panel3.add(amList);
//        //result box
//        JLabel resultLabel = new JLabel("Average Rating",
//                JLabel.LEADING); //== LEFT
//        panel3.add(resultLabel);
//        //text panel
//        textAreaAverage = new JTextArea();
//        textAreaAverage.setEditable(false);
//        JScrollPane textAreaAverageScroll = new JScrollPane(textAreaAverage);
//        textAreaAverageScroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
//        textAreaAverageScroll.setMinimumSize(new Dimension(10, 10));
//        panel3.add(textAreaAverageScroll);
//    }

//    //EFFECTS: constructs the PM Mood panel with 5 components (slider, set button, day combobox,
//    // text panel, and save button
//    private void pmPanel(JTabbedPane tabbedPane, ImageIcon icon) {
//        JPanel panel2 = new JPanel(new GridLayout(0, 1));
//        pmSlider(panel2);
//        setButtonPm(panel2);
//        comboBoxPm(panel2);
//        JLabel label2 = new JLabel("PM Mood: ");
//        panel2.add(label2);
//        textPanelPm(panel2);
//        saveButtonPm(panel2);
//        TitledBorder title2;
//        title2 = BorderFactory.createTitledBorder("PM Mood");
//        panel2.setBorder(title2);
//        tabbedPane.addTab("PM Mood", icon, panel2,
//                "Does twice as much nothing");
//        tabbedPane.setMnemonicAt(1, KeyEvent.VK_2);
//    }
//
//    //EFFECTS: creates save button for PM Mood
//    private void saveButtonPm(JPanel panel2) {
//        saveButtonPM = new JButton("Save Mood!");
//        saveButtonPM.setActionCommand("save");
//        ActionListener savePmButtonActionListener = new ButtonActionListenerPM();
//        saveButtonPM.addActionListener(savePmButtonActionListener);
//        panel2.add(saveButtonPM);
//    }
//
//    //EFFECTS: creates a text panel for PM Mood
//    private void textPanelPm(JPanel panel2) {
//        textAreaPM = new JTextArea();
//        textAreaPM.setEditable(false);
//        JScrollPane textAreaPMScroll = new JScrollPane(textAreaPM);
//        textAreaPMScroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
//        textAreaPMScroll.setMinimumSize(new Dimension(10, 10));
//        panel2.add(textAreaPMScroll);
//    }
//
//    //EFFECTS: creates a combobox for PM Mood
//    private void comboBoxPm(JPanel panel2) {
//        comboBox2 = new JComboBox(weekDays);
//        comboBox2.setSelectedIndex(7);
//        ActionListener comboBoxListener2 = new ComboBoxActionListener2();
//        comboBox2.addActionListener(comboBoxListener2);
//        panel2.add(comboBox2);
//    }
//
//    //EFFECTS: creates a set button for PM Mood
//    private void setButtonPm(JPanel panel2) {
//        setButton1 = new JButton("Set");
//        setButton1.setActionCommand("set");
//        ChangeListener buttonListener1 = new ButthonChangeListener1();
//        setButton1.addChangeListener(buttonListener1);
//        ActionListener buttonActionListener1 = new ButtonActionListener1();
//        setButton1.addActionListener(buttonActionListener1);
//        panel2.add(setButton1);
//    }
//
//    //EFFECTS: creates a mood rating slider from 0-10 for PM Mood
//    private void pmSlider(JPanel panel2) {
//        ChangeListener pmSliderListener = new SliderChangeListener1();
//        pmRatingSlider = new JSlider(minRating, maxRating);
//        pmRatingSlider.addChangeListener(pmSliderListener);
//        pmRatingSlider.setMajorTickSpacing(1);
//        pmRatingSlider.setPaintTicks(true);
//        pmRatingSlider.setPaintLabels(true);
//        panel2.add(pmRatingSlider);
//    }

//    //EFFECTS: constructs the AM Mood panal in the AM Mood tab
//    private void amPanel(JTabbedPane tabbedPane, ImageIcon icon) {
//        JPanel panel1 = new JPanel(new GridLayout(0, 1));
//        amSlider(panel1);
//        amSetButtion(panel1);
//        comboBoxAm(panel1);
//        JLabel label1 = new JLabel("AM Mood: ");
//        panel1.add(label1);
//        textPanelAm(panel1);
//        saveButtonAm(panel1);
//        TitledBorder title1;
//        title1 = BorderFactory.createTitledBorder("AM Mood");
//        panel1.setBorder(title1);
//        tabbedPane.addTab("AM Mood", icon, panel1,
//                "Does nothing");
//        tabbedPane.setMnemonicAt(0, KeyEvent.VK_1);
//    }
//
//    //EFFECTS: creates a save button for AM Mood
//    private void saveButtonAm(JPanel panel1) {
//        saveButtonAM = new JButton("Save Mood!");
//        saveButtonAM.setActionCommand("save");
//        ChangeListener saveAmButtonListener = new ButtonChangeListenerAM();
//        saveButtonAM.addChangeListener(saveAmButtonListener);
//        ActionListener saveAmButtonActionListener = new ButtonActionListenerAM();
//        saveButtonAM.addActionListener(saveAmButtonActionListener);
//        panel1.add(saveButtonAM);
//    }
//
//    //EFFECTS: creates a text panel for AM Mood
//    private void textPanelAm(JPanel panel1) {
//        textAreaAM = new JTextArea();
//        textAreaAM.setEditable(false);
//        JScrollPane textAreaAMScroll = new JScrollPane(textAreaAM);
//        textAreaAMScroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
//        textAreaAMScroll.setMinimumSize(new Dimension(10, 10));
//        panel1.add(textAreaAMScroll);
//    }
//
//    //EFFECTS: creates a combobox for AM Mood
//    private void comboBoxAm(JPanel panel1) {
//        comboBox1 = new JComboBox(weekDays);
//        comboBox1.setSelectedIndex(7);
//        ActionListener comboBoxListener1 = new ComboBoxActionListener1();
//        comboBox1.addActionListener(comboBoxListener1);
//        panel1.add(comboBox1);
//    }
//
//    //EFFECTS: creates a set button for AM Mood
//    private void amSetButtion(JPanel panel1) {
//        setButton = new JButton("Set");
//        setButton.setActionCommand("set");
//        ChangeListener buttonListener = new ButtonChangeListener();
//        setButton.addChangeListener(buttonListener);
//        ActionListener buttonActionListener = new ButtonActionListener();
//        setButton.addActionListener(buttonActionListener);
//        panel1.add(setButton);
//    }
//
//    //EFFECTS: creates a rating slider (0-10) for AM Mood
//    private void amSlider(JPanel panel1) {
//        ChangeListener amSliderListener = new SliderChangeListener();
//        amRatingSlider = new JSlider(minRating, maxRating);
//        amRatingSlider.addChangeListener(amSliderListener);
//        amRatingSlider.setMajorTickSpacing(1);
//        amRatingSlider.setPaintTicks(true);
//        amRatingSlider.setPaintLabels(true);
//        panel1.add(amRatingSlider);
//    }

    //EFFECTS: Returns an ImageIcon, or null if the path was invalid.
    //Method adapted from Oracle Java Tutorials (https://docs.oracle.com/javase/tutorial/uiswing/events/intro.html)
    protected static ImageIcon createImageIcon(String path) {
        java.net.URL imgURL = GUI.class.getResource(path);
        if (imgURL != null) {
            return new ImageIcon(imgURL);
        } else {
            System.err.println("Couldn't find file: " + path);
            return null;
        }
    }

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

//    //EFFECTS: updates the weekDay mood log to the current set rating
//    private void updateAMWeekDay(String weekDay) {
//        if (weekDay.equals("Monday")) {
//            MoodEntry me = monday.getMoodEntry();
//            me.setAMmood(saveNumberHereAM);
//            //monday = new MoodLog("Monday", new MoodEntry(saveNumberHereAM, saveNumberHerePM));
//        } else if (weekDay.equals("Tuesday")) {
//            MoodEntry me1 = tuesday.getMoodEntry();
//            me1.setAMmood(saveNumberHereAM);
//            //tuesday = new MoodLog("Tuesday", new MoodEntry(saveNumberHereAM, saveNumberHerePM));
//        } else if (weekDay.equals("Wednesday")) {
//            MoodEntry me2 = wednesday.getMoodEntry();
//            me2.setAMmood(saveNumberHereAM);
//            //wednesday = new MoodLog("Wednesday", new MoodEntry(saveNumberHereAM, saveNumberHerePM));
//        } else if (weekDay.equals("Thursday")) {
//            MoodEntry me3 = thursday.getMoodEntry();
//            me3.setAMmood(saveNumberHereAM);
//            //thursday = new MoodLog("Thursday", new MoodEntry(saveNumberHereAM, saveNumberHerePM));
//        } else if (weekDay.equals("Friday")) {
//            MoodEntry me4 = friday.getMoodEntry();
//            me4.setAMmood(saveNumberHereAM);
//            //friday = new MoodLog("Friday", new MoodEntry(saveNumberHereAM, saveNumberHerePM));
//        } else if (weekDay.equals("Saturday")) {
//            MoodEntry me5 = monday.getMoodEntry();
//            me5.setAMmood(saveNumberHereAM);
//            //saturday = new MoodLog("Saturday", new MoodEntry(saveNumberHereAM, saveNumberHerePM));
//        } else if (weekDay.equals("Sunday")) {
//            MoodEntry me6 = monday.getMoodEntry();
//            me6.setAMmood(saveNumberHereAM);
//            //sunday = new MoodLog("Sunday", new MoodEntry(saveNumberHereAM, saveNumberHerePM));
//        } else {
//            System.out.println("Select a Day");
//        }
//    }

//    private void updatePMWeekDay(String weekDay) {
//        if (weekDay.equals("Monday")) {
//            MoodEntry me = monday.getMoodEntry();
//            me.setPMmood(saveNumberHerePM);
//            //monday = new MoodLog("Monday", new MoodEntry(saveNumberHereAM, saveNumberHerePM));
//        } else if (weekDay.equals("Tuesday")) {
//            MoodEntry me1 = tuesday.getMoodEntry();
//            me1.setPMmood(saveNumberHerePM);
//            //tuesday = new MoodLog("Tuesday", new MoodEntry(saveNumberHereAM, saveNumberHerePM));
//        } else if (weekDay.equals("Wednesday")) {
//            MoodEntry me2 = wednesday.getMoodEntry();
//            me2.setPMmood(saveNumberHerePM);
//            //wednesday = new MoodLog("Wednesday", new MoodEntry(saveNumberHereAM, saveNumberHerePM));
//        } else if (weekDay.equals("Thursday")) {
//            MoodEntry me3 = thursday.getMoodEntry();
//            me3.setPMmood(saveNumberHerePM);
//            //thursday = new MoodLog("Thursday", new MoodEntry(saveNumberHereAM, saveNumberHerePM));
//        } else if (weekDay.equals("Friday")) {
//            MoodEntry me4 = friday.getMoodEntry();
//            me4.setPMmood(saveNumberHerePM);
//            //friday = new MoodLog("Friday", new MoodEntry(saveNumberHereAM, saveNumberHerePM));
//        } else if (weekDay.equals("Saturday")) {
//            MoodEntry me5 = monday.getMoodEntry();
//            me5.setPMmood(saveNumberHerePM);
//            //saturday = new MoodLog("Saturday", new MoodEntry(saveNumberHereAM, saveNumberHerePM));
//        } else if (weekDay.equals("Sunday")) {
//            MoodEntry me6 = monday.getMoodEntry();
//            me6.setPMmood(saveNumberHerePM);
//            //sunday = new MoodLog("Sunday", new MoodEntry(saveNumberHereAM, saveNumberHerePM));
//        } else {
//            System.out.println("Select a Day");
//        }
//    }

//    // EFFECTS: saves state of moods to MOODS_FILE
//    // method adapted from CPSC 210/TellerAPP/2020
//    private void saveMoodLogs() {
//        try {
//            Writer writer = new Writer(new File(MOODS_FILE));
//            writer.write(monday);
//            writer.write(tuesday);
//            writer.write(wednesday);
//            writer.write(thursday);
//            writer.write(friday);
//            writer.write(saturday);
//            writer.write(sunday);
//            writer.close();
//            System.out.println("Mood logs saved to file " + MOODS_FILE);
//        } catch (FileNotFoundException e) {
//            System.out.println("Unable to save mood logs to " + MOODS_FILE);
//        } catch (UnsupportedEncodingException e) {
//            e.printStackTrace();
//            // this is due to a programming error
//        }
//    }

    // MODIFIES: this
    // EFFECTS: loads accounts from MOOD_FILE, if that file exists;
    // otherwise initializes accounts with default values
    // Method adapted from CPSC 210/TellerAPP/2020
    private static void loadMoodLog() {
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


//    //EFFECTS: plays soundName
//    //Method adapted from http://suavesnippets.blogspot.com/2011/06/add-sound-on-jbutton-click-in-java.html
//    public void playSound(String soundName) {
//        try {
//            if (soundName.equals("button1.wav")) {
//                AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(
//                        new File("data/button1.wav"));
//                Clip clip = AudioSystem.getClip();
//                clip.open(audioInputStream);
//                clip.start();
//            } else {
//                AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(
//                        new File("data/button4.wav"));
//                Clip clip = AudioSystem.getClip();
//                clip.open(audioInputStream);
//                clip.start();
//            }
//        } catch (Exception ex) {
//            System.out.println("Error with playing sound.");
//            ex.printStackTrace();
//        }
//    }

    //EFFECTS: Create the GUI and show it.  For thread safety, this method should be invoked from
    // the event dispatch thread.
    //Method adapted from Oracle Java Tutorials (https://docs.oracle.com/javase/tutorial/uiswing/events/intro.html)
    private static void createAndShowGUI() {
        //Create and set up the window.

////        JFrame frame = new JFrame("Mood Tracker");
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//
//        //Add content to the window.
//        frame.add(new GUI(), BorderLayout.CENTER);
//
//        //Display the window.
//        frame.pack();
//        frame.setVisible(true);
////        TabBar tabBar = new TabBar();
////        frame.add(tabBar);
        //loadMoodLog();
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

//    /// TAB1-AM
//    private class SliderChangeListener implements ChangeListener {
//        @Override
//        public void stateChanged(ChangeEvent e) {
//            if (!amRatingSlider.getValueIsAdjusting()) {
//                System.out.println("Slider changed: " + amRatingSlider.getValue());
//            }
//        }
//    }
//
//    public static class ButtonChangeListener implements ChangeListener {
//        public void stateChanged(ChangeEvent changeEvent) {
//            saveNumberHereAM = amRatingSlider.getValue();
//        }
//    }
//
//    private class ButtonActionListener implements ActionListener {
//        @Override
//        public void actionPerformed(ActionEvent e) {
//            if ("set".equals(e.getActionCommand())) {
//                setButton.setEnabled(true);
//                setButton.getChangeListeners();
//                playSound("button1.wav");
//            } else {
//                setButton.setEnabled(false);
//            }
//        }
//    }
//
//    private class ComboBoxActionListener1 implements ActionListener {
//        @Override
//        public void actionPerformed(ActionEvent e) {
//            JComboBox cb = (JComboBox) e.getSource();
//            String weekName = (String) cb.getSelectedItem();
//            updateAMWeekDay(weekName);
//            textAreaAM.append(weekName + " " + saveNumberHereAM + "\n");
//        }
//    }
//
//    private class ButtonChangeListenerAM implements ChangeListener {
//        @Override
//        public void stateChanged(ChangeEvent e) {
//            saveNumberHereAM = amRatingSlider.getValue();
//        }
//    }
//
//    private class ButtonActionListenerAM implements ActionListener {
//        @Override
//        public void actionPerformed(ActionEvent e) {
//            if ("save".equals(e.getActionCommand())) {
//                saveButtonAM.setEnabled(true);
//                saveButtonAM.getChangeListeners();
//                playSound("button4.wav");
//                saveMoodLogs();
//            } else {
//                saveButtonAM.setEnabled(false);
//            }
//        }
//    }


//    // TAB2-PM
//    private class SliderChangeListener1 implements ChangeListener {
//        @Override
//        public void stateChanged(ChangeEvent e) {
//            if (!pmRatingSlider.getValueIsAdjusting()) {
//                System.out.println("Slider changed: " + pmRatingSlider.getValue());
//            }
//        }
//    }
//
//    private class ButthonChangeListener1 implements ChangeListener {
//        @Override
//        public void stateChanged(ChangeEvent e) {
//            saveNumberHerePM = pmRatingSlider.getValue();
//        }
//    }
//
//    private class ButtonActionListener1 implements ActionListener {
//        @Override
//        public void actionPerformed(ActionEvent e) {
//            if ("set".equals(e.getActionCommand())) {
//                setButton1.setEnabled(true);
//                setButton1.getChangeListeners();
//                playSound("button1.wav");
//            } else {
//                setButton1.setEnabled(false);
//            }
//        }
//
//    }
//
//    private class ComboBoxActionListener2 implements ActionListener {
//        @Override
//        public void actionPerformed(ActionEvent e) {
//            JComboBox cb = (JComboBox) e.getSource();
//            String weekName = (String) cb.getSelectedItem();
//            updatePMWeekDay(weekName);
//            textAreaPM.append(weekName + " " + saveNumberHerePM + "\n");
//        }
//    }
//
//    private class ButtonActionListenerPM implements ActionListener {
//        @Override
//        public void actionPerformed(ActionEvent e) {
//            if ("save".equals(e.getActionCommand())) {
//                saveButtonPM.setEnabled(true);
//                saveButtonPM.getChangeListeners();
//                playSound("button4.wav");
//                saveMoodLogs();
//            } else {
//                saveButtonAM.setEnabled(false);
//            }
//        }
//    }

//    //Average tab
//    private class ComboBoxActionListener3 implements ActionListener {
//        @Override
//        public void actionPerformed(ActionEvent e) {
//            JComboBox cb1 = (JComboBox) e.getSource();
//            String weekName = (String) cb1.getSelectedItem();
//            if (weekName.equals("Monday")) {
//                textAreaAverage.append("Monday: " + monday.getAverageMoodLog() + "\n");
//            } else if (weekName.equals("Tuesday")) {
//                textAreaAverage.append("Tuesday: " + tuesday.getAverageMoodLog() + "\n");
//            } else if (weekName.equals("Wednesday")) {
//                textAreaAverage.append("Wednesday: " + wednesday.getAverageMoodLog() + "\n");
//            } else if (weekName.equals("Thursday")) {
//                textAreaAverage.append("Thursday: " + thursday.getAverageMoodLog() + "\n");
//            } else if (weekName.equals("Friday")) {
//                textAreaAverage.append("Friday: " + friday.getAverageMoodLog() + "\n");
//            } else if (weekName.equals("Saturday")) {
//                textAreaAverage.append("Saturday: " + saturday.getAverageMoodLog() + "\n");
//            } else if (weekName.equals("Sunday")) {
//                textAreaAverage.append("Sunday: " + sunday.getAverageMoodLog() + "\n");
//            } else {
//                System.out.println("Select a Day");
//            }
//        }
//    }

//    //TAB 4- week log
//    private class ComboBoxActionListener4 implements ActionListener {
//        @Override
//        public void actionPerformed(ActionEvent e) {
//            JComboBox cb = (JComboBox) e.getSource();
//            String weekName = (String) cb.getSelectedItem();
//            if (weekName.equals("Monday")) {
//                textAreaWeekLog.append(monday.toString());
//            } else if (weekName.equals("Tuesday")) {
//                textAreaWeekLog.append(tuesday.toString());
//            } else if (weekName.equals("Wednesday")) {
//                textAreaWeekLog.append(wednesday.toString());
//            } else if (weekName.equals("Thursday")) {
//                textAreaWeekLog.append(thursday.toString());
//            } else if (weekName.equals("Friday")) {
//                textAreaWeekLog.append(friday.toString());
//            } else if (weekName.equals("Saturday")) {
//                textAreaWeekLog.append(saturday.toString());
//            } else if (weekName.equals("Sunday")) {
//                textAreaWeekLog.append(sunday.toString());
//            } else {
//                System.out.println("Select a Day");
//            }
//        }
//    }
}












