package common;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.config.Configurator;

public class Log4JTest {
	
	final Logger log = LogManager.getLogger(Log4JTest.class);
	
	public void name() {
		System.out.println("Sumit");
		log.debug("This is an debug log");
		
	}
	
	public void surname() {
		System.out.println("surname");
		log.info("Info log");
		log.info("Info log");
		log.info("Info log");
		log.info("Info log");
		log.info("Info log");
		log.info("Info log");
	}
	
	public void classes() {
		System.out.println("classes");
		log.error("This is an error log");	
		
		log.error("This is an error log");
		log.error("This is an error log");
		log.error("This is an error log");
		log.error("This is an error log");
		log.error("This is an error log");
		
		log.info("Info log");
		log.info("Info log");
		log.info("Info log");
		log.info("Info log");
		log.info("Info log");
	}

	public static void main(String[] args) {
		
		Log4JTest logg = new Log4JTest(); 
		logg.name();
		logg.classes();
		logg.surname();
	}

}

