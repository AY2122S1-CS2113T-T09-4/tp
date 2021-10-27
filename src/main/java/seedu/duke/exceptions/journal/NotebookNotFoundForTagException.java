package seedu.duke.exceptions.journal;

public class NotebookNotFoundForTagException extends Exception {
    public NotebookNotFoundForTagException() {
        System.out.println("Invalid notebook for tagging");
    }
}
