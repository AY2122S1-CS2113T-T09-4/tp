package seedu.duke.food;

import seedu.duke.constants.Messages;
import seedu.duke.ui.Ui;

/**
 *  A food record simply records the name and calorie count of a food item.
 *  [FOOD_NAME] [CALORIES]
 *
 * @author  ngnigel99
 */
public class FoodRecord {
    private String foodName;
    private Integer calorieCount;

    public FoodRecord(String foodName, Integer calorieCount) {
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
        return foodName
                + Messages.RECORD_ATTRIBUTE_DIVIDER
                + calorieCount;
    }

    public String toSaveListFormat() {
        return foodName + "|" + calorieCount + "\n";
    }

    public void printRecordOnAdd()  {
        Ui.printAddRecord(this);
    }
}
