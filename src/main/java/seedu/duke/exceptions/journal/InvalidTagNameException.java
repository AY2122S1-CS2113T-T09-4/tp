package seedu.duke.exceptions.journal;

public class InvalidTagNameException extends Exception {
    public InvalidTagNameException() {
        System.out.println("Sorry!The tag argument is invalid!");
    }
}
