package ui.tabs;

import ui.GUI;

import javax.swing.*;

//Represents the tab bar for the GUI
public class TabBar extends JTabbedPane {
    private AmPanel amPanel;
    private PmPanel pmPanel;
    private AveragePanel averagePanel;
    private MoodLogPanel moodLogPanel;
    private GUI gui;


    //EFFECTS: constructs a tab bar with 4 panels and takes in a gui
    public TabBar(GUI gui) {
        this.gui = gui;
        amPanel = new AmPanel(gui);
        pmPanel = new PmPanel(gui);
        averagePanel = new AveragePanel(gui);
        moodLogPanel = new MoodLogPanel(gui);

        addTab("AM Mood", amPanel);
        addTab("PM Mood", pmPanel);
        addTab("Average Mood", averagePanel);
        addTab("Mood Log", moodLogPanel);
    }

}
