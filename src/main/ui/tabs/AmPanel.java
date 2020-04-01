package ui.tabs;

import ui.GUI;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class AmPanel extends MoodEntryPanel {

    private Double saveNumberHereAm;


    //EFFECTS: constructs the AM Mood panal in the AM Mood tab
    public AmPanel(GUI gui) {
        super(gui);
        TitledBorder title2;
        title2 = BorderFactory.createTitledBorder("AM Mood");
        setBorder(title2);

    }

    @Override
    protected void addLabel() {
        JLabel label1 = new JLabel("AM Mood: ");
        add(label1);
    }



    @Override
    protected void addListener() {
        setButton.addChangeListener(new ButtonChangeListener());
        comboBox.addActionListener(new ComboBoxActionListener1());
        saveButton.addChangeListener(new ButtonChangeListenerAM());
    }

    public class ButtonChangeListener implements ChangeListener {
        @Override
        public void stateChanged(ChangeEvent changeEvent) {
            saveNumberHereAm = Double.valueOf(ratingSlider.getValue());
            gui.setMoodAM(saveNumberHereAm);
        }
    }

    private class ComboBoxActionListener1 implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String weekName = (String) comboBox.getSelectedItem();
            gui.updateAMWeekDay(weekName);
            textArea.append(weekName + " " + saveNumberHereAm + "\n");
        }
    }

    private class ButtonChangeListenerAM implements ChangeListener {
        @Override
        public void stateChanged(ChangeEvent e) {
            saveNumberHereAm = Double.valueOf(ratingSlider.getValue());
        }
    }
}


