package pages;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import utils.WaitUtils;

public class HomeScreen {
    AndroidDriver driver;
    WaitUtils wait;

    public HomeScreen(AndroidDriver driver1) {
        this.driver = driver1;
        this.wait = new WaitUtils(driver);
    }

    private By bgChanger = By.id("com.mga.bg.changer.ai.background.remover:id/materialCardView2");

    public void openBgChanger(){
        wait.waitAndClick(bgChanger);
    }


}
