package ui.tools;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.KeyEvent;

public class GUI extends JPanel {
    static final int minRating = 0;
    static final int maxRating = 10;
    static final int initialRating = 5;

    public GUI() {
        super(new GridLayout(1, 1));

        JTabbedPane tabbedPane = new JTabbedPane();
        ImageIcon icon = createImageIcon("images/middle.gif");

        //Tab 1
        //slider
        JPanel panel1 = new JPanel(new BorderLayout());
        JSlider amRatingSlider = new JSlider(minRating,maxRating);
//      amRatingSlider.addChangeListener((ChangeListener) this);
        amRatingSlider.setMajorTickSpacing(1);
        amRatingSlider.setPaintTicks(true);
        amRatingSlider.setPaintLabels(true);
        //JComponent amSlider = amRatingSlider; ///change panel type
        panel1.add(amRatingSlider, BorderLayout.CENTER);
        //enter button
        JButton setButton = new JButton("Set");
        panel1.add(setButton, BorderLayout.PAGE_END);
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
        JPanel panel2 = new JPanel(new BorderLayout());
        JSlider pmRatingSlider = new JSlider(minRating,maxRating);
//        amRatingSlider.addChangeListener((ChangeListener) this);
        pmRatingSlider.setMajorTickSpacing(1);
        pmRatingSlider.setPaintTicks(true);
        pmRatingSlider.setPaintLabels(true);
        panel2.add(pmRatingSlider, BorderLayout.CENTER);
        JButton setButton1 = new JButton("Set");
        panel2.add(setButton1, BorderLayout.PAGE_END);
        //JComponent panel2 = pmRatingSlider;
        TitledBorder title2;
        title2 = BorderFactory.createTitledBorder("PM Mood");
        panel2.setBorder(title2);
        tabbedPane.addTab("PM Mood", icon, panel2,
                "Does twice as much nothing");
        tabbedPane.setMnemonicAt(1, KeyEvent.VK_2);

        //Tab 3
        JComponent panel3 = makeTextPanel("Daily Average");
        TitledBorder title3;
        title3 = BorderFactory.createTitledBorder("Daily Average");
        panel3.setBorder(title3);
        tabbedPane.addTab("Daily Average", icon, panel3,
                "Still does nothing");
        tabbedPane.setMnemonicAt(2, KeyEvent.VK_3);

        //Tab 4
        JComponent panel4 = makeTextPanel("Weekly Log");
        TitledBorder title4;
        title4 = BorderFactory.createTitledBorder("Weekly Log");
        panel4.setBorder(title4);
        panel4.setPreferredSize(new Dimension(410, 450));
        tabbedPane.addTab("Week Log", icon, panel4,
                "Does nothing at all");
        tabbedPane.setMnemonicAt(3, KeyEvent.VK_4);

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
}
