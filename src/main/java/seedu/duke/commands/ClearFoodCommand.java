package seedu.duke.commands;

import seedu.duke.storage.Storage;
import seedu.duke.storage.StorageFood;
import seedu.duke.task.TaskList;
import seedu.duke.ui.Ui;

import java.io.IOException;
import java.util.Scanner;

/**
 * Clears the current list  of food, and clear entries in storage.
 * @author  ngnigel99
 */
public class ClearFoodCommand extends Command {
    @Override
    public void execute(Ui ui, Storage storage) throws IOException {
        storage.whatIAteTodayList.clearList();
        StorageFood.saveList(storage.whatIAteTodayList);
    }
}
