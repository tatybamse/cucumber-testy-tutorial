package org.fasttrackit.automation;

import org.fasttrackit.util.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
//import org.testng.annotations.Test;

@RunWith(JUnit4.class)
public class LoginTest extends TestBase {

    @Test
    public void validLoginTest() {

        openBrowser();

        login("eu@fast.com", "eu.pass");

        try {
            WebElement logoutBtn = driver.findElement(By.linkText("Logout"));
            logoutBtn.click();
        } catch (NoSuchElementException er) {
            Assert.fail("Could not login.");
        }
    }

        @Test
        public void invalidPasswordTest() {

            openBrowser();

            login("eu@fast.com", "eu.pass123");

            WebElement errorElement = driver.findElement(By.className("error-msg"));
            System.out.println(errorElement.getText());
            assertThat("Mesage is displayed",errorElement.isDisplayed());
            assertThat("Complete flow",errorElement.getText(), is("Invalid user or password!"));

            }

    @Test
    public void changePass(){

        openBrowser();

        login("eu@fast.com", "eu.pass");

        WebElement preferencesBtn = driver.findElement(By.xpath("//button[@data-target='#preferences-win']"));
        preferencesBtn.click();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        newPasswordsFields("wrong.pass","new.password", "new.password");

    }

    private void newPasswordsFields(String password, String newPass, String repeatPass) {


        WebElement currentPass = driver.findElement(By.name("password"));
        WebElement newPassword = driver.findElement(By.name("newPassword"));
        WebElement repetNewPassword = driver.findElement(By.name("newPasswordRepeat"));

        currentPass.sendKeys(password);
        newPassword.sendKeys(newPass);
        repetNewPassword.sendKeys(repeatPass);
    }

    private void openBrowser() {
        System.out.println("ready");
        driver.get("https://rawgit.com/sdl/Testy/master/src/test/functional/app-demo/login.html");
    }


    public void login(String user, String password) {

        WebElement emailField = driver.findElement(By.id("email"));
        WebElement passField = driver.findElement(By.name("password"));
        WebElement loginBtn = driver.findElement(By.className("login-btn"));

        System.out.println("Enter an email:");
        emailField.sendKeys(user);
        passField.sendKeys(password);
        loginBtn.click();

    }

}





