package pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class SplashToHomeNormalFlow_Test {

    private AndroidDriver driver;
    private WebDriverWait wait;

    public SplashToHomeNormalFlow_Test(AndroidDriver driver1) {
        this.driver = driver1;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void appLaunchedSuccessfullyForSecondTime() {
        System.out.println("App launches successfully for 2nd time");
    }

    public void closeUpdateAppDialogIfVisible() {
        try {
            WebElement elements =
                    wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.mga" +
                            ".bg.changer.ai.background.remover:id/title")));
            driver.findElement(AppiumBy.id("com.mga.bg.changer.ai.background" +
                    ".remover:id/permission_exit")).click();


        } catch (Exception e) {

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
