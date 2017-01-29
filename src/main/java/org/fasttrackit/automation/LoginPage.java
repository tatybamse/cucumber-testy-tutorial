package org.fasttrackit.automation;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class LoginPage {

    @FindBy(id = "email")
    private WebElement emailField;
    @FindBy(name = "password")
    private WebElement passField;
    @FindBy (className = "login-btn")
    private WebElement loginBtn;
    @FindBy (xpath = "//form//div[contains(@class, 'error-msg')]")
    private WebElement errorMsg;


    public void login(String email, String pass) {
        emailField.sendKeys(email);
        passField.sendKeys(pass);
        loginBtn.click();

    }

    public void invalidLogin(String email, String pass, String errorDisplayed) {
        emailField.sendKeys(email);
        passField.sendKeys(pass);
        loginBtn.click();

        assertThat("Message is not visible", errorMsg.isDisplayed());
        assertThat("The message is visible", errorMsg.getText(),is(errorDisplayed));

    }


}
