package pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class Onboarding_Test {
    private AndroidDriver driver;
    private WebDriverWait wait;

    public Onboarding_Test(AndroidDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }


    public void onboarding1NextBtn() {
        try {
            WebElement nextBtn = wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.mga.bg.changer.ai.background.remover:id/cvNext")));
            Assert.assertTrue(nextBtn.isDisplayed(), "next btn on onboarding 1 not displayed");
            nextBtn.click();
            System.out.println("Next btn clicked on onboarding 1 screen");


        } catch (Exception e) {
            Assert.fail("Next btn not clicked" + e.getMessage());

        }
    }

    public void onboarding2NextBtn() {
        try {
            WebElement nextBtn = wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.mga.bg.changer.ai.background.remover:id/cvNext")));
            Assert.assertTrue(nextBtn.isDisplayed(), "Next button not displayed");
            nextBtn.click();
            System.out.println("Next btn of onboarding 2 clicked");

        } catch (Exception e) {
            Assert.fail("Next btn not clicked" + e.getMessage());

        }
    }

    public void onboarding3NextBtn() {
        try {
            WebElement nextBtn = wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.mga.bg.changer.ai.background.remover:id/cvNext")));
            Assert.assertTrue(nextBtn.isDisplayed(), "Next button not displayed");
            nextBtn.click();
            System.out.println("Next btn of onboarding 3 clicked");

        } catch (Exception e) {
            Assert.fail("Next btn not clicked" + e.getMessage());

        }
    }


}
