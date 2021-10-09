package seedu.duke;

import java.io.IOException;
import java.util.Scanner;

import seedu.duke.exceptions.ClickException;
import seedu.duke.task.TaskList;
import seedu.duke.exceptions.ExceptionHandler;
import seedu.duke.schedule.Schedule;

import seedu.duke.ui.Ui;
import seedu.duke.commands.Command;
import seedu.duke.storage.Storage;
import seedu.duke.exceptions.ExceptionHandler;
import seedu.duke.parser.Parser;

public class Duke {

    private static Ui ui = new Ui();
    private static ExceptionHandler exceptionHandler = new ExceptionHandler();
    private static Storage storage;

    static {
        try {
            storage = new Storage();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static Parser parser = new Parser();

    /**
     * Reads and executes command from user inputs.
     */
    private static void run() {
        ui.printGreeting();
        Scanner in = new Scanner(System.in);
        while (true) {
            String userInput = ui.getUserInput(in);
            try {
                Command c = parser.parseCommand(userInput);
                c.execute(ui, storage);
                ui.printLine();
            } catch (ClickException e) {
                exceptionHandler.handleDukeExceptions(e);
            } catch (Exception e) {
                exceptionHandler.handleOtherExceptions(e);
            }
        }
    }

    /**
     * Main entry method to run Duke.
     *
     * @param args Unused params.
     */
    public static void main(String[] args) {
        new Duke();
        Duke.run();
    }
}
