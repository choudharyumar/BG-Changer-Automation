package base;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.net.URL;
import java.time.Duration;

public class BaseTest {
    public AndroidDriver driver;
    Dimension dim;

    @BeforeClass
    public void launchApp() throws Exception {

        DesiredCapabilities caps = new DesiredCapabilities();

        caps.setCapability("platformName", "Android");
        caps.setCapability("automationName", "UiAutomator2");
        caps.setCapability("deviceName", "23091JEGR02444");

        caps.setCapability("appPackage", "com.mga.bg.changer.ai.background.remover");
        caps.setCapability("appActivity", "com.jehanzeb.bgchanger.ui.SplashScreen");

        caps.setCapability("noReset", true);



        driver = new AndroidDriver(
                new URL("http://127.0.0.1:4723/wd/hub"),
                caps
        );
       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        dim = driver.manage().window().getSize();


    }

}
