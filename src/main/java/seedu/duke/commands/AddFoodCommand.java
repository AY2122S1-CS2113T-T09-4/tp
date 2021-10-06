package seedu.duke.commands;

import seedu.duke.calories.FoodRecord;
import seedu.duke.parser.Parser;
import seedu.duke.storage.Storage;
import seedu.duke.ui.Ui;

/**
 * Command to add a food item to the existing  list.
 * prefix would be food add [FOOD_NAME] [CALORIE_COUNT(kcal)]
 *
 * @author ngnigel99
 */
public class AddFoodCommand extends Command {

    @Override
    public void execute(Ui ui, Storage storage) {
        //TODO read in user input, check correct data entry

        //TODO parse in foodRecord here
        //FoodRecord = Parser.parseFoodRecord(userInput);
        // storage.whatIAteTodayList.add(someFoodRecord);
    }
}
