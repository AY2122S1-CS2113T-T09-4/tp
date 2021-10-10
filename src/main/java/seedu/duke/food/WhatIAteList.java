package seedu.duke.food;

import seedu.duke.ui.Ui;

import java.util.ArrayList;
import java.util.Date;

/**
 * Represents a list of what the user has eaten.
 *  This would include the date of the record and
 *      the food items consumed.
 *
 * @author ngnigel99
 */
public class WhatIAteList extends ListOfRecords<FoodRecord> {

    private Date dayOfRecordList;

    public WhatIAteList(Date dayOfRecordList) {
        this.dayOfRecordList = dayOfRecordList;
    }

    //if date not given
    public WhatIAteList() {
    }

    public ArrayList<FoodRecord> getList() {
        return list;
    }

    /**
     * Adds a food Record to a list, then notifies the user of what  item
     *  they  have entered.
     *
     * @author  ngnigel99
     * @param recordToAdd record to add to list
     */
    @Override
    public void addToList(FoodRecord recordToAdd) {
        super.addToList(recordToAdd);
        Ui.printAddRecord(recordToAdd);
    }

    /**
     * Prints  index with suffix for visuals.
     *
     * @author ngnigel99
     * @param index index of list
     */
    public void printIndexWithSuffix(int index) {
        String[] suffixList = {"st", "nd", "rd", "th"};
        String suffixToPrint;
        if ((index - 1) %  10 == 0) {
            suffixToPrint = suffixList[0];
        } else if ((index - 2) % 10 == 0) {
            suffixToPrint = suffixList[1];
        } else if ((index - 3) % 10 == 0) {
            suffixToPrint = suffixList[2];
        } else {
            suffixToPrint = suffixList[3];
        }
        System.out.print(index + suffixToPrint  +  ",");
    }

    /**
     * Prints food records collated in list.
     * In context, for today.
     *
     * @author ngnigel99
     */
    @Override
    public void printList() {
        int index = 1;  //TODO integrate this with storage so it's not a magic number
        int calorieSum =  0;
        for (FoodRecord listRecord : list) {
            printIndexWithSuffix(index);
            System.out.println("You consumed  " + listRecord.getFoodName()
                                + " , which has a calorie count of : "
                                + listRecord.getCalorieCount() + "!");
            index++;
            calorieSum += listRecord.getCalorieCount();
        }
        System.out.println("Wow, that's a lot of food! Finished reading today's list");
        System.out.println("You consumed " + calorieSum +  " calories in total today!");
    }

    @Override
    public void clearList() {
        super.clearList();
        Ui.printDoneClearList();
    }
}
