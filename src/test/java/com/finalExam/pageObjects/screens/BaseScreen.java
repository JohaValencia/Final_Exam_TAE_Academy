package com.finalExam.pageObjects.screens;

import com.finalExam.configuration.mobile.MobilOperations;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class BaseScreen extends MobilOperations {

    public BaseScreen(AndroidDriver<AndroidElement> driver) {
        super(driver);
    }
}
