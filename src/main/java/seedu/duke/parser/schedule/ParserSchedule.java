package seedu.duke.parser.schedule;

import java.time.YearMonth;

public class ParserSchedule {
    public static YearMonth parseCalendarCommandForJunit(String input) {
        // takes substring excluding "calendar" from command
        String extractMonthYear = input.substring(9);
        var arguments = extractMonthYear.split("-");
        int month = Integer.parseInt(arguments[0]);
        assert month <= 12;
        int year = Integer.parseInt(arguments[1]);
        YearMonth yearMonth = YearMonth.of(year, month);
        return yearMonth;
    }
}
