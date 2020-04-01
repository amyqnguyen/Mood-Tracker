package ui.tabs;


import ui.GUI;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


//Represents the mood log panel in the GUI
public class MoodLogPanel extends TextPanel {

    //EFFECTS: constructs the Week Log panel with 2 components (day combobox and a text panel)
    public MoodLogPanel(GUI gui) {
        super(gui);
        TitledBorder title4;
        title4 = BorderFactory.createTitledBorder("Weekly Log");
        setBorder(title4);
    }

    @Override
    protected void addLabel() {
        JLabel resultLabel2 = new JLabel("Current Mood Ratings for the Week: ",
                JLabel.LEADING); //== LEFT
        add(resultLabel2);
    }

    @Override
    protected void addListener() {
        weekList.addActionListener(new ComboBoxActionListener4());
    }

    //TAB 4- week log
    private class ComboBoxActionListener4 implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
//            JComboBox cb = (JComboBox) e.getSource();
//            String weekName = (String) cb.getSelectedItem();
            String weekName = (String) weekList.getSelectedItem();
            String log = gui.printMoodLog(weekName);
            textArea.append(log);
        }
    }
}
