package seedu.duke.ui;

import seedu.duke.food.FoodRecord;
import seedu.duke.constants.Messages;
import seedu.duke.schedule.Schedule;
import seedu.duke.task.Task;

import java.time.YearMonth;
import java.util.ArrayList;
import java.util.Scanner;

import static seedu.duke.constants.Messages.*;

public class Ui {

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
        printCurrentMonthCalendar();
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

    //UI for journal
    public static void printIntroMessage() {
        System.out.println("Hello, I am Journal Bud.");
        System.out.println("How may I help you?");
    }

    public static void printAddedNoteMessage(String noteName) {
        System.out.println("Great you have added the note: " + noteName);
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
        printCalenderTitle(currentYearMonth);
        Schedule.displayCalendar(currentYearMonth);
    }


    /**
     * Prints all valid commands and their purpose.
     */
    public static void printHelp() {
        System.out.println(HELP_COMMAND_CALENDAR);
        System.out.println(HELP_COMMAND_ADD_NOTE);
        System.out.println(HELP_COMMAND_EXIT);
        System.out.println(HELP_COMMAND_MODULE);
    }

    public static void printModule(String action) {
        switch (action) {
        case "show":
            System.out.println(CURRENT_MODULES);
            break;
        case "CS2113T":
            System.out.println(DETAIL_CS2113T);
            break;
        case "CG2028":
            System.out.println(DETAIL_CG2028);
            break;
        case "GES1011":
            System.out.println(DETAIL_GES1011);
            break;
        case "CFG1002":
            System.out.println(DETAIL_CFG1002);
            break;
        default:
            break;
        }

    }

    public static void printInvalidModuleCodeMessage() {
        System.out.println("The module code entered is invalid");
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
  
    //End Schedule

}
