package org.fasttrackit.automation;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LaunchDemoModalPage {


    @FindBy(xpath = "//form//button[contains(@data-target, '#myModal')]")
    private WebElement  launchDemoModal;
    @FindBy(xpath = "//*[@id='email']")
    private WebElement emailLaunchField;
    @FindBy(xpath = "//*[@id='userName']")
    private WebElement userLaunchName;
    @FindBy (xpath = "//*[@id='saveButton']")
    private WebElement saveOnLaunchButton;
    @FindBy (xpath = "//*[@id='close']")
    private WebElement closeOnLaunchButton;

    public void setLaunchDemoModal(String email, String userName){

        launchDemoModal.click();
        emailLaunchField.sendKeys(email);
        userLaunchName.sendKeys(userName);
        saveOnLaunchButton.click();
        closeOnLaunchButton.click();
    }






}
