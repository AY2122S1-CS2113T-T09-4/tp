package seedu.duke.module;

//@@ author nvbinh15

/**
 * A representation of a Module.
 */
public class Module {
    private String code;
    private String name;
    private String expectedGrade; // to be replaced with enumeration

    private static final String DEFAULT_MODULE_NAME = "NONE";
    private static final String DEFAULT_EXPECTED_GRADE = "N/A";

    /**
     * Class constructor specifying the module code.
     *
     * @param code The module code.
     */
    public Module(String code) {
        this.code = code;
        this.name = DEFAULT_MODULE_NAME;
        this.expectedGrade = DEFAULT_EXPECTED_GRADE;
    }

    /**
     * Class constructor specifying the module code and module name.
     *
     * @param code The module code.
     * @param name The module name.
     */
    public Module(String code, String name) {
        this.code = code;
        this.name = name;
        this.expectedGrade = DEFAULT_EXPECTED_GRADE;
    }

    /**
     * Class constructor specifying the module code, module name, and the expected grade.
     *
     * @param code The module code.
     * @param name The module name.
     * @param expectedGrade The expected grade of the module.
     */
    public Module(String code, String name, String expectedGrade) {
        this.code = code;
        this.name = name;
        this.expectedGrade = expectedGrade;
    }

    /**
     * Returns the module code.
     *
     * @return the module code.
     */
    public String getCode() {
        return code;
    }

    /**
     * Returns the module name.
     *
     * @return the module name.
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the module expected grade.
     *
     * @return the module expected grade.
     */
    public String getExpectedGrade() {
        return expectedGrade;
    }

    /**
     * Sets the code of the module.
     *
     * @param code The code to be set.
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * Sets the name of the module.
     *
     * @param name The name to be set.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Sets the expected grade of the module.
     *
     * @param expectedGrade The grade to be set.
     */
    public void setExpectedGrade(String expectedGrade) {
        this.expectedGrade = expectedGrade;
    }

    /**
     * Overrides toString method of class Object to get the string representation of Module.
     *
     * @return The string representation of the module.
     */
    @Override
    public String toString() {
        if (this.name.equals(DEFAULT_MODULE_NAME) & this.expectedGrade == DEFAULT_EXPECTED_GRADE) {
            return this.code;
        } else if (this.expectedGrade == DEFAULT_EXPECTED_GRADE) {
            return this.code + " | " + this.name;
        } else {
            return this.code + " | " + this.name + " | Expected grade: " + this.expectedGrade;
        }
    }

}
