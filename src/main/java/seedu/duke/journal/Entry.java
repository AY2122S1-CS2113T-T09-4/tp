package seedu.duke.journal;

//@@author SvethaMahadevan

public class Entry {
    private String entryName;
    private String noteName;

    /**
     * Constructor of Entry class.
     *
     * @param noteName name of the notebook
     * @param titleOfJournalEntry title of the entry.
     */
    public Entry(String noteName, String titleOfJournalEntry) {
        this.entryName = titleOfJournalEntry;
        this.noteName = noteName;
    }


    /**
     * Returns the name of the entry.
     *
     * @return entryName which is a string variable which stores the name of entry
     */
    public String getNameOfJournalEntry() {
        return entryName;
    }

    /**
     * Returns the name of the notebook corresponding to the entry.
     *
     * @return noteName stores name of notebook corresponding to entry.
     */
    public String getEntryNoteName() {
        return noteName;
    }

    /**
     * Returns names of entry and its corresponding notebook in format to save in data file.
     *
     * @return  formattedNameOfNoteAndEntry names of entry and its notebook in format
     */
    public String toSaveFileFormat() {
        String formattedNameOfNoteAndEntry =  noteName + "|" + entryName;
        return formattedNameOfNoteAndEntry;
    }
}