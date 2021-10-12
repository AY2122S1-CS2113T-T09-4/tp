package seedu.duke.commands;

import seedu.duke.exceptions.ArgumentsNotFoundException;
import seedu.duke.food.FoodRecord;
import seedu.duke.exceptions.IllegalFoodParameterException;
import seedu.duke.parser.Parser;
import seedu.duke.storage.Storage;
import seedu.duke.storage.StorageFood;
import seedu.duke.ui.Ui;

import java.io.IOException;

/**
 * Command to add a food item to the existing  list.
 * prefix would be food add [FOOD_NAME] [CALORIE_COUNT(kcal)]
 *
 * @author ngnigel99
 */
public class AddFoodCommand extends Command {
    private String inputString; //name + calorie

    public AddFoodCommand(String inputString) {
        super();
        this.inputString = inputString;
    }

    @Override
    public void execute(Ui ui, Storage storage) throws IllegalFoodParameterException, IOException {
        FoodRecord foodRecord  = null;
        try {
            foodRecord = Parser.parseFoodRecord(inputString);
        } catch (ArgumentsNotFoundException e) {
            e.printStackTrace();    //dividers are not aligned with syntax
        }
        storage.whatIAteTodayList.addToList(foodRecord);
        StorageFood.saveList(storage.whatIAteTodayList);
    }
}
