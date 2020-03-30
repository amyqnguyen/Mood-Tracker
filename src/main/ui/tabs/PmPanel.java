package ui.tabs;

import model.MoodEntry;
import model.MoodLog;
import persistence.Writer;
import ui.GUI;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;

public class PmPanel extends JPanel {
    private static final int minRating = 0;
    private static final int maxRating = 10;
    protected static JButton setButton1;
    private static JButton saveButtonPM;
    private static JSlider pmRatingSlider;
    private static JComboBox comboBox2;
    private static JTextArea textAreaPM;
    private static double saveNumberHerePM;
    private static String[] weekDays = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday",
            "Select A Day"};
    private static final String MOODS_FILE = "./data/moodsGUI.txt";

    MoodLog monday;
    MoodLog tuesday;
    MoodLog wednesday;
    MoodLog thursday;
    MoodLog friday;
    MoodLog saturday;
    MoodLog sunday;


    //EFFECTS: constructs the PM Mood panel with 5 components (slider, set button, day combobox,
    // text panel, and save button
    public PmPanel() {
        setLayout(new GridLayout(0, 1));
        //JPanel panel2 = new JPanel(new GridLayout(0, 1));
//        pmSlider(panel2);
//        setButtonPm(panel2);
//        comboBoxPm(panel2);
        pmSlider();
        setButtonPm();
        comboBoxPm();
        JLabel label2 = new JLabel("PM Mood: ");
        add(label2);
        textPanelPm();
        saveButtonPm();
//        textPanelPm(panel2);
//        saveButtonPm(panel2);
        TitledBorder title2;
        title2 = BorderFactory.createTitledBorder("PM Mood");
        setBorder(title2);
//        tabbedPane.addTab("PM Mood", icon, panel2,
//                "Does twice as much nothing");
//        tabbedPane.setMnemonicAt(1, KeyEvent.VK_2);
    }

    //EFFECTS: creates save button for PM Mood
    private void saveButtonPm() {
        saveButtonPM = new JButton("Save Mood!");
        saveButtonPM.setActionCommand("save");
        ActionListener savePmButtonActionListener = new ButtonActionListenerPM();
        saveButtonPM.addActionListener(savePmButtonActionListener);
        add(saveButtonPM);
    }

    //EFFECTS: creates a text panel for PM Mood
    private void textPanelPm() {
        textAreaPM = new JTextArea();
        textAreaPM.setEditable(false);
        JScrollPane textAreaPMScroll = new JScrollPane(textAreaPM);
        textAreaPMScroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        textAreaPMScroll.setMinimumSize(new Dimension(10, 10));
        add(textAreaPMScroll);
    }

    //EFFECTS: creates a combobox for PM Mood
    private void comboBoxPm() {
        comboBox2 = new JComboBox(weekDays);
        comboBox2.setSelectedIndex(7);
        ActionListener comboBoxListener2 = new ComboBoxActionListener2();
        comboBox2.addActionListener(comboBoxListener2);
        add(comboBox2);
    }

    //EFFECTS: creates a set button for PM Mood
    private void setButtonPm() {
        setButton1 = new JButton("Set");
        setButton1.setActionCommand("set");
        ChangeListener buttonListener1 = new ButthonChangeListener1();
        setButton1.addChangeListener(buttonListener1);
        ActionListener buttonActionListener1 = new ButtonActionListener1();
        setButton1.addActionListener(buttonActionListener1);
        add(setButton1);
    }

    //EFFECTS: creates a mood rating slider from 0-10 for PM Mood
    private void pmSlider() {
        ChangeListener pmSliderListener = new SliderChangeListener1();
        pmRatingSlider = new JSlider(minRating, maxRating);
        pmRatingSlider.addChangeListener(pmSliderListener);
        pmRatingSlider.setMajorTickSpacing(1);
        pmRatingSlider.setPaintTicks(true);
        pmRatingSlider.setPaintLabels(true);
        add(pmRatingSlider);
    }

    //EFFECTS: plays soundName
    //Method adapted from http://suavesnippets.blogspot.com/2011/06/add-sound-on-jbutton-click-in-java.html
    public void playSound(String soundName) {
        try {
            if (soundName.equals("button1.wav")) {
                AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(
                        new File("data/button1.wav"));
                Clip clip = AudioSystem.getClip();
                clip.open(audioInputStream);
                clip.start();
            } else {
                AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(
                        new File("data/button4.wav"));
                Clip clip = AudioSystem.getClip();
                clip.open(audioInputStream);
                clip.start();
            }
        } catch (Exception ex) {
            System.out.println("Error with playing sound.");
            ex.printStackTrace();
        }
    }

    private void updatePMWeekDay(String weekDay) {
        if (weekDay.equals("Monday")) {
            MoodEntry me = monday.getMoodEntry();
            me.setPMmood(saveNumberHerePM);
            //monday = new MoodLog("Monday", new MoodEntry(saveNumberHereAM, saveNumberHerePM));
        } else if (weekDay.equals("Tuesday")) {
            MoodEntry me1 = tuesday.getMoodEntry();
            me1.setPMmood(saveNumberHerePM);
            //tuesday = new MoodLog("Tuesday", new MoodEntry(saveNumberHereAM, saveNumberHerePM));
        } else if (weekDay.equals("Wednesday")) {
            MoodEntry me2 = wednesday.getMoodEntry();
            me2.setPMmood(saveNumberHerePM);
            //wednesday = new MoodLog("Wednesday", new MoodEntry(saveNumberHereAM, saveNumberHerePM));
        } else if (weekDay.equals("Thursday")) {
            MoodEntry me3 = thursday.getMoodEntry();
            me3.setPMmood(saveNumberHerePM);
            //thursday = new MoodLog("Thursday", new MoodEntry(saveNumberHereAM, saveNumberHerePM));
        } else if (weekDay.equals("Friday")) {
            MoodEntry me4 = friday.getMoodEntry();
            me4.setPMmood(saveNumberHerePM);
            //friday = new MoodLog("Friday", new MoodEntry(saveNumberHereAM, saveNumberHerePM));
        } else if (weekDay.equals("Saturday")) {
            MoodEntry me5 = monday.getMoodEntry();
            me5.setPMmood(saveNumberHerePM);
            //saturday = new MoodLog("Saturday", new MoodEntry(saveNumberHereAM, saveNumberHerePM));
        } else if (weekDay.equals("Sunday")) {
            MoodEntry me6 = monday.getMoodEntry();
            me6.setPMmood(saveNumberHerePM);
            //sunday = new MoodLog("Sunday", new MoodEntry(saveNumberHereAM, saveNumberHerePM));
        } else {
            System.out.println("Select a Day");
        }
    }

    // EFFECTS: saves state of moods to MOODS_FILE
    // method adapted from CPSC 210/TellerAPP/2020
    private void saveMoodLogs() {
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

    // TAB2-PM
    private class SliderChangeListener1 implements ChangeListener {
        @Override
        public void stateChanged(ChangeEvent e) {
            if (!pmRatingSlider.getValueIsAdjusting()) {
                System.out.println("Slider changed: " + pmRatingSlider.getValue());
            }
        }
    }

    private class ButthonChangeListener1 implements ChangeListener {
        @Override
        public void stateChanged(ChangeEvent e) {
            saveNumberHerePM = pmRatingSlider.getValue();
        }
    }

    private class ButtonActionListener1 implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if ("set".equals(e.getActionCommand())) {
                setButton1.setEnabled(true);
                setButton1.getChangeListeners();
                playSound("button1.wav");
            } else {
                setButton1.setEnabled(false);
            }
        }
    }

    private class ComboBoxActionListener2 implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            JComboBox cb = (JComboBox) e.getSource();
            String weekName = (String) cb.getSelectedItem();
            updatePMWeekDay(weekName);
            textAreaPM.append(weekName + " " + saveNumberHerePM + "\n");
        }
    }

    private class ButtonActionListenerPM implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if ("save".equals(e.getActionCommand())) {
                saveButtonPM.setEnabled(true);
                saveButtonPM.getChangeListeners();
                playSound("button4.wav");
                saveMoodLogs();
            } else {
                saveButtonPM.setEnabled(false);
            }
        }
    }
}
