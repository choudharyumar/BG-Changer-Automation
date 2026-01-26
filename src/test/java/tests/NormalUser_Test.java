package tests;

import base.BaseTest;
import org.testng.annotations.Test;
import pages.SplashToHomeNormalFlow_Test;

public class NormalUser_Test extends BaseTest {

    @Test
    public void NormalUser_Test(){
        SplashToHomeNormalFlow_Test splashToHomeNormalFlowTest =
                new SplashToHomeNormalFlow_Test(driver);
        splashToHomeNormalFlowTest.appLaunchedSuccessfullyForSecondTime();
        splashToHomeNormalFlowTest.closeUpdateAppDialogIfVisible();
        splashToHomeNormalFlowTest.homeScreenDisplayed();

    }

}
