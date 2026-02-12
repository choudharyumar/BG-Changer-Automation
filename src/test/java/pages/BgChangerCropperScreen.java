package pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import utils.WaitUtils;

public class BgChangerCropperScreen {

    AndroidDriver androidDriver;
    WaitUtils wait;

    public BgChangerCropperScreen(AndroidDriver androidDriver1){
        this.androidDriver = androidDriver1;
        this.wait = new WaitUtils(androidDriver1);

    }

    private By cropperText = By.id("com.mga.bg.changer.ai.background.remover:id/itemText");
    private By squareAspectRatioButton = AppiumBy.androidUIAutomator("new UiSelector().resourceId" +
            "(\"com.mga.bg.changer.ai.background.remover:id/itemAspect\").instance(1)");
    private By tickButton = By.id("com.mga.bg.changer.ai.background.remover:id/doneItem");


    public boolean isCropperScreenVisible(){
        try {
            System.out.println(wait.waitUntilVisible(cropperText));
            return wait.waitUntilVisible(cropperText);
        }catch (Exception e){
            Assert.fail("Cropper screen not visible"+e.getMessage());
            return false;
        }
    }

    public void cropperScreenVisibility(){
        if (isCropperScreenVisible()){
            System.out.println("Bg changer cropper screen visible");
            clickSquareAspectRatioButton();
            clickTickButton();

        }else{
            System.out.println("Bg changer cropper screen not visible check issue");
        }

    }

    public void clickSquareAspectRatioButton(){
        try{
           wait.waitAndClick(squareAspectRatioButton);
            System.out.println("click performed on square aspect ratio button");
        }catch (Exception e){
            Assert.fail("click not performed on square aspect ratio button"+e.getMessage());

        }
    }

    public void clickTickButton(){
        try {
            wait.waitAndClick(tickButton);
            System.out.println("click performed on cropper screen tick button ");
        }catch (Exception e){
            Assert.fail("Issue in click of tick button in cropper screen "+e.getMessage());

        }
    }


}
