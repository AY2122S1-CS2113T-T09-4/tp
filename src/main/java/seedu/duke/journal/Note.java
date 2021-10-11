package seedu.duke.journal;

import java.util.ArrayList;

public class Note {
    protected String noteName;
    private final ArrayList<Entry> entriesList = new ArrayList<>();

    public Note(String noteName) {
        this.noteName = noteName;
    }

    public String getNoteName() {
        return noteName;
    }

    public ArrayList<Entry> getEntryArrayList() {
        return entriesList;
    }

    public void addEntry(String title)  {
        entriesList.add(new Entry(title));
    }

    public String toSaveFileFormat() {
        return "note" + "|" + noteName;
    }

    public void print() {
        for (int i = 0; i < entriesList.size(); i++) {
            System.out.println(entriesList.get(i).getNameOfJournalEntry());
        }
    }
}