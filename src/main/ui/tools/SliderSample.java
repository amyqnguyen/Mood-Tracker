package ui.tools;

import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.util.Hashtable;

public class SliderSample {
    private static JFrame frame = new JFrame("Sample Sliders");
    private static JSlider slider = new JSlider(1, 5);
    private static JButton button = new JButton("Button");
    private static int saveNumberHere;


    public static void main(final String args[]) {
        Runnable runner = new Runnable() {
            public void run() {

                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                Hashtable<Integer, JComponent> table = new Hashtable<Integer, JComponent>();
                table.put(1, new JLabel("1"));
                table.put(2, new JLabel("2"));
                table.put(3, new JLabel("3"));
                table.put(4, new JLabel("4"));
                table.put(5, new JLabel("5"));
                slider.setLabelTable(table);
                slider.setPaintLabels(true);

                ChangeListener sliderListener = new SliderChangeListener();
                slider.addChangeListener(sliderListener);
                ChangeListener buttonListener = new ButthonChangeListener();
                button.addChangeListener(buttonListener);

                frame.add(slider, BorderLayout.CENTER);
                frame.add(button, BorderLayout.SOUTH);
                frame.setSize(400, 300);
                frame.setVisible(true);
            }
        };
        EventQueue.invokeLater(runner);
    }

    public static class SliderChangeListener implements ChangeListener {
        public void stateChanged(ChangeEvent changeEvent) {
            if (!slider.getValueIsAdjusting()) {
                System.out.println("Slider changed: " + slider.getValue());
            }
        }
    }

    public static class ButthonChangeListener implements ChangeListener {
        public void stateChanged(ChangeEvent changeEvent) {
            saveNumberHere = slider.getValue();
            System.out.println(saveNumberHere);
        }
    }
}