package utils;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WaitUtils {

    AndroidDriver driver;
    WebDriverWait wait;

    public WaitUtils(AndroidDriver driver1) {
        this.driver = driver1;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    }

    public void waitAndClick(By locator) {
        wait.until(ExpectedConditions.elementToBeClickable(locator)).click();

    }

    public boolean waitUntilVisible(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).isDisplayed();
    }


}
