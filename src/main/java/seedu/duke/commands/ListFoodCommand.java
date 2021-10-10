package seedu.duke.commands;

import seedu.duke.storage.Storage;
import seedu.duke.task.TaskList;
import seedu.duke.ui.Ui;

import java.util.Scanner;

/**
 * List all current records (assumed today for simplicity).
 * @author ngnigel99
 */
public class ListFoodCommand extends Command  {
    @Override
    public void execute(Ui ui, Storage storage) {
        storage.whatIAteTodayList.printList();
    }
}
