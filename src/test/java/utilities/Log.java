package utilities;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

/**
 * @author alpinaro (Alper Çınaroğlu)
 * https://github.com/alpinaro
 */
public class Log {

    static Logger logger = Logger.getLogger(Log.class);

    protected Log() {

        DOMConfigurator.configure("log4j.xml");
    }

    protected void info(String message) {

        logger.info(message);
    }

    protected void warn(String message) {

        logger.warn(message);
    }

    protected void error(String message) {

        logger.error(message);
    }
}