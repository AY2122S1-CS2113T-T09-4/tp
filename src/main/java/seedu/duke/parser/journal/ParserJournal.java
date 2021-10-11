package seedu.duke.parser.journal;

public class ParserJournal {
    //@author SvethaMahadevan
    public static String parseAddNoteCommand(String input) {
        String noteNameDetails = input.trim().split("notebook")[1];
        String noteName = noteNameDetails.split("n/")[1].trim();
        return noteName;
    }

    public static String[] parseAddEntryCommand(String input) {
        String noteNameDetails = input.trim().split("entry")[1];
        String noteAndEntryName = noteNameDetails.split("n/")[1].trim();
        String entryName = noteAndEntryName.split("e/")[1].trim();
        String noteName = noteAndEntryName.split("e/")[0].trim();
        return new String[]{noteName, entryName};
    }
}