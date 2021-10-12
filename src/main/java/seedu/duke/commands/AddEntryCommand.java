package seedu.duke.commands;

import seedu.duke.exceptions.DuplicateEntryException;
import seedu.duke.storage.Storage;
import seedu.duke.storage.StorageEntries;
import seedu.duke.storage.StorageNotes;
import seedu.duke.ui.Ui;
import seedu.duke.parser.journal.ParserJournal;
import seedu.duke.journal.Entry;
import seedu.duke.journal.Note;
import seedu.duke.journal.CollectionOfNotes;

import java.io.IOException;
import java.util.ArrayList;

public class AddEntryCommand extends Command {
    public String userInput;

    public AddEntryCommand(String userInput) {
        this.userInput = userInput;
    }

    /**
     * Allows for the adding of entry
     * @param ui allows for printing of a message to indicate that the entry has been added
     * @param storage to allow for storage of entries
     */
    @Override
    public void execute(Ui ui, Storage storage) throws IOException, DuplicateEntryException {
        String[] argumentsNoteEntry = ParserJournal.parseAddEntryCommand(userInput);
        ArrayList<Note> notes =storage.collectionOfNotes.getNotesArrayList();
        for (Note note : notes) {
            if (note.getNoteName().equals(argumentsNoteEntry[0])) {
                storage.collectionOfEntries.addEntry(argumentsNoteEntry[0], argumentsNoteEntry[1]);
            }
        }
        ui.printAddedEntryMessage(argumentsNoteEntry[1]);
        StorageEntries.writeEntries(storage.collectionOfEntries);
    }
}
