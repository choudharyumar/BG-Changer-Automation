package tests;

import base.BaseTest;
import flows.NormalUserFlow;
import org.testng.annotations.Test;
import pages.SplashToHomeNormalFlow_Test;

public class NormalUser_Test extends BaseTest {

    @Test
    public void NormalUserFlow(){
        NormalUserFlow flow = new NormalUserFlow(driver);
        flow.navigateToHome();
    }

}
