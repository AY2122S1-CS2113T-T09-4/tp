package seedu.duke.commands;

import seedu.duke.storage.Storage;
import seedu.duke.ui.Ui;

public class HelpCommand extends Command{
    @Override
    public void execute(Ui ui, Storage storage) {
        ui.printHelp();
    }
}
