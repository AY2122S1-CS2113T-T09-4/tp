package seedu.duke.zoom;

import org.junit.jupiter.api.Test;
import seedu.duke.commands.zoom.AddZoomCommand;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LinkTest {
    static AddZoomCommand addition = new AddZoomCommand("moduleName", "https://test.com");

    @Test
    void checkZoomLink() {
        assertEquals(addition.getZoomLink().split("//")[0].trim(), "https:");
    }
}
