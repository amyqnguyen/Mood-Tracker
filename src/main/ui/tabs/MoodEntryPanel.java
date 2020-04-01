package ui.tabs;

import ui.GUI;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//Represents an abstract class used to construct the am and pm panel
public abstract class MoodEntryPanel extends JPanel {

    private static final int minRating = 0;
    private static final int maxRating = 10;
    private static String[] weekDays = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday",
            "Select A Day"};

    protected JButton setButton;
    protected JButton saveButton;
    protected JSlider ratingSlider;
    protected  JComboBox comboBox;
    protected  JTextArea textArea;
    protected GUI gui;


    //EFFECTS: constructs a panel with several components that takes in a gui
    public MoodEntryPanel(GUI gui) {
        this.gui = gui;
        setLayout(new GridLayout(0, 1));
        createSlider();
        createSetButton();
        comboBox();
        addLabel();
        textArea();
        saveButton();
        addListener();
    }

    //EFFECTS: adds a label to the panel
    protected abstract void addLabel();

    //EFFECTS: creates a save button
    public void saveButton() {
        saveButton = new JButton("Save Mood!");
        saveButton.setActionCommand("save");
        ActionListener saveAmButtonActionListener = new ButtonActionListenerAM();
        saveButton.addActionListener(saveAmButtonActionListener);
        add(saveButton);
    }

    //EFFECTS: creates a text panel
    public void textArea() {
        textArea = new JTextArea();
        textArea.setEditable(false);
        JScrollPane textAreaAMScroll = new JScrollPane(textArea);
        textAreaAMScroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        textAreaAMScroll.setMinimumSize(new Dimension(10, 10));
        add(textAreaAMScroll);
    }

    //EFFECTS: creates a combobox
    public void comboBox() {
        comboBox = new JComboBox(weekDays);
        comboBox.setSelectedIndex(7);
        add(comboBox);
    }

    //EFFECTS: creates a set button
    public void createSetButton() {
        setButton = new JButton("Set");
        setButton.setActionCommand("set");
        setButton.addActionListener(new ButtonActionListener());
        add(setButton);
    }

    //EFFECTS: creates a rating slider (0-10)
    protected void createSlider() {
        ratingSlider = new JSlider(minRating, maxRating);
        ratingSlider.setMajorTickSpacing(1);
        ratingSlider.setPaintTicks(true);
        ratingSlider.setPaintLabels(true);
        ratingSlider.addChangeListener(new SliderChangeListener());
        add(ratingSlider);
    }

    // EFFECTS: adds a listener for this panel
    protected abstract void addListener();

    private class SliderChangeListener implements ChangeListener {
        @Override
        public void stateChanged(ChangeEvent e) {
            if (!ratingSlider.getValueIsAdjusting()) {
                System.out.println("Slider changed: " + ratingSlider.getValue());
            }
        }
    }

    private class ButtonActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if ("set".equals(e.getActionCommand())) {
                setButton.setEnabled(true);
                setButton.getChangeListeners();
                gui.playSound("button1.wav");
            } else {
                setButton.setEnabled(false);
            }
        }
    }


    private class ButtonActionListenerAM implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if ("save".equals(e.getActionCommand())) {
                saveButton.setEnabled(true);
                saveButton.getChangeListeners();
                gui.playSound("button4.wav");
                gui.saveMoodLogs();
            } else {
                saveButton.setEnabled(false);
            }
        }
    }
}



