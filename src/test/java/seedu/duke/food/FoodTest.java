package seedu.duke.food;

import org.junit.jupiter.api.Test;

import seedu.duke.constants.Messages;
import seedu.duke.exceptions.IllegalFoodParameterException;
import seedu.duke.parser.Parser;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FoodTest {
    private Parser parser = new Parser();

    /**
     * Checks food parsed correctly.
     * @author ngnigel99
     */
    @Test
    void testFoodAdd() {
        assertEquals("Samurai Burger : 433", new FoodRecord("Samurai Burger", 433).toString());
    }

    /**
     * Checks for NumberFormatException on adding a food item.
     * @author ngnigel99
     */
    @Test
    void addFoodItem_stringNotInt_illegalFoodParameterThrown() throws IllegalFoodParameterException {
        boolean nfeThrown = false;
        try {
            FoodRecord foodRecord = parser.parseFoodRecord("name_test" + " " + "sample_string");
        } catch (Exception e) {
            assertEquals(Messages.PRINT_ADD_FOOD_SYNTAX, e.getMessage());
        }
    }

    /**
     * Checks for IllegalFoodParameterException thrown when word count != 2.
     * @author ngnigel99
     */
    @Test
    void addFoodItem_wrongSyntax_illegalFoodParameterExceptionThrown() throws IllegalFoodParameterException {
        try {
            FoodRecord foodRecord = parser.parseFoodRecord("Cheezburger");  //calorie count not included
        } catch (Exception e) {
            assertEquals(Messages.PRINT_ADD_FOOD_SYNTAX, e.getMessage());
        }
    }

    /**
     * Checks for illegal food parameter exception thrown on null input.
     * @author ngnigel99
     */
    @Test
    void addFoodItem_noInputGiven_illegalFoodParameterThrown() throws IllegalFoodParameterException {
        try {
            FoodRecord foodRecord = parser.parseFoodRecord("");
        } catch (Exception e) {
            assertEquals(Messages.PRINT_ADD_FOOD_SYNTAX, e.getMessage());
        }
    }

}
