package tests.modules;

import base.BaseTest;
import flows.NormalUserFlow;
import org.testng.annotations.Test;
import pages.HomeScreen;

public class BgChangerModule extends BaseTest {

    @Test
    public void openBgChanger(){
        NormalUserFlow normalUserFlow = new NormalUserFlow(driver);
        normalUserFlow.navigateToHome();

        HomeScreen homeScreen = new HomeScreen(driver);
        homeScreen.openBgChanger();

    }
}
