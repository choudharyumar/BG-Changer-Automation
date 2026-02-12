package tests.modules;

import base.BaseTest;
import flows.NormalUserFlow;
import org.testng.annotations.Test;
import pages.BgChangerCropperScreen;
import pages.BgChangerGalleryScreen;
import pages.HomeScreen;

public class BgChangerModule extends BaseTest {

    @Test
    public void openBgChanger(){
        NormalUserFlow normalUserFlow = new NormalUserFlow(driver);
        normalUserFlow.navigateToHome();

        HomeScreen homeScreen = new HomeScreen(driver);
        homeScreen.openBgChanger();

        // Gallery screen

        BgChangerGalleryScreen  bgChangerGalleryScreen = new BgChangerGalleryScreen(driver);
        bgChangerGalleryScreen.handleGalleryPermission();
        bgChangerGalleryScreen.clickImageInGallery();

        //Cropper screen

        BgChangerCropperScreen bgChangerCropperScreen = new BgChangerCropperScreen(driver);
        bgChangerCropperScreen.cropperScreenVisibility();

    }
}
