package seedu.duke.task;

public abstract class Task {

    protected String description;
    protected String date;

    public Task(String description, String date) {
        this.description = description;
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public String getDate() {
        return date;
    }

    public abstract String toSaveFileFormat();

    public String toString() {
        return description;
    }

}