package seedu.duke.exceptions;

import seedu.duke.constants.Messages;

/**
 * Exception thrown when parameters are left blank when adding a food item.
 * More specifically, when user input is not 2 words consisting of name, calorie count.
 *
 * @author ngnigel99
 */
public class IllegalFoodParameterException extends ClickException {
    public IllegalFoodParameterException() {
        this.message = Messages.PRINT_ADD_FOOD_SYNTAX;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
