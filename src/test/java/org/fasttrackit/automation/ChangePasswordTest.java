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

        errorsWhenChangePassword("Password does not match the confirm password!");




    }

    @Test
    public void invalidPasswordTest() {


        loginPage.login("eu@fast.com", "eu.pass");


        WebElement preferencesBtn = driver.findElement(By.xpath("//button[@data-target='#preferences-win']"));
        preferencesBtn.click();

        waitBeforeClick();

        changePasswordPage.changePassword("eu.pass", "news","new");




    }

    @Test
    public void invalidActualPass(){

        openBrowser();

        loginPage.login("eu@fast.com", "eu.pass");


        WebElement preferencesBtn = driver.findElement(By.xpath("//button[@data-target='#preferences-win']"));
        preferencesBtn.click();

        waitBeforeClick();


        changePasswordPage.changePassword("wrong.pass", "new.password", "new.password");

        waitBeforeClick();

        errorsWhenChangePassword("Your preview password is incorrect!");


        changePasswordPage.closeWindow();

    }


    private void errorsWhenChangePassword(String errors) {
        WebElement errorMsg = driver.findElement(By.xpath("//form//div[contains(@class,'status-msg')]"));
        System.out.println(errorMsg.getText());
        assertThat("Message is displayed",errorMsg.isDisplayed());
        assertThat("Wrong initial password", errorMsg.getText(), is(errors));
    }

}

