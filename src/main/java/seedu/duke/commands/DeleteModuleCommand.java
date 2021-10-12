package seedu.duke.commands;

import seedu.duke.exceptions.ClickException;
import seedu.duke.module.ModuleList;
import seedu.duke.storage.Storage;
import seedu.duke.ui.Ui;

public class DeleteModuleCommand extends Command {
    String commandArgs;

    public DeleteModuleCommand(String commandArgs) {
        this.commandArgs = commandArgs;
    }

    @Override
    public void execute(Ui ui, Storage storage) throws ClickException, Exception {
        ModuleList moduleList = storage.storageModule.readDataFromFile();
        int moduleIndex = Integer.parseInt(commandArgs.strip()) - 1;
        System.out.println("I have deleted this module:");
        System.out.println(moduleList.getModuleByIndex(moduleIndex));
        moduleList.removeModuleByIndex(moduleIndex);
        storage.storageModule.saveDataToFile(moduleList);
    }
}
