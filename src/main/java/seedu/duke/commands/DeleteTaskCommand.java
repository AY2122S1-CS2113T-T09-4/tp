package seedu.duke.commands;

import seedu.duke.exceptions.IncorrectNumberOfArgumentsException;
import seedu.duke.exceptions.IndexNotFoundException;
import seedu.duke.storage.Storage;
import seedu.duke.storage.StorageTasks;
import seedu.duke.ui.Ui;
import static seedu.duke.constants.Messages.DELETED_TASK;

import java.io.IOException;


public class DeleteTaskCommand extends Command {
    private int index;
    private String userInput;

    /**
     * Constructor for DeleteTaskCommand class.
     *
     * @param index index of task to be deleted
     * @param userInput input from user
     */
    public DeleteTaskCommand(int index, String userInput) {
        this.index = index;
        this.userInput = userInput;
    }

    /**
     * Executed delete task command.
     *
     * @param ui      The component of CLICK that deals with the interaction with the user.
     * @param storage The component of CLICK that deals with loading tasks from the file and saving tasks in the file.
     * @throws IOException if command entered is wrong.
     * @throws IndexNotFoundException if index is not found.
     * @throws IncorrectNumberOfArgumentsException in case of wrong number of arguments.
     */
    @Override
    public void execute(Ui ui, Storage storage) throws IOException,
            IndexNotFoundException, IncorrectNumberOfArgumentsException {
        if (this.index > storage.tasksList.getTaskList().size()) {
            throw new IndexNotFoundException();
        }
        Storage.tasksList.deleteTask(this.index);
        System.out.println(DELETED_TASK);
        StorageTasks.writeTaskList(Storage.tasksList);
    }
}