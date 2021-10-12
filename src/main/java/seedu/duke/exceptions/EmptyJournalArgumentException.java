package seedu.duke.exceptions;

public class EmptyJournalArgumentException extends Exception {
    public EmptyJournalArgumentException()
    {
        System.out.println("No arguments found for journal.");
    }
}
