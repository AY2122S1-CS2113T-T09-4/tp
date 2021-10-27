package seedu.duke.storage;


import seedu.duke.exceptions.StorageException;
import seedu.duke.exceptions.module.IllegalModuleException;
import seedu.duke.exceptions.zoom.InvalidZoomDataPath;
import seedu.duke.exceptions.zoom.InvalidZoomLinkException;
import seedu.duke.module.Module;
import seedu.duke.ui.Ui;
import seedu.duke.parser.module.ParserModule;

import java.awt.Desktop;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;

//@@author shoibloya

/**
 * This class deals with writing and reading text files relevant to the zoom feature.
 */
public class StorageZoom {
    private static final String folderName = "zoomdata/";
    private static final String fileName = "zoom.txt";
    private static String filePath =  folderName +  fileName;
    private static ParserModule parserModule = new ParserModule();

    /**
     * This function writes/overwrites a zoom link for the given module.
     *
     * @param moduleName The module name
     * @param zoomLink The zoom link
     * @throws IOException Throws an Input Output Exception
     */
    public static void saveLink(String moduleName, String zoomLink) throws IOException {
        Storage.checkAndAddDirectory(folderName);
        File newList = new File(folderName + fileName);

        if (isModuleIn(folderName + fileName, moduleName)) {
            String newData = "";
            Scanner scanner = new Scanner(newList);
            while (scanner.hasNext()) {
                String line = scanner.nextLine();
                String module = line.split("\\|")[0];
                if (module.equals(moduleName)) {
                    newData = newData + moduleName + "|" + zoomLink + "\n";
                } else {
                    newData = newData + line + "\n";
                }
            }

            FileWriter fw = new FileWriter(folderName + fileName, false);
            fw.write(newData);
            fw.close();
            Ui.printMessage("Zoom link updated successfully!");
        } else if (isModuleIn("module/module.txt", moduleName)) {
            FileWriter fw = new FileWriter(folderName + fileName, true);
            fw.write(moduleName + "|" + zoomLink + "\n");
            fw.close();
            Ui.printMessage("Zoom link added successfully");
        } else {
            Ui.printMessage("Module Not Found!");
        }

    }

    /**
     * This function reads data from zoom.txt prints it on screen.
     *
     * @throws InvalidZoomDataPath Throws the Invalid Zoom Data Path Exception
     */
    public static void displayLinks() throws InvalidZoomDataPath {
        try {
            BufferedReader br = new BufferedReader(new FileReader(folderName + fileName));
            String line;
            while ((line = br.readLine()) != null) {
                String moduleName = line.split("\\|", 2)[0];
                String zoomLink = line.split("\\|", 2)[1];
                Ui.displayZoomLink(moduleName, zoomLink);
            }
        } catch (Exception e) {
            throw new InvalidZoomDataPath();
        }

    }

    /**
     * This function checks if the given module is in the records.
     *
     * @param filePath The path of the data file
     * @param moduleName The name of the module
     * @return returns true if the module is in record, false otherwise.
     * @throws IOException throws the Input Output Exception
     */
    public static boolean isModuleIn(String filePath, String moduleName) throws IOException {
        File moduleList = new File(filePath);
        ArrayList<String> listOfModules = new ArrayList<>();

        Scanner scanner = new Scanner(moduleList);
        while (scanner.hasNext()) {
            String module;
            module = scanner.nextLine();
            listOfModules.add(module.split("\\|")[0].trim());
        }

        return listOfModules.contains(moduleName);
    }

    /**
     * This function opens zoom link in browser.
     *
     * @param module Name of the module
     * @throws IOException throws the Input Output Exception
     * @throws InvalidZoomLinkException throws the Invalid Zoom Link Exception
     */
    public static void openZoomLink(String module) throws IOException, InvalidZoomLinkException {
        String urlString = getZoomLink(module);
        System.out.println(urlString);
        try {
            Desktop.getDesktop().browse(new URL(urlString).toURI());
        } catch (Exception e) {
            throw new InvalidZoomLinkException();
        }
    }

    /**
     * This function returns the zoom link associated to a module.
     *
     * @param module The name of the module
     * @return returns the zoom link.
     * @throws IOException throws the Input Output Exception
     */
    public static String getZoomLink(String module) throws IOException {
        File data = new File("zoomdata/zoom.txt");

        Scanner scanner = new Scanner(data);
        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            if (module.equals(line.split("\\|")[0].trim())) {
                return line.split("\\|")[1].trim();
            }
        }

        return "";
    }

}
