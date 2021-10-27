package seedu.duke.journal;

//@@author SvethaMahadevan

import seedu.duke.exceptions.journal.InvalidTagNameException;
import seedu.duke.storage.StorageNotes;

import seedu.duke.storage.Storage;

import java.io.IOException;

public class Note {
    protected String noteName;
    protected String tag;

    /**
     * Constructor of Note class.
     *
     * @param noteName name of the note
     * @param tag of the notebook
     */
    public Note(String noteName, String tag) {
        this.noteName = noteName;
        this.tag = tag;
    }

    /**
     * Tags the notebook.
     *
     * @param tag name of the tag for the notebook
     *
     */
    public void tag(String tag, Storage storage) throws InvalidTagNameException, IOException {
        if (!tag.equals("")) {
            this.tag = tag;
            StorageNotes.writeCollectionOfNotes(storage.collectionOfNotes);
        } else {
            throw new InvalidTagNameException();
        }
    }

    /**
     * Returns the tag.
     *
     * @return tag name of the notebook
     *
     */
    public String getTag() {
        return tag;
    }

    /**
     * Returns the name of the note.
     *
     * @return noteName which stores the name of the note.
     */
    public String getNoteName() {
        return noteName;
    }

    /**
     * Returns name of notebook in format to save in data file.
     *
     * @return  stringForStorage name of notebook in format to save in data file.
     */
    public String toSaveFileFormat() {
        String stringForStorage = "note" + "|" + noteName + "|" + tag;
        return stringForStorage;
    }

}