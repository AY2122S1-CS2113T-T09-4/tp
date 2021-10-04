package seedu.duke.parser.schedule;

import java.time.YearMonth;

/**
 * @author swatim
 */
public class ParserSchedule {

    public static YearMonth parseCalendarCommand(String input) {
        // takes substring excluding "calendar" from command
        String extractMonthYear = input.substring(9);
        var arguments = extractMonthYear.split("-");
        int month = Integer.parseInt(arguments[0]);
        int year = Integer.parseInt(arguments[1]);
        YearMonth yearMonth = YearMonth.of(year, month);
        return yearMonth;
    }

}

