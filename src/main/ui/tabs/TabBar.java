package ui.tabs;

import ui.GUI;

import javax.swing.*;

public class TabBar extends JTabbedPane {
    private AmPanel amPanel;
    private PmPanel pmPanel;
    private AveragePanel averagePanel;
    private MoodLogPanel moodLogPanel;
    private GUI gui;


    public TabBar(GUI gui) {
        this.gui = gui;
        //ImageIcon icon = createImageIcon("images/middle.gif");
        amPanel = new AmPanel(gui);
        pmPanel = new PmPanel(gui);
        averagePanel = new AveragePanel(gui);
        moodLogPanel = new MoodLogPanel(gui);

        addTab("AM Mood", amPanel);
        addTab("PM Mood", pmPanel);
        addTab("Average Mood", averagePanel);
        addTab("Mood Log", moodLogPanel);
    }

//    //EFFECTS: Returns an ImageIcon, or null if the path was invalid.
//    //Method adapted from Oracle Java Tutorials (https://docs.oracle.com/javase/tutorial/uiswing/events/intro.html)
//    protected static ImageIcon createImageIcon(String path) {
//        java.net.URL imgURL = GUI.class.getResource(path);
//        if (imgURL != null) {
//            return new ImageIcon(imgURL);
//        } else {
//            System.err.println("Couldn't find file: " + path);
//            return null;
//        }
//    }
}
