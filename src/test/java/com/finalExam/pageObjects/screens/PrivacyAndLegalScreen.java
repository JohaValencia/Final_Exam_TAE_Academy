package com.finalExam.pageObjects.screens;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PrivacyAndLegalScreen extends BaseScreen {

    @AndroidFindBy(id = "txt_element")
    private List<AndroidElement> pylOptions;

    public PrivacyAndLegalScreen(AndroidDriver<AndroidElement> driver) {
        super(driver);
    }

    public boolean checkPYLOptions() {
        List<String> options = new ArrayList<>();
        List<Boolean> correct = new ArrayList<>();
        Collections.addAll(options,
                "Privacy Policy",
                "Terms of Use",
                "Supplemental Terms and Conditions",
                "Legal Notices",
                "Property Rules",
                "Electronic Communications Disclosure",
                "Your California Privacy Rights",
                "Do Not Sell My Personal Information",
                "In-App Maps Subject to Google Terms and Conditions",
                "In-App Maps Subject to Google Privacy Policy"
        );
        super.waitForVisibilityAll(this.pylOptions);
        for (int i = 0; i < this.pylOptions.size(); i++) {
            correct.add(this.pylOptions.get(i).getText().equals(options.get(i)));
        }
        return !correct.contains(false);
    }
}
