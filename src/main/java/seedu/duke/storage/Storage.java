package seedu.duke.storage;

import seedu.duke.calories.WhatIAteList;

import java.util.Date;

public class Storage {
    /**
     * synchronised date with food record  list.
     * @author ngnigel99
     * //TODO storage  file  implementation with hard-disk capability
     * //TODO sync todaysDate from  file as well
     */

    private Date todaysDate;
    public WhatIAteList whatIAteTodayList =  new WhatIAteList(todaysDate);
}
