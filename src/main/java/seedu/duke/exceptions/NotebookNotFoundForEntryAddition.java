package seedu.duke.exceptions;

public class NotebookNotFoundForEntryAddition extends Exception {
    public NotebookNotFoundForEntryAddition() {
        System.out.println("Notebook hasn't been created yet!");
        System.out.println("Cannot add entry!");
    }
}
