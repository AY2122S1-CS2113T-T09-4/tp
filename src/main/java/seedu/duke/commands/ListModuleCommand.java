package seedu.duke.commands;

import seedu.duke.exceptions.ClickException;
import seedu.duke.module.Module;
import seedu.duke.module.ModuleList;
import seedu.duke.storage.Storage;
import seedu.duke.ui.Ui;

public class ListModuleCommand extends Command {

    public static final String MESSAGE_NO_MODULE = "You don't have any modules";
    public static final String MESSAGE_LISTING_MODULES = "Here are the modules in your list:";

    @Override
    public void execute(Ui ui, Storage storage) throws ClickException, Exception {
        ModuleList moduleList = storage.storageModule.readDataFromFile();
        if (moduleList.getNumberOfModules() <= 0) {
            System.out.println(MESSAGE_NO_MODULE);
            return;
        }
        System.out.println(MESSAGE_LISTING_MODULES);
        int i = 1;
        for (Module m : moduleList.getModules()) {
            System.out.println(i + ". " + m);
            i++;
        }
    }
}
