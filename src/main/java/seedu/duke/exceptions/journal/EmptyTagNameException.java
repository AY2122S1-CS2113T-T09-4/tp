package seedu.duke.exceptions.journal;

public class EmptyTagNameException extends Exception {
    public EmptyTagNameException() {
        System.out.println("No tag name entered after 't/' ");
    }
}
