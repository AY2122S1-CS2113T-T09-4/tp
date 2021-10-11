package seedu.duke;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.util.Scanner;
import java.util.logging.Logger;

import seedu.duke.exceptions.ClickException;
import seedu.duke.logger.ClickLogger;
import seedu.duke.task.TaskList;
import seedu.duke.exceptions.ExceptionHandler;

import seedu.duke.ui.Ui;
import seedu.duke.commands.Command;
import seedu.duke.storage.Storage;
import seedu.duke.parser.Parser;

public class Duke {

    private static Ui ui = new Ui();
    private static ExceptionHandler exceptionHandler = new ExceptionHandler();
    private static Storage storage;
    private static Logger logger;

    static {
        try {
            storage = new Storage();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static Parser parser = new Parser();

    private static void run() {
        logger = ClickLogger.getNewLogger();
        logger.info("running click");

        ui.printGreeting();
        Scanner in = new Scanner(System.in);
        while (true) {
            String userInput = in.hasNextLine() ? in.nextLine()  : null;
            try {
                Command c = parser.parseCommand(userInput);
                c.execute(ui, storage);
                ui.printLine();
            } catch (ClickException e) {
                exceptionHandler.handleDukeExceptions(e, userInput);
            } catch (Exception  e) {
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
