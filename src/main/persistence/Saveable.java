package persistence;

import java.io.PrintWriter;

public interface Saveable {

    // MODIFIES: printWriter
    // EFFECTS: writes the saveable to printWriter
    // Class adapted from CPSC 210/TellerAPP/2020
    void save(PrintWriter printWriter);
}
