package seedu.duke.commands;

import seedu.duke.exceptions.InvalidArgumentsException;
import seedu.duke.storage.Storage;
import seedu.duke.ui.Ui;
import seedu.duke.parser.Parser;
import seedu.duke.schedule.Schedule;
import java.time.YearMonth;

import static seedu.duke.constants.Messages.YEAR_LOWER_LIMIT;
import static seedu.duke.constants.Messages.YEAR_UPPER_LIMIT;
import static seedu.duke.constants.Messages.MONTH_LOWER_LIMIT;
import static seedu.duke.constants.Messages.MONTH_UPPER_LIMIT;

public class DisplayCalendarCommand extends Command {

    private int year;
    private int month;
    private YearMonth inputYearMonth;
    private String[] yearMonthArguments;

    public DisplayCalendarCommand(String input) {
        try {
            try {
                this.yearMonthArguments = Parser.parseCalendarCommand(input);
            } catch (IndexOutOfBoundsException | NumberFormatException e) {
                Ui.printInvalidYearMonthMessage();
            }
            this.year = Integer.parseInt(yearMonthArguments[1]);
            this.month = Integer.parseInt(yearMonthArguments[0]);
            if (year < YEAR_LOWER_LIMIT || year > YEAR_UPPER_LIMIT || month < MONTH_LOWER_LIMIT
                || month > MONTH_UPPER_LIMIT) {
                throw new InvalidArgumentsException();
            }
            this.inputYearMonth = YearMonth.of(year, month);
        } catch (IndexOutOfBoundsException | NumberFormatException | InvalidArgumentsException c) {
            Ui.printInvalidCalendarInput();
        }
    }

    @Override
    public void execute(Ui ui, Storage storage) {
        Ui.printCalenderTitle(inputYearMonth);
        Schedule.displayCalendar(inputYearMonth);
    }
}