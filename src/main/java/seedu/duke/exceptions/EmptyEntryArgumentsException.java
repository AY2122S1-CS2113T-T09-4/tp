package seedu.duke.exceptions;

public class EmptyEntryArgumentsException extends Exception {
    public EmptyEntryArgumentsException()
    {
        System.out.println("No arguments found for entry.");
    }
}
