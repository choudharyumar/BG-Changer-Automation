package tests;

import base.BaseTest;
import flows.FirstTimeUserFlow;
import pages.Home_Test;
import pages.Language_Test;
import pages.Onboarding_Test;
import org.testng.annotations.Test;

public class FirstTimeUser_E2E_Test extends BaseTest {
    @Test
    public void completeFirstTimeUserFlow() {
        FirstTimeUserFlow firstTimeUserFlow = new FirstTimeUserFlow(driver);
        firstTimeUserFlow.completeFirstTimeUserJourney();

    }

}
