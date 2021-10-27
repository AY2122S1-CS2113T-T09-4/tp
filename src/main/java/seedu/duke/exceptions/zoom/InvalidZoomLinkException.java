package seedu.duke.exceptions.zoom;

import seedu.duke.ui.Ui;

public class InvalidZoomLinkException extends Exception {
    public InvalidZoomLinkException() {
        Ui.printMessage("Invalid Zoom Link! (Format: https://google.com");
    }
}
