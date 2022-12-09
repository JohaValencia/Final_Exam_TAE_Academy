package com.finalExam.pageObjects.pages;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    @FindBy(css = ".promo-banner-container iframe")
    private WebElement bannerContainer;

    @FindBy(css = "section.PromoBanner")
    private WebElement promoBanner;

    @FindBy(id = "global-user-trigger")
    private WebElement userIcon;

    @FindBy(css = "div.PromoBanner__CloseBtn")
    private WebElement bannerCloseBtn;

    @FindBy(id = "sideLogin-left-rail")
    private WebElement login;

    @FindBy(css = "div.global-user:last-child ul.account-management > li:last-child > a")
    private WebElement homeLoginLink;

    @FindBy (css = "li.user > div.global-user:last-child")
    private WebElement containerOptions;

    @FindBy (id = "oneid-iframe")
    private WebElement iframe;

    @FindBy (css = "div.global-user:last-child ul.account-management > li:last-child > a")
    private WebElement homeLogOutLink;

    @FindBy (css = "div.view-starry-night > div:first-child")
    private  WebElement loginIframe;

    @FindBy (id = "logo")
    private WebElement espnLogo;

    @FindBy (id = "InputLoginValue")
    private WebElement inputEmail;

    @FindBy (id = "InputPassword")
    private WebElement inputPassword;

    @FindBy (css = "h2#Title span")
    private WebElement signUpTitle;

    @FindBy (id = "InputFirstName")
    private WebElement inputFirstName;

    @FindBy (id = "InputLastName")
    private WebElement inputLastName;

    @FindBy (id = "InputEmail")
    private WebElement inputEmailIframe;

    @FindBy (id = "password-new")
    private WebElement passwordIframe;

    @FindBy (id = "BtnSubmit")
    private WebElement loginIframeBtn;

    @FindBy (id = "BtnCreateAccount")
    private WebElement signUpIframeBtn;

    @FindBy (id = "BtnSubmit")
    private WebElement signUpIframeButton;

    @FindBy (id = "close")
    private WebElement closeIframeBtn;

    @FindBy (css = "div.global-user:last-child ul.account-management li.display-user")
    private WebElement welcomeText;

    @FindBy (css = "li.pillar.watch > a")
    private WebElement watchLink;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void loginSteps (String email, String password) {
        this.userIconIsVisible();
        this.clickUserIcon();
        this.switchIframe();
        this.typeOnEmail(email);
        this.typeOnPassword(password);
        this.clickOnLoginBtn();
        this.leaveToIframe();
        this.waitForLogIn();
    }

    public void waitForLogIn() {
        super.waitForPresenceOfElement("#sideLogin-left-rail");
        super.waitForChangeAttribute(login, "style", "display: none");
    }

    public  void waitForLogOut() {
        super.waitForPresenceOfElement("#sideLogin-left-rail");
        super.waitForChangeAttribute(login, "style", "display: block;");
    }

    public void leaveToIframe() {
        super.getDriver().switchTo().defaultContent();
    }

    public boolean verifyBanner() {
        boolean banner = true;
        try {
            super.waitForPresenceOfElement(".promo-banner-container iframe", 10);
        } catch (TimeoutException e) {
            banner = false;
        }
        return banner;
    }

    public boolean userIconIsVisible() {
        super.waitForVisibility(this.userIcon);
        return this.userIcon.isDisplayed();
    }

    public void clickUserIcon() {
        super.clickElement(this.userIcon);
        super.waitForVisibility(this.containerOptions);
    }

    public void closeBanner() {
        if (this.verifyBanner()) {
            super.getDriver().switchTo().frame(this.iframe);
            super.waitForVisibility(this.promoBanner);
            super.clickElement(this.bannerCloseBtn);
            this.leaveToIframe();

        }
    }

    public void clickOnLogInHome() {
        super.clickElement(this.homeLoginLink);
    }

    public void clickOnLOgOutHome() {
        super.getDriver().switchTo().defaultContent();
    }

    public  void switchIframe() {
        super.getDriver().switchTo().frame(this.iframe);
    }

    public void leaveIframe() {
        super.getDriver().switchTo().defaultContent();
    }

    public  boolean modalIsVisible() {
        super.waitForVisibility(this.loginIframe);
        return this.loginIframe.isDisplayed();
    }

    public boolean espnLogoIsVisible() {
        super.waitForVisibility(this.espnLogo);
        return this.espnLogo.isDisplayed();
    }

    public boolean logInBtnIsVisible() {
        super.waitForVisibility(this.loginIframeBtn);
        return this.loginIframeBtn.isDisplayed();
    }

    public boolean signUpBtnIsVisible() {
        super.waitForVisibility(this.signUpIframeBtn);
        return this.signUpIframeBtn.isDisplayed();
    }

    public void typeOnEmail(String text) {
        super.waitForVisibility(this.inputEmail);
        super.typeOnInput(this.inputEmail, text);
    }

    public void typeOnPassword(String text) {
        super.waitForClickable(this.inputPassword);
        super.typeOnInput(this.inputPassword, text);
    }

    public boolean signUpTitleIsVisible() {
        super.waitForVisibility(this.signUpTitle);
        return this.signUpTitle.isDisplayed();
    }

    public boolean firstNameIsVisible() {
        super.waitForVisibility(this.inputFirstName);
        return this.inputFirstName.isDisplayed();
    }

    public void typeOnFirstName(String text) {
        super.waitForVisibility(this.inputFirstName);
        super.typeOnInput(this.inputFirstName, text);
    }

    public boolean lastNameIsVisible() {
        super.waitForVisibility(this.inputLastName);
        return this.inputLastName.isDisplayed();
    }

    public void typeOnLastName(String text) {
        super.waitForVisibility(this.inputLastName);
        super.typeOnInput(this.inputLastName, text);
    }

    public boolean emailInputIsVisible() {
        super.waitForVisibility(this.inputEmail);
        return this.inputEmail.isDisplayed();
    }

    public void typeOnEmailToSignUp(String text) {
        super.waitForVisibility(this.inputEmail);
        super.typeOnInput(this.inputEmail, text);
    }

    public boolean passwordInputIsVisible() {
        super.waitForVisibility(this.inputPassword);
        return this.inputPassword.isDisplayed();
    }

    public void typeOnPasswordToSignUp(String text) {
        super.waitForVisibility(this.inputPassword);
        super.typeOnInput(this.inputPassword, text);
    }

    public boolean signUpButtonIsVisible() {
        super.waitForVisibility(this.signUpIframeButton);
        return this.signUpIframeButton.isDisplayed();
    }

    public boolean closeIframeBtnIsVisible() {
        super.waitForVisibility(this.closeIframeBtn);
        return this.closeIframeBtn.isDisplayed();
    }

    public void clickOnLoginBtn() {
        super.clickElement(this.loginIframeBtn);
    }

    public void clickOnSignUpBtn() {
        super.clickElement(this.signUpIframeBtn);
    }

    public WatchPage watchPage() {
        super.clickElement(this.watchLink);
        return new WatchPage(super.getDriver());
    }

    public String getWelcomeText() {
        super.waitForVisibility(this.welcomeText);
        return this.welcomeText.getText();
    }

    public String createEmail() {
        int randomItem = (int)(Math.random() * 100);
        return "text.new.email.espn" + randomItem + "@email.com";
    }

}
