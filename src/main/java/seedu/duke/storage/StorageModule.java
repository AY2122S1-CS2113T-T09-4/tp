package seedu.duke.storage;

import seedu.duke.exceptions.StorageException;
import seedu.duke.module.Module;
import seedu.duke.module.ModuleList;
import seedu.duke.parser.Parser;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class StorageModule {

    private static Parser parser = new Parser();

    public static final String PROJECT_ROOT = System.getProperty("user.dir");
    public static final String STORAGE_FOLDER = "module";
    public static final String FILE_NAME = "module.txt";
    public static final Path PATH_TO_STORAGE_FILE = Paths.get(PROJECT_ROOT, STORAGE_FOLDER, FILE_NAME);

    public static void createFile() throws IOException {
        File file = new File(String.valueOf(PATH_TO_STORAGE_FILE));
        if (file.exists()) {
            file.delete();
        }
        file.getParentFile().mkdirs();
        file.createNewFile();
    }

    public static ModuleList readDataFromFile() throws IOException {
        if (Files.notExists(PATH_TO_STORAGE_FILE)) {
            createFile();
        }
        ArrayList<Module> storedModules = new ArrayList<>();
        File file = new File(String.valueOf(PATH_TO_STORAGE_FILE));
        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNext()) {
                Module module;
                module = parser.retrieveStoredModule(scanner.nextLine());
                storedModules.add(module);
            }
        } catch (FileNotFoundException e) {
            System.out.println("MESSAGE_FILE_NOT_FOUND");
            return new ModuleList();
        } catch (StorageException e) {
            createFile();
            System.out.println("MESSAGE_STORAGE_EXCEPTION");
            return new ModuleList();
        }
        return new ModuleList(storedModules);
    }

    public static void saveDataToFile(ModuleList moduleList) throws IOException {
        FileWriter fileWriter = new FileWriter(String.valueOf(PATH_TO_STORAGE_FILE));
        for (Module m : moduleList.getModules()) {
            fileWriter.write(parser.formatModuleToStore(m));
        }
        fileWriter.close();
    }
}
