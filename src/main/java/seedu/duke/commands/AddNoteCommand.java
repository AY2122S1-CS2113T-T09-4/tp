package seedu.duke.commands;

import seedu.duke.storage.Storage;
import seedu.duke.ui.Ui;
import seedu.duke.parser.Parser;

import java.util.ArrayList;

public class AddNoteCommand extends Command {

    private ArrayList<String> noteList = new ArrayList<>();
    public String userInput;

    public AddNoteCommand(String userInput) {
        this.userInput = userInput;
    }

    @Override
    public void execute(Ui ui, Storage storage) {
        String noteName = Parser.parseAddNoteCommand(userInput);
        noteList.add(noteName);
        ui.printAddedNoteMessage(noteName);
    }
}

