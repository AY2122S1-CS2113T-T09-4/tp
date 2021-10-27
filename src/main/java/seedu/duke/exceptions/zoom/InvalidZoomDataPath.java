package seedu.duke.exceptions.zoom;

import seedu.duke.ui.Ui;

public class InvalidZoomDataPath extends Exception {
    public InvalidZoomDataPath() {
        Ui.printMessage("Cannot find the requested zoom data file");
    }
}
