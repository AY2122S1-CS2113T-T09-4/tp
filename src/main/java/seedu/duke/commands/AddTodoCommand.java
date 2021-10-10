package seedu.duke.commands;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import seedu.duke.storage.Storage;
import seedu.duke.ui.Ui;
import seedu.duke.task.Task;
import seedu.duke.task.Todo;

import static seedu.duke.constants.Messages.INDEX_TODO_DESCRIPTION;
import static seedu.duke.constants.Messages.INDEX_TODO_DATE;

//@author swatim
public class AddTodoCommand extends Command {

    private ArrayList<String> arguments;

    public String parseDate(String todoDate) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
        Date parsed = format.parse(todoDate);
        return format.format(parsed);
    }

    public AddTodoCommand(ArrayList<String> arguments) {
        super();
        this.arguments = arguments;
    }

    //Adds Task task into TaskList
    @Override
    public void execute(Ui ui, Storage storage) throws IOException, ParseException {
        String description = arguments.get(INDEX_TODO_DESCRIPTION);
        String date = parseDate(arguments.get(INDEX_TODO_DATE));
        Task task = new Todo(description, date);
        storage.tasksList.addTask(task);
        Ui.printTaskAddedMessage();
        storage.writeTaskList(storage.tasksList);
    }

}
