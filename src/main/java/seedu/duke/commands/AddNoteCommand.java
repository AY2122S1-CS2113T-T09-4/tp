package seedu.duke.commands;

import seedu.duke.exceptions.DuplicateNoteException;
import seedu.duke.exceptions.EmptyNoteArgumentsException;
import seedu.duke.exceptions.EmptyNoteNameException;
import seedu.duke.storage.Storage;
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
     * Adds the notebooks to a collection of notebooks.
     * @param ui allows for printing that note is added
     * @param storage to allow for storage of notes
     */
    @Override
    public void execute(Ui ui, Storage storage) throws EmptyNoteNameException, EmptyNoteArgumentsException, IOException,
        DuplicateNoteException {
        String noteName = ParserJournal.parseAddNoteCommand(userInput, storage);
        ui.printAddedNoteMessage(noteName);
        storage.collectionOfNotes.addNote(noteName);
        StorageNotes.writeCollectionOfNotes(storage.collectionOfNotes);
    }
}
