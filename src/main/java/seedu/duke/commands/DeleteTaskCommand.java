package seedu.duke.commands;

import seedu.duke.storage.Storage;
import seedu.duke.storage.StorageTasks;
import seedu.duke.ui.Ui;

import java.io.IOException;

public class DeleteTaskCommand extends Command {
    private int index;

    public DeleteTaskCommand(int index) {
        super();
        this.index = index;
    }

    @Override
    public void execute(Ui ui, Storage storage) throws IOException {
        Storage.tasksList.deleteTask(this.index);
        System.out.println("DELETED!");
        StorageTasks.writeTaskList(Storage.tasksList);
    }
}