package seedu.duke.commands.journal;

//@@author SvethaMahadevan

import seedu.duke.commands.Command;
import seedu.duke.exceptions.journal.EmptyNoteNameException;
import seedu.duke.exceptions.journal.EmptyTagArgumentsException;
import seedu.duke.exceptions.journal.EmptyTagNameException;
import seedu.duke.exceptions.journal.InvalidTagNameException;
import seedu.duke.exceptions.journal.NotebookArgumentNotFoundException;
import seedu.duke.exceptions.journal.NotebookNotFoundForTagException;
import seedu.duke.journal.Note;
import seedu.duke.parser.journal.ParserJournal;
import seedu.duke.storage.Storage;
import seedu.duke.ui.Ui;

import java.io.IOException;
import java.util.ArrayList;

public class TagNotebookCommand extends Command {


    public String userInput;

    public TagNotebookCommand() {
        syntax = "journal tag n/ NOTE_INDEX t/ TAG_NAME";
    }

    /**
     * Constructor for the TagNotebookCommand.
     *
     * @param userInput input from the user.
     */
    public TagNotebookCommand(String userInput) {
        this.userInput = userInput;
        helpMessage = "Tag a notebook from list";
        syntax = "journal tag n/ NOTE_INDEX t/ TAG_NAME";
    }


    /**
     * Tags the notebook.
     *
     * @param ui allows for printing that note is added
     * @param storage to allow for storage of notes
     */
    @Override
    public void execute(Ui ui, Storage storage) throws EmptyTagNameException, EmptyNoteNameException,
            EmptyTagArgumentsException, NotebookArgumentNotFoundException,
            InvalidTagNameException, IOException, NotebookNotFoundForTagException {
        String[] tagNameAndNotebook = ParserJournal.parseTagNotebookCommand(userInput, storage);
        ArrayList<Note> notes = storage.collectionOfNotes.getNotesArrayList();
        Note noteToBeTagged = notes.get(Integer.parseInt(tagNameAndNotebook[0]) - 1);
        noteToBeTagged.tag(tagNameAndNotebook[1], storage);
        ui.printTaggedNotebookMessage();
    }
}
