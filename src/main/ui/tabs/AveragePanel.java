package ui.tabs;

import ui.GUI;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//Represents the average panel
public class AveragePanel extends TextPanel {

    //EFFECTS: constructs the average panel with 2 components (day combobox and text panel)
    public AveragePanel(GUI gui) {
        super(gui);
        setLayout(new GridLayout(0, 1));
        TitledBorder title3;
        title3 = BorderFactory.createTitledBorder("Daily Average");
        setBorder(title3);
    }

    @Override
    protected void addLabel() {
        JLabel resultLabel = new JLabel("Average Rating",
                JLabel.LEADING); //== LEFT
        add(resultLabel);
    }

    @Override
    protected void addListener() {
        weekList.addActionListener(new ComboBoxActionListener3());
    }

    //Average tab
    private class ComboBoxActionListener3 implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            //JComboBox cb1 = (JComboBox) e.getSource();
            //String weekName = (String) cb1.getSelectedItem();
            String weekName = (String) weekList.getSelectedItem();
            String average = gui.printAverage(weekName);
            textArea.append(average);
        }
    }
}
