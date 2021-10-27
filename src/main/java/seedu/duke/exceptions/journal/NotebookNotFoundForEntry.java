package seedu.duke.exceptions.journal;

public class NotebookNotFoundForEntry extends Exception {
    public NotebookNotFoundForEntry() {
        System.out.println("Notebook hasn't been created yet!");
    }
}
