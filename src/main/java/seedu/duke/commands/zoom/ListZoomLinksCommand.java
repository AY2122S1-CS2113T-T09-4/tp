package seedu.duke.commands.zoom;

import seedu.duke.commands.Command;
import seedu.duke.storage.Storage;
import seedu.duke.storage.StorageZoom;
import seedu.duke.ui.Ui;

//@@author shoibloya

/**
 * A representation of the command to list all the zoom links.
 */
public class ListZoomLinksCommand extends Command {

    /**
     * Constructor to display syntax via the help feature.
     */
    public ListZoomLinksCommand() {
        syntax = "zoom list";
    }

    /**
     * Function to execute the ListZoomLinks command.
     *
     * @param ui      The component of Duke that deals with the interaction with the user.
     * @param storage The component of Duke that deals with loading tasks from the file and saving tasks in the file.
     * @throws Exception throws the default exception.
     */
    @Override
    public void execute(Ui ui, Storage storage) throws Exception {
        ui.printLine();
        try {
            StorageZoom.displayLinks();
            ui.printLine();
        } catch (Exception e) {
            ui.printLine();
        }
    }
}
