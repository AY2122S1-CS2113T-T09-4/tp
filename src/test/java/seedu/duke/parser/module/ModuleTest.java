package seedu.duke.parser.module;

import org.junit.jupiter.api.Test;
import seedu.duke.parser.Parser;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ModuleTest {

    @Test
    void sampleTest() {
        assertEquals("moduleCode", Parser.parseModuleCode("module n/ moduleCode"));
    }

}