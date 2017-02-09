package org.fasttrackit.automation;


import com.sdl.selenium.extjs6.form.CheckBox;
import com.sdl.selenium.web.SearchType;
import com.sdl.selenium.web.WebLocator;
import com.sdl.selenium.web.utils.Utils;

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
    public WebLocator labelStopTheProcess = new WebLocator().setText("Stop the process?", SearchType.TRIM);
    public WebLocator labelWithError = new WebLocator().setText("Label with Enter.", SearchType.TRIM, SearchType.CHILD_NODE);
    public CheckBox checkBoxStopTheProcess = new CheckBox(labelStopTheProcess).setElPath("//input");
    public CheckBox checkBoxLabelWithError = new CheckBox(labelWithError);



    public WebLocator techButton = new WebLocator("clearfix");

    public WebLocator manualButton = new WebLocator().setElPath("//span[@class='pull-left'][normalize-space(text())='Manual']");
    public WebLocator autoButton = new WebLocator().setElPath("//span[@class='pull-left'][normalize-space(text())='Auto']");

    public static void main(String[] args) {
        LoginView test = new LoginView();
        System.out.println(test.labelStopTheProcess.getSelector());
        System.out.println(test.labelWithError.getSelector());
        System.out.println(test.checkBoxLabelWithError.getSelector());
        System.out.println(test.checkBoxStopTheProcess.getSelector());
    }


    public void login(String email, String pass) {
        emailField.sendKeys(email);
        passField.sendKeys(pass);
        loginBtn.click();

    }

    public void clickOnLabels(){
        labelStopTheProcess.click();
        labelWithError.click();

        Utils.sleep(2000);

        checkBoxStopTheProcess.click();
        checkBoxLabelWithError.click();

        assertThat("Stop the process is not selected!", checkBoxStopTheProcess.isSelected(), is(true));
        assertThat("Label with Enter", checkBoxLabelWithError.isSelected(), is(true));
    }

    public void selectTech(){
        techButton.click();

        Utils.sleep(1000);

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
