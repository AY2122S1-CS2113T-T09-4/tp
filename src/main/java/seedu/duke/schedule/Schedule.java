package seedu.duke.schedule;

import java.time.DayOfWeek;
import java.time.YearMonth;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

import seedu.duke.ui.Ui;

import static seedu.duke.constants.Messages.NUMBER_OF_DAYS_IN_WEEK;
import static seedu.duke.constants.Messages.LEAVE_EMPTY_IN_DISPLAY;
import static seedu.duke.constants.Messages.DAYS_IN_MONTH;
import static seedu.duke.constants.Messages.FIRST_INDEX;

//@author swatim
public class Schedule {

    public static void displayCalendar(YearMonth inputYearMonth, ArrayList<ArrayList<String>> calendarTasks) {
        ArrayList<String> calendar = new ArrayList<>();
        addDatesForDaysInMonth(inputYearMonth, calendar);
        addNoDatesInBeginning(inputYearMonth, calendar);
        addNoDatesInEnd(calendar);

        // Print out the entire display in week rows
        int totalWeeks = (int) Math.ceil((double)calendar.size() / NUMBER_OF_DAYS_IN_WEEK);
        int currentWeek = 0;
        AtomicInteger j = new AtomicInteger();
        Ui.printCalendarLine();
        while (currentWeek < totalWeeks) {
            int indexOfDay = currentWeek * 7;
            Ui.printDayDemarcation();
            printCalendarDates(calendar, indexOfDay);
            System.out.println();
            printTaskForWeek(calendarTasks, calendar, indexOfDay);
            Ui.printCalendarLine();
            currentWeek++;
        }
    }

    //Add all dates that are available in the month from 01-value of last day of month
    private static void addDatesForDaysInMonth(YearMonth inputYearMonth, ArrayList<String> calendar) {
        String[] daysInMonth = DAYS_IN_MONTH;
        calendar.addAll(Arrays.asList(daysInMonth).subList(0, inputYearMonth.lengthOfMonth()));
    }

    // Add in spaces at the beginning for display upto day 1
    private static void addNoDatesInBeginning(YearMonth inputYearMonth, ArrayList<String> calendar) {
        DayOfWeek dayOneOfMonth = inputYearMonth.atDay(1).getDayOfWeek();
        if (dayOneOfMonth != DayOfWeek.SUNDAY) {
            IntStream.range(FIRST_INDEX, dayOneOfMonth.getValue()).forEachOrdered(i ->
                    calendar.add(0, LEAVE_EMPTY_IN_DISPLAY));
        }
    }

    //Add in spaces at the end after the last day to fill in the week
    private static void addNoDatesInEnd(ArrayList<String> calendar) {
        while (calendar.size() % NUMBER_OF_DAYS_IN_WEEK != 0) {
            calendar.add(LEAVE_EMPTY_IN_DISPLAY);
        }
    }

    //Print out the top rows with dates from 01-value of last day of month
    private static void printCalendarDates(ArrayList<String> calendar, int indexOfDay) {
        for (int dayOfWeek = 0; dayOfWeek < NUMBER_OF_DAYS_IN_WEEK; dayOfWeek++) {
            String s = "" + calendar.get(indexOfDay + dayOfWeek) + "            |";
            System.out.print(s);
        }
    }

    private static void printTaskForWeek(ArrayList<ArrayList<String>> calendarTasks,
                                         ArrayList<String> calendar, int dayIndex) {
        int row = 0;
        while (row < 3) {
            System.out.print("|");
            for (int day = 0; day < 7; day++) {
                printDetails(calendarTasks, calendar, dayIndex, row, day);
            }
            System.out.println();
            row++;
        }
    }

    private static void printDetails(ArrayList<ArrayList<String>> calendarTasks,
                                     ArrayList<String> calendarDates, int dayIndex, int row, int day) {
        String dayString = calendarDates.get(dayIndex + day).trim();
        if (!dayString.equals("") && calendarTasks.get(Integer.parseInt(dayString)).size() > row) {
            int currentDay = Integer.parseInt(dayString);
            String taskName = calendarTasks.get(currentDay).get(row);
            formatAndPrintTask(taskName);
        } else {
            Ui.printEmptyTaskSpot();
        }
    }

    private static void formatAndPrintTask(String taskName) {
        if (taskName.length() > 10) {
            taskName = taskName.substring(0, 10);
        } else {
            taskName = String.format("%-" + 10 + "s", taskName);
        }
        System.out.print("" + taskName + "    |");
    }

}