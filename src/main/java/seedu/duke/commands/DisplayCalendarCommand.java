package seedu.duke.commands;

import seedu.duke.exceptions.InvalidArgumentsException;
import seedu.duke.storage.Storage;
import seedu.duke.task.Task;
import seedu.duke.task.TaskList;
import seedu.duke.ui.Ui;
import seedu.duke.parser.Parser;
import seedu.duke.schedule.Schedule;
import java.time.YearMonth;
import java.util.ArrayList;

import static seedu.duke.constants.Messages.YEAR_LOWER_LIMIT;
import static seedu.duke.constants.Messages.YEAR_UPPER_LIMIT;
import static seedu.duke.constants.Messages.MONTH_LOWER_LIMIT;
import static seedu.duke.constants.Messages.MONTH_UPPER_LIMIT;
import static seedu.duke.constants.Messages.TOTAL_SIZE;

public class DisplayCalendarCommand extends Command {

    private int year;
    private int month;
    private YearMonth inputYearMonth;
    private String[] yearMonthArguments;
    private ArrayList<ArrayList<String>> calendarTasks = new ArrayList<>(TOTAL_SIZE);

    public DisplayCalendarCommand(String input) {
        while (calendarTasks.size() != TOTAL_SIZE) {
            calendarTasks.add(new ArrayList<>());
        }
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

    private void addTaskToCalendarList(String time, String description, int day) {
        String entry = description;
        this.calendarTasks.get(day).add(entry);
    }

    private void parseTaskList(TaskList taskList) {
        for (Task task : taskList.getTaskList()) {
            String description = task.getDescription();
            String time = "";
            String[] dateSplit = task.getDate().split("-");
            if (this.month == Integer.parseInt(dateSplit[1]) && this.year == Integer.parseInt(dateSplit[2])) {
                int day = Integer.parseInt(dateSplit[0]);
                addTaskToCalendarList(time, description, day);
            }
        }
    }

    @Override
    public void execute(Ui ui, Storage storage) {
        Ui.printCalenderTitle(inputYearMonth);
        parseTaskList(storage.tasksList);
        Schedule.displayCalendar(inputYearMonth, calendarTasks);
    }
}