package com.finalExam.configuration.web;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.support.PageFactory.initElements;

public class MobileOperations {

    private final WebDriver driver;
    private final WebDriverWait wait;

    private final long waitDuration = 15L;

    public MobileOperations(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, waitDuration);
        initElements(driver, this);
    }
    protected WebDriver getDriver() {
        return driver;
    }
    public void clickElement(WebElement element) {
        waitForClickable(element);
        element.click();
    }

    public void typeOnInput(WebElement element, String text) {
        this.waitForVisibility(element);
        element.sendKeys(text);
    }

    public void waitForVisibility(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    private void waitForClickable(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void waitForInvisibility(WebElement element) {
        wait.until(ExpectedConditions.invisibilityOf(element));
    }
}
