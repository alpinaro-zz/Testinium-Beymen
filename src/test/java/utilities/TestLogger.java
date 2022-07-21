package utilities;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestWatcher;

import java.util.Optional;

/**
 * @author alpinaro (Alper Çınaroğlu)
 * https://github.com/alpinaro
 */
public class TestLogger implements TestWatcher {

    Log log = new Log();

    @Override
    public void testDisabled(ExtensionContext context, Optional<String> reason) {

    }

    @Override
    public void testSuccessful(ExtensionContext context) {

        String testName = context.getDisplayName();
        log.info("PASSED " + testName);
    }

    @Override
    public void testAborted(ExtensionContext context, Throwable cause) {

    }

    @Override
    public void testFailed(ExtensionContext context, Throwable cause) {

        String testName = context.getDisplayName();
        String testFailCause = cause.getMessage();
        log.error("FAILED " + testName + " CAUSE: " + testFailCause);
    }
}