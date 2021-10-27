package seedu.duke.parser;

import seedu.duke.commands.calendar.AddLectureCommand;
import seedu.duke.commands.calendar.AddTodoCommand;
import seedu.duke.commands.calendar.DeleteLectureCommand;
import seedu.duke.commands.calendar.EditTasksCommand;
import seedu.duke.commands.calendar.ListLecturesCommand;
import seedu.duke.commands.calendar.DisplayCommand;
import seedu.duke.commands.calendar.DeleteTaskCommand;
import seedu.duke.commands.calendar.ListTasksCommand;
import seedu.duke.commands.food.AddFoodCommand;
import seedu.duke.commands.food.AddFoodFromReferenceCommand;
import seedu.duke.commands.food.ClearFoodCommand;
import seedu.duke.commands.food.DeleteFoodCommand;
import seedu.duke.commands.food.FindFoodWithDateCommand;
import seedu.duke.commands.food.ListFoodCommand;
import seedu.duke.commands.food.ViewReferenceFoodCommand;
import seedu.duke.commands.journal.AddEntryCommand;
import seedu.duke.commands.journal.AddNoteCommand;
import seedu.duke.commands.journal.DeleteEntryCommand;
import seedu.duke.commands.journal.DeleteNoteCommand;
import seedu.duke.commands.journal.FindNotebooksByTagCommand;
import seedu.duke.commands.journal.TagNotebookCommand;
import seedu.duke.commands.journal.ListJournalCommand;
import seedu.duke.commands.module.AddModuleCommand;
import seedu.duke.commands.module.CapInfoCommand;
import seedu.duke.commands.module.DeleteModuleCommand;
import seedu.duke.commands.module.GetCapCommand;
import seedu.duke.commands.module.ListModuleCommand;
import seedu.duke.commands.zoom.AddZoomCommand;
import seedu.duke.commands.Command;
import seedu.duke.commands.module.DeleteModuleCommand;
import seedu.duke.commands.food.DeleteFoodCommand;
import seedu.duke.commands.ExitCommand;
import seedu.duke.commands.HelpCommand;
import seedu.duke.commands.zoom.ListZoomLinks;
import seedu.duke.exceptions.calendar.IncorrectCommandException;
import seedu.duke.exceptions.calendar.IncorrectNumberOfArgumentsException;
import seedu.duke.exceptions.ArgumentsNotFoundException;
import seedu.duke.exceptions.ClickException;
import seedu.duke.exceptions.IllegalDateTimeException;
import seedu.duke.exceptions.WrongDividerOrderException;
import seedu.duke.exceptions.StorageException;
import seedu.duke.exceptions.food.IllegalFoodParameterException;
import seedu.duke.exceptions.food.MissingDateException;
import seedu.duke.exceptions.journal.EmptyJournalArgumentException;
import seedu.duke.exceptions.journal.IncorrectJournalArgumentException;

import seedu.duke.food.FoodRecord;
import seedu.duke.constants.Messages;
import seedu.duke.module.Module;
import seedu.duke.parser.schedule.ParserSchedule;
import seedu.duke.ui.Ui;

import javax.swing.text.View;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;

import static seedu.duke.constants.CommandConstants.COMMAND_ADD_ENTRY;
import static seedu.duke.constants.CommandConstants.COMMAND_ADD_NOTE;
import static seedu.duke.constants.CommandConstants.COMMAND_JOURNAL_LIST;
import static seedu.duke.constants.CommandConstants.COMMAND_JOURNAL_FIND;
import static seedu.duke.constants.CommandConstants.COMMAND_JOURNAL_TAG;

import static seedu.duke.constants.CommandConstants.COMMAND_CALENDAR;
import static seedu.duke.constants.CommandConstants.COMMAND_DELETE_ENTRY;
import static seedu.duke.constants.CommandConstants.COMMAND_DELETE_NOTE;
import static seedu.duke.constants.CommandConstants.COMMAND_DISPLAY;

import static seedu.duke.constants.CommandConstants.COMMAND_CALENDAR;

import static seedu.duke.constants.CommandConstants.COMMAND_EXIT;
import static seedu.duke.constants.CommandConstants.COMMAND_FOOD;
import static seedu.duke.constants.CommandConstants.COMMAND_HElP;

import static seedu.duke.constants.CommandConstants.COMMAND_LECTURE;
import static seedu.duke.constants.CommandConstants.COMMAND_MODULE;
import static seedu.duke.constants.CommandConstants.COMMAND_NOTE;
import static seedu.duke.constants.CommandConstants.COMMAND_SUFFIX_ADD;
import static seedu.duke.constants.CommandConstants.COMMAND_SUFFIX_CLEAR;
import static seedu.duke.constants.CommandConstants.COMMAND_SUFFIX_DELETE;
import static seedu.duke.constants.CommandConstants.COMMAND_SUFFIX_EDIT;
import static seedu.duke.constants.CommandConstants.COMMAND_SUFFIX_FIND;
import static seedu.duke.constants.CommandConstants.COMMAND_SUFFIX_LIST;
import static seedu.duke.constants.CommandConstants.COMMAND_SUFFIX_RADD;
import static seedu.duke.constants.CommandConstants.COMMAND_SUFFIX_VIEW;
import static seedu.duke.constants.CommandConstants.COMMAND_TODO;
import static seedu.duke.constants.CommandConstants.COMMAND_ZOOM;
import static seedu.duke.constants.CommandConstants.COMMAND_ZOOM_SUFFIX_ADD;

import static seedu.duke.constants.CommandConstants.COMMAND_SUFFIX_EDIT;
import static seedu.duke.constants.CommandConstants.COMMAND_MODULE;
import static seedu.duke.constants.CommandConstants.COMMAND_NOTE;
import static seedu.duke.constants.CommandConstants.COMMAND_SUFFIX_ADD;
import static seedu.duke.constants.CommandConstants.COMMAND_SUFFIX_CLEAR;
import static seedu.duke.constants.CommandConstants.COMMAND_SUFFIX_DELETE;
import static seedu.duke.constants.CommandConstants.COMMAND_SUFFIX_LIST;
import static seedu.duke.constants.CommandConstants.COMMAND_TODO;
import static seedu.duke.constants.CommandConstants.COMMAND_ZOOM;
import static seedu.duke.constants.CommandConstants.COMMAND_ZOOM_SUFFIX_ADD;
import static seedu.duke.constants.CommandConstants.COMMAND_DISPLAY;
import static seedu.duke.constants.CommandConstants.COMMAND_LECTURE;
import static seedu.duke.constants.CommandConstants.COMMAND_CAP;
import static seedu.duke.constants.CommandConstants.COMMAND_SUFFIX_EXPECTED;
import static seedu.duke.constants.CommandConstants.COMMAND_LECTURE;

import static seedu.duke.constants.Messages.EMPTY_STRING;
import static seedu.duke.constants.Messages.PRINT_NOT_AN_INT;
import static seedu.duke.constants.Messages.CALENDAR_INVALID_ARGS;
import static seedu.duke.constants.Messages.CALENDAR_EDIT_DELETE_INVALID_ARGS;

//@@author nvbinh15
public class Parser {

    static final String INPUT_DATE_TIME_FORMAT = "dd-MM-yyyy HHmm";
    static final String OUTPUT_DATE_TIME_FORMAT = "MMM dd yyyy HH:mm";

    static final int FOOD_MINIMUM_PARAMETER = 4; // tags {/n /c} + 2 inputs {name, calorie}
    static final String FOOD_NAME_DIVIDER = "n/";
    static final String FOOD_CALORIE_DIVIDER = "c/";
    static final String FOOD_DATE_DIVIDER = "d/";

    /**
     * Converts date and time in string format to a LocalDateTime object.
     *
     * @param string Date and time in string format.
     * @return A LocalDateTime object that represents the given date and time.
     * @throws IllegalDateTimeException If the input date time is invalid.
     */
    public static LocalDateTime stringToDateTime(String string) throws IllegalDateTimeException {
        try {
            return LocalDateTime.parse(string, DateTimeFormatter.ofPattern(INPUT_DATE_TIME_FORMAT));
        } catch (Exception e) {
            throw new IllegalDateTimeException();
        }
    }

    /**
     * Converts date and time in LocalDateTime format to a string.
     *
     * @param dateTime A LocalDateTime object that represents the given date and time.
     * @return The string representation of the given LocalDateTime object.
     */
    public static String dateTimeToString(LocalDateTime dateTime) {
        return dateTime.format(DateTimeFormatter.ofPattern(OUTPUT_DATE_TIME_FORMAT));
    }

    /**
     * Formats the user's input date time.
     *
     * @param rawDateTime The raw date time from user's input.
     * @return The string representation of other form of the given date time.
     * @throws IllegalDateTimeException If the input date time is invalid.
     */
    public static String formatDateTime(String rawDateTime) throws IllegalDateTimeException {
        try {
            return dateTimeToString(stringToDateTime(rawDateTime));
        } catch (IllegalDateTimeException e) {
            throw new IllegalDateTimeException();
        }
    }

    /**
     * Splits raw user input into command word and command arguments.
     *
     * @param userInput Raw input from user.
     * @return a String array of size 2 including the command type and the arguments.
     */
    public static String[] splitCommandAndArgs(String userInput) {
        String[] tokens = userInput.trim().split("\\s+", 2);
        String command = tokens[0];
        if (tokens.length == 2) {
            return tokens;
        } else {
            return new String[] {command, EMPTY_STRING};
        }
    }

    /**
     * Parses a line of text to a food record.
     * Assumes that both name, calories field not null.
     * Note format: [NAME] | [CALORIES] | {DATE}
     * @param readLine line of text to read
     * @return FoodRecord food record object
     */
    public static FoodRecord parseFoodSavedListToRecord(String readLine) {
        String[] nameCalories = readLine.split("\\|");
        if (nameCalories.length == 2) {
            return new FoodRecord(nameCalories[0], Integer.parseInt(nameCalories[1].trim()));
        }
        FoodRecord recordWithDate = new FoodRecord(nameCalories[0], Integer.parseInt(nameCalories[1]));
        String dateToParse = nameCalories[2];
        setDateOnFoodRecord(recordWithDate, dateToParse);
        return recordWithDate;
    }

    /**
     * Returns a command to be executed based on the raw input from user.
     *
     * @param userInput The raw input from user.
     * @return The command to be executed.
     * @throws ClickException If there is an exception to type DukeException occurs.
     */
    public Command parseCommand(String userInput)
            throws ClickException, IncorrectNumberOfArgumentsException, IncorrectJournalArgumentException,
            EmptyJournalArgumentException, IncorrectCommandException {
        final String[] commandTypeAndParams = splitCommandAndArgs(userInput);
        assert commandTypeAndParams.length == 2;
        final String commandType = commandTypeAndParams[0];
        final String commandArgs = commandTypeAndParams[1];

        switch (commandType) {
        case COMMAND_EXIT:
            return new ExitCommand();
        case COMMAND_CALENDAR:
            return getCalendarCommand(commandArgs, userInput);
        case COMMAND_FOOD:
            return getFoodCommand(userInput, commandArgs);
        case COMMAND_NOTE:
            String[] noteArguments = commandArgs.split(" ");
            switch (noteArguments[0]) {
            case COMMAND_ADD_NOTE:
                return new AddNoteCommand(userInput);
            case COMMAND_ADD_ENTRY:
                return new AddEntryCommand(userInput);
            case COMMAND_JOURNAL_LIST:
                return new ListJournalCommand();
            case COMMAND_DELETE_NOTE:
                return new DeleteNoteCommand(userInput);
            case COMMAND_DELETE_ENTRY:
                return new DeleteEntryCommand(userInput);
            case COMMAND_JOURNAL_TAG:
                return new TagNotebookCommand(userInput);
            case COMMAND_JOURNAL_FIND:
                return new FindNotebooksByTagCommand(userInput);
            case "":
                throw new EmptyJournalArgumentException();
            default:
                throw new IncorrectJournalArgumentException();
            }
        case COMMAND_MODULE:
            return getModuleCommand(commandArgs);
        case COMMAND_CAP:
            switch (commandArgs) {
            case COMMAND_SUFFIX_EDIT:
                return new CapInfoCommand();
            case COMMAND_SUFFIX_EXPECTED:
                return new GetCapCommand();
            default:
                throw new ClickException();
            }
        case COMMAND_ZOOM:
            String[] zoomArgs = commandArgs.split(" ");
            switch (zoomArgs[0]) {
            case COMMAND_ZOOM_SUFFIX_ADD:
                return new AddZoomCommand(zoomArgs[1], zoomArgs[2]);
            case COMMAND_SUFFIX_LIST:
                return new ListZoomLinks();
            default:
                throw new ArgumentsNotFoundException();
            }

        case COMMAND_HElP:
            String[] helpArgs = commandArgs.split(" ");
            return new HelpCommand();
        default:
            throw new ClickException();
        }
    }

    //@@author ngnigel99
    /**
     * Returns appropriate command related to Food based  on user's input.
     *
     * @param userInput Full string entered by user.
     * @param commandArgs second word onwards from userInput.
     * @return A command that's related to Food based on userInput.
     * @throws IllegalArgumentException if command entered does not exists, but starts with food.
     *
     * @author ngnigel99
     */
    private Command getFoodCommand(String userInput, String commandArgs) throws IllegalArgumentException,
            MissingDateException, WrongDividerOrderException,
            ArgumentsNotFoundException {
        String[] foodArgs = commandArgs.split(" ");
        switch (foodArgs[0]) {  //consider 2nd word
        case COMMAND_SUFFIX_ADD:
            return new AddFoodCommand(
                    filterStringAfterCommand(userInput, COMMAND_FOOD + " " + COMMAND_SUFFIX_ADD)
            );
        case COMMAND_SUFFIX_DELETE:
            return new DeleteFoodCommand(
                    filterStringAfterCommand(userInput, COMMAND_FOOD + " " + COMMAND_SUFFIX_DELETE)
            );
        case COMMAND_SUFFIX_CLEAR:
            return new ClearFoodCommand();
        case COMMAND_SUFFIX_LIST:
            return new ListFoodCommand();
        case COMMAND_SUFFIX_VIEW:
            return new ViewReferenceFoodCommand(userInput);
        case COMMAND_SUFFIX_FIND:
            if (userInput.split(" ").length == 3) {
                return new FindFoodWithDateCommand(foodArgs[1]);
            } else {
                throw new MissingDateException();
            }
        case COMMAND_SUFFIX_RADD:
            return new AddFoodFromReferenceCommand(
                    filterStringAfterCommand(userInput, COMMAND_FOOD
                            + " " + COMMAND_SUFFIX_RADD));
        default:
            throw new IllegalArgumentException(Messages.LIST_PROPER_FEATURE +  COMMAND_FOOD);
        }
    }
    //@@author ngnigel99

    //@@author nvbinh15
    /**
     * Returns a command related to Module based on user's input.
     *
     * @param commandArgs The command arguments.
     * @return A command that related to Module based on user's input.
     * @throws ClickException If there is an exception of type ClickException occurs.
     */
    private Command getModuleCommand(String commandArgs) throws ClickException {
        String[] moduleCommandAndArgs = splitCommandAndArgs(commandArgs);
        assert moduleCommandAndArgs.length == 2;
        switch (moduleCommandAndArgs[0]) {
        case COMMAND_SUFFIX_ADD:
            return new AddModuleCommand(moduleCommandAndArgs[1]);
        case COMMAND_SUFFIX_LIST:
            return new ListModuleCommand();
        case COMMAND_SUFFIX_DELETE:
            return new DeleteModuleCommand(moduleCommandAndArgs[1]);
        default:
            throw new ClickException();
        }
    }

    /**
     * Returns a Calendar command based on the user input.
     *
     * @param commandArgs The part of user given input from second word.
     * @param userInput Input entered by user of type String.
     * @return A calendar based command.
     * @throws IncorrectNumberOfArgumentsException If command entered
     *         by the user does not have the required number of arguments.
     *
     * @author swatimahadevan
     */
    private Command getCalendarCommand(String commandArgs, String userInput)
            throws IncorrectNumberOfArgumentsException, IncorrectCommandException {
        String[] calendarArguments = commandArgs.split(" ");
        switch (calendarArguments[0]) {
        case COMMAND_SUFFIX_LIST:
            Command list = getCalendarListCommand(calendarArguments);
            return list;
        case COMMAND_DISPLAY:
            return new DisplayCommand(userInput);
        case COMMAND_SUFFIX_EDIT:
            return new EditTasksCommand(getTaskIndex(calendarArguments));
        case COMMAND_TODO:
            ArrayList<String> arguments = ParserSchedule.parseTodoCommand(userInput);
            return new AddTodoCommand(arguments);
        case COMMAND_SUFFIX_DELETE:
            Command delete = getCalendarDeleteCommand(calendarArguments, userInput);
            return delete;
        case COMMAND_LECTURE:
            ArrayList<String> argumentsLecture = ParserSchedule.parseLectureCommand(userInput);
            return new AddLectureCommand(argumentsLecture);
        default:
            throw new IncorrectNumberOfArgumentsException(CALENDAR_INVALID_ARGS);
        }
    }

    private Command getCalendarListCommand(String[] calendarArguments)
            throws IncorrectCommandException {
        if (calendarArguments[1].equals("task")) {
            return new ListTasksCommand();
        } else if (calendarArguments[1].equals("lec")) {
            return new ListLecturesCommand();
        } else {
            throw new IncorrectCommandException("Incorrect command for list!");
        }
    }

    private Command getCalendarDeleteCommand(String[] calendarArguments, String userInput)
            throws IncorrectCommandException, IncorrectNumberOfArgumentsException {
        if (calendarArguments[1].equals("task")) {
            return new DeleteTaskCommand(getTaskIndex(calendarArguments), userInput);
        } else if (calendarArguments[1].equals("lec")) {
            return new DeleteLectureCommand(getTaskIndex(calendarArguments), userInput);
        } else {
            throw new IncorrectCommandException("Incorrect command for delete!");
        }
    }

    private int getTaskIndex(String[] calendarArguments) throws IncorrectNumberOfArgumentsException {
        if (calendarArguments.length != 3) {
            throw new IncorrectNumberOfArgumentsException(CALENDAR_EDIT_DELETE_INVALID_ARGS);
        }
        int indexOfTaskToBeEdited = 0;
        try {
            indexOfTaskToBeEdited = Integer.parseInt(calendarArguments[2]);
        } catch (NumberFormatException e) {
            System.out.println(PRINT_NOT_AN_INT);
        }
        return indexOfTaskToBeEdited;
    }

    public static int getWordCount(String input) {
        return input.trim().split(" ").length;
    }

    //@@author ngnigel99
    /**
     * Returns a string representing a data block, separated by 2 dividers.
     * For example, n/ [DATA_1] c/ [DATA_2], if n/ is passed, DATA_1 would be returned.
     *
     * @param input input that contains dividers and data
     * @param dividerBefore divider before the data
     * @param dividerAfter divider after the data
     * @return data Array List of data extracted, containing both DATA_1 and DATA_2
     *
     * @author ngnigel99
     */
    public static String[] getData(String input,
                                   String dividerBefore,
                                   String dividerAfter)
            throws WrongDividerOrderException, ArgumentsNotFoundException {
        if (!(input.contains(dividerBefore) && input.contains(dividerAfter))) {
            throw new ArgumentsNotFoundException();
        }
        if (input.indexOf(dividerBefore) >= input.indexOf(dividerAfter)) {
            throw new WrongDividerOrderException();
        }
        assert !input.equals("") : "exception not accounted for empty string!";
        assert input.indexOf(dividerBefore) < input.indexOf(dividerAfter) : "divider order is wrong!";
        String afterFirstDivider  = input.split(dividerBefore)[1];
        String dataFirst          = afterFirstDivider.split(dividerAfter)[0].trim();
        String afterSecondDivider = afterFirstDivider.split(dividerAfter)[1];
        String dataSecond         = afterSecondDivider.trim();
        return  new String[] {dataFirst, dataSecond};

    }

    /**
     * Parses a string into a food item.
     * current implementation: {food add} n/ [NAME] c/ [CALORIES] d/ {date}.
     *
     * @param input string consisting of food name and calories.
     * @return recordToAdd if valid syntax given.
     * @throws IllegalFoodParameterException Invalid types given.
     * @throws ArgumentsNotFoundException Invalid syntax given.
     *
     * @author ngnigel99
     */
    public static FoodRecord parseFoodRecord(String input) throws IllegalFoodParameterException,
            ArgumentsNotFoundException {
        try {
            FoodRecord recordToAdd = null;
            if (getWordCount(input) < FOOD_MINIMUM_PARAMETER) {
                throw new IllegalFoodParameterException();
            }
            String[] foodName = getData(input, FOOD_NAME_DIVIDER, FOOD_CALORIE_DIVIDER);
            String name = foodName[0];
            if (input.contains(FOOD_DATE_DIVIDER)) {
                String[] foodCalorie = getData(input, FOOD_CALORIE_DIVIDER, FOOD_DATE_DIVIDER);
                int calories = Integer.parseInt(foodCalorie[0]);
                recordToAdd = new FoodRecord(name, calories);
                int dateDividerIndex = input.indexOf(FOOD_DATE_DIVIDER);
                String inputAfterDateDivider = input.substring(dateDividerIndex + 2).trim();
                setDateOnFoodRecord(recordToAdd, inputAfterDateDivider);
                Ui.printMessage("Nice, I see you consumed " + name + " on "
                       + recordToAdd.getDateIAte().toString()
                                + ", and have recorded ");
            } else {
                int calories = Integer.parseInt(foodName[1]);
                recordToAdd = new FoodRecord(name, calories);
            }
            return recordToAdd;
        } catch (NumberFormatException e) {
            Ui.printAddFoodSyntax();
        } catch (NullPointerException e) {
            Ui.printNonNullInput();
        } catch (WrongDividerOrderException e) {
            e.printStackTrace();
            System.out.println("Oops, internal error");
        } catch (DateTimeParseException e) {
            System.out.println("Please follow the format DD-MM-YYYY!");
        }
        return null;
    }

    /**
     * Sets a date for a food Record.
     * @param recordToAdd food record to be added
     * @param inputAfterDateDivider date as input string
     */
    private static void setDateOnFoodRecord(FoodRecord recordToAdd, String inputAfterDateDivider) {
        DateTimeFormatter localDateFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate dateIAte = LocalDate.parse(inputAfterDateDivider, localDateFormatter);
        recordToAdd.setDateIAte(dateIAte);
    }

    /**
     * Parses a string list to an integer list.
     * Current implementation supports single integer, but
     * future implementations would involve reading a list.
     *
     * @param strings any amount of string input to be converted
     * @return integerList integers that are successfully parsed
     *
     * @author ngnigel99
     */
    public static ArrayList<Integer> parseStringToIntegerList(String... strings) {
        ArrayList<Integer> integerList = new ArrayList<>();
        for (String string : strings) {
            try {
                integerList.add(Integer.parseInt(string));
            } catch (NumberFormatException e) {
                Ui.printOnlyIntegers();
            }
        }
        return integerList;
    }

    /**
     * Returns string after "food add" for the purpose of
     * parsing those characters into integers.
     * @param userInput full line of user input
     * @param  command command syntax e.g. food delete
     * @return string after command from userInput
     *
     * @author ngnigel99
     */
    public static String filterStringAfterCommand(String userInput, String command) {
        assert userInput.contains(command) : "Please check correct command syntax";
        return userInput.split(command)[1].trim();
    }
  
}

