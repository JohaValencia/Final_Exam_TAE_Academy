package com.finalExam.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

    @CucumberOptions (
            features = "src/test/java/com/finalExam/tests/features",
            glue = {"com.finalExam.tests.stepsDefinition.web"},
            tags = "@webAutomation")

    public class TestWeb extends AbstractTestNGCucumberTests {

    }

