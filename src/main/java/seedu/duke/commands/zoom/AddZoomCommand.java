package seedu.duke.commands.zoom;

import seedu.duke.commands.Command;
import seedu.duke.exceptions.ClickException;
import seedu.duke.exceptions.FileNotFoundException;
import seedu.duke.exceptions.StorageException;
import seedu.duke.exceptions.module.IllegalModuleException;
import seedu.duke.exceptions.zoom.InvalidZoomLinkException;
import seedu.duke.storage.Storage;
import seedu.duke.storage.StorageZoom;
import seedu.duke.ui.Ui;

import java.io.IOException;

//@@author shoibloya

/**
 * This is a representation of the AddZoomCommand command.
 */
public class AddZoomCommand extends Command {
    private String moduleName;
    private String zoomLink;

    /**
     * Constructor for help function.
     */
    public AddZoomCommand() {
        syntax = "zoom add [MODULE_CODE] [ZOOM_LINK]";
    }

    /**
     * Class constructor.
     *
     * @param moduleName Name of the module
     * @param zoomLink Zoom link
     */
    public AddZoomCommand(String moduleName, String zoomLink) {
        this.moduleName = moduleName;
        this.zoomLink = zoomLink;
    }

    /**
     * Returns the zoom link.
     *
     * @return The zoom link.
     */
    public String getZoomLink() {
        return zoomLink;
    }

    /**
     * Executes the AddZoomCommand function.
     *
     * @param ui The component of Duke that deals with the interaction with the user.
     * @param storage The component of Duke that deals with loading tasks from the file and saving tasks in the file.
     * @throws IOException throws the Input Output Exception
     * @throws IllegalModuleException throws the Illegal Module Exception
     * @throws StorageException throws the Storage Exception
     */
    @Override
    public void execute(Ui ui, Storage storage) throws IOException, IllegalModuleException,
            StorageException, InvalidZoomLinkException {
        if (zoomLink.contains("https://")) {
            ui.printLine();
            try {
                StorageZoom.saveLink(moduleName, zoomLink);
                ui.printLine();
            } catch (IOException e) {
                ui.printMessage("Unsuccessful");
                ui.printLine();
            }
        } else {
            throw new InvalidZoomLinkException();
        }
    }
}
