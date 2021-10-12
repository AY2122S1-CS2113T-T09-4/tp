package seedu.duke.commands;

import seedu.duke.exceptions.EmptyNoteArgumentsException;
import seedu.duke.storage.Storage;
import seedu.duke.storage.StorageEntries;
import seedu.duke.storage.StorageNotes;
import seedu.duke.ui.Ui;
import seedu.duke.parser.journal.ParserJournal;

import java.io.IOException;

public class AddNoteCommand extends Command {

    public String userInput;

    public AddNoteCommand(String userInput) {
        this.userInput = userInput;
    }

    /**
     * Adds the notebooks to a collection of notebooks
     * @param ui allows for printing of a message to indicate that the note has been added
     * @param storage to allow for storage of notes
     */
    @Override
    public void execute(Ui ui, Storage storage) throws IOException, EmptyNoteArgumentsException {
        String noteName;
        noteName = ParserJournal.parseAddNoteCommand(userInput);
        storage.collectionOfNotes.addNote(noteName);
        ui.printAddedNoteMessage(noteName);
        StorageNotes.writeCollectionOfNotes(storage.collectionOfNotes);
    }
}
