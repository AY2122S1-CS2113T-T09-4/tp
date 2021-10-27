package seedu.duke.exceptions.journal;

public class EmptyTagArgumentsException extends Exception {
    public EmptyTagArgumentsException() {
        System.out.println("No arguments for tag");
    }
}
