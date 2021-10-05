package seedu.duke.schedule;

import java.time.DayOfWeek;
import java.time.YearMonth;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;


//@author swatim
public class Schedule {
    public static void displayCalendar(YearMonth inputYearMonth) {
        ArrayList<String> calendar = new ArrayList<>();
        String[] daysInMonth = {"01", "02", "03", "04", "05",
            "06", "07", "08", "09", "10", "11", "12", "13",
            "14", "15", "16", "17", "18", "19", "20", "21",
            "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"};
        // Add all days to calendar ArrayList first
        calendar.addAll(Arrays.asList(daysInMonth).subList(0, inputYearMonth.lengthOfMonth()));

        // Add in spaces at the beginning for display upto day 1
        DayOfWeek dayOneOfMonth = inputYearMonth.atDay(1).getDayOfWeek();
        if (dayOneOfMonth != DayOfWeek.SUNDAY) {
            for (int i = 0; i < dayOneOfMonth.getValue(); i++) {
                calendar.add(0, "  ");
            }
        }
        // Add spaces after for display after last day to end of week
        while (calendar.size() % 7 != 0) {
            calendar.add("  ");
        }

        // Print out the entire display in week rows
        int totalWeeks = (int) Math.ceil((double)calendar.size() / 7);
        int currentWeek = 0;
        AtomicInteger j = new AtomicInteger();
        while (currentWeek < totalWeeks) {
            // Print day number from calendar (maybe a number string like "01" or " ") and space
            IntStream.range(0, 7).mapToObj(dayOfMonth -> "|  "
                    + calendar.get(j.getAndIncrement()) + "  |").forEachOrdered(System.out::print);
            System.out.println();
            currentWeek++;
        }
    }
}
