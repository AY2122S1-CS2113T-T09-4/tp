package seedu.duke.parser.journal;

import seedu.duke.exceptions.DuplicateNoteException;
import seedu.duke.exceptions.EmptyEntryArgumentsException;
import seedu.duke.exceptions.EmptyNoteArgumentsException;
import seedu.duke.exceptions.EmptyNoteNameException;
import seedu.duke.exceptions.EmptyEntryNameException;
import seedu.duke.exceptions.NotebookArgumentNotFoundException;
import seedu.duke.exceptions.NotebookNotFoundForEntryAddition;
import seedu.duke.journal.Note;
import seedu.duke.parser.Parser;
import seedu.duke.storage.Storage;

import java.util.ArrayList;

public class ParserJournal {



    /**
     * Returns the name of the notebook.
     * @param input contains notebook information
     * @return noteName a string which contains the name of the notebook
     */
    public static String parseAddNoteCommand(String input, Storage storage) throws DuplicateNoteException,
            EmptyNoteArgumentsException, EmptyNoteNameException {
        final String[] commandTypeAndParams = Parser.splitCommandAndArgs(input);
        ArrayList<Note> notes = storage.collectionOfNotes.getNotesArrayList();
        final String commandArgs = commandTypeAndParams[1];
        String[] noteArguments = commandArgs.split(" ");
        if (noteArguments.length == 1) {
            throw new EmptyNoteArgumentsException();
        } else if (noteArguments.length == 2 && noteArguments[1].equals("n/")) {
            throw new EmptyNoteNameException();
        }

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
     * Returns the name of the notebook and entry to allow for adding of entry.
     * @param input contains information about entry and the desired notebook from user
     * @return a String array which stores notebook name and entry name
     */
    public static String[] parseAddEntryCommand(String input, Storage storage) throws EmptyEntryArgumentsException,
            EmptyNoteNameException, EmptyEntryNameException, NotebookArgumentNotFoundException,
            NotebookNotFoundForEntryAddition {
        final String[] commandTypeAndParams = Parser.splitCommandAndArgs(input);
        final String commandArgs = commandTypeAndParams[1];
        ArrayList<Note> notes = storage.collectionOfNotes.getNotesArrayList();
        String[] noteArguments = commandArgs.split(" ");
        if (noteArguments.length == 1) {
            throw new EmptyEntryArgumentsException();
        } else if (noteArguments.length == 2 && noteArguments[1].equals("n/")) {
            throw new EmptyNoteNameException();
        } else if (noteArguments.length == 4 && noteArguments[3].equals("e/")) {
            throw new EmptyEntryNameException();
        }
        boolean isNoteArgumentPresent = false;
        boolean isEntryArgumentPresent = false;
        for (int i = 0; i < noteArguments.length; i++) {
            if (noteArguments[i].equals("n/")) {
                isNoteArgumentPresent = true;
            }
            if (noteArguments[i].equals("e/")) {
                isEntryArgumentPresent = true;
            }
        }
        if (isEntryArgumentPresent && isNoteArgumentPresent) {
            String noteNameDetails = input.trim().split("entry")[1];
            String noteAndEntryName = noteNameDetails.split("n/")[1].trim();
            String entryName = noteAndEntryName.split("e/")[1].trim();
            String noteName = noteAndEntryName.split("e/")[0].trim();
            int flagNotebookPresent = 0;
            for (Note note : notes) {
                if (note.getNoteName().equals(noteName) == true) {
                    flagNotebookPresent = 1;
                    break;
                }
            }
            if (flagNotebookPresent == 0) {
                throw new NotebookNotFoundForEntryAddition();
            } else {
                return new String[]{noteName, entryName};
            }
        } else if (isEntryArgumentPresent && !isNoteArgumentPresent) {
            throw new NotebookArgumentNotFoundException("Note argument not found!");
        } else if (!isEntryArgumentPresent && isNoteArgumentPresent) {
            throw new NotebookArgumentNotFoundException("Entry argument not found!");
        }
        return null;
    }
}