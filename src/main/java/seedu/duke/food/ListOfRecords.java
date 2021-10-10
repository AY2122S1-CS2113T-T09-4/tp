package seedu.duke.food;

import java.util.ArrayList;

/**
 * An abstract class for implementing food record  lists.
 * @author ngnigel99
 */
public abstract class ListOfRecords<T> {
    protected ArrayList<T> list =  new  ArrayList<>();

    protected ArrayList<T> getList() {
        return list;
    }

    /**
     * Adds items to a list.
     *
     * @author ngnigel99
     * @param recordToAdd record to add into list
     */
    protected void addToList(T recordToAdd) {
        list.add(recordToAdd);
    }

    /**
     * Prints a list.
     *
     * @author ngnigel99
     */
    protected void printList() {
        for (T listRecord : list) {
            System.out.println(listRecord);
        }
    }

    /**
     * Clears a list,  and wipes  storage.
     *
     * @author  ngnigel99
     */
    protected void clearList()  {
        list.clear();
    }
}
