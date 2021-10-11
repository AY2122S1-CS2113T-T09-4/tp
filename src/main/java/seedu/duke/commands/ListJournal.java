package seedu.duke.commands;
import seedu.duke.journal.CollectionOfNotes;
import seedu.duke.journal.Entry;
import seedu.duke.journal.Note;
import seedu.duke.parser.journal.ParserJournal;
import seedu.duke.storage.Storage;
import seedu.duke.ui.Ui;

import java.util.ArrayList;

public class ListJournal extends Command {
    public ListJournal() {
    }
    @Override
    public void execute(Ui ui, Storage storage) {
        CollectionOfNotes collectionOfNotes = new CollectionOfNotes();
        ArrayList<Note> notes = collectionOfNotes.getNotesArrayList();
        System.out.println("The notebooks in the collection are");
        collectionOfNotes.print();
        for (int i = 0; i < notes.size(); i++) {
             System.out.println("The entries in the notebook " + notes.get(i).getNoteName() + " are: ");
             notes.get(i).print();
        }
    }
}