package seedu.duke.commands;

import seedu.duke.exceptions.InvalidArgumentsException;
import seedu.duke.storage.Storage;
import seedu.duke.ui.Ui;
import seedu.duke.parser.Parser;
import seedu.duke.schedule.Schedule;
import java.time.YearMonth;

public class DisplayCalendarCommand extends Command{

    private int year;
    private int month;
    private YearMonth inputYearMonth;
    private String[] yearMonthArguments;

    public DisplayCalendarCommand(String input) {
        try {
            try{
                this.yearMonthArguments = Parser.parseCalendarCommand(input);
            }
            catch (IndexOutOfBoundsException | NumberFormatException e)
            {
                Ui.printInvalidYearMonthMessage();
            }
            this.year = Integer.parseInt(yearMonthArguments[1]);
            this.month = Integer.parseInt(yearMonthArguments[0]);
            if (year < 2021 || year > 2025 || month < 1 || month > 12)
            {
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
