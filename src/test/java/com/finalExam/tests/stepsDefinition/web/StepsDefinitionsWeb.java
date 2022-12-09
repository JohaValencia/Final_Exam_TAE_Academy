package com.finalExam.tests.stepsDefinition.web;

import com.finalExam.pageObjects.pages.HomePage;
import com.finalExam.pageObjects.pages.WatchPage;
import com.finalExam.reporting.Reporter;
import com.finalExam.utils.data.WebData;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class StepsDefinitionsWeb {

    private HomePage homePage;
    private WatchPage watchPage;
    private static String email;

    @Given("You are in the espn website home page")
    public void espnHomePage() {
        homePage = new HomePage(WebHooks.getDriver());
        homePage.closeBanner();
    }

    @Given("You are in the log in modal")
    public void logInModal() {
        homePage.clickUserIcon();
        homePage.clickOnLogInHome();
        homePage.leaveToIframe();
    }

    @Then("The log in items are visible correctly")
    public void logInItemsAreVisible() {
        Reporter.info("Checking items in the log in modal");
        Reporter.info("Checking if log in modal is visible");
        Assert.assertTrue(homePage.modalIsVisible(), "Log in modal is not visible");
        Reporter.info("Checking if the ESPN logo is visible");
        Assert.assertTrue(homePage.espnLogoIsVisible(), "ESPN logo is not visible");
        Reporter.info("Checking if the log in button is visible");
        Assert.assertTrue(homePage.logInBtnIsVisible(), "Log in button is not visible");
        Reporter.info("Checking if the sign up button is visible");
        Assert.assertTrue(homePage.signUpBtnIsVisible(), "Sig up button is visible");
    }

    @When("You can click on the sign up button")
    public void clickOnSignUp() {
        homePage.clickOnSignUpBtn();
    }

    @Then("Items for the sign up are visible")
    public void itemsForSignUPAreVisible() {
        Reporter.info("Checking sign up modal items");
        Reporter.info("Checking if the sign up title is visible");
        Assert.assertTrue(homePage.signUpTitleIsVisible(), "Sign up title is not visible");
        Reporter.info("Checking if the first name input is visible");
        Assert.assertTrue(homePage.firstNameIsVisible(), "First name input is not visible");
        Reporter.info("Checking if the last name input is visible");
        Assert.assertTrue(homePage.lastNameIsVisible(), "Last name input is not visible");
        Reporter.info("Checking if the email input is visible");
        Assert.assertTrue(homePage.emailInputIsVisible(), "Email input is not visible");
        Reporter.info("Checking if the password input is visible");
        Assert.assertTrue(homePage.passwordInputIsVisible(), "Password input is not visible");
        Reporter.info("Checking if the sign up button is visible");
        Assert.assertTrue(homePage.signUpButtonIsVisible(), "Sign up button is not visible");
        Reporter.info("Checking if the close button is visible");
        Assert.assertTrue(homePage.closeIframeBtnIsVisible(), "Close button is not visible");
    }

    @And("Typing personal information to sign up")
    public void typePersonalInformationToSignUp() {
        email = homePage.createEmail();
        homePage.typeOnFirstName(WebData.returnData("user"));
        homePage.typeOnLastName(WebData.returnData("user"));
        homePage.typeOnEmailToSignUp(email);
        homePage.typeOnPassword(WebData.returnData("password"));
        homePage.clickOnSignUpBtn();
        homePage.leaveIframe();

    }

    @Then("You should be logged in")
    public void shouldBeLoggedIn() {
        homePage.waitForLogIn();
        homePage.clickUserIcon();
        Reporter.info("Checking the account was create correctly");
        Assert.assertEquals(homePage.getWelcomeText(), WebData.returnData("welcomeText"), "Account was not created correctly");
        homePage.clickOnLOgOutHome();
        homePage.waitForLogOut();

    }

    @Given("You are logged correctly")
    public void logged() {
        homePage.loginSteps(WebData.returnData("emailToLogging"), WebData.returnData("password"));
    }

    @When("You move to watch page")
    public void moveToWatchPage() {
        watchPage = homePage.watchPage();
    }

    @Then("Items to watch page are visible correctly")
    public void itemsToWatchPageAreVisible() {
        Reporter.info("Checking watch page items");
        Reporter.info("Checking cards in the second carrousel");
        Assert.assertTrue(watchPage.titleCards(), "Cards in the second carrousel don´t have title");
        Reporter.info("Checking cards in the second carrousel have description");
        Assert.assertTrue(watchPage.checkCardsDescription(), "Cards in the second carrousel don´t have description");
        watchPage.clickCard();
        Reporter.info("Checking close button is visible");
        Assert.assertTrue(watchPage.closeBtnModalIsVisible(), "Close button is not visible");
        watchPage.clickToCloseModal();
    }

    @And("You should come back to ESPN home page")
    public void comeBackToHomePage() {
        watchPage.backHomePage();
        Reporter.info("Checking it can come back to ESPN home page");
        Assert.assertTrue(homePage.userIconIsVisible(), "It cannot come back to home page");
    }

    @Then("Welcome text with the name is visible")
    public void welcomeTextIsVisible() {
        Reporter.info("Checking welcome text was visible correctly");
        Assert.assertEquals(homePage.getWelcomeText(), WebData.returnData("welcomeText"), "Welcome texts is not visible");
    }

    @When("You log out")
    public void logOut() {
        homePage.clickOnLOgOutHome();
        homePage.waitForLogOut();
    }


}
