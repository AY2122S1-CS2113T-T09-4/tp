package seedu.duke.commands.calendar;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import seedu.duke.commands.Command;
import seedu.duke.exceptions.calendar.DuplicateTaskException;
import seedu.duke.exceptions.calendar.InvalidDateException;
import seedu.duke.exceptions.calendar.ModuleNotFoundException;
import seedu.duke.module.ModuleList;
import seedu.duke.schedule.lecture.Lecture;
import seedu.duke.storage.Storage;
import seedu.duke.storage.StorageLecture;
import seedu.duke.ui.Ui;

//@@author swatimahadevan
//@@author
/**
 * Class to execute adding of module lecture.
 */
public class AddLectureCommand extends Command {
    private ArrayList<String> argumentsLecture;

    public AddLectureCommand() {
        syntax = "calendar lecture m/ [MODULE_CODE] s/ [DD-MM-YYYY(START_DATE)] e/ [DD-MM-YYYY(END_DATE)]";
    }

    public static void checkIfDuplicate(Lecture lecture) throws InvalidDateException, DuplicateTaskException {
        for (int i = 0; i < Storage.lectureList.getLectureList().size(); i++) {
            if (lecture.getModuleName().equals(Storage.lectureList.getLectureList().get(i).getModuleName())) {
                throw new DuplicateTaskException("A lecture for this module has already been added!");
            }
        }
    }

    /**
     * Constructor for AddLectureCommand.
     */
    public AddLectureCommand(ArrayList<String> argumentsLecture) {
        this.argumentsLecture = argumentsLecture;
    }

    public static boolean isValid(String todoDateStringFormat) {
        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        dateFormat.setLenient(false);
        try {
            dateFormat.parse(todoDateStringFormat);
        } catch (ParseException e) {
            return false;
        }
        return true;
    }

    public static void checkIfDateValid(String todoDateStringFormat) throws InvalidDateException {
        if (!isValid(todoDateStringFormat)) {
            throw new InvalidDateException();
        }
    }

    /**
     * To execute adding of lecture.
     *
     * @param ui      The component of CLICK that deals with the interaction with the user.
     * @param storage The component of CLICK that deals with loading tasks from the file and saving tasks in the file.
     * @throws IOException in case of writing to save file error.
     * @throws InvalidDateException in case date is incorrect.
     * @throws ModuleNotFoundException in case module has not been added before.
     */
    @Override

    public void execute(Ui ui, Storage storage) throws IOException,
            ModuleNotFoundException, InvalidDateException, DuplicateTaskException {
        ModuleList moduleList = storage.storageModule.readModulesFromFile();
        String module = argumentsLecture.get(0).trim();
        boolean isModuleInList = false;
        for (int i = 0; i < moduleList.getNumberOfModules(); i++) {
            if (module.equalsIgnoreCase(moduleList.getModuleByIndex(i).getCode().trim())) {
                isModuleInList = true;
            }
        }
        if (isModuleInList) {
            String dateStartStringFormat = argumentsLecture.get(1).trim();
            String dateEndStringFormat = argumentsLecture.get(2);
            Lecture lecture = new Lecture(argumentsLecture.get(0), dateStartStringFormat, dateEndStringFormat);
            checkIfDateValid(dateStartStringFormat);
            checkIfDateValid(dateEndStringFormat);
            checkIfDuplicate(lecture);
            storage.lectureList.addLecture(lecture);
            System.out.println("Added lecture!");
        } else {
            System.out.println("Could not find module, "
                    + "add module first before adding lecture!");
        }
        StorageLecture.writeLectureList(storage.lectureList);
    }

}
