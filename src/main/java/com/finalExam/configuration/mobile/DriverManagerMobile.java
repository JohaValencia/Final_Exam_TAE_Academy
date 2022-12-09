package com.finalExam.configuration.mobile;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class DriverManagerMobile {

    private final AndroidDriver<AndroidElement> driver;

    public DriverManagerMobile(AndroidDriver<AndroidElement> driver) {
        this.driver = driver;
    }

    public AndroidDriver<AndroidElement> getDriver() {
        return this.driver;
    }
}
