package seedu.duke.storage;

import seedu.duke.food.WhatIAteList;
import seedu.duke.task.Task;
import seedu.duke.task.TaskList;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import static seedu.duke.constants.Messages.STORAGE_FILEPATH_SCHEDULE;

public class Storage {

    /**
     * Synchronised date with food record  list.
     *
     * @author ngnigel99
     * */
    private Date todaysDate;    //TODO sync date with file
    private String tasksFilePath;

    public WhatIAteList whatIAteTodayList =  StorageFood.load();
    public TaskList tasksList = readTaskList();

    public Storage() throws IOException {
    }

    //@author swatim
    //Loads data in the form of ArrayList<String> data from the save file
    public static ArrayList<String> loadDataFromSaveFile(String filePath) throws IOException {
        FileReader fileReader = new FileReader(filePath);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        ArrayList<String> data = new ArrayList<>();
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            data.add(line);
        }
        return data;
    }

    //Write data from ArrayList<String> data onto save file
    public static void writeDataOntoSaveFile(String filePath, ArrayList<String> data) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filePath));
        for (String dataObject : data) {
            String dataLine = dataObject.toString();
            bufferedWriter.write(dataLine + '\n');
        }
        bufferedWriter.close();
    }

    //SCHEDULE BEGIN
    //Write tasks data onto save file using writeDataOntoSaveFile() method
    //ArrayList<Task> tasks--->ArrayList<String> data--->save file
    //Can do the same for other save files by replacing the filepath constant
    public void writeTaskList(TaskList taskList) throws IOException {
        ArrayList<Task> tasks = taskList.getTaskList();
        ArrayList<String> data = StorageTasks.tasksToData(tasks);
        writeDataOntoSaveFile(StorageTasks.filePath, data); //author ngnigel99
    }

    //save file--->ArrayList<String> data--->ArrayList<Task> tasks
    //Can do the same for other save files by replacing the filepath constant
    public TaskList readTaskList() throws NullPointerException, IOException {
        ArrayList<Task> tasks;
        try {
            StorageFood.checkAndAddDirectory(StorageTasks.folderName);  //author ngnigel99
            //ArrayList<String> data = loadDataFromSaveFile(STORAGE_FILEPATH_SCHEDULE);
            ArrayList<String> data = loadDataFromSaveFile(StorageTasks.filePath);
            tasks = StorageTasks.dataToTask(data);
            TaskList tasksList = new TaskList();
            for (int i = 0; i < tasks.size(); i++) {
                tasksList.addTask(tasks.get(i));
            }
            return tasksList;
        } catch (FileNotFoundException e) {     //author ngnigel99 - create new file
            File f = new File(StorageTasks.filePath);
            System.out.println("Hey, I didn't find " + StorageTasks.fileName + " in " + StorageTasks.folderName + "!");
            System.out.println("creating new file...");
        }
        return tasksList;
    }
    //SCHEDULE END
}
