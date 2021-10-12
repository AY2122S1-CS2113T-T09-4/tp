package seedu.duke.exceptions;

public class EmptyNoteArgumentsException extends Exception {
    public EmptyNoteArgumentsException() {
        System.out.println("No arguments found for notebook.");
    }
}