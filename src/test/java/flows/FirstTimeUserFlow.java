package flows;

import io.appium.java_client.android.AndroidDriver;
import pages.Home_Test;
import pages.Language_Test;
import pages.Onboarding_Test;

public class FirstTimeUserFlow {

    AndroidDriver driver;

    public FirstTimeUserFlow(AndroidDriver driver) {
        this.driver = driver;
    }

    public void completeFirstTimeUserJourney() {

        Language_Test language = new Language_Test(driver);
        language.verifyAppLaunchSuccessfully();
        language.verifyLanguageScreenTitle();
        language.verifyScrollBottomAndTop();
        language.clickEnglishLanguage();
        language.clickOnNextButton();

        Onboarding_Test onboarding = new Onboarding_Test(driver);
        onboarding.completeSwipeFlow();
        onboarding.onboarding1NextBtn();
        onboarding.onboarding2NextBtn();
        onboarding.onboarding3NextBtn();

        Home_Test home = new Home_Test(driver);
        home.closeUpdateAppDialogIfVisible();
        home.clickAllowOnNotificationPermissionDialog();
        home.clickAllowOnSystemNotificationPermissionDialog();
        home.homeScreenDisplayed();
    }
}
