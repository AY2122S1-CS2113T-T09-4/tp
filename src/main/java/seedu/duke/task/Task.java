package seedu.duke.task;

public abstract class Task {

    protected String description;
    protected String date;

    public Task(String description, String date) {
        this.description = description;
        this.date = date;
    }

    public abstract String toSaveFileFormat();

    public String toString() {
        return description;
    }

}