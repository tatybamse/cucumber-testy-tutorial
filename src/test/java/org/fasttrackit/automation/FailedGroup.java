package org.fasttrackit.automation;

import org.fasttrackit.util.TestBase;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class FailedGroup extends TestBase {



    @Test

    public void  failedLoginTest() {

        System.out.println("ready");

        checkLoginErrors("eu@fast.com", "", "Please enter your password!");
        checkLoginErrors("", "", "Please enter your email!");
        checkLoginErrors("", "", "Please enter your email!");



    }

    private void checkLoginErrors(String user, String pass, String errorMsg) {

        driver.get("https://rawgit.com/sdl/Testy/master/src/test/functional/app-demo/login.html");

         WebElement emailField = driver.findElement(By.id("email"));
         WebElement passField = driver.findElement(By.name("password"));
         WebElement loginBtn = driver.findElement(By.className("login-btn"));
         WebElement nonPass = driver.findElement(By.className("error-msg"));



        System.out.println("Enter an email:");
        emailField.sendKeys(user);
        System.out.println("Enter a password");
        passField.sendKeys(pass);
        loginBtn.click();


        assertThat("Message is not visible", nonPass.isDisplayed());
        assertThat("Complete flow", nonPass.getText(),is(errorMsg));

    }
}
