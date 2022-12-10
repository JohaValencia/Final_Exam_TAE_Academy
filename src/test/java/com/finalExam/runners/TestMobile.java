package com.finalExam.runners;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src//java/com/finalExam/tests/features",
        glue = {"com.finalExam.tests.stepDefinition.mobile"},
        tags = "@mobileAutomation"
)

public class TestMobile extends AbstractTestNGCucumberTests {
}
