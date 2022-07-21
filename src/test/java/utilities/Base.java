package utilities;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;

/**
 * @author alpinaro (Alper Çınaroğlu)
 * https://github.com/alpinaro
 */
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@ExtendWith(TestLogger.class)
public abstract class Base {

    @BeforeAll
    protected void setUp() {

        Driver.getDriver().get(ConfigReader.getProperty("BeymenURL"));
    }

    @AfterAll
    protected void tearDown() {

        Driver.closeDriver();
    }
}