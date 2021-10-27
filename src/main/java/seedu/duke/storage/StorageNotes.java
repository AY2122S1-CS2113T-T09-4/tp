package seedu.duke.storage;

//@@author SvethaMahadevan

import seedu.duke.journal.CollectionOfNotes;
import seedu.duke.journal.Note;
import seedu.duke.logger.ClickLogger;
import java.util.logging.Level;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;


public class StorageNotes {
    public static final String folderName = "journalData/";
    public static final String fileName   = "journalNotes.txt";
    public static final String filePath = folderName + fileName;

    static ArrayList<Note> dataToNotes(ArrayList<String> data) {
        ArrayList<Note> notes = new ArrayList<>();
        int i = 0;
        int dataSize = data.size();
        while (i < dataSize) {
            String dataLine = data.get(i);
            String[] noteArguments = dataLine.split("\\|");
            notes.add(addNote(noteArguments));
            i++;
        }
        return notes;
    }

    private static Note addNote(String[] noteArguments) {
        String name = noteArguments[1].trim();
        String tag = noteArguments[2].trim();
        return new Note(name, tag);
    }

    public static ArrayList<String> notesToData(ArrayList<Note> notes) {
        ArrayList<String> data = new ArrayList<>();
        for (Note note : notes) {
            data.add(note.toSaveFileFormat());
        }
        return data;
    }

    public static void writeCollectionOfNotes(CollectionOfNotes collectionOfNotes) throws IOException {
        ArrayList<Note> notes = collectionOfNotes.getNotesArrayList();
        ArrayList<String> data = notesToData(notes);
        Storage.writeDataOntoSaveFile(filePath, data);
    }

    public static CollectionOfNotes readCollectionOfNotes() throws NullPointerException, IOException {
        CollectionOfNotes collectionOfNotes = new CollectionOfNotes();
        ArrayList<Note> notes;
        try {
            Storage.checkAndAddDirectory(StorageNotes.folderName);
            ArrayList<String> data = Storage.loadDataFromSaveFile(StorageNotes.filePath);
            notes = StorageNotes.dataToNotes(data);
            for (int i = 0; i < notes.size(); i++) {
                collectionOfNotes.addNote(notes.get(i).getNoteName(), notes.get(i).getTag());
            }
        } catch (FileNotFoundException e) {
            ClickLogger.getNewLogger().log(Level.WARNING, "file not found on load");
            File f = new File(StorageNotes.filePath);
            System.out.println("Hey, I didn't find " + StorageNotes.fileName + " in " + StorageNotes.folderName + "!");
            System.out.println("creating new file...");
        }
        return collectionOfNotes;
    }
}