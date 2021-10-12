package seedu.duke.commands;
import seedu.duke.journal.CollectionOfNotes;
import seedu.duke.journal.Entry;
import seedu.duke.journal.Note;
import seedu.duke.parser.journal.ParserJournal;
import seedu.duke.storage.Storage;
import seedu.duke.storage.StorageEntries;
import seedu.duke.ui.Ui;

import java.util.ArrayList;

public class ListJournalCommand extends Command {
    public ListJournalCommand() {
    }

    /**
     * Allows for the listing of notebooks and entries
     * @param ui allows for printing of a message to indicate that the note has been added
     * @param storage to print from storage
     */
    @Override
    public void execute(Ui ui, Storage storage) {
        ArrayList<Note> notes =storage.collectionOfNotes.getNotesArrayList();
        ArrayList<Entry> entries =storage.collectionOfEntries.getEntriesArrayList();
        for (Note note : notes) {
            System.out.println("The notebook " + note.getNoteName() + " contains: ");
            for(Entry entry : entries) {
                if(entry.getEntryNoteName().equals(note.getNoteName())) {
                    System.out.println(entry.getNameOfJournalEntry());
                }
            }
        }

    }
}