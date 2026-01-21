package pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import java.time.Duration;

public class Onboarding_Test {

    private final AndroidDriver driver;
    private final WebDriverWait wait;

    public Onboarding_Test(AndroidDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    private void swipe(WebElement element, String direction, int durationMillis) {
        int width = element.getSize().getWidth();
        int height = element.getSize().getHeight();
        int y = element.getLocation().getY() + (height / 2);

        int startX, endX;
        if (direction.equalsIgnoreCase("left")) {
            startX = (int) (width * 0.8);
            endX = (int) (width * 0.2);
        } else if (direction.equalsIgnoreCase("right")) {
            startX = (int) (width * 0.2);
            endX = (int) (width * 0.8);
        } else {
            throw new IllegalArgumentException("Direction must be 'left' or 'right'");
        }

        new TouchAction<>(driver)
                .press(PointOption.point(startX, y))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(durationMillis)))
                .moveTo(PointOption.point(endX, y))
                .release()
                .perform();

        System.out.printf("↔ Swiped %s%n", direction);
    }

    public void completeSwipeFlow() {
        WebElement viewPager = wait.until(
                ExpectedConditions.presenceOfElementLocated(
                        AppiumBy.id("com.mga.bg.changer.ai.background.remover:id/viewPager")));

        swipe(viewPager, "left", 500);
        swipe(viewPager, "left", 500);
        swipe(viewPager, "right", 500);
        swipe(viewPager, "right", 500);

        System.out.println("🎉 Swipe flow (1→3→1) completed successfully");
    }

    public void onboarding1NextBtn() {
        clickNext("Onboarding 1");
    }

    public void onboarding2NextBtn() {
        clickNext("Onboarding 2");
    }

    public void onboarding3NextBtn() {
        clickNext("Onboarding 3");
    }

    private void clickNext(String screen) {
        try {
            WebElement nextBtn = wait.until(ExpectedConditions.elementToBeClickable(
                    AppiumBy.id("com.mga.bg.changer.ai.background.remover:id/cvNext")));
            Assert.assertTrue(nextBtn.isDisplayed(), "Next button not displayed on " + screen);
            nextBtn.click();
            System.out.printf("✅ Next button clicked on %s screen%n", screen);
        } catch (Exception e) {
            Assert.fail("❌ Next button click failed on " + screen + ": " + e.getMessage());
        }
    }
}