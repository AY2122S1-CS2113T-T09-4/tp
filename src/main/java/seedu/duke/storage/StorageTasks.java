package seedu.duke.storage;

import seedu.duke.task.Task;
import seedu.duke.task.TaskList;
import seedu.duke.task.Todo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
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

    public static ArrayList<String> tasksToData(ArrayList<Task> tasks) {
        ArrayList<String> data = new ArrayList<>();
        for (Task task : tasks) {
            data.add(task.toSaveFileFormat());
        }
        return data;
    }

    public static void writeTaskList(TaskList taskList) throws IOException {
        ArrayList<Task> tasks = taskList.getTaskList();
        ArrayList<String> data = StorageTasks.tasksToData(tasks);
        Storage.writeDataOntoSaveFile(StorageTasks.filePath, data);
    }

    public static TaskList readTaskList() throws NullPointerException, IOException {
        TaskList tasksList = new TaskList();
        ArrayList<Task> tasks;
        try {
            Storage.checkAndAddDirectory(StorageTasks.folderName);
            ArrayList<String> data = Storage.loadDataFromSaveFile(StorageTasks.filePath);
            tasks = StorageTasks.dataToTask(data);
            for (int i = 0; i < tasks.size(); i++) {
                tasksList.addTask(tasks.get(i));
            }
            return tasksList;
        } catch (FileNotFoundException e) {
            File f = new File(StorageTasks.filePath);
            System.out.println("Hey, I didn't find " + StorageTasks.fileName + " in " + StorageTasks.folderName + "!");
            System.out.println("creating new file...");
        }
        return tasksList;
    }
}