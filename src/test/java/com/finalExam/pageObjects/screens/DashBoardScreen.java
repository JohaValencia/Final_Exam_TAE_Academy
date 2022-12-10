package com.finalExam.pageObjects.screens;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DashBoardScreen extends BaseScreen {

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"dismiss-icon\")")
    private AndroidElement closeWelcome;

    @AndroidFindBy(id = "android:id/button2")
    private AndroidElement preferencesBtn;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceIdMatches(\".*tab_icon\").description(\"Map, Tab, 2of5\")")
    private AndroidElement mapBtn;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceIdMatches(\".*tab_icon\").description(\"More Options, Tab, 5of5\")")
    private AndroidElement menuBtn;

    @AndroidFindBy(id = "tab_animated_icon")
    private AndroidElement addPlansBtn;

    @AndroidFindBy(id = "categoryTitle")
    private AndroidElement categoryListBtn;

    @AndroidFindBy(id = "filterTitle")
    private AndroidElement filterBtn;

    @AndroidFindBy(id = "toggleTitle")
    private AndroidElement showListBtn;

    @AndroidFindBy (id = "categorySelectHeader")
    private AndroidElement categoryTitle;

    @AndroidFindBy (id = "facilityTypeTitle")
    private List<AndroidElement> categoryList;

    public void navigateOptions(AndroidElement options) {
        if (super.isElementAvailable(this.closeWelcome, 20)) {
            click(this.closeWelcome);
        }
        if (super.isElementAvailable(this.preferencesBtn, 20)) {
        }
        click(options);
    }


    public DashBoardScreen(AndroidDriver<AndroidElement> driver) {
        super(driver);
    }

    public AddPlansScreen addPlansScreen() {
        this.navigateOptions(this.addPlansBtn);
        return new AddPlansScreen(getDriver());
    }

}
