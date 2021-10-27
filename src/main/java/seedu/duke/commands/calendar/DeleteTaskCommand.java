package seedu.duke.commands.calendar;

import seedu.duke.commands.Command;
import seedu.duke.exceptions.calendar.IncorrectNumberOfArgumentsException;
import seedu.duke.exceptions.calendar.CalendarIndexNotFoundException;
import seedu.duke.storage.Storage;
import seedu.duke.storage.StorageTasks;
import seedu.duke.ui.Ui;
import static seedu.duke.constants.Messages.DELETED_TASK;

import java.io.IOException;


public class DeleteTaskCommand extends Command {
    private int index;
    private String userInput;

    public DeleteTaskCommand() {
        syntax = "calendar delete task [TASK_INDEX]";
    }

    /**
     * Constructor for DeleteTaskCommand class.
     *
     * @param index index of task to be deleted
     * @param userInput input from user
     */
    public DeleteTaskCommand(int index, String userInput) {
        this.index = index;
        this.userInput = userInput;
        helpMessage = "Delete task from calendar";
        syntax = "calendar delete TASK_INDEX";
    }

    /**
     * Executed delete task command.
     *
     * @param ui      The component of CLICK that deals with the interaction with the user.
     * @param storage The component of CLICK that deals with loading tasks from the file and saving tasks in the file.
     * @throws IOException in case of writing to save file error.
     * @throws CalendarIndexNotFoundException if index is not found.
     * @throws IncorrectNumberOfArgumentsException in case of wrong number of arguments.
     */
    @Override
    public void execute(Ui ui, Storage storage) throws IOException,
            CalendarIndexNotFoundException, IncorrectNumberOfArgumentsException {
        if (this.index > storage.tasksList.getTaskList().size()) {
            throw new CalendarIndexNotFoundException();
        }
        Storage.tasksList.deleteTask(this.index);
        System.out.println(DELETED_TASK);
        StorageTasks.writeTaskList(Storage.tasksList);
    }

}