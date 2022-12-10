package com.finalExam.configuration.web;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.support.PageFactory.initElements;

public class WebOperations {

    private final WebDriver driver;
    private final WebDriverWait wait;

    private final long timeToWait = 12L;

    public WebOperations(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, timeToWait);
        initElements(driver, this);
    }

    public WebOperations(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void clickElement (WebElement element) {
        this.waitForVisibility(element);
        this.waitForClickable(element);
        element.click();
    }


    public void waitForClickable(WebElement element) {
        this.wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void waitForPresenceOfElement(String locator) {
        this.wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector(locator)));
    }

    public void waitForPresenceOfElements(String locator) {
        this.wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(locator)));
    }

    public void waitForPresenceOfElement(String locator, long timeout) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(locator)));
    }

    public void waitForChangeAttribute(WebElement element, String attribute, String value) {
        this.wait.until(ExpectedConditions.attributeToBe(element,attribute,value));
    }

    public void waitForVisibility(WebElement element) {
        this.wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void typeOnInput(WebElement element, String text) {
        this.waitForVisibility(element);
        element.sendKeys(text);
    }

}
