package com.finalExam.configuration.mobile;


import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;

import static org.openqa.selenium.support.PageFactory.initElements;

public abstract class MobilOperations {

    private final AndroidDriver<AndroidElement> driver;
    private final WebDriverWait wait;

    private final long waitTime = 12L;


    public MobilOperations(AndroidDriver<AndroidElement> driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, waitTime);
        initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(0)), this);
    }

    public AndroidDriver<AndroidElement> getDriver() {
        return this.driver;
    }

    public void swipeDown() {
        Dimension dimension = driver.manage().window().getSize();
        int height = dimension.getHeight();
        int width = dimension.getWidth();
        int x = width/2;
        int bottom = (int)(height*0.80);
        int top = (int)(height*0.20);
        TouchAction touchscreen = new TouchAction(driver);
        touchscreen.press(PointOption.point(x,bottom))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(200)))
                .moveTo(PointOption.point(x, top))
                .release()
                .perform();
    }

public void waitForVisibility(AndroidElement element) {
        this.wait.until(ExpectedConditions.visibilityOf(element));
}

public void waitForVisibility(AndroidElement element, WebDriverWait wait) {
        wait.until(ExpectedConditions.visibilityOf(element));
}

public void waitForVisibilityAll(List<AndroidElement> elements) {
        elements.stream().forEach(element -> {
            this.waitForVisibility(element);
        });
}

public void click(AndroidElement element) {
        this.waitForVisibility(element);
        element.click();
}

public boolean isElementAvailable(AndroidElement element) {
        try {
            this.waitForVisibility(element);
            return true;
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
}

public boolean isElementAvailable(AndroidElement element, long timeout) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        try {
            this.waitForVisibility(element, wait);
            return true;
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
}


}
