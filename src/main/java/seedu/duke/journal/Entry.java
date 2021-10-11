package seedu.duke.journal;

public class Entry {
    private String titleOfJournalEntry;

    public Entry(String titleOfJournalEntry) {
        this.titleOfJournalEntry = titleOfJournalEntry;
    }

    public String getNameOfJournalEntry() {
        return titleOfJournalEntry;
    }

    public String toSaveFileFormat() {
        return "entry" + "|" + titleOfJournalEntry;
    }

}