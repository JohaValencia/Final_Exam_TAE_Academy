package com.finalExam.pageObjects.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class WatchPage extends BasePage {

    @FindBy (css = "section.Carousel")
    private List<WebElement> carousel;

    @FindBy (css = "div.Carousel__Wrapper--canScrollRight ul.Carousel__Inner li:nth-child(2) > a")
    private WebElement secondCard;

    @FindBy (css = "section.lightbox__contentBox")
    private WebElement modal;

    @FindBy (css = ".lightbox__closebtn")
    private WebElement closeBtnModal;

    public WatchPage(WebDriver driver) {
        super(driver);
    }

    public List<WebElement> cardsInSecondCarrousel() {
        return this.carousel.get(1).findElements(By.cssSelector("ul.Carousel__Inner li"));
    }

    public boolean titleCards() {
        List<Boolean> title = new ArrayList<>();
        super.waitForPresenceOfElements("ul.Carousel__Inner li");
        this.cardsInSecondCarrousel().stream().forEach(element -> {
            title.add(!element.findElement(By.cssSelector("h2.WatchTile__Title")).getText().equals(""));
        });
        return !title.contains(false);
    }

     public boolean checkCardsDescription() {
        List<Boolean> description = new ArrayList<>();
        super.waitForPresenceOfElements("ul.Carousel__Inner li");
        this.cardsInSecondCarrousel().stream().forEach(element -> {

        });
        return !description.contains(false);
     }

     public void clickCard() {
        super.waitForVisibility(this.secondCard);
        super.clickElement(this.secondCard);
     }

     public void clickToCloseModal() {
        super.clickElement(this.closeBtnModal);
     }

     public boolean closeBtnModalIsVisible() {
        super.waitForVisibility(this.modal);
        super.waitForVisibility(this.closeBtnModal);
        return this.closeBtnModal.isDisplayed();
     }

     public HomePage backHomePage() {
        super.getDriver().navigate().back();
        return new HomePage(super.getDriver());
     }

}
