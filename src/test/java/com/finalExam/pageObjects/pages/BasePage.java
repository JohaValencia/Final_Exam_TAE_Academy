package com.finalExam.pageObjects.pages;

import com.finalExam.configuration.mobile.MobilOperations;
import com.finalExam.configuration.web.WebOperations;
import org.openqa.selenium.WebDriver;

public abstract class BasePage extends WebOperations {

    public BasePage(WebDriver driver) {
        super(driver);
    }
}
