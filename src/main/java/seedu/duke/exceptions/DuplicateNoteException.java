package seedu.duke.exceptions;

public class DuplicateNoteException extends Exception {
    public DuplicateNoteException()
    {
        System.out.println("Error ! The notebook already exists");
    }
}
