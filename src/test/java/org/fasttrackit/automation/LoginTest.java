package org.fasttrackit.automation;

import org.fasttrackit.util.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
//import org.testng.annotations.Test;
@RunWith(JUnit4.class)
public class LoginTest extends TestBase {

    @Test
    public void validLoginTest(){

        System.out.println("ready");
        driver.get("https://rawgit.com/sdl/Testy/master/src/test/functional/app-demo/login.html");

        WebElement emailField = driver.findElement(By.id("email"));
        WebElement passField = driver.findElement(By.name("password"));
        WebElement loginBtn = driver.findElement(By.className("login-btn"));

        System.out.println("Enter an email:");
        emailField.sendKeys("eu@fast.com");
        passField.sendKeys("eu.pass");
        loginBtn.click();

        try {
            WebElement logoutBtn = driver.findElement(By.linkText("Logout"));
            logoutBtn.click();
        } catch (NoSuchElementException er){
            Assert.fail("Could not login.");
        }

    }



}
