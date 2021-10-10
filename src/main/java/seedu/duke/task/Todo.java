package seedu.duke.task;

public class Todo extends Task {

    public Todo(String description, String date) {
        super(description, date);
    }

    @Override
    public String toSaveFileFormat() {
        return "todo" + "|" + description + "|" + date;
    }

    @Override
    public String toString() {
        return super.toString() + " (on: " + date + ")";
    }

}
