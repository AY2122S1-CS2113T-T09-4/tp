package seedu.duke.commands;

import seedu.duke.parser.Parser;
import seedu.duke.storage.Storage;
import seedu.duke.ui.Ui;

import java.util.ArrayList;
import java.util.Arrays;

public class ModuleShow extends Command{
    private ArrayList<String> moduleList = new ArrayList<String>(Arrays.asList("show", "CS2113T", "CG2028", "GES1011", "CGF1002"));
    private String action = "";

    public ModuleShow (String input){
        this.action = Parser.parseModuleCode(input);
        try {
            if (!moduleList.contains(action)){
                throw new Exception();
            }
        } catch (Exception e){
            Ui.printInvalidModuleCodeMessage();
        }
    }
    @Override
    public void execute(Ui ui, Storage storage) {
        Ui.printModule(action);
    }
}
