package com.finalExam.tests.stepsDefinition.mobile;

import com.finalExam.pageObjects.screens.*;
import com.finalExam.reporting.Reporter;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class StepsDefinitionsMobile {

    private AddPlansScreen addPlansScreen;
    private DashBoardScreen dashBoardScreen;
    private MenuScreen menuScreen;
    private PrivacyAndLegalScreen privacyAndLegalScreen;
    private TutorialScreen tutorialScreen;

    @Given("You are in the dashboard screen")
    public void dashboardScreen() {
        tutorialScreen = new TutorialScreen(MobileHooks.getDriver());
        tutorialScreen.askForPermission();
        dashBoardScreen = tutorialScreen.shareLocation();
    }

  @Then("Items to menu view are visible")
    public void itemsToMenuViewAreVisible() {
        Reporter.info("Checking menu view items");
        Reporter.info("Banner is visible");
        Assert.assertTrue(menuScreen.bannerIsVisible(),"Banner is not visible");
        menuScreen.swipeToScreensEnd();
        Reporter.info("Menu options are visible correctly");
        Assert.assertTrue(menuScreen.checkMenu(), "Menú options are not visible correctly");
  }

  @When("You can select all add plans options")
    public void selectAllAddPlansOptions() {
      Reporter.info("Get into add plans view");
      addPlansScreen = dashBoardScreen.addPlansScreen();
  }

  @Then("The check dining option is visible")
    public void checkDiningIsVisible() {
      Reporter.info("check dining available option is visible");
      Assert.assertTrue(addPlansScreen.checkDinningIsVisible(), "check dining available option is not visible");
  }
}
