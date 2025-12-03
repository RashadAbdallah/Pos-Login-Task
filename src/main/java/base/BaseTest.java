package base;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class BaseTest {
    protected AndroidDriver driver;

    @BeforeMethod
    public void setUp() throws MalformedURLException {
        UiAutomator2Options options = new UiAutomator2Options();

        // Pos Properties
        options.setPlatformName("Android");
        options.setAutomationName("UiAutomator2");

        options.setDeviceName("0123456789ABCDEF");
        options.setUdid("0123456789ABCDEF");

        options.setAppPackage("newland.raya.aman");
        options.setAppActivity("com.raya.aman.auth.ui.AuthPosActivity");


        options.setNoReset(false);
        options.setFullReset(false);

        // Connect to appium server
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/"), options);


        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    // Close appium after test
    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
