package ui.tabs;

import ui.GUI;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;



public class AmPanel extends JPanel {
    private static final String MOODS_FILE = "./data/moodsGUI.txt";
    private static final int minRating = 0;
    private static final int maxRating = 10;
    protected static JButton setButton;
    private static JButton saveButtonAM;
    private static JSlider amRatingSlider;
    private static double saveNumberHereAM;
    private static JComboBox comboBox1;
    private static JTextArea textAreaAM;
    private static String[] weekDays = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday",
            "Select A Day"};

    GUI gui;


    //EFFECTS: constructs the AM Mood panal in the AM Mood tab
    public AmPanel(GUI gui) {
        this.gui = gui;
        setLayout(new GridLayout(0, 1));
        amSlider();
        amSetButtion();
        comboBoxAm();
        JLabel label1 = new JLabel("AM Mood: ");
        add(label1);
        textPanelAm();
        saveButtonAm();
    }

    //EFFECTS: creates a save button for AM Mood
    private void saveButtonAm() {
        saveButtonAM = new JButton("Save Mood!");
        saveButtonAM.setActionCommand("save");
        ChangeListener saveAmButtonListener = new ButtonChangeListenerAM();
        saveButtonAM.addChangeListener(saveAmButtonListener);
        ActionListener saveAmButtonActionListener = new ButtonActionListenerAM();
        saveButtonAM.addActionListener(saveAmButtonActionListener);
        add(saveButtonAM);
    }

    //EFFECTS: creates a text panel for AM Mood
    private void textPanelAm() {
        textAreaAM = new JTextArea();
        textAreaAM.setEditable(false);
        JScrollPane textAreaAMScroll = new JScrollPane(textAreaAM);
        textAreaAMScroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        textAreaAMScroll.setMinimumSize(new Dimension(10, 10));
        add(textAreaAMScroll);
    }

    //EFFECTS: creates a combobox for AM Mood
    private void comboBoxAm() {
        comboBox1 = new JComboBox(weekDays);
        comboBox1.setSelectedIndex(7);
        ActionListener comboBoxListener1 = new ComboBoxActionListener1();
        comboBox1.addActionListener(comboBoxListener1);
        add(comboBox1);
    }

    //EFFECTS: creates a set button for AM Mood
    private void amSetButtion() {
        setButton = new JButton("Set");
        setButton.setActionCommand("set");
        ChangeListener buttonListener = new ButtonChangeListener();
        setButton.addChangeListener(buttonListener);
        ActionListener buttonActionListener = new ButtonActionListener();
        setButton.addActionListener(buttonActionListener);
        add(setButton);
    }

    //EFFECTS: creates a rating slider (0-10) for AM Mood
    private void amSlider() {
        ChangeListener amSliderListener = new SliderChangeListener();
        amRatingSlider = new JSlider(minRating, maxRating);
        amRatingSlider.addChangeListener(amSliderListener);
        amRatingSlider.setMajorTickSpacing(1);
        amRatingSlider.setPaintTicks(true);
        amRatingSlider.setPaintLabels(true);
        add(amRatingSlider);
    }

    //EFFECTS: plays soundName
    //Method adapted from http://suavesnippets.blogspot.com/2011/06/add-sound-on-jbutton-click-in-java.html
    private void playSound(String soundName) {
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


    /// TAB1-AM
    private class SliderChangeListener implements ChangeListener {
        @Override
        public void stateChanged(ChangeEvent e) {
            if (!amRatingSlider.getValueIsAdjusting()) {
                System.out.println("Slider changed: " + amRatingSlider.getValue());
            }
        }
    }

    public class ButtonChangeListener implements ChangeListener {
        public void stateChanged(ChangeEvent changeEvent) {
            saveNumberHereAM = amRatingSlider.getValue();
            gui.setMoodAM(saveNumberHereAM);
        }
    }

    private class ButtonActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if ("set".equals(e.getActionCommand())) {
                setButton.setEnabled(true);
                setButton.getChangeListeners();
                playSound("button1.wav");
            } else {
                setButton.setEnabled(false);
            }
        }
    }

    private class ComboBoxActionListener1 implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            JComboBox cb = (JComboBox) e.getSource();
            String weekName = (String) cb.getSelectedItem();
            gui.updateAMWeekDay(weekName);
            textAreaAM.append(weekName + " " + saveNumberHereAM + "\n");
        }
    }

    private class ButtonChangeListenerAM implements ChangeListener {
        @Override
        public void stateChanged(ChangeEvent e) {
            saveNumberHereAM = amRatingSlider.getValue();
        }
    }

    private class ButtonActionListenerAM implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if ("save".equals(e.getActionCommand())) {
                saveButtonAM.setEnabled(true);
                saveButtonAM.getChangeListeners();
                playSound("button4.wav");
                gui.saveMoodLogs();
            } else {
                saveButtonAM.setEnabled(false);
            }
        }
    }
}
