package seedu.duke.module;

import java.util.ArrayList;

//@@ author nvbinh15

public class ModuleManager {
    private ArrayList<Module> modules;

    /**
     * Class constructor.
     * Creates an empty ArrayList of Module.
     */
    public ModuleManager() {
        this.modules = new ArrayList<>();
    }

    /**
     * Gets the list of modules.
     *
     * @return The list of modules.
     */
    public ArrayList<Module> getModules() {
        return modules;
    }

    /**
     * Sets the list of modules.
     *
     * @param modules The list of modules to be set.
     */
    public void setModules(ArrayList<Module> modules) {
        this.modules = modules;
    }
}
