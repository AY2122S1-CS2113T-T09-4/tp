package seedu.duke.ui;

import seedu.duke.calories.foodRecord;
import seedu.duke.constants.Messages;

import java.time.YearMonth;
import java.util.Scanner;

import static seedu.duke.constants.Messages.HORIZONTAL_LINE;
import static seedu.duke.constants.Messages.LOGO;
import static seedu.duke.constants.Messages.MESSAGE_GOODBYE;
import static seedu.duke.constants.Messages.MESSAGE_GREETING;
import static seedu.duke.constants.Messages.CALENDAR_HEADER_LINE;
import static seedu.duke.constants.Messages.INVALID_YEARMONTH;
import static seedu.duke.constants.Messages.INVALID_CALENDAR_INPUT;

public class Ui {

    /**
     * Reads the text entered by the user.
     *
     * @param in The Scanner to read user input.
     * @return line Full line entered by the user.
     */
    public static String getUserInput(Scanner in) {
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

    /**
     * Prints the name of the record, as well as the calorie count.
     *
     * @param record Record of food names and calorie count.
     */
    public static void printAddRecord(foodRecord record)  {
        System.out.println(Messages.ADD_RECORD_GREET
                + record.getFoodName()
                + Messages.ADD_RECORD_TTL
                + Messages.ADD_RECORD_CONNECTOR
                + record.getCalorieCount()
                + Messages.ADD_RECORD_FINAL);
    }

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
    //End Schedule

    //UI for journal
    public static void printIntroMessage()
    {
        System.out.println("Hello, I am Journal Bud.");
        System.out.println("How may I help you?");
    }

    public static void printAddedNoteMessage(String noteName)
    {
        System.out.println("Great you have added the note: " + noteName);
    }
    //end of UI for journal
}
