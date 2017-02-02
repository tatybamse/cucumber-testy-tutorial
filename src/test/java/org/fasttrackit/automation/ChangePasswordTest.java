package org.fasttrackit.automation;


import org.fasttrackit.util.TestBase;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class ChangePasswordTest extends TestBase {

    private LoginPage loginPage;
    private ChangePasswordPage changePasswordPage;

//    public LoginTest() {
//        loginPage = PageFactory.initElements(driver, LoginPage.class);
//    }


    public ChangePasswordTest() {

        loginPage = PageFactory.initElements(driver, LoginPage.class);
        changePasswordPage = PageFactory.initElements(driver,ChangePasswordPage.class);

    }


    @Test
    public void invalidNewPass(){

        openBrowser();

        loginPage.login("eu@fast.com", "eu.pass");


        driver.findElement(By.xpath("//button[@data-target='#preferences-win']")).click();

        waitBeforeClick();


        changePasswordPage.changePassword("eu.pass","new", "new.");

        waitBeforeClick();

        assertThat(changePasswordPage.getStatusMessage(),is("Password does not match the confirm password!"));


    }

    @Test
    public void emptyNewPasswordTest() {

        openPage("eu@fast.com", "eu.pass");

        changePasswordPage.changePassword("eu.pass", " ","");

        assertThat(changePasswordPage.getStatusMessage(),is("Your preview password is incorrect!"));




    }

    @Test
    public void invalidActualPass(){

        openPage("eu@fast.com", "eu.pass");


        changePasswordPage.changePassword("wrong.pass", "new.password", "new.password");

        waitBeforeClick();

        assertThat(changePasswordPage.getStatusMessage(),is("Your preview password is incorrect!"));

//        msgWhenChangePassword("Your preview password is incorrect!");


        changePasswordPage.closeWindow();

    }

    @Test

    public void successfullyChangedPassword(){

        openPage("tu@fast.com", "tu.pass");
        WebElement preferencesBtn;

        changePasswordPage.changePassword("tu.pass","newpass","newpass");

        waitBeforeClick();

        assertThat(changePasswordPage.getStatusMessage(),is("Your password has been successfully changed."));

//        msgWhenChangePassword("Your password has been successfully changed.");

        changePasswordPage.closeWindow();

        waitBeforeClick();

        changePasswordPage.clickLogOutBtn();

        waitBeforeClick();

        loginPage.login("tu@fast.com", "newpass");

        waitBeforeClick();

        preferencesBtn = driver.findElement(By.xpath("//button[@data-target='#preferences-win']"));

        preferencesBtn.click();

        waitBeforeClick();
    }

    private void openPage(String email, String pass) {
        openBrowser();
        loginPage.login(email, pass);

        WebElement preferencesBtn = driver.findElement(By.xpath("//button[@data-target='#preferences-win']"));

        preferencesBtn.click();

        waitBeforeClick();
    }


//    private void msgWhenChangePassword(String errors) {
//        WebElement errorMsg = driver.findElement(By.xpath("//form//div[contains(@class,'status-msg')]"));
//        System.out.println(errorMsg.getText());
//        assertThat("Message is displayed",errorMsg.isDisplayed());
//        assertThat("Wrong initial password", errorMsg.getText(), is(errors));
//    }




}

