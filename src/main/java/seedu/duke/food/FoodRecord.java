package seedu.duke.food;

import seedu.duke.constants.Messages;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


/**
 *  A food record simply records the name and calorie count of a food item.
 *  [FOOD_NAME] [CALORIES]
 *
 * @author  ngnigel99
 */
public class FoodRecord {
    private final LocalDate defaultDate = LocalDate.now();
    private String foodName;
    private Integer calorieCount;
    private LocalDate dateIAte = defaultDate;

    public FoodRecord(String foodName, Integer calorieCount) {
        this.foodName = foodName;
        this.calorieCount = calorieCount;
    }

    public void setDateIAte(LocalDate dateIAte) {
        this.dateIAte = dateIAte;
    }

    public LocalDate getDateIAte() {
        return dateIAte;
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
                + calorieCount
                + " KCal";
    }

    public String toSaveListFormat() {
        return foodName + "|" + calorieCount + stringLocalDateIfExist() + "\n";
    }

    public String stringLocalDateIfExist() {
        if (this.dateIAte != null) {
            String printDateWithFormat = dateIAte.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
            return "|" + printDateWithFormat;
        }
        return "";
    }
}
