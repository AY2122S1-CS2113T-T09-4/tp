package seedu.duke.exceptions;

public class NoNotebookFoundException extends Exception {
    public NoNotebookFoundException()
    {
        System.out.println("The notebook has not been created");
        System.out.println("Please add one first!");
    }
}