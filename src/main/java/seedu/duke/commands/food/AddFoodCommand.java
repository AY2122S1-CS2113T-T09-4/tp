package seedu.duke.commands.food;

import seedu.duke.commands.Command;
import seedu.duke.exceptions.ArgumentsNotFoundException;
import seedu.duke.food.FoodRecord;
import seedu.duke.exceptions.food.IllegalFoodParameterException;
import seedu.duke.parser.Parser;
import seedu.duke.storage.Storage;
import seedu.duke.storage.StorageFood;
import seedu.duke.ui.Ui;

import java.io.IOException;

//@@author ngnigel99
/**
 * Command to add a food item to the existing  list.
 *
 * @author ngnigel99
 */
public class AddFoodCommand extends Command {
    private String inputString; //name + calorie

    public AddFoodCommand() {
        syntax = "food add n/ [FOOD_NAME] c/ [CALORIE] d/ {DD-MM-YYYY(DATE_RECORDED)}";
    }

    public AddFoodCommand(String inputString) {
        super();
        this.inputString = inputString;
        this.helpMessage = "Adds a food item to a list";
    }

    /**
     * Executes add food command.
     * @param ui      The component of Duke that deals with the interaction with the user.
     * @param storage The component of Duke that deals with loading tasks from the file and saving tasks in the file.
     * @throws IllegalFoodParameterException If syntax is not followed.
     * @throws IOException If there is an error while reading/ saving data to file.
     *
     * @author ngnigel99
     */
    @Override
    public void execute(Ui ui, Storage storage) throws IllegalFoodParameterException, IOException {
        FoodRecord foodRecord  = null;
        try {
            foodRecord = Parser.parseFoodRecord(inputString);
        } catch (ArgumentsNotFoundException e) {
            Ui.printLine();
            Ui.printMessage("Wrong syntax! Refer to help for more options.");
        }
        storage.whatIAteTodayList.addToList(foodRecord, false);
        StorageFood.saveList(storage.whatIAteTodayList);
    }


}
