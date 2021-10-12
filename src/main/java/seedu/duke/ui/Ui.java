package seedu.duke.ui;

import seedu.duke.commands.DisplayCalendarCommand;
import seedu.duke.food.FoodRecord;
import seedu.duke.constants.Messages;
import seedu.duke.schedule.Schedule;
import seedu.duke.task.Task;
import seedu.duke.storage.Storage;

import java.io.IOException;
import java.time.YearMonth;
import java.util.ArrayList;
import java.util.Scanner;

import static seedu.duke.constants.CommandConstants.COMMAND_HELP_SUFFIX_CALENDAR;
import static seedu.duke.constants.CommandConstants.COMMAND_HELP_SUFFIX_EXIT;
import static seedu.duke.constants.CommandConstants.COMMAND_HELP_SUFFIX_FOOD;
import static seedu.duke.constants.CommandConstants.COMMAND_HELP_SUFFIX_MODULE;
import static seedu.duke.constants.Messages.ADDED_TASK;
import static seedu.duke.constants.Messages.DISPLAY_LINE;
import static seedu.duke.constants.Messages.DAY_DEMARCATION;
import static seedu.duke.constants.Messages.NO_TASK_IN_DAY;
import static seedu.duke.constants.Messages.CALENDAR_HEADER_LINE;
import static seedu.duke.constants.Messages.HELP_MESSAGE;
import static seedu.duke.constants.Messages.HELP_MESSAGE_CALENDAR;
import static seedu.duke.constants.Messages.HELP_MESSAGE_EXIT;
import static seedu.duke.constants.Messages.HELP_MESSAGE_FOOD;
import static seedu.duke.constants.Messages.HELP_MESSAGE_MODULE;
import static seedu.duke.constants.Messages.HORIZONTAL_LINE;
import static seedu.duke.constants.Messages.INVALID_CALENDAR_INPUT;
import static seedu.duke.constants.Messages.INVALID_YEARMONTH;
import static seedu.duke.constants.Messages.LIST_TASKS_HEADER;
import static seedu.duke.constants.Messages.LOGO;
import static seedu.duke.constants.Messages.MESSAGE_GOODBYE;
import static seedu.duke.constants.Messages.MESSAGE_GREETING;

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
        printMessage(LOGO + MESSAGE_GREETING);
        //printCurrentMonthCalendar();
    }

    /**
     * Prints the goodbye message to standard output.
     */
    public static void printGoodBye() {
        printMessage(MESSAGE_GOODBYE);
    }

    /**
     * Prints message to the standard output.
     *
     * @param message The message to be printed.
     */
    public static void printMessage(String message) {
        System.out.println(HORIZONTAL_LINE);
        System.out.println(message);
        System.out.println(HORIZONTAL_LINE);
    }

    //start of FOOD
    /**
     * Prints the name of the record, as well as the calorie count.
     * @author ngnigel99
     * @param record record to be added
     */
    //TODO  remove messages, may be neater
    public static void printAddRecord(FoodRecord record)  {
        System.out.println("Nice.  I've added "
                + record.getFoodName()
                + " to the list, with "
                + record.getCalorieCount()
                + " calories!");
    }

    /**
     * Prints success on clear message to user.
     *
     * @author ngnigel99
     */
    public static void printDoneClearList() {
        System.out.println(Messages.PRINT_DONE_CLEAR_LIST);
    }

    public static void printAddFoodSyntax() {
        System.out.println(Messages.PRINT_ADD_FOOD_SYNTAX);
    }

    public static void printNonNullInput() {
        System.out.println(Messages.NON_NULL_INPUT);
    }

    //end of FOOD

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
    //end of UI for journal

    //@author swatim
    //Schedule
    /**
     * Prints the header of the calendar with the month and year.
     *
     * @param inputYearMonth The YearMonth object parsed from user input string.
     */
    public static void printCalenderTitle(YearMonth inputYearMonth) {
        System.out.println("                     " + inputYearMonth.getMonth() + " "
                + inputYearMonth.getYear());
        System.out.println(CALENDAR_HEADER_LINE);
    }

    /**
     * Prints error message for invalid calendar display input.
     */
    public static void printInvalidYearMonthMessage() {
        System.out.println(INVALID_CALENDAR_INPUT);
    }

    /**
     * Prints error message for invalid year (invalid if >2025 or <2021)
     * or month (invalid if >12 or <1) values
     * for calendar display command.
     */
    public static void printInvalidCalendarInput() {
        System.out.println(INVALID_YEARMONTH);
    }

    /**
     * Prints calendar for current month (intro display).
     */
    public static void printCurrentMonthCalendar() {
        YearMonth currentYearMonth = YearMonth.now();
        String month = String.valueOf(currentYearMonth.getMonthValue());
        String year = String.valueOf(currentYearMonth.getYear());
        new DisplayCalendarCommand("calendar " + month + "-" + year).execute(ui, storage);
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

    public static void printCalendarLine() {
        System.out.println(DISPLAY_LINE);
    }

    public static void printDayDemarcation() {
        System.out.print(DAY_DEMARCATION);
    }

    public static void printEmptyTaskSpot() {
        System.out.print(NO_TASK_IN_DAY);
    }
    //End Schedule

    public static void printHelpMessage(String helpMessage) {
        switch (helpMessage) {
            case COMMAND_HELP_SUFFIX_MODULE:
                System.out.println(HELP_MESSAGE_MODULE);
                break;
            case COMMAND_HELP_SUFFIX_CALENDAR:
                System.out.println(HELP_MESSAGE_CALENDAR);
                break;
            case COMMAND_HELP_SUFFIX_FOOD:
                System.out.println(HELP_MESSAGE_FOOD);
                break;
            case COMMAND_HELP_SUFFIX_EXIT:
                System.out.println(HELP_MESSAGE_EXIT);
                break;
            default:
                System.out.println(HELP_MESSAGE);
        }

    }

}