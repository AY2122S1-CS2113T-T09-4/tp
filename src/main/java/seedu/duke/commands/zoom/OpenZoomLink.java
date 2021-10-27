package seedu.duke.commands.zoom;

import seedu.duke.commands.Command;
import seedu.duke.storage.Storage;
import seedu.duke.storage.StorageZoom;
import seedu.duke.ui.Ui;

//@@author shoibloya

/**
 * This class represents the zoom command to open a link.
 */
public class OpenZoomLink extends Command {
    private String module;

    /**
     * Constructor to print syntax via the help feature.
     */
    public OpenZoomLink() {
        syntax = "zoom open [MODULE_CODE]";
    }

    /**
     * Class constructor.
     *
     * @param module The module
     */
    public OpenZoomLink(String module) {
        this.module = module;
    }

    /**
     * Execute the OpenZoomLink command.
     *
     * @param ui      The component of Duke that deals with the interaction with the user.
     * @param storage The component of Duke that deals with loading tasks from the file and saving tasks in the file.
     * @throws Exception Throws the default exception
     */
    @Override
    public void execute(Ui ui, Storage storage) throws Exception {
        ui.printLine();
        try {
            StorageZoom.openZoomLink(module);
            ui.printLine();
        } catch (Exception e) {
            ui.printLine();
        }
    }
}
