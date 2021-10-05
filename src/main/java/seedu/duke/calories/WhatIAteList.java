package seedu.duke.calories;

import seedu.duke.ui.Ui;

import java.util.Date;

/**
 * Represents a list of what the user has eaten.
 *  This would include the date of the record and
 *      the food items consumed
 *
 * @author ngnigel99
 */
public class WhatIAteList extends ListOfRecords<foodRecord> {

    private Date dayOfRecordList;

    public WhatIAteList(Date dayOfRecordList) {
        this.dayOfRecordList = dayOfRecordList;
    }

    /**
     * Adds a food Record to a list, then notifies the user of what  item
     * they  have entered.
     *
     * @author  ngnigel99
     * @param recordToAdd record to add to list
     */
    @Override
    public void addToList(foodRecord recordToAdd) {
        List.add(recordToAdd);
        Ui.printAddRecord(recordToAdd);
    }
}
