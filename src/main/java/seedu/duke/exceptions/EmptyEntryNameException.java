package seedu.duke.exceptions;

public class EmptyEntryNameException extends Exception {
    public EmptyEntryNameException() {
        System.out.println("No entry name entered after 'e/' ");
    }
}