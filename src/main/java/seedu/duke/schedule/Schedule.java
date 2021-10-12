package seedu.duke.schedule;

import java.time.DayOfWeek;
import java.time.YearMonth;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

import static seedu.duke.constants.Messages.NUMBER_OF_DAYS_IN_WEEK;
import static seedu.duke.constants.Messages.LEAVE_EMPTY_IN_DISPLAY;
import static seedu.duke.constants.Messages.DAYS_IN_MONTH;
import static seedu.duke.constants.Messages.FIRST_INDEX;
import static seedu.duke.constants.Messages.DECOR_BEFORE;
import static seedu.duke.constants.Messages.DECOR_AFTER;

//@author swatim
public class Schedule {
    public static void displayCalendar(YearMonth inputYearMonth) {
        ArrayList<String> calendar = new ArrayList<>();
        String[] daysInMonth = DAYS_IN_MONTH;
        // Add all days to calendar ArrayList first
        calendar.addAll(Arrays.asList(daysInMonth).subList(0, inputYearMonth.lengthOfMonth()));

        // Add in spaces at the beginning for display upto day 1
        DayOfWeek dayOneOfMonth = inputYearMonth.atDay(1).getDayOfWeek();
        if (dayOneOfMonth != DayOfWeek.SUNDAY) {
            for (int i = FIRST_INDEX; i < dayOneOfMonth.getValue(); i++) {
                calendar.add(0, LEAVE_EMPTY_IN_DISPLAY);
            }
        }
        // Add spaces after for display after last day to end of week
        while (calendar.size() % NUMBER_OF_DAYS_IN_WEEK != 0) {
            calendar.add(LEAVE_EMPTY_IN_DISPLAY);
        }

        // Print out the entire display in week rows
        int totalWeeks = (int) Math.ceil((double)calendar.size() / NUMBER_OF_DAYS_IN_WEEK);
        int currentWeek = 0;
        AtomicInteger j = new AtomicInteger();
        while (currentWeek < totalWeeks) {
            // Print day number from calendar (maybe a number string like "01" or " ") and space
            IntStream.range(0, NUMBER_OF_DAYS_IN_WEEK).mapToObj(dayOfMonth -> DECOR_BEFORE
                    + calendar.get(j.getAndIncrement()) + DECOR_AFTER).forEachOrdered(System.out::print);
            System.out.println();
            currentWeek++;
        }
    }
}