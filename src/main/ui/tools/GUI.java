package ui.tools;

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

//import ui.TrackerApp;
import model.MoodEntry;
import model.MoodLog;
import persistence.Reader;
import persistence.Writer;

public class GUI extends JPanel {
    private static final String MOODS_FILE = "./data/moodsGUI.txt";
    private static final int minRating = 0;
    private static final int maxRating = 10;
    protected static JButton setButton;
    protected static JButton setButton1;
    private static JButton saveButtonAM;
    private static JButton saveButtonPM;
    private static JSlider amRatingSlider;
    private static JSlider pmRatingSlider;
    private static double saveNumberHereAM;
    private static double saveNumberHerePM;
    private static JComboBox comboBox1;
    private static JComboBox comboBox2;
    private static JComboBox amList;
    private static JTextArea textAreaAM;
    private static JTextArea textAreaPM;
    private static JTextArea textAreaAverage;
    private static JTextArea textAreaWeekLog;

    private static MoodLog newLog;
    private static MoodLog monday;
    private static MoodLog tuesday;
    private static MoodLog wednesday;
    private static MoodLog thursday;
    private static MoodLog friday;
    private static MoodLog saturday;
    private static MoodLog sunday;
    private static MoodEntry moodEntry;

    public GUI() {
        super(new GridLayout(1, 1));

        JTabbedPane tabbedPane = new JTabbedPane();
        ImageIcon icon = createImageIcon("images/middle.gif");

        //Tab 1
        JPanel panel1 = new JPanel(new GridLayout(0, 1));
        //slider
        ChangeListener amSliderListener = new SliderChangeListener();
        amRatingSlider = new JSlider(minRating, maxRating);
        amRatingSlider.addChangeListener(amSliderListener);
        amRatingSlider.setMajorTickSpacing(1);
        amRatingSlider.setPaintTicks(true);
        amRatingSlider.setPaintLabels(true);
        //JComponent amSlider = amRatingSlider; ///change panel type
        panel1.add(amRatingSlider);
        //enter button
        setButton = new JButton("Set");
        setButton.setActionCommand("set");
        ChangeListener buttonListener = new ButtonChangeListener();
        setButton.addChangeListener(buttonListener);
        ActionListener buttonActionListener = new ButtonActionListener();
        setButton.addActionListener(buttonActionListener);
        panel1.add(setButton);
        //ComboBox
        String[] weekDays = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday",
                "Select A Day"};
        comboBox1 = new JComboBox(weekDays);
        comboBox1.setSelectedIndex(7);
        ActionListener comboBoxListener1 = new ComboBoxActionListener1();
        comboBox1.addActionListener(comboBoxListener1);
        panel1.add(comboBox1);
        //text box
        JLabel label1 = new JLabel("AM Mood: ");
        panel1.add(label1);
        //text panel
        textAreaAM = new JTextArea();
        textAreaAM.setEditable(false);
        panel1.add(textAreaAM);
        //save button
        saveButtonAM = new JButton("Save Mood!");
        saveButtonAM.setActionCommand("save");
        ChangeListener saveAmButtonListener = new ButtonChangeListenerAM();
        saveButtonAM.addChangeListener(saveAmButtonListener);
        ActionListener saveAmButtonActionListener = new ButtonActionListenerAM();
        saveButtonAM.addActionListener(saveAmButtonActionListener);
        panel1.add(saveButtonAM);


        TitledBorder title1;
        title1 = BorderFactory.createTitledBorder("AM Mood");
        panel1.setBorder(title1);
        tabbedPane.addTab("AM Mood", icon, panel1,
                "Does nothing");
        tabbedPane.setMnemonicAt(0, KeyEvent.VK_1);

        //Tab 2
        //slider
        JPanel panel2 = new JPanel(new GridLayout(0, 1));
        ChangeListener pmSliderListener = new SliderChangeListener1();
        pmRatingSlider = new JSlider(minRating, maxRating);
        pmRatingSlider.addChangeListener(pmSliderListener);
        pmRatingSlider.setMajorTickSpacing(1);
        pmRatingSlider.setPaintTicks(true);
        pmRatingSlider.setPaintLabels(true);
        panel2.add(pmRatingSlider);
        setButton1 = new JButton("Set");
        setButton1.setActionCommand("set");
        ChangeListener buttonListener1 = new ButthonChangeListener1();
        setButton1.addChangeListener(buttonListener1);
        ActionListener buttonActionListener1 = new ButtonActionListener1();
        setButton1.addActionListener(buttonActionListener1);
        panel2.add(setButton1);
        //ComboBox
        comboBox2 = new JComboBox(weekDays);
        comboBox2.setSelectedIndex(7);
        ActionListener comboBoxListener2 = new ComboBoxActionListener2();
        comboBox2.addActionListener(comboBoxListener2);
        panel2.add(comboBox2);
        //text box
        JLabel label2 = new JLabel("PM Mood: ");
        panel2.add(label2);
        //text panel
        textAreaPM = new JTextArea();
        textAreaPM.setEditable(false);
        panel2.add(textAreaPM);
        //save button
        saveButtonPM = new JButton("Save Mood!");
        saveButtonPM.setActionCommand("save");
        //ChangeListener savePmButtonListener = new ButtonChangeListenerPM();
        //saveButtonPM.addChangeListener(savePmButtonListener);
        ActionListener savePmButtonActionListener = new ButtonActionListenerPM();
        saveButtonPM.addActionListener(savePmButtonActionListener);
        panel2.add(saveButtonPM);
//        field2 = new JFormattedTextField();
//        field2.setColumns(10);
//        field2.setEditable(false);
//        field2.setBackground(Color.white);
//        field2.setValue(saveNumberHerePM);
//        panel2.add(field2);
        TitledBorder title2;
        title2 = BorderFactory.createTitledBorder("PM Mood");
        panel2.setBorder(title2);
        tabbedPane.addTab("PM Mood", icon, panel2,
                "Does twice as much nothing");
        tabbedPane.setMnemonicAt(1, KeyEvent.VK_2);


        //Tab 3
        //JPanel panel3 = new JPanel(new BorderLayout());
        JPanel panel3 = new JPanel(new GridLayout(0, 1));
        TitledBorder title3;
        title3 = BorderFactory.createTitledBorder("Daily Average");
        panel3.setBorder(title3);
        tabbedPane.addTab("Daily Average", icon, panel3,
                "Still does nothing");
        tabbedPane.setMnemonicAt(2, KeyEvent.VK_3);
        //combo box
        amList = new JComboBox(weekDays);
        amList.setSelectedIndex(7);
        ActionListener comboBoxListener3 = new ComboBoxActionListener3();
        amList.addActionListener(comboBoxListener3);
        panel3.add(amList);
        //result box
        JLabel resultLabel = new JLabel("Average Rating",
                JLabel.LEADING); //== LEFT
        panel3.add(resultLabel);
        //text panel
        textAreaAverage = new JTextArea();
        textAreaAverage.setEditable(false);
        panel3.add(textAreaAverage);

        //Tab 4
        //JComponent panel4 = makeTextPanel("Weekly Log");
        JPanel panel4 = new JPanel(new GridLayout(0, 1));
        //JPanel panel4 = new JPanel(new BorderLayout());
        TitledBorder title4;
        title4 = BorderFactory.createTitledBorder("Weekly Log");
        panel4.setBorder(title4);
        panel4.setPreferredSize(new Dimension(410, 450));
        tabbedPane.addTab("Week Log", icon, panel4,
                "Does nothing at all");
        tabbedPane.setMnemonicAt(3, KeyEvent.VK_4);
        //combo box
        JComboBox weekList = new JComboBox(weekDays);
        ActionListener comboBoxListener4 = new ComboBoxActionListener4();
        weekList.addActionListener(comboBoxListener4);
        weekList.setSelectedIndex(7);
        panel4.add(weekList);
        JLabel resultLabel2 = new JLabel("Ratings for the Week Day: ",
                JLabel.LEADING); //== LEFT
        panel4.add(resultLabel2);
        //text panel
        textAreaWeekLog = new JTextArea();
        textAreaWeekLog.setEditable(false);
        panel4.add(textAreaWeekLog);


        //Add the tabbed pane to this panel.
        add(tabbedPane);

        //The following line enables to use scrolling tabs.
        tabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
    }

    protected JComponent makeTextPanel(String text) {
        JPanel panel = new JPanel(false);
        JLabel filler = new JLabel(text);
        filler.setHorizontalAlignment(JLabel.CENTER);
        panel.setLayout(new GridLayout(1, 1));
        panel.add(filler);
        return panel;
    }

    /**
     * Returns an ImageIcon, or null if the path was invalid.
     */
    protected static ImageIcon createImageIcon(String path) {
        java.net.URL imgURL = GUI.class.getResource(path);
        if (imgURL != null) {
            return new ImageIcon(imgURL);
        } else {
            System.err.println("Couldn't find file: " + path);
            return null;
        }
    }

    private static void init() {
        monday = new MoodLog("Monday", new MoodEntry(0.0, 0.0));
        tuesday = new MoodLog("Tuesday", new MoodEntry(0.0, 0.0));
        wednesday = new MoodLog("Wednesday", new MoodEntry(0.0, 0.0));
        thursday = new MoodLog("Thursday", new MoodEntry(0.0, 0.0));
        friday = new MoodLog("Friday", new MoodEntry(0.0, 0.0));
        saturday = new MoodLog("Saturday", new MoodEntry(0.0, 0.0));
        sunday = new MoodLog("Sunday", new MoodEntry(0.0, 0.0));
    }

    private void updateWeekDay(String weekDay) {
        if (weekDay.equals("Monday")) {
            monday = new MoodLog("Monday", new MoodEntry(saveNumberHereAM, saveNumberHerePM));
        } else if (weekDay.equals("Tuesday")) {
            tuesday = new MoodLog("Tuesday", new MoodEntry(saveNumberHereAM, saveNumberHerePM));
        } else if (weekDay.equals("Wednesday")) {
            wednesday = new MoodLog("Wednesday", new MoodEntry(saveNumberHereAM, saveNumberHerePM));
        } else if (weekDay.equals("Thursday")) {
            thursday = new MoodLog("Thursday", new MoodEntry(saveNumberHereAM, saveNumberHerePM));
        } else if (weekDay.equals("Friday")) {
            friday = new MoodLog("Friday", new MoodEntry(saveNumberHereAM, saveNumberHerePM));
        } else if (weekDay.equals("Saturday")) {
            saturday = new MoodLog("Saturday", new MoodEntry(saveNumberHereAM, saveNumberHerePM));
        } else if (weekDay.equals("Sunday")) {
            sunday = new MoodLog("Sunday", new MoodEntry(saveNumberHereAM, saveNumberHerePM));
        } else {
            System.out.println("Select a Day");
        }
    }

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

    /**
     * Create the GUI and show it.  For thread safety,
     * this method should be invoked from
     * the event dispatch thread.
     */
    private static void createAndShowGUI() {
        //Create and set up the window.
        JFrame frame = new JFrame("TabbedPaneDemo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Add content to the window.
        frame.add(new GUI(), BorderLayout.CENTER);

        //Display the window.
        frame.pack();
        frame.setVisible(true);
        init();
    }


    public static void main(String[] args) {
        //Schedule a job for the event dispatch thread:
        //creating and showing this application's GUI.
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                //Turn off metal's use of bold fonts
                UIManager.put("swing.boldMetal", Boolean.FALSE);
                createAndShowGUI();
            }
        });
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

    public static class ButtonChangeListener implements ChangeListener {
        public void stateChanged(ChangeEvent changeEvent) {
            saveNumberHereAM = amRatingSlider.getValue();
            //System.out.println(saveNumberHere);
        }
    }

    private class ButtonActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if ("set".equals(e.getActionCommand())) {
                setButton.setEnabled(true);
                setButton.getChangeListeners();
                //field1.setValue(saveNumberHereAM);
                //System.out.println(saveNumberHereAM);
                //moodEntry = new MoodEntry((double) saveNumberHereAM, 0.0);
                //moodEntry.setAMmood(saveNumberHereAM);
            } else {
                setButton.setEnabled(false);
            }
        }
    }

    private class ComboBoxActionListener1 implements ActionListener {
        private static final String MOODS_FILE = "./data/moodsGUI.txt";

        @Override
        public void actionPerformed(ActionEvent e) {
            JComboBox cb = (JComboBox) e.getSource();
            String weekName = (String) cb.getSelectedItem();
            updateWeekDay(weekName);
            textAreaAM.append(weekName + " " + saveNumberHereAM + "\n");
            System.out.println(weekName);
        }
    }

    private class ButtonChangeListenerAM implements ChangeListener {
        @Override
        public void stateChanged(ChangeEvent e) {
            saveNumberHereAM = amRatingSlider.getValue();
            String day = (String) comboBox1.getSelectedItem();
        }
    }

    private class ButtonActionListenerAM implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if ("save".equals(e.getActionCommand())) {
                saveButtonAM.setEnabled(true);
                saveButtonAM.getChangeListeners();
                saveMoodLogs();
            } else {
                saveButtonAM.setEnabled(false);
            }
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
                //moodEntry = new MoodEntry(saveNumberHereAM, saveNumberHerePM);
               // moodEntry.setPMmood(saveNumberHerePM);
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
            updateWeekDay(weekName);
            textAreaPM.append(weekName + " " + saveNumberHerePM + "\n");
            System.out.println(weekName); //test

        }
    }

    private class ButtonActionListenerPM implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if ("save".equals(e.getActionCommand())) {
                saveButtonPM.setEnabled(true);
                saveButtonPM.getChangeListeners();
                saveMoodLogs();
            } else {
                saveButtonAM.setEnabled(false);
            }
        }
    }

    //Average tab
    private class ComboBoxActionListener3 implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            JComboBox cb1 = (JComboBox) e.getSource();
            String weekName = (String) cb1.getSelectedItem();
            if (weekName.equals("Monday")) {
                textAreaAverage.append(monday.getAverageMoodLog() + "\n");
                //monday = new MoodLog("Monday", new MoodEntry(saveNumberHereAM, saveNumberHerePM));
            } else if (weekName.equals("Tuesday")) {
                //tuesday = new MoodLog("Tuesday", new MoodEntry(saveNumberHereAM, saveNumberHerePM));
                textAreaAverage.append(tuesday.getAverageMoodLog() + "\n");
                //printAverage(tuesday.getMoodEntry());
            } else if (weekName.equals("Wednesday")) {
                //wednesday = new MoodLog("Wednesday", new MoodEntry(saveNumberHereAM, saveNumberHerePM));
                textAreaAverage.append(wednesday.getAverageMoodLog() + "\n");
                //printAverage(wednesday.getMoodEntry());
            } else if (weekName.equals("Thursday")) {
                //thursday = new MoodLog("Thursday", new MoodEntry(saveNumberHereAM, saveNumberHerePM));
                textAreaAverage.append(thursday.getAverageMoodLog() + "\n");
                //printAverage(thursday.getMoodEntry());
            } else if (weekName.equals("Friday")) {
                //friday = new MoodLog("Friday", new MoodEntry(saveNumberHereAM, saveNumberHerePM));
                textAreaAverage.append(friday.getAverageMoodLog() + "\n");
                //printAverage(friday.getMoodEntry());
            } else if (weekName.equals("Saturday")) {
                //saturday = new MoodLog("Saturday", new MoodEntry(saveNumberHereAM, saveNumberHerePM));
                textAreaAverage.append(saturday.getAverageMoodLog() + "\n");
                //printAverage(saturday.getMoodEntry());
            } else if (weekName.equals("Sunday")) {
                //sunday = new MoodLog("Sunday", new MoodEntry(saveNumberHereAM, saveNumberHerePM));
                textAreaAverage.append(sunday.getAverageMoodLog() + "\n");
                //printAverage(sunday.getMoodEntry());
            } else {
                System.out.println("Select a Day");
            }
        }
    }

    //TAB 4- week log
    private class ComboBoxActionListener4 implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            JComboBox cb = (JComboBox) e.getSource();
            String weekName = (String) cb.getSelectedItem();
            if (weekName.equals("Monday")) {
                textAreaWeekLog.append(monday.toString());
            } else if (weekName.equals("Tuesday")) {
                textAreaWeekLog.append(tuesday.toString());
            } else if (weekName.equals("Wednesday")) {
                textAreaWeekLog.append(wednesday.toString());
            } else if (weekName.equals("Thursday")) {
                textAreaWeekLog.append(thursday.toString());
            } else if (weekName.equals("Friday")) {
                textAreaWeekLog.append(friday.toString());
            } else if (weekName.equals("Saturday")) {
                textAreaWeekLog.append(saturday.toString());
            } else if (weekName.equals("Sunday")) {
                textAreaWeekLog.append(sunday.toString());
            } else {
                System.out.println("Select a Day");
            }
        }
    }
}








