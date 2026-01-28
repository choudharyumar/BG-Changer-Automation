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

    public BgChangerGalleryScreen(AndroidDriver driver1) {
        this.driver = driver1;
        this.wait = new WaitUtils(driver);
    }

    public boolean isGrantPermissionButtonVisible(){
        try {
            return wait.waitUntilVisible(permissionButton);
        }catch (Exception e){
            return false;
        }
    }

    public void tapPermissionButton(){
        try {
            wait.waitAndClick(permissionButton);
        }catch (Exception e){
            Assert.fail("Grant permission button not visible"+e.getMessage());
        }

    }

    public void handleGalleryPermission(){
        try {
            if (isGrantPermissionButtonVisible()){
                System.out.println("permission not granted");
                tapPermissionButton();
            }
        }catch (Exception e){
            System.out.println("permission is already granted");

        }
    }

}
