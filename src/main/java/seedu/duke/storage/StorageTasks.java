package seedu.duke.storage;

import seedu.duke.task.Task;
import seedu.duke.task.Todo;

import java.util.ArrayList;

import static seedu.duke.constants.Messages.TODO;
import static seedu.duke.constants.Messages.INDEX_TODO_DESCRIPTION;
import static seedu.duke.constants.Messages.INDEX_TODO_DATE;
import static seedu.duke.constants.Messages.FIRST_INDEX;

//@author swatim
public class StorageTasks {
    //author ngnigel99 - create in folder
    public static final String folderName = "tasksdata/";
    public static final String fileName   = "scheduleTasks.txt";
    public static final String filePath = folderName + fileName;

    static ArrayList<Task> dataToTask(ArrayList<String> data) {
        ArrayList<Task> tasks = new ArrayList<>();
        int i = 0;
        int dataSize = data.size();
        while (i < dataSize) {
            String dataLine = data.get(i);
            String[] todoArguments = dataLine.split("\\|");
            if (TODO.equals(todoArguments[FIRST_INDEX])) {
                tasks.add(addToDo(todoArguments));
            }
            i++;
        }
        return tasks;
    }

    private static Todo addToDo(String[] todoArguments) {
        String description = todoArguments[INDEX_TODO_DESCRIPTION].trim();
        String date = todoArguments[INDEX_TODO_DATE].trim();
        return new Todo(description, date);
    }

    static ArrayList<String> tasksToData(ArrayList<Task> tasks) {
        ArrayList<String> data = new ArrayList<>();
        for (Task task : tasks) {
            data.add(task.toSaveFileFormat());
        }
        return data;
    }
}
