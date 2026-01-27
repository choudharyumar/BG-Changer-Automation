package flows;

import io.appium.java_client.android.AndroidDriver;
import pages.SplashToHomeNormalFlow_Test;

public class NormalUserFlow {


    AndroidDriver driver;

    public NormalUserFlow(AndroidDriver driver) {
        this.driver = driver;
    }

    public void navigateToHome() {
        SplashToHomeNormalFlow_Test splash =
                new SplashToHomeNormalFlow_Test(driver);

        splash.appLaunchedSuccessfullyForSecondTime();
        splash.closeUpdateAppDialogIfVisible();
        splash.homeScreenDisplayed();
    }
}