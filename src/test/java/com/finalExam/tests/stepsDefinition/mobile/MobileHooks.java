package com.finalExam.tests.stepsDefinition.mobile;

import com.finalExam.configuration.mobile.DriverManagerMobile;
import com.finalExam.utils.capabilities.CapabilitiesConfig;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class MobileHooks {

    private static DriverManagerMobile driver;

    public static AndroidDriver<AndroidElement> getDriver() {
        return driver.getDriver();
    }

    @Before
    public void setUp() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        CapabilitiesConfig.deviceSetUp(capabilities);
        CapabilitiesConfig.applicationSetUp(capabilities);
        try {
            driver = new DriverManagerMobile(new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities));
        } catch (MalformedURLException exception) {
            exception.printStackTrace();
        }
    }

    @After
    public void close() {
        driver.getDriver().quit();
    }


}
