package seedu.duke.parser.journal;

import seedu.duke.exceptions.EmptyNoteArgumentsException;

public class ParserJournal {

    private static Object EmptyNoteArgumentsException;

    /**
     * Returns the name of the notebook
     * @param input a string which contains information about notebook entered by the user
     * @return noteName a string which contains the name of the notebook
     */
    public static String parseAddNoteCommand(String input) throws EmptyNoteArgumentsException {
        String noteNameDetails = input.trim().split("notebook")[1];
        String noteName = noteNameDetails.split("n/")[1].trim();
            if (noteName.isEmpty()) {
                throw new EmptyNoteArgumentsException();
            }
            return noteName;
    }

    /**
     * Returns the name of the notebook and entry to allow for adding of entry
     * @param input contains information about entry and the desired notebook from user
     * @return a String array which stores notebook name and entry name
     */
    public static String[] parseAddEntryCommand(String input) {
        String noteNameDetails = input.trim().split("entry")[1];
        String noteAndEntryName = noteNameDetails.split("n/")[1].trim();
        String entryName = noteAndEntryName.split("e/")[1].trim();
        String noteName = noteAndEntryName.split("e/")[0].trim();
        return new String[]{noteName, entryName};
    }
}