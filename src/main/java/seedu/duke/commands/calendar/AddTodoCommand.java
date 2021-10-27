package seedu.duke.commands.calendar;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import seedu.duke.commands.Command;
import seedu.duke.exceptions.calendar.DuplicateTaskException;
import seedu.duke.exceptions.calendar.InvalidDateException;
import seedu.duke.schedule.task.Task;
import seedu.duke.schedule.task.Todo;
import seedu.duke.storage.Storage;
import seedu.duke.storage.StorageTasks;
import seedu.duke.ui.Ui;

import static seedu.duke.constants.Messages.INDEX_TODO_DESCRIPTION;
import static seedu.duke.constants.Messages.INDEX_TODO_DATE;

/**
 * Class to execute adding of todo task.
 *
 * @author swatimahadevan
 */
public class AddTodoCommand extends Command {

    private ArrayList<String> arguments;

    public AddTodoCommand() {
        syntax = "calendar todo n/ [TASK_NAME] d/ [DD-MM-YYYY]";
    }

    /**
     * Constructor for AddTodoCommand.
     *
     * @param arguments which has the todo task arguments.
     */
    public AddTodoCommand(ArrayList<String> arguments) {
        super();
        this.arguments = arguments;
        this.helpMessage = "Add a todo task to calendar";
    }

    /**
     * To check that date is in the format dd-MM-YYYY.
     *
     * @param todoDateStringFormat todo date
     * @return
     */
    public static boolean isValid(String todoDateStringFormat) {
        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        dateFormat.setLenient(false);
        try {
            dateFormat.parse(todoDateStringFormat);
        } catch (ParseException e) {
            return false;
        }
        return true;
    }

    public static void checkIfDateValid(String todoDateStringFormat) throws InvalidDateException {
        if (!isValid(todoDateStringFormat)) {
            throw new InvalidDateException();
        }
    }

    public static void checkIfDuplicate(Task task) throws InvalidDateException, DuplicateTaskException {
        for (int i = 0; i < Storage.tasksList.getTaskList().size(); i++) {
            if (task.getDescription().equals(Storage.tasksList.getTaskList().get(i).getDescription())) {
                throw new DuplicateTaskException("A task by this name has already been added!");
            }
        }
    }

    /**
     * To execute adding of todo.
     *
     * @param ui      The component of CLICK that deals with the interaction with the user.
     * @param storage The component of CLICK that deals with loading tasks from the file and saving tasks in the file.
     * @throws IOException in case of writing to save file error.
     * @throws ParseException in case of error while parsing.
     * @throws InvalidDateException in case date is incorrect.
     * @throws DuplicateTaskException in case task already exists.
     */
    @Override
    public void execute(Ui ui, Storage storage) throws IOException,
            ParseException, DuplicateTaskException, InvalidDateException {
        String description = arguments.get(INDEX_TODO_DESCRIPTION).trim();
        String todoDateStringFormat = arguments.get(INDEX_TODO_DATE);
        Task task = new Todo(description, todoDateStringFormat);
        checkIfDuplicate(task);
        checkIfDateValid(todoDateStringFormat);
        storage.tasksList.addTask(task);
        Ui.printTaskAddedMessage();
        StorageTasks.writeTaskList(storage.tasksList);
    }

}