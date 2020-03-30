package ui.tabs;

import model.MoodLog;
import ui.GUI;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

public class AveragePanel extends JPanel {
    private static JComboBox amList;
    private static JTextArea textAreaAverage;
    private static String[] weekDays = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday",
            "Select A Day"};

    MoodLog monday;
    MoodLog tuesday;
    MoodLog wednesday;
    MoodLog thursday;
    MoodLog friday;
    MoodLog saturday;
    MoodLog sunday;
    GUI gui;

    //EFFECTS: constructs the Week Log panel with 2 components (day combobox and text panel)
    public AveragePanel(GUI gui) {
        this.gui = gui;
        setLayout(new GridLayout(0, 1));
        //JPanel panel3 = new JPanel(new GridLayout(0, 1));
        TitledBorder title3;
        title3 = BorderFactory.createTitledBorder("Daily Average");
        setBorder(title3);
//        tabbedPane.addTab("Daily Average", icon, panel3,
//                "Still does nothing");
//        tabbedPane.setMnemonicAt(2, KeyEvent.VK_3);
        //combo box
        amList = new JComboBox(weekDays);
        amList.setSelectedIndex(7);
        ActionListener comboBoxListener3 = new ComboBoxActionListener3();
        amList.addActionListener(comboBoxListener3);
        add(amList);
        //result box
        JLabel resultLabel = new JLabel("Average Rating",
                JLabel.LEADING); //== LEFT
        add(resultLabel);
        //text panel
        textAreaAverage = new JTextArea();
        textAreaAverage.setEditable(false);
        JScrollPane textAreaAverageScroll = new JScrollPane(textAreaAverage);
        textAreaAverageScroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        textAreaAverageScroll.setMinimumSize(new Dimension(10, 10));
        add(textAreaAverageScroll);
    }

    //Average tab
    private class ComboBoxActionListener3 implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            JComboBox cb1 = (JComboBox) e.getSource();
            String weekName = (String) cb1.getSelectedItem();
            String average = gui.printAverage(weekName);
            textAreaAverage.append(average);
        }
    }
}