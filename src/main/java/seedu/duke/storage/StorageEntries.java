package seedu.duke.storage;

import seedu.duke.journal.CollectionOfEntries;
import seedu.duke.journal.Entry;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;


public class StorageEntries {
    public static final String folderName = "journalData/";
    public static final String fileName   = "journalEntries.txt";
    public static final String filePath = folderName + fileName;

    static ArrayList<Entry> dataToEntries(ArrayList<String> data) {
        ArrayList<Entry> entries = new ArrayList<>();
        int i = 0;
        int dataSize = data.size();
        while (i < dataSize) {
            String dataLine = data.get(i);
            String[] entryArguments = dataLine.split("\\|");
            entries.add(addEntry(entryArguments));
            i++;
        }
        return entries;
    }

    private static Entry addEntry(String[] noteArguments) {
        String noteName = noteArguments[0].trim();
        String entryName = noteArguments[1].trim();
        return new Entry(noteName, entryName);
    }

    public static ArrayList<String> entriesToData(ArrayList<Entry> entries) {
        ArrayList<String> data = new ArrayList<>();
        for (Entry entry : entries) {
            data.add(entry.toSaveFileFormat());
        }
        return data;
    }

    public static void writeEntries(CollectionOfEntries collectionOfEntries) throws IOException {
        ArrayList<Entry> entries = collectionOfEntries.getEntriesArrayList();
        ArrayList<String> data = entriesToData(entries);
        Storage.writeDataOntoSaveFile(filePath, data);
    }

    public static CollectionOfEntries readEntries() throws NullPointerException, IOException {
        CollectionOfEntries collectionOfEntries = new CollectionOfEntries();
        ArrayList<Entry> entries;
        try {
            Storage.checkAndAddDirectory(StorageEntries.folderName);
            ArrayList<String> data = Storage.loadDataFromSaveFile(StorageEntries.filePath);
            entries = StorageEntries.dataToEntries(data);
            for (int i = 0; i < entries.size(); i++) {
                collectionOfEntries.addEntry(entries.get(i).getEntryNoteName(), entries.get(i).getNameOfJournalEntry());
            }
            return collectionOfEntries;
        } catch (FileNotFoundException e) {
            File f = new File(StorageEntries.filePath);
            System.out.println("CREATING ENTRY FILE");
        }
        return collectionOfEntries;
    }
}