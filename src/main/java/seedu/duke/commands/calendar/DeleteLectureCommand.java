package seedu.duke.commands.calendar;

import seedu.duke.commands.Command;
import seedu.duke.exceptions.calendar.CalendarIndexNotFoundException;
import seedu.duke.exceptions.calendar.IncorrectNumberOfArgumentsException;
import seedu.duke.exceptions.calendar.LectureIndexNotFoundException;
import seedu.duke.storage.Storage;
import seedu.duke.storage.StorageLecture;
import seedu.duke.storage.StorageTasks;
import seedu.duke.ui.Ui;

import java.io.IOException;

import static seedu.duke.constants.Messages.DELETED_TASK;


public class DeleteLectureCommand extends Command {
    private int index;
    private String userInput;

    public DeleteLectureCommand() {
        syntax = "calendar delete lec [LECTURE_INDEX]";
    }

    /**
     * Constructor for DeleteTaskCommand class.
     *
     * @param index index of task to be deleted
     * @param userInput input from user
     */
    public DeleteLectureCommand(int index, String userInput) {
        this.index = index;
        this.userInput = userInput;
    }

    /**
     * Executed delete task command.
     *
     * @param ui      The component of CLICK that deals with the interaction with the user.
     * @param storage The component of CLICK that deals with loading tasks from the file and saving tasks in the file.
     * @throws IOException in case of writing to save file error.
     * @throws CalendarIndexNotFoundException if index is not found.
     * @throws IncorrectNumberOfArgumentsException in case of wrong number of arguments.
     */
    @Override
    public void execute(Ui ui, Storage storage)
            throws IOException, IncorrectNumberOfArgumentsException, LectureIndexNotFoundException {
        if (this.index > storage.lectureList.getLectureList().size()) {
            throw new LectureIndexNotFoundException();
        }
        Storage.lectureList.deleteLecture(this.index);
        System.out.println("Lecture has been deleted!");
        StorageLecture.writeLectureList(Storage.lectureList);
    }

}