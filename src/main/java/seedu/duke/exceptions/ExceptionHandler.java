package seedu.duke.exceptions;

import seedu.duke.ui.Ui;

/**
 * A class that handles exceptions thrown by Duke.
 */
public class ExceptionHandler {

    private static Ui ui = new Ui();

    /**
     * Handles duke exceptions.
     *
     * @param e Exception of type DukeException thrown by Duke.
     */
    public static void handleDukeExceptions(ClickException e, String userInput) {
        System.out.println("hey, I can't " + userInput + " yet, try help for more commands");
    }

    /**
     * Handles other exceptions.
     *
     * @param e Exception of types other than DukeException thrown by Duke.
     */
    public static void handleOtherExceptions(Exception e) {
        System.out.println("OOPs, invalid command, try help for more commands.");
    }
}
