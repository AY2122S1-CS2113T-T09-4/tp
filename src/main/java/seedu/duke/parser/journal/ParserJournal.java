package seedu.duke.parser.journal;

import seedu.duke.exceptions.journal.DuplicateNoteException;
import seedu.duke.exceptions.journal.EmptyEntryArgumentsException;
import seedu.duke.exceptions.journal.EmptyEntryNameException;
import seedu.duke.exceptions.journal.EmptyNoteArgumentsException;
import seedu.duke.exceptions.journal.EmptyNoteNameException;
import seedu.duke.exceptions.journal.EmptyTagArgumentsException;
import seedu.duke.exceptions.journal.EmptyTagNameException;
import seedu.duke.exceptions.journal.NotebookArgumentNotFoundException;
import seedu.duke.exceptions.journal.NotebookNotFoundForEntry;
import seedu.duke.journal.Note;
import seedu.duke.parser.Parser;
import seedu.duke.storage.Storage;

import java.util.ArrayList;

public class ParserJournal {

    /**
     * Returns the name of the notebook.
     *
     * @param input contains notebook information
     * @return noteName a string which contains the name of the notebook
     * @throws DuplicateNoteException if notebook with same name has been added before
     */
    public static String parseAddNoteCommand(String input, Storage storage) throws DuplicateNoteException,
            EmptyNoteNameException, EmptyNoteArgumentsException {
        if (isValidNotebookCommand(input)) {
            ArrayList<Note> notes = storage.collectionOfNotes.getNotesArrayList();
            String noteName = checkDuplicateOrNot(input, notes);
            return noteName;
        }
        return null;
    }

    /**
     * Checking if addition of the notebook will result in duplicates.
     *
     * @param input getting userInput regarding notebook
     * @param notes list of notes
     * @return notebook name if it is not duplicate
     * @throws DuplicateNoteException checks for duplicate note
     */
    public static String checkDuplicateOrNot(String input, ArrayList<Note> notes) throws DuplicateNoteException {
        String noteNameDetails = input.trim().split("notebook")[1];
        String noteName = noteNameDetails.split("n/")[1].trim();
        for (Note note : notes) {
            if (note.getNoteName().equals(noteName)) {
                throw new DuplicateNoteException();
            }
        }
        return noteName;
    }

    /**
     * To check if notebook command is valid, else false.
     *
     * @param input user input
     * @return true if notebook command is valid, else false
     * @throws EmptyNoteArgumentsException checks if note arguments are empty
     * @throws EmptyNoteNameException      checks if notebook name is not entered
     */
    public static boolean isValidNotebookCommand(String input) throws EmptyNoteArgumentsException,
            EmptyNoteNameException {
        final String[] commandTypeAndParams = Parser.splitCommandAndArgs(input);
        final String commandArgs = commandTypeAndParams[1];
        String[] noteArguments = commandArgs.split(" ");
        if (noteArguments.length == 1) {
            throw new EmptyNoteArgumentsException();
        }
        if (noteArguments.length == 2 && noteArguments[1].equals("n/")) {
            throw new EmptyNoteNameException();
        }
        return true;
    }


    /**
     * Returns the name of the notebook and entry to allow for adding of entry.
     *
     * @param input contains information about entry and the desired notebook from user
     * @return a String array which stores notebook name and entry name
     * @throws EmptyEntryArgumentsException      if no arguments found after entry
     * @throws EmptyNoteNameException            if no note name found after n/
     * @throws EmptyEntryNameException           if no entry name found after e/
     * @throws NotebookArgumentNotFoundException note or entry argument not found when adding entry.
     * @throws NotebookNotFoundForEntry  if notebook to add entry doesn't exist
     */
    public static String[] parseAddEntryCommand(String input, Storage storage) throws EmptyEntryArgumentsException,
            EmptyNoteNameException, EmptyEntryNameException, NotebookArgumentNotFoundException,
            NotebookNotFoundForEntry {
        String[] noteEntryNames = parseNoteEntryName(input);
        return new String[]{noteEntryNames[0], noteEntryNames[1]};

    }

    public static String[] parseTagNotebookCommand(String input, Storage storage) {
        String[] noteTagNames = parseNotebookNameAndTag(input);
        return new String[]{noteTagNames[0], noteTagNames[1]};

    }


    public static String[] parseDeleteEntryCommand(String input, Storage storage) throws EmptyEntryArgumentsException,
            EmptyNoteNameException, EmptyEntryNameException, NotebookArgumentNotFoundException,
            NotebookNotFoundForEntry {
        String[] noteEntryNames = parseArgumentsDeleteEntryCommand(input);
        return new String[]{noteEntryNames[0], noteEntryNames[1]};

    }

    /**
     * Parsing notebook and entry name.
     *
     * @param input from user
     * @return notebook name and entry name in form of string array
     */
    public static String[] parseNoteEntryName(String input) {
        String noteNameDetails = input.trim().substring(input.indexOf("entry"));
        String noteAndEntryName = noteNameDetails.substring(noteNameDetails.indexOf("n/")).trim();
        String noteName =
                noteAndEntryName.substring(noteAndEntryName.indexOf("n/") + 2, noteAndEntryName.indexOf("e/")).trim();
        String entryName = noteAndEntryName.substring(noteAndEntryName.indexOf("e/") + 2).trim();
        return new String[]{noteName, entryName};
    }

    /**
     * Parsing tag for the notebook.
     *
     * @param input from user
     * @return notebook name and tag name in form of String array.
     */
    public static String[] parseNotebookNameAndTag(String input) {
        String noteAndTagDetails = input.trim().substring(input.indexOf("tag"));
        String noteAndTagName = noteAndTagDetails.substring(noteAndTagDetails.indexOf("n/")).trim();
        String notebookIndex = noteAndTagName.substring(noteAndTagName.indexOf("n/") + 2, noteAndTagName.indexOf("t/"));
        String tagName = noteAndTagName.substring(noteAndTagName.indexOf("t/") + 2).trim();
        return new String[]{notebookIndex, tagName};
    }

    /**
     * Parsing index for notebook to be deleted.
     *
     * @param input from user
     * @return index for notebook to be deleted
     */
    public static int parseDeleteNoteCommand(String input) {
        String indexOfDeletedNotebook = input.trim().split("delete_notebook")[1].trim();
        return Integer.parseInt(indexOfDeletedNotebook);
    }

    /**
     * Parsing index of entry and notebook to delete entry.
     *
     * @param input from user
     * @return index for notebook to be deleted
     */
    public static String[] parseArgumentsDeleteEntryCommand(String input) {
        String noteNameAndEntryNameDetails = input.trim().substring(input.indexOf("delete_entry"));
        String noteNameAndEntryName =
                noteNameAndEntryNameDetails.substring(noteNameAndEntryNameDetails.indexOf("n/")).trim();
        String noteName = noteNameAndEntryName.substring(noteNameAndEntryName.indexOf("n/") + 2,
                noteNameAndEntryName.indexOf("e/")).trim();
        String entryName = noteNameAndEntryName.substring(noteNameAndEntryName.indexOf("e/") + 2).trim();
        return new String[]{noteName, entryName};
    }

    /**
     * Parsing tag for finding notebooks by tag.
     *
     * @param input from user
     * @return tagName
     */
    public static String parseTagForFinding(String input) {
        String tagName = input.trim().split("find")[1];
        return tagName;
    }

}