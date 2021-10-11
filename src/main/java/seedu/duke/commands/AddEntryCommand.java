package seedu.duke.commands;

import seedu.duke.storage.Storage;
import seedu.duke.ui.Ui;
import seedu.duke.parser.journal.ParserJournal;
import seedu.duke.journal.Entry;
import seedu.duke.journal.Note;
import seedu.duke.journal.CollectionOfNotes;
import java.util.ArrayList;

public class AddEntryCommand extends Command {
    public String userInput;

    public AddEntryCommand(String userInput) {
        this.userInput = userInput;
    }

    @Override
    public void execute(Ui ui, Storage storage) {
        String[] argumentsNoteEntry = ParserJournal.parseAddEntryCommand(userInput);
        CollectionOfNotes collectionOfNotes = new CollectionOfNotes();
        ArrayList<Note> notes = collectionOfNotes.getNotesArrayList();
        int indexOfNote = 0;
        for (int i = 0; i < notes.size(); i++) {
            if (argumentsNoteEntry[0].equals(notes.get(i).getNoteName())) {
                notes.get(i).addEntry(argumentsNoteEntry[1]);
                indexOfNote = i;
                assert indexOfNote < notes.size();
                break;
            }
        }
        ui.printAddedEntryMessage(argumentsNoteEntry[1]);
    }
}
