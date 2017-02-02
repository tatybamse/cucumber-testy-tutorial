package org.fasttrackit.automation;

import org.fasttrackit.util.TestBase;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class FailedLoginTest extends TestBase {

//    private LoginPage failedLoginPage;
    private LoginView failedLoginPage = new LoginView();


//    public FailedLoginTest() {
//
//        failedLoginPage = PageFactory.initElements(driver, LoginPage.class);
//
//    }

    @Test

    public void invalidLoginWithoutPassword() {

        openBrowser();

        failedLoginPage.invalidLogin("eu@fast.com", "", "Please enter your password!!");


    }

    @Test

    public void invalidLoginWithoutEmail() {

        openBrowser();

        failedLoginPage.invalidLogin("", "eu.pass", "Please enter your email!");


    }

    @Test

    public void invalidLoginWithNoEmailAndPassword() {

        openBrowser();

        failedLoginPage.invalidLogin("", "", "Please enter your email!");


    }

    @Test

    public void invalidLoginWithWrongEmailAndPassword() {

        openBrowser();

        failedLoginPage.invalidLogin("ciupi@wrg.com", "eu.passt", "Invalid user or password!");


    }

}
