package seedu.duke.ui;

import seedu.duke.commands.calendar.DisplayCommand;
import seedu.duke.exceptions.calendar.IncorrectNumberOfArgumentsException;
import seedu.duke.food.FoodRecord;
import seedu.duke.constants.Messages;
import seedu.duke.schedule.lecture.Lecture;
import seedu.duke.schedule.task.Task;
import seedu.duke.storage.Storage;

import java.io.IOException;
import java.time.YearMonth;
import java.util.ArrayList;
import java.util.Scanner;

import static seedu.duke.constants.Messages.ADDED_TASK;
import static seedu.duke.constants.Messages.DAY_DEMARCATION;
import static seedu.duke.constants.Messages.DISPLAY_LINE;
import static seedu.duke.constants.Messages.HORIZONTAL_LINE;
import static seedu.duke.constants.Messages.INVALID_CALENDAR_INPUT;
import static seedu.duke.constants.Messages.LINE_PREFIX;
import static seedu.duke.constants.Messages.LIST_TASKS_HEADER;
import static seedu.duke.constants.Messages.LOGO;
import static seedu.duke.constants.Messages.MESSAGE_GOODBYE;
import static seedu.duke.constants.Messages.MESSAGE_GREETING;
import static seedu.duke.constants.Messages.NO_TASK_IN_DAY;

public class Ui {

    private static Storage storage;

    static {
        try {
            storage = new Storage();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static Ui ui = new Ui();

    /**
     * Reads the text entered by the user.
     *
     * @param in The Scanner to read user input.
     * @return line Full line entered by the user.
     */
    public String getUserInput(Scanner in) {
        String line = in.nextLine();
        return line;
    }

    /**
     * Prints the divider HORIZONTAL_LINE.
     */
    public static void printLine() {
        System.out.println(HORIZONTAL_LINE);
    }

    /**
     * Prints the greeting message to standard output.
     */
    public static void printGreeting() {
        printLine();
        printMessage(LOGO + MESSAGE_GREETING);
        printLine();
        //printCurrentMonthCalendar();
    }

    /**
     * Prints the goodbye message to standard output.
     */
    public static void printGoodBye() {
        printLine();
        printMessage(MESSAGE_GOODBYE);
        printLine();
    }

    /**
     * Prints message to the standard output.
     *
     * @param message The message to be printed.
     */
    public static void printMessage(String message) {
        System.out.println(LINE_PREFIX + message);
    }

    public static void printMessageSameLine(String message) {
        System.out.print(LINE_PREFIX + message);
    }

    //@@author ngnigel99
    /**
     * Prints the name of the record, as well as the calorie count.
     * @author ngnigel99
     * @param record record to be added
     */
    //TODO  remove messages, may be neater
    public static void printAddRecord(FoodRecord record)  {
        Ui.printLine();
        Ui.printMessage("Nice.  I've added "
                + record.getFoodName()
                + " to the list, with "
                + record.getCalorieCount()
                + " calories!");
        Ui.printLine();
    }

    /**
     * Prints success on clear message to user.
     *
     * @author ngnigel99
     */
    public static void printDoneClearList() {
        Ui.printLine();
        Ui.printMessage(Messages.PRINT_DONE_CLEAR_LIST);
        Ui.printLine();
    }

    public static void printAddFoodSyntax() {
        Ui.printLine();
        Ui.printMessage(Messages.PRINT_ADD_FOOD_SYNTAX);
        Ui.printLine();
    }

    public static void printNonNullInput() {
        Ui.printLine();
        Ui.printMessage(Messages.NON_NULL_INPUT);
        Ui.printLine();
    }

    public static void printOnlyIntegers() {
        Ui.printLine();
        Ui.printMessage(Messages.PRINT_NOT_AN_INT);
        Ui.printLine();
    }

    /**
     * Prints a general error message.
     * Ideally should be more specific, try not to use this
     * for exceptions - implement in further testing versions.
     */
    public static void printErrorMessageGeneral() {
        Ui.printLine();
        Ui.printMessage(Messages.PRINT_ERROR_MESSAGE_GENERAL);
        Ui.printLine();
    }

    public static void printDoneDeleteFood(FoodRecord foodRecord, int index) {
        Ui.printLine();
        Ui.printMessage(Messages.PRINT_DONE_DELETE_INDEX + " "
                +  foodRecord.getFoodName()
                + " at index: " + index);
        Ui.printLine();
    }
    //@@author ngnigel99

    /**
     * Prints message to indicate note has been added.
     *
     * @author SvethaMahadevan
     */
    public static void printAddedNoteMessage(String noteName) {
        System.out.println("Great you have added the note: " + noteName);
    }

    /**
     * Prints message to indicate entry has been added.
     *
     * @author SvethaMahadevan
     */
    public static void printAddedEntryMessage(String entryName) {
        System.out.println("Great you have added the entry: " + entryName);
    }

    /**
     * Prints message to indicate that the notebook has been deleted.
     *
     * @author SvethaMahadevan
     */
    public static void printDeletedNotebookMessage(int indexOfDeletedNotebook) {
        System.out.println("Great you have deleted the notebook at : " + indexOfDeletedNotebook);
    }

    /**
     * Prints message to indicate that the entry has been deleted.
     *
     * @author SvethaMahadevan
     */
    public static void printDeletedEntryMessage() {
        System.out.println("Great you have deleted the entry");
    }


    //Schedule
    /**
     * Prints the header of the calendar with the month and year.
     *
     * @param inputYearMonth The YearMonth object parsed from user input string.
     */
    public static void printCalenderTitle(YearMonth inputYearMonth) {
        System.out.println("                                       " + inputYearMonth.getMonth() + " "
                + inputYearMonth.getYear());
    }

    /**
     * Prints error message for all invalid calendar inputs
     * telling user to use 'command help'.
     */
    public static void printInvalidCalendarInput() {
        System.out.println(INVALID_CALENDAR_INPUT);
    }

    /**
     * Prints calendar for current month (intro display).
     */
    public static void printCurrentMonthCalendar() throws
            IncorrectNumberOfArgumentsException {
        YearMonth currentYearMonth = YearMonth.now();
        String month = String.valueOf(currentYearMonth.getMonthValue());
        String year = String.valueOf(currentYearMonth.getYear());
        new DisplayCommand("calendar " + month + "-" + year).execute(ui, storage);
    }

    public static void printLectureList(ArrayList<Lecture> lectures) {
        System.out.println("Here is your list of lectures:");
        if (!lectures.isEmpty()) {
            int i = 1;
            for (Lecture item : lectures) {
                System.out.println((i++) + ". " + item);
            }
        } else {
            System.out.println("NO Lectures!");
        }
    }

    /**
     * Prints confirmatory message after task is added successfully.
     */
    public static void printTaskAddedMessage() {
        System.out.println(ADDED_TASK);
    }

    /**
     * Prints out tasks list.
     *
     * @param tasks List of tasks to be displayed.
     */
    public static void printTaskList(ArrayList<Task> tasks) {
        System.out.println(LIST_TASKS_HEADER);
        if (!tasks.isEmpty()) {
            int i = 1;
            for (Task item : tasks) {
                System.out.println((i++) + ". " + item);
            }
        } else {
            System.out.println("NO TASKS!");
        }
    }

    public static void printHelpMessage(String helpMessage, String syntax) {
        System.out.println("Description: " + helpMessage);
        //System.out.println("Syntax: ");
        System.out.println("Syntax: " + syntax);
    }

    /**
     * Prints calendar lines for display.
     */
    public static void printCalendarLine() {
        System.out.println(DISPLAY_LINE);
    }

    /**
     * Prints out the vertical lines between days.
     */
    public static void printDayDemarcation() {
        System.out.print(DAY_DEMARCATION);
    }

    /**
     * Prints out the task grid for empty task days.
     */
    public static void printEmptyTaskSpot() {
        System.out.print(NO_TASK_IN_DAY);
    }
    //End Schedule

    public static void displayZoomLink(String moduleName, String zoomLink) {
        System.out.println("Module: " + moduleName);
        System.out.println("Zoom: " + zoomLink + "\n");
    }


}
