package org.fasttrackit.automation;


import com.sdl.selenium.web.WebLocator;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class LoginView {

//    @FindBy(id = "email")
//    private WebElement emailField;

    private WebLocator emailField = new WebLocator().setId("email");



//    @FindBy(name = "password")
//    private WebElement passField;

    private WebLocator passField = new WebLocator().setName("password");


//    @FindBy (className = "login-btn")
//    private WebElement loginBtn;

    private WebLocator loginBtn = new WebLocator().setClasses("login-btn");


//    @FindBy (xpath = "//form//div[contains(@class, 'error-msg')]")
//    private WebElement errorMsg;

    private WebLocator errorMsg = new WebLocator().setElPath("//form//div[contains(@class, 'error-msg')]");
    public WebLocator stopTheProcess = new WebLocator().setText("\n" +
            "            Stop the process?\n" +
            "        ");

    public WebLocator labelWithError = new WebLocator().setText("\n" +
            "            Label with Enter.\n" +
            "        ");

    public WebLocator techButton = new WebLocator("clearfix");

    public WebLocator manualButton = new WebLocator().setText("Manual");
    public void login(String email, String pass) {
        emailField.sendKeys(email);
        passField.sendKeys(pass);
        loginBtn.click();

    }

    public void clickOnLabels(){
        stopTheProcess.click();
        labelWithError.click();

    }

    public void selectTech(){
        techButton.click();

        manualButton.click();
    }

    public void invalidLogin(String email, String pass, String errorDisplayed) {
        emailField.sendKeys(email);
        passField.sendKeys(pass);
        loginBtn.click();

        //assertThat("Message is not visible", errorMsg.isDisplayed());
        assertThat("The message is visible", errorMsg.getText(),is(errorDisplayed));

    }


}
