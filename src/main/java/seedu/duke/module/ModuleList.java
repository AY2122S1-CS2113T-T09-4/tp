package seedu.duke.module;

import java.util.ArrayList;

//@@ author nvbinh15

public class ModuleList {
    private ArrayList<Module> modules;

    /**
     * Class constructor.
     * Creates an empty ArrayList of Module.
     */
    public ModuleList() {
        this.modules = new ArrayList<>();
    }

    public ModuleList(ArrayList<Module> modules) {
        this.modules = modules;
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

    /**
     * Returns the total number of modules.
     *
     * @return The total number of modules.
     */
    public int getNumberOfModules() {
        return modules.size();
    }

    /**
     * Returns a module knowing its index in the ArrayList of modules (0-based).
     *
     * @param index Index of the module to be returned (0-based).
     * @return The module having the given index
     */
    public Module getModuleByIndex(int index) {
        return modules.get(index);
    }

    /**
     * Adds a new module to modules.
     *
     * @param module The module to be added.
     */
    public void addModule(Module module) {
        modules.add(module);
    }

    /**
     * Removes a module from modules.
     *
     * @param index Index of the module to be removed (0-based).
     */
    public void removeModuleByIndex(int index) {
        modules.remove(index);
    }
}
