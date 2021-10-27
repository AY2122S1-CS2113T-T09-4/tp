package seedu.duke.commands.food;

import seedu.duke.commands.Command;
import seedu.duke.exceptions.ArgumentsNotFoundException;
import seedu.duke.exceptions.ClickException;
import seedu.duke.exceptions.WrongDividerOrderException;
import seedu.duke.food.FoodRecord;
import seedu.duke.food.ReferenceLists;
import seedu.duke.parser.Parser;
import seedu.duke.storage.Storage;
import seedu.duke.storage.StorageFood;
import seedu.duke.ui.Ui;

/**
 * Allows the user to add a food from a reference list.
 * radd refers to "reference add"
 */
public class AddFoodFromReferenceCommand extends Command {
    private int storeIndex;
    private int itemIndex;

    public AddFoodFromReferenceCommand() {
        this.syntax = "food radd s/ [STORE_INDEX] i/ [ITEM_INDEX]";
    }

    //assumes string given after food radd
    public AddFoodFromReferenceCommand(String userInput) throws WrongDividerOrderException,
        ArgumentsNotFoundException {
        String[] data = Parser.getData(userInput, "s/", "i/");
        String storeIndexString = data[0];
        String itemIndexString = data[1];
        try {
            storeIndex = Integer.parseInt(storeIndexString);
            itemIndex = Integer.parseInt(itemIndexString) - 1;
        } catch (NumberFormatException e) {
            Ui.printOnlyIntegers();
        }
    }

    @Override
    public void execute(Ui ui, Storage storage) throws ClickException, Exception {
        FoodRecord toAdd = storage
            .reference
            .getTechnoEdge()
            .getFoodRecordFromStall(storeIndex, itemIndex);
        Ui.printLine();
        Ui.printMessageSameLine("Nice, adding the record - ");
        Ui.printMessage(toAdd.toString());
        storage.whatIAteTodayList.addToList(toAdd, false);
        StorageFood.saveList(storage.whatIAteTodayList);
    }
}
