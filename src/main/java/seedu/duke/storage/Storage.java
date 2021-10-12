package seedu.duke.storage;

import seedu.duke.food.WhatIAteList;
import seedu.duke.journal.CollectionOfEntries;
import seedu.duke.journal.CollectionOfNotes;
import seedu.duke.task.Task;
import seedu.duke.task.TaskList;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Date;

public class Storage {

    /**
     * Synchronised date with food record  list.
     *
     * @author ngnigel99
     * */
    private Date todaysDate;    //TODO sync date with file
    private String tasksFilePath;

    public WhatIAteList whatIAteTodayList =  StorageFood.load();
    public TaskList tasksList = StorageTasks.readTaskList();
    public CollectionOfNotes collectionOfNotes = StorageNotes.readCollectionOfNotes();
    public CollectionOfEntries collectionOfEntries = StorageEntries.readEntries();

    public Storage() throws IOException {
    }

    //@author nigel
    static void checkAndAddDirectory(String folderName) throws IOException {
        String home = new File("").getAbsolutePath() + '/';
        File dirCheck = new File(home + folderName);
        if (dirCheck.isDirectory()) {
            return;
        }
        System.out.println("Hey, I didn't find directory " + folderName);
        System.out.println("adding " + folderName + " into repository...");
        Files.createDirectories(Paths.get(home + folderName));
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
}
