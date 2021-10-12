package seedu.duke.exceptions;

public class EmptyNoteNameException extends Exception {
    public EmptyNoteNameException() {
        System.out.println("No note name entered after 'n/' ");
    }
}