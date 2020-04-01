package ui.tabs;

import ui.GUI;

import javax.swing.*;
import java.awt.*;

public abstract class TextPanel extends JPanel {

    protected GUI gui;

    protected JComboBox weekList;
    protected JTextArea textArea;
    private static String[] weekDays = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday",
            "Select A Day"};

    public TextPanel(GUI gui) {
        this.gui = gui;
        setLayout(new GridLayout(0, 1));
        addComboBox();
        addLabel();
        addTextArea();
        addListener();

    }

    public void addComboBox() {
        weekList = new JComboBox(weekDays);
        weekList.setSelectedIndex(7);
        add(weekList);
    }

    protected abstract void addLabel();

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
