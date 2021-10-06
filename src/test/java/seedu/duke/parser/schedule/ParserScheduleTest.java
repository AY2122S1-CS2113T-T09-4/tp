package seedu.duke.parser.schedule;

import org.junit.jupiter.api.Test;

import java.time.YearMonth;

import static org.junit.jupiter.api.Assertions.assertEquals;

//@author swatim
class ParserScheduleTest {

    static ParserSchedule parser = new ParserSchedule();

    @Test
    void formatYearMonth() {
        assertEquals(YearMonth.of(2021, 10), parser.parseCalendarCommandForJunit("calendar 10-2021"));
    }
}