package seedu.duke.journal;

//@@author SvethaMahadevan

import java.util.ArrayList;

public class CollectionOfEntries {
    private static ArrayList<Entry> entries = new ArrayList<>();

    public CollectionOfEntries() {
        this.entries = new ArrayList<>();
    }

    /**
     * Returns list of entries.
     *
     * @return list of entries
     */
    public ArrayList<Entry> getEntriesArrayList() {
        return entries;
    }

    /**
     * Adds entry to collection of entries.
     *
     * @param nameOfNote contains notebook name in which to add entry
     * @param nameOfEntry contains name of entry
     */
    public static void addEntry(String nameOfNote, String nameOfEntry) {
        entries.add(new Entry(nameOfNote, nameOfEntry));
    }

}