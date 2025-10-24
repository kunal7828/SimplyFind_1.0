package common;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.config.Configurator;

public class Log4JTest {

    // Define a logger instance for the class
    final Logger log = LogManager.getLogger(Log4JTest.class);

    // Method to print the first name and log a debug message
    public void printName() {
        System.out.println("Sumit");
        log.debug("This is a debug log: Name method executed");
    }

    // Method to print the surname and log info messages
    public void printSurname() {
        log.info("Info log: Surname method executed");

        // Avoid redundancy by using a loop or different log message context
        for (int i = 0; i < 3; i++) {
            log.info("Info log: Repeating log entry #" + (i + 1));
        }
    }

    // Method to log class information and error messages
    public void logClassInfo() {
        System.out.println("Classes");
        
        // Log multiple error messages in a loop or based on some condition
        for (int i = 0; i < 3; i++) {
            log.error("Error log: Class info error #" + (i + 1));
        }
        
        // Logging some additional info to balance the error logs
        log.info("Info log: Successfully logged class information.");
    }

    // Main method to execute the logging methods
    public static void main(String[] args) {
        // Create instance of the class
        Log4JTest logTest = new Log4JTest();

        // Call the methods to see the logs in action
        logTest.printName();
        logTest.logClassInfo();
        logTest.printSurname();
    }
}


