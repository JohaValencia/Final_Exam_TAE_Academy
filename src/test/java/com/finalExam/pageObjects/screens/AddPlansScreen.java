package com.finalExam.pageObjects.screens;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

import java.util.ArrayList;
import java.util.List;

public class AddPlansScreen extends BaseScreen {

    @AndroidFindBy(id = "actionSheetItemText")
    private List<AndroidElement> addPlansOptions;

    public AddPlansScreen(AndroidDriver<AndroidElement> driver) {
        super(driver);
    }

    public boolean checkDinningIsVisible() {
        List<Boolean> isCheckDiningIsVisible = new ArrayList<>();
        super.waitForVisibilityAll(this.addPlansOptions);
        this.addPlansOptions.stream().forEach(element -> {
            isCheckDiningIsVisible.add(element.getText().equals("Check Dining Availability"));
        });
        return isCheckDiningIsVisible.contains(true);
    }
}
