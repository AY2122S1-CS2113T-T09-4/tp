package seedu.duke.constants;

public class Messages {

    public static final String LOGO = "\t" + " ____        _\n"
            + "\t" + "|  _ \\ _   _| | _____\n"
            + "\t" + "| | | | | | | |/ / _ \\\n"
            + "\t" + "| |_| | |_| |   <  __/\n"
            + "\t" + "|____/ \\__,_|_|\\_\\___|\n\n";

    public static final String OPEN_SQUARE_BRACKET = "[";
    public static final String CLOSE_SQUARE_BRACKET = "]";
    public static final String VERTICAL_BAR = " | ";
    public static final String VERTICAL_BAR_REGEX = " \\| ";
    public static final String EMPTY_STRING = "";

    public static final String LINE_PREFIX = "\t";
    public static final String LINE_SEPARATOR = System.lineSeparator();
    public static final String NEW_LINE = LINE_SEPARATOR + LINE_PREFIX;
    public static final String HORIZONTAL_LINE = LINE_PREFIX + "__________________________________________________";

    public static final String MESSAGE_GREETING = LINE_PREFIX + "Hello! I'm Duke" + NEW_LINE + "What can I do for you?";
    public static final String MESSAGE_GOODBYE = LINE_PREFIX + "Bye. Hope to see you again soon!";

    // Food partition
    public static final String ADD_RECORD_GREET = "Nice.  I've added ";
    public static final String ADD_RECORD_TTL = "to the list,";
    public static final String RECORD_ATTRIBUTE_DIVIDER = "*";
    public static final String ADD_RECORD_CONNECTOR = " with ";
    public static final String ADD_RECORD_FINAL = " calories!";
    //end of Food

    //@author swatim
    public static String CALENDAR_HEADER_LINE = "________________________________________________________";
    public static final String INVALID_CALENDAR_INPUT = " Invalid Input! Please "
            + "type command in format:   | calendar MM-YYYY |";
    public static final String INVALID_YEARMONTH = " Invalid Input! Please give "
            + "a month between 1-12 and year between 2021-2025";
}
