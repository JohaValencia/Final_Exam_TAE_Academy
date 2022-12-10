package com.finalExam.pageObjects.screens;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class TutorialScreen extends BaseScreen {

    @AndroidFindBy(id = "permission_primary_btn")
    private AndroidElement startBtn;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceIdMatches(\".*permission_primary_btn\").text(\"Share Location\")")
    private AndroidElement locationBtn;

    @AndroidFindBy(id = "android:id/button1")
    private AndroidElement allowLocationBtn;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceIdMatches(\".*permission_allow_button\")")
    private AndroidElement allowButton;

    public TutorialScreen(AndroidDriver<AndroidElement> driver) {
        super(driver);
    }

    public void askForPermission() {
        super.click(this.startBtn);
    }

    public DashBoardScreen shareLocation() {
        super.click(this.locationBtn);
        super.click(this.allowLocationBtn);
        super.click(this.allowButton);
        return new DashBoardScreen(getDriver());
    }
}
