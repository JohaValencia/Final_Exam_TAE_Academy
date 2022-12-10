package com.finalExam.pageObjects.screens;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MenuScreen extends BaseScreen {

    @AndroidFindBy(id = "avatarImage")
    private AndroidElement menuBanner;

    @AndroidFindBy (id = "content")
    private List<AndroidElement> menuOptions;

    @AndroidFindBy (uiAutomator = "new UiSelector().resourceIdMatches(\".*content\").text(\"Privacy & Legal\")")
    private AndroidElement privacyAndLegalOption;

    public MenuScreen(AndroidDriver<AndroidElement> driver) {
        super(driver);
    }

    public boolean bannerIsVisible() {
        return super.isElementAvailable(this.menuBanner);
    }

    public boolean privacyAndLegacyOptionIsVisible() {
        return super.isElementAvailable(this.privacyAndLegalOption, 5);
    }

    public void swipeToScreensEnd() {
        int swipes = 0;
        int maxSwipe = 5;
        while (!this.privacyAndLegacyOptionIsVisible() && swipes < maxSwipe) {
            swipeDown();
            swipes++;
        }
    }

    public PrivacyAndLegalScreen clickOnPrivacyAndLegacy() {
        super.click(this.privacyAndLegalOption);
        return new PrivacyAndLegalScreen(getDriver());
    }

    public boolean checkMenu() {
        List<String> options = new ArrayList<>();
        List<Boolean> correct = new ArrayList<>();
        Collections.addAll(options,
                "My Profile",
                "Property Rules",
                "Cast Compliment",
                "Link to Account",
                "Car Locator",
                "Help",
                "Privacy & Legal"
        );
        super.waitForVisibilityAll(this.menuOptions);
        for (int i = 0; i < this.menuOptions.size(); i++) {
            correct.add(this.menuOptions.get(i).getText().equals(options.get(i)));
        }
        return !correct.contains(false);
    }
}
