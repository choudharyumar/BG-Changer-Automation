package pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class Home_Test {

    private AndroidDriver driver;
    private WebDriverWait wait;

    public Home_Test(AndroidDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }


    public void clickAllowOnNotificationPermissionDialog() {
        try {
            WebElement clickAllow = wait.until(ExpectedConditions.elementToBeClickable
                    (AppiumBy.id("com.mga.bg.changer.ai.background.remover:id/cvAllow")));
            Assert.assertTrue(clickAllow.isDisplayed(), "click allow not displayed");
            clickAllow.click();
            System.out.println("click on allow done");

        } catch (Exception e) {
            Assert.fail("click on allow btn not done" + e.getMessage());

        }
    }

    public void clickAllowOnSystemNotificationPermissionDialog() {
        try {
            WebElement clickAllow = wait.until(ExpectedConditions.elementToBeClickable
                    (AppiumBy.id("com.android.permissioncontroller:id/permission_allow_button")));
            Assert.assertTrue(clickAllow.isDisplayed()
                    , "Allow button is not displayed on system notification permission dialog");
            clickAllow.click();
            System.out.println("Clicked Allow button on system notification permission dialog");

        } catch (Exception e) {
            Assert.fail("Failed to click Allow button on system notification permission dialog:" +
                    "" + e.getMessage());

        }
    }


    public void homeScreenDisplayed() {
        try {
            WebElement backgroundText =
                    wait.until(ExpectedConditions.visibilityOfElementLocated
                            (AppiumBy.id("com.mga.bg.changer.ai.background.remover:id/tvBackground")));
            Assert.assertTrue(backgroundText.isDisplayed(), "background home text not displayed");
            System.out.println("Home screen show");
        } catch (Exception e) {
            Assert.fail("Home screen not show" + e.getMessage());
        }
    }

}
