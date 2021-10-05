package seedu.duke.parser;

import org.junit.jupiter.api.Test;
import seedu.duke.exceptions.IllegalDateTimeException;

import java.time.YearMonth;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

//@@author nvbinh15

class ParserTest {

    static Parser parser = new Parser();

    @Test
    void formatDateTime_legalDateTime_dateTimeOfOtherFormat() throws IllegalDateTimeException {
        String inputDateTime = "01-10-2021 2359";
        String expectedDateTime = "Oct 01 2021 23:59";
        assertEquals(expectedDateTime, parser.formatDateTime(inputDateTime));
    }

    @Test
    void formatDateTime_illegalDateTime_illegalDateTimeException() {
        String illegalDateTime = "01/01/2021 2359";
        assertThrows(IllegalDateTimeException.class, () -> parser.formatDateTime(illegalDateTime));
    }

    //@author swatim
    @Test
    void formatYearMonth() {
        assertEquals(YearMonth.of(2021, 10), parser.parseCalendarCommand("calendar 10-2021"));
    }

    //@author SvethaMahadevan
    @Test
    void sampleTest() {
        assertEquals("testnotename", parser.parseAddNoteCommand("add n/ testnotename"));
    }

}
