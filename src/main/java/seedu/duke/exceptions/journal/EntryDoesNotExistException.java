package seedu.duke.exceptions.journal;

public class EntryDoesNotExistException extends Exception {
    public EntryDoesNotExistException() {
        System.out.println("Entry doesn't exist.");
    }
}
