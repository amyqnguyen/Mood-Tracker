package ui.tabs;

import ui.GUI;

import javax.swing.*;
import java.awt.*;

//Represents an abstract class that creates a text panel
public abstract class TextPanel extends JPanel {

    protected GUI gui;

    protected JComboBox weekList;
    protected JTextArea textArea;
    private static String[] weekDays = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday",
            "Select A Day"};

    //EFFECTS: constructs a text panel with several components that takes in a gui
    public TextPanel(GUI gui) {
        this.gui = gui;
        setLayout(new GridLayout(0, 1));
        addComboBox();
        addLabel();
        addTextArea();
        addListener();

    }

    //EFFECTS: creates a combo box
    public void addComboBox() {
        weekList = new JComboBox(weekDays);
        weekList.setSelectedIndex(7);
        add(weekList);
    }

    //EFFECTS: creates a label
    protected abstract void addLabel();

    //EFFECTS: creates a text area
    public void addTextArea() {
        textArea = new JTextArea();
        textArea.setEditable(false);
        JScrollPane textAreaAverageScroll = new JScrollPane(textArea);
        textAreaAverageScroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        textAreaAverageScroll.setMinimumSize(new Dimension(10, 10));
        add(textAreaAverageScroll);
    }

    // EFFECTS: adds a listener for this tool
    protected abstract void addListener();

}
