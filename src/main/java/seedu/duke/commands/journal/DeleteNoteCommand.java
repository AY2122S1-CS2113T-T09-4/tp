package seedu.duke.commands.journal;

//@@author SvethaMahadevan

import seedu.duke.commands.Command;
import seedu.duke.exceptions.journal.InvalidNotebookIndexException;
import seedu.duke.journal.Note;
import seedu.duke.parser.journal.ParserJournal;
import seedu.duke.storage.Storage;
import seedu.duke.storage.StorageNotes;
import seedu.duke.ui.Ui;

import java.io.IOException;
import java.util.ArrayList;

public class DeleteNoteCommand extends Command {

    public String userInput;

    /**
     * Constructor for the DeleteNoteCommand.
     *
     * @param userInput input from the user.
     */
    public DeleteNoteCommand(String userInput) {
        this.userInput = userInput;
        helpMessage = "Delete a notebook from list";
        syntax = "journal delete_notebook n/ NOTEBOOK_NAME";
    }


    /**
     * Deletes the notebooks from a collection of notebooks.
     *
     * @param ui allows for printing that note is added
     * @param storage to allow for storage of notes
     * @throws InvalidNotebookIndexException if index of notebook is invalid
     */
    @Override
    public void execute(Ui ui, Storage storage) throws IOException, InvalidNotebookIndexException {
        ArrayList<Note> notes = storage.collectionOfNotes.getNotesArrayList();
        int indexOfNotebookToDelete = ParserJournal.parseDeleteNoteCommand(userInput);
        if (indexOfNotebookToDelete < 1 || indexOfNotebookToDelete > notes.size()) {
            throw new InvalidNotebookIndexException();
        }
        ui.printDeletedNotebookMessage(indexOfNotebookToDelete);
        storage.collectionOfNotes.deleteNote(indexOfNotebookToDelete, storage);
        StorageNotes.writeCollectionOfNotes(storage.collectionOfNotes);
    }
}