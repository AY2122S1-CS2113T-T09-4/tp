package seedu.duke.logger;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

/**
 * A class to handle logging file.
 */
public class ClickLogger {
    private Logger logger;
    private static ClickLogger loggerInstance = null;

    public static final String PROJECT_ROOT = System.getProperty("user.dir");
    public static final String PATH_TO_LOG_FILE = Paths.get(PROJECT_ROOT, "logs", "ClickLogs.log").toString();

    private ClickLogger() {
        try {
            File file = new File(PATH_TO_LOG_FILE);
            file.getParentFile().mkdirs();
            file.createNewFile();

            SimpleFormatter formatter = new SimpleFormatter();
            FileHandler fileHandler = new FileHandler(PATH_TO_LOG_FILE);
            fileHandler.setFormatter(formatter);

            logger = Logger.getLogger("ClickLogger");
            logger.addHandler(fileHandler);
            logger.setUseParentHandlers(false);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Logger getNewLogger() {
        if (loggerInstance == null) {
            loggerInstance = new ClickLogger();
        }
        return loggerInstance.logger;
    }
}
