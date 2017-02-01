package org.fasttrackit.automation;


import com.gargoylesoftware.htmlunit.Page;
import org.fasttrackit.util.TestBase;
import org.junit.Test;
import org.openqa.selenium.support.PageFactory;

public class LaunchDemoModalTest extends TestBase{

    private LaunchDemoModalPage launchDemoModalPage;
    private LoginPage loginPage;


    public LaunchDemoModalTest(){

        launchDemoModalPage = PageFactory.initElements(driver, LaunchDemoModalPage.class);
        loginPage = PageFactory.initElements(driver, LoginPage.class);
    }

    @Test

    public void setLaunchDemoModalPage(){

        openBrowser();


        loginPage.login("eu@fast.com", "eu.pass");

        waitBeforeClick();

        launchDemoModalPage.setLaunchDemoModal("eu@fast.com", "Rares");

    }
}
