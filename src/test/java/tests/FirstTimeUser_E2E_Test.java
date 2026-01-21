package tests;

import base.BaseTest;
import pages.Language_Test;
import pages.Onboarding_Test;
import org.testng.annotations.Test;

public class FirstTimeUser_E2E_Test extends BaseTest {
    @Test
    public void completeFirstTimeUserFlow(){
        Language_Test languageTest = new Language_Test(driver);
        // Splash
        languageTest.verifyAppLaunchSuccessfully();
        // Language Screen
        languageTest.verifyLanguageScreenTitle();
        languageTest.verifyScrollBottomAndTop();
        languageTest.clickEnglishLanguage();
        languageTest.clickOnNextButton();

        // Onboarding screens

        Onboarding_Test onboardingTest = new Onboarding_Test(driver);
        onboardingTest.onboarding1NextBtn();
        onboardingTest.onboarding2NextBtn();
        onboardingTest.onboarding3NextBtn();



    }

}
