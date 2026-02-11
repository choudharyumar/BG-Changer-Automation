package pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import utils.WaitUtils;

public class BgChangerGalleryScreen {

    AndroidDriver driver;
    WaitUtils wait;
    private By permissionButton = By.id("com.mga.bg.changer.ai.background" +
            ".remover:id/btnGrant");


    private By allTabButton = AppiumBy.androidUIAutomator(
            "new UiSelector().resourceId(\"com.mga.bg.changer.ai.background.remover:id/tabText\").text(\"All\")"
    );

    private By firstGalleryImage = By.xpath("//android.widget.GridView[@resource-id=\"com.mga.bg" +
            ".changer.ai.background.remover:id/imagesRV\"]/androidx.cardview.widget.CardView[1]\n");
    private By firstGalleryDemoImage = By.xpath("//android.widget.GridView[@resource-id=\"com.mga" +
            ".bg.changer.ai.background.remover:id/rvSample\"]/androidx.cardview.widget" +
            ".CardView[1]\n");


    public BgChangerGalleryScreen(AndroidDriver driver1) {
        this.driver = driver1;
        this.wait = new WaitUtils(driver);
    }

    public boolean isGrantPermissionButtonVisible() {
        try {
            return wait.waitUntilVisible(permissionButton);
        } catch (Exception e) {
            return false;
        }
    }

    public void tapPermissionButton() {
        try {
            wait.waitAndClick(permissionButton);
            tapPermissionSystemAllowButton();
        } catch (Exception e) {
            Assert.fail("Grant permission button not visible" + e.getMessage());
        }

    }

    public void tapPermissionSystemAllowButton() {
        try {
            wait.waitAndClick(AppiumBy.id("com.android.permissioncontroller:id/permission_allow_button"));
        } catch (Exception e) {
            Assert.fail("Grant system permission button not visible" + e.getMessage());

        }
    }

    public void handleGalleryPermission() {
        try {
            if (isGrantPermissionButtonVisible()) {
                System.out.println("permission granted");
                tapPermissionButton();
            } else {
                System.out.println("permission is already granted");
            }
        } catch (Exception e) {
            System.out.println("permission is already granted");

        }
    }

    public boolean tabsVisible() {
        try {
            return wait.waitUntilVisible(allTabButton);
        } catch (Exception e) {
            System.out.println("Tab not visible in gallery screen" + e.getMessage());
            return false;
        }

    }

    public void clickImageInGallery() {
        try {
            if (tabsVisible()) {
                clickFirstGalleryImage();
            } else {
                clickFirstDemoImage();
            }
        } catch (Exception e) {
            Assert.fail("NO gallery image show " + e.getMessage());
        }
    }

    private void clickFirstDemoImage() {
        try {
            wait.waitAndClick(firstGalleryDemoImage);
            System.out.println("click first demo image in gallery screen");
        } catch (Exception e) {
            System.out.println("Issue in gallery demo image " + e.getMessage());
        }
    }

    private void clickFirstGalleryImage() {
        try {
            wait.waitAndClick(firstGalleryImage);
            System.out.println("click first image in gallery screen");
        } catch (Exception e) {
            System.out.println("Issue in gallery image " + e.getMessage());
        }
    }


}
