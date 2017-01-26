package org.fasttrackit.automation;

import com.sdl.selenium.web.utils.Utils;
import org.fasttrackit.util.TestBase;
import org.hamcrest.Matcher;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
//import org.testng.annotations.Test;

@RunWith(JUnit4.class)
public class LoginTest extends TestBase {

    private LoginPage loginPage;

    public LoginTest() {
        loginPage = PageFactory.initElements(driver, LoginPage.class);
    }

    @Test
    public void validLoginTest() {

        openBrowser();

        loginPage.login("eu@fast.com", "eu.pass");

        try {
            WebElement logoutBtn = driver.findElement(By.linkText("Logout"));
            logoutBtn.click();
        } catch (NoSuchElementException er) {
            Assert.fail("Could not login.");
        }
    }

}





