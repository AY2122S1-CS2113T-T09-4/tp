package seedu.duke.module;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ModuleTest {

    @Test
    void getCode_newModuleSpecifyingCode_specifiedCode() {
        String moduleCode = "CS2113T";
        Module module = new Module(moduleCode);
        assertEquals(moduleCode, module.getCode());
    }

    @Test
    void getName_newModuleSpecifyingCodeAndName_specifiedName() {
        String moduleCode = "CS2113T";
        String moduleName = "Software Engineering & Object-Oriented Programming";
        Module module = new Module(moduleCode, moduleName);
        assertEquals(moduleName, module.getName());
    }

    @Test
    void getExpectedGrade_newModuleSpecifyingCodeNameAndGrade_specifiedGrade() {
        String moduleCode = "CS2113T";
        String moduleName = "Software Engineering & Object-Oriented Programming";
        String expectedGrade = "A-";
        Module module = new Module(moduleCode, moduleName, expectedGrade);
        assertEquals(expectedGrade, module.getExpectedGrade());
    }

    @Test
    void setCode_newModuleChangeToNewCode_newCode() {
        String moduleCode = "CS2113T";
        Module module = new Module(moduleCode);
        String newModuleCode = "CS2113";
        module.setCode(newModuleCode);
        assertEquals(newModuleCode, module.getCode());
    }

    @Test
    void setName_newModuleChangeToNewName_newName() {
        String moduleCode = "CS2113T";
        String moduleName = "Software Engineering & Object-Oriented Programming";
        Module module = new Module(moduleCode, moduleName);
        String newModuleName = "Software Engineering and Object-Oriented Programming";
        module.setName(newModuleName);
        assertEquals(newModuleName, module.getName());
    }

    @Test
    void setExpectedGrade_newModuleChangeToNewGrade_newGrade() {
        String moduleCode = "CS2113T";
        String moduleName = "Software Engineering & Object-Oriented Programming";
        String expectedGrade = "A-";
        Module module = new Module(moduleCode, moduleName, expectedGrade);
        String newExpectedGrade = "A";
        module.setExpectedGrade(newExpectedGrade);
        assertEquals(newExpectedGrade, module.getExpectedGrade());
    }

    @Test
    void testToString() {
        String moduleCode = "CS2113T";
        String moduleName = "Software Engineering & Object-Oriented Programming";
        String expectedGrade = "A";
        String moduleStringRepresentation = moduleCode + " | " + moduleName + " | Expected grade: " + expectedGrade;
        Module module = new Module(moduleCode, moduleName, expectedGrade);
        assertEquals(moduleStringRepresentation, module.toString());
    }
}
