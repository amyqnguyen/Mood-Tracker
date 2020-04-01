package ui.tabs;

import ui.GUI;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//Represents the pm panel in the gui
public class PmPanel extends MoodEntryPanel {

    private Double saveNumberHerePm;

    //EFFECTS: constructs the pm Mood panal in the PM Mood tab
    public PmPanel(GUI gui) {
        super(gui);
        TitledBorder title2;
        title2 = BorderFactory.createTitledBorder("PM Mood");
        setBorder(title2);
    }

    @Override
    protected void addLabel() {
        JLabel label2 = new JLabel("PM Mood: ");
        add(label2);
    }

    @Override
    protected void addListener() {
        setButton.addChangeListener(new ButtonChangeListener());
        comboBox.addActionListener(new ComboBoxActionListener1());
        saveButton.addChangeListener(new ButtonChangeListenerPM());
    }


    public class ButtonChangeListener implements ChangeListener {
        @Override
        public void stateChanged(ChangeEvent changeEvent) {
            saveNumberHerePm = Double.valueOf(ratingSlider.getValue());
            gui.setMoodPM(saveNumberHerePm);
        }
    }

    private class ComboBoxActionListener1 implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // JComboBox cb = (JComboBox) e.getSource();
            String weekName = (String) comboBox.getSelectedItem();
            //String weekName = (String) cb.getSelectedItem();
            gui.updatePMWeekDay(weekName);
            textArea.append(weekName + " " + saveNumberHerePm + "\n");
        }
    }

    private class ButtonChangeListenerPM implements ChangeListener {
        @Override
        public void stateChanged(ChangeEvent e) {
            saveNumberHerePm = Double.valueOf(ratingSlider.getValue());
        }
    }
}





