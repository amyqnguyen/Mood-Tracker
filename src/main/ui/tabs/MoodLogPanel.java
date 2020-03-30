package ui.tabs;

import model.MoodLog;
import ui.GUI;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;


public class MoodLogPanel extends JPanel {
    private static String[] weekDays = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday",
            "Select A Day"};

    private static JTextArea textAreaWeekLog;
    private static JComboBox weekList;
    MoodLog monday;
    MoodLog tuesday;
    MoodLog wednesday;
    MoodLog thursday;
    MoodLog friday;
    MoodLog saturday;
    MoodLog sunday;
    GUI gui;

    //EFFECTS: constructs the Week Log panel with 2 components (day combobox and a text panel)
    public MoodLogPanel(GUI gui) {
        this.gui = gui;
        setLayout(new GridLayout(0, 1));
        //JPanel panel4 = new JPanel(new GridLayout(0, 1));
        TitledBorder title4;
        title4 = BorderFactory.createTitledBorder("Weekly Log");
        setBorder(title4);
        setPreferredSize(new Dimension(410, 450));
        //tabbedPane.addTab("Week Log", icon, panel4,
        //"Does nothing at all");
        //tabbedPane.setMnemonicAt(3, KeyEvent.VK_4);
        //text panel
        textAreaWeekLog = new JTextArea();
        textAreaWeekLog.setEditable(false);
        JScrollPane textAreaWeekScroll = new JScrollPane(textAreaWeekLog);
        textAreaWeekScroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        textAreaWeekScroll.setMinimumSize(new Dimension(10, 10));
        //combo box
        weekList = new JComboBox(weekDays);
        ActionListener comboBoxListener4 = new ComboBoxActionListener4();
        weekList.addActionListener(comboBoxListener4);
        weekList.setSelectedIndex(7);
        add(weekList);
        JLabel resultLabel2 = new JLabel("Current Mood Ratings for the Week: ",
                JLabel.LEADING); //== LEFT
        add(resultLabel2);
        add(textAreaWeekScroll);
    }

    //TAB 4- week log
    private class ComboBoxActionListener4 implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            JComboBox cb = (JComboBox) e.getSource();
            String weekName = (String) cb.getSelectedItem();
            String log = gui.printMoodLog(weekName);
            System.out.println(log);
            textAreaWeekLog.append(log);
        }
    }
}