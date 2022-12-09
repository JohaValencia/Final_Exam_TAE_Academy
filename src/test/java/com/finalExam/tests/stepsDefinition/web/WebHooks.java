package com.finalExam.tests.stepsDefinition.web;

import com.finalExam.configuration.mobile.DriverManagerMobile;
import com.finalExam.configuration.web.DriverManagerWeb;
import com.finalExam.utils.data.WebData;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;

public class WebHooks {
   private static DriverManagerWeb driver;

   @Before
    public void setUp() {
       driver = new DriverManagerWeb();
       driver.getDriver().get(WebData.returnData("url"));
       driver.getDriver().manage().window().maximize();
   }

   @After
    public void close() {
       driver.getDriver().quit();
   }

   public static WebDriver getDriver() {
       return driver.getDriver();
   }
}
