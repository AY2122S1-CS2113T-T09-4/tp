package seedu.duke.exceptions;

public class DuplicateEntryException extends Exception {
    public DuplicateEntryException()
    {
        System.out.println("Error ! The entry already exists");
    }
}