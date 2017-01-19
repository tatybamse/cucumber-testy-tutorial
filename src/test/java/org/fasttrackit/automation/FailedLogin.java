package org.fasttrackit.automation;

import org.fasttrackit.util.TestBase;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class FailedLogin extends TestBase {

@Test

public void  failedLoginTest() {

    System.out.println("ready");
    driver.get("https://rawgit.com/sdl/Testy/master/src/test/functional/app-demo/login.html");

    WebElement emailField = driver.findElement(By.id("email"));
    WebElement passField = driver.findElement(By.name("password"));
    WebElement loginBtn = driver.findElement(By.className("login-btn"));


    System.out.println("Enter an email:");
    emailField.sendKeys("eu@fast.com");
    System.out.println("Enter a password");
    passField.sendKeys("");
    loginBtn.click();

    WebElement nonPass = driver.findElement(By.className("error-msg"));
    assertThat("Message is not visible", nonPass.isDisplayed());
    assertThat("Complete flow", nonPass.getText(),is("Please enter your password!"));
}

}
