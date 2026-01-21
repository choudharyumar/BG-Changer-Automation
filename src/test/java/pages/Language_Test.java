package pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;


public class Language_Test {
    private AndroidDriver driver;
    private WebDriverWait wait;


    public Language_Test(AndroidDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void verifyAppLaunchSuccessfully() {
        System.out.println("App launched Successfully");
    }


    public void verifyLanguageScreenTitle() {
        try {
            By LanguageTittle = AppiumBy.id("com.mga.bg.changer.ai.background.remover:id/tvTitle");

            WebElement title = wait.until(
                    ExpectedConditions.visibilityOfElementLocated(LanguageTittle)
            );
            Assert.assertTrue(title.isDisplayed(), "Tittle not displayed");
            System.out.println("langauge screen show with tittle");

        } catch (Exception e) {
            Assert.fail("Language screen not show" + e.getMessage());
        }


    }

    public void verifyScrollBottomAndTop() {

        try {

            // Scroll to END (Bottom)
            String scrollToEnd =
                    "new UiScrollable(new UiSelector().scrollable(true))" +
                            ".setAsVerticalList()" +
                            ".scrollToEnd(10)";

            driver.findElement(AppiumBy.androidUIAutomator(scrollToEnd));
            System.out.println("✅ Scrolled to bottom");

            // Scroll to BEGINNING (Top)
            String scrollToBeginning =
                    "new UiScrollable(new UiSelector().scrollable(true))" +
                            ".setAsVerticalList()" +
                            ".scrollToBeginning(10)";

            driver.findElement(AppiumBy.androidUIAutomator(scrollToBeginning));
            System.out.println("✅ Scrolled back to top");

        } catch (Exception e) {
            Assert.fail("❌ Scroll bottom/top failed: " + e.getMessage());
        }
    }


    public void clickEnglishLanguage() {

        try {
            String pkg = "com.mga.bg.changer.ai.background.remover";
            String rvId = pkg + ":id/recyclerView";     // RecyclerView (scroll container)
            String nameId = pkg + ":id/tvLanguageName";   // TextView with language name
            String cardId = pkg + ":id/cvLanguage";       // Clickable CardView
            String target = "English";

            // 1) Scroll inside RecyclerView until "English" text is visible
            driver.findElement(AppiumBy.androidUIAutomator(
                    "new UiScrollable(new UiSelector().resourceId(\"" + rvId + "\"))"
                            + ".setAsVerticalList().setMaxSearchSwipes(40)"
                            + ".scrollIntoView(new UiSelector().resourceId(\"" + nameId + "\").text(\"" + target + "\"))"
            ));

            // 2) Click the clickable CardView that contains that text
            By englishCardBy = AppiumBy.xpath(
                    "//*[@resource-id='" + nameId + "' and @text='" + target + "']/ancestor::*[@resource-id='" + cardId + "']"
            );
            WebElement englishCard = driver.findElement(englishCardBy);

            englishCard.click(); // Simple and reliable

            // Optional: log/output
            System.out.println("Clicked on language: " + target);
        } catch (Exception e) {
            Assert.fail("Language item click test case failed: " + e.getMessage());
        }

    }


    public void clickOnNextButton() {

        try {

            WebElement nextBtn = wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.mga.bg.changer.ai.background.remover:id/btnNext")));
            Assert.assertTrue(nextBtn.isDisplayed(), "Next button not displayed");
            nextBtn.click();
            System.out.println("Click on next button is done");

        } catch (Exception e) {
            Assert.fail("next button not found" + e.getMessage());
        }
    }


}
