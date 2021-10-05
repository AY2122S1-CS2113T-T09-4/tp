package seedu.duke.calories;

import seedu.duke.constants.Messages;
import seedu.duke.ui.Ui;

/**
 * A food record simply records the name and colorie count of a food item
 * [FOOD_NAME] [CALORIES]
 *
 * @author  ngnigel99
 */
public class foodRecord {
    private String foodName;
    private Integer calorieCount;

    public foodRecord(String foodName, Integer calorieCount) {
        this.foodName = foodName;
        this.calorieCount = calorieCount;
    }

    public String getFoodName() {
        return foodName;
    }

    public Integer getCalorieCount() {
        return calorieCount;
    }

    @Override
    public String toString() {
        return foodName + " "
                + Messages.RECORD_ATTRIBUTE_DIVIDER  + " "
                + calorieCount;
    }

    public void printRecordOnAdd()  {
        Ui.printAddRecord(this);
    }
}
