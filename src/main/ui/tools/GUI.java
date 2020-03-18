package ui.tools;

import javax.swing.*;
import java.awt.*;
import javax.swing.border.TitledBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.event.*;

//import ui.TrackerApp;
import model.MoodEntry;

public class GUI extends JPanel implements ActionListener{
    static final int minRating = 0;
    static final int maxRating = 10;
    protected static JButton setButton;
    protected static JButton setButton1;
    private static JSlider amRatingSlider;
    private static JSlider pmRatingSlider;
    private static JFormattedTextField field1;
    private static JFormattedTextField field2;
    private static int saveNumberHereAM;
    private static int saveNumberHerePM;
//    int amRating;
//    int pmRating;

    public GUI() {
        super(new GridLayout(1, 1));

        JTabbedPane tabbedPane = new JTabbedPane();
        ImageIcon icon = createImageIcon("images/middle.gif");

        //Tab 1
        //slider
        JPanel panel1 = new JPanel(new GridLayout(0, 1));
        ChangeListener amSliderListener = new SliderChangeListener();
        amRatingSlider = new JSlider(minRating,maxRating);
        amRatingSlider.addChangeListener(amSliderListener);
        amRatingSlider.setMajorTickSpacing(1);
        amRatingSlider.setPaintTicks(true);
        amRatingSlider.setPaintLabels(true);
        //JComponent amSlider = amRatingSlider; ///change panel type
        panel1.add(amRatingSlider);
        //enter button
        setButton = new JButton("Set");
        setButton.setActionCommand("set");
        ChangeListener buttonListener = new ButthonChangeListener();
        setButton.addChangeListener(buttonListener);
        ActionListener buttonActionListener = new ButtonActionListener();
        setButton.addActionListener(buttonActionListener);
        //setButton.addActionListener(this::actionPerformed);
        panel1.add(setButton);
        //text box
        JLabel label1 = new JLabel("AM Mood: ");
        panel1.add(label1);
        field1 = new JFormattedTextField();
        field1.setColumns(10);
        field1.setEditable(false);
        field1.setBackground(Color.white);
        //double d = saveNumberHere; ///TEST
        field1.setValue(saveNumberHereAM);
        panel1.add(field1);
        //main panel
        //Container contentPane = new Container();

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
        pmRatingSlider = new JSlider(minRating,maxRating);
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
        //text box
        JLabel label2 = new JLabel("PM Mood: ");
        panel2.add(label2);
        field2 = new JFormattedTextField();
        field2.setColumns(10);
        field2.setEditable(false);
        field2.setBackground(Color.white);
        field2.setValue(saveNumberHerePM);
        panel2.add(field2);
        TitledBorder title2;
        title2 = BorderFactory.createTitledBorder("PM Mood");
        panel2.setBorder(title2);
        tabbedPane.addTab("PM Mood", icon, panel2,
                "Does twice as much nothing");
        tabbedPane.setMnemonicAt(1, KeyEvent.VK_2);


        //Tab 3
        //JPanel panel3 = new JPanel(new BorderLayout());
        JPanel panel3 = new JPanel(new GridLayout(0, 1));
        //JComponent panel3 = makeTextPanel("Daily Average");
        TitledBorder title3;
        title3 = BorderFactory.createTitledBorder("Daily Average");
        panel3.setBorder(title3);
        tabbedPane.addTab("Daily Average", icon, panel3,
                "Still does nothing");
        tabbedPane.setMnemonicAt(2, KeyEvent.VK_3);
        //combo box
        String[] amDays = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
        JComboBox amList = new JComboBox(amDays);
        amList.setSelectedIndex(6);
        //amList.setEditable(true);
        panel3.add(amList);
        //result box
        JLabel resultLabel = new JLabel("Average Rating",
                JLabel.LEADING); //== LEFT
        JLabel result = new JLabel(" ");
        result.setForeground(Color.black);
        result.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.black),
                BorderFactory.createEmptyBorder(5,5,5,5)
        ));
        panel3.add(resultLabel);
        panel3.add(result);

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
        String[] weekDays = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
        JComboBox weekList = new JComboBox(weekDays);
        amList.setSelectedIndex(6);
        panel4.add(weekList);
        JLabel resultLabel2 = new JLabel("Average Rating",
                JLabel.LEADING); //== LEFT
        JLabel result2 = new JLabel(" ");
        result2.setForeground(Color.black);
        result2.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.black),
                BorderFactory.createEmptyBorder(1,1,1,1)
        ));
        panel4.add(resultLabel2);
        panel4.add(result2);


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

    /** Returns an ImageIcon, or null if the path was invalid. */
    protected static ImageIcon createImageIcon(String path) {
        java.net.URL imgURL = GUI.class.getResource(path);
        if (imgURL != null) {
            return new ImageIcon(imgURL);
        } else {
            System.err.println("Couldn't find file: " + path);
            return null;
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

    //SLIDER action
    //Listens to the button
    @Override
    public void actionPerformed(ActionEvent e) {
        JSlider source = (JSlider)e.getSource();
        if ("set".equals(e.getActionCommand())) {
            setButton.setEnabled(true);
            int amRating = source.getValue();
            MoodEntry moodEntry = new MoodEntry((double) amRating, 0.0);
        } else {
            setButton.setEnabled(false);
        }
    }

    //Listens to slider
//    @Override
//    public void stateChanged(ChangeEvent e) {
//        JSlider source = (JSlider)e.getSource();
//        if (!source.getValueIsAdjusting()) {
//            this.amRating = (int)source.getValue();
//            MoodEntry moodEntry = new MoodEntry((double) amRating, 0.0);
//            moodEntry.setAMmood((double) amRating);
//            System.out.println("Slider changed: " + (int)source.getValue());
//            //update Moodentry
//        }
//    }

    /// TAB1-AM
    private class SliderChangeListener implements ChangeListener {
        @Override
        public void stateChanged(ChangeEvent e) {
            if (!amRatingSlider.getValueIsAdjusting()) {
                System.out.println("Slider changed: " + amRatingSlider.getValue());
            }
        }
    }

    public static class ButthonChangeListener implements ChangeListener {
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
                field1.setValue(saveNumberHereAM);
                System.out.println(saveNumberHereAM);
                MoodEntry moodEntry = new MoodEntry((double) saveNumberHereAM, 0.0);
            } else {
                setButton.setEnabled(false);
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
                field2.setValue(saveNumberHerePM);
                System.out.println(saveNumberHerePM);
                MoodEntry moodEntry = new MoodEntry((double) saveNumberHereAM, (double) saveNumberHerePM);
            } else {
                setButton1.setEnabled(false);
            }
        }
    }


}

    //update Moodentry? method

