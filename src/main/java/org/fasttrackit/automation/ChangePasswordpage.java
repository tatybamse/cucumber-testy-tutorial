package org.fasttrackit.automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ChangePasswordPage {

    @FindBy(name = "password")
    private WebElement currentPass;
    @FindBy(name = "newPassword")
    private WebElement newPassword;
    @FindBy(name = "newPasswordRepeat")
    private WebElement repeatNewPassword;
//    @FindBy (xpath = "//div[@id='preferences-win']/form//button[contains(@class,'btn-warning')]")
    @FindBy (xpath = "//*[@id=\"preferences-win\"]//button[normalize-space(text()) = \"Save\"]")
    private WebElement saveBtn;
    @FindBy (xpath = "//div[@id='preferences-win']/form//button[contains(@class,'btn-default')]")
    private WebElement closeWindowBtn;
    @FindBy (xpath = "//nav//a[normalize-space(text())=\"Logout\"]")
    private WebElement logOutBtn;
    @FindBy(className = "status-msg")
    private WebElement statusMsg;


    public void changePassword(String password, String newPass, String repeatPass){

        currentPass.sendKeys(password);
        newPassword.sendKeys(newPass);
        repeatNewPassword.sendKeys(repeatPass);
        saveBtn.click();

    }

    public void closeWindow() {
        closeWindowBtn.click();
    }
    public void clickLogOutBtn() { logOutBtn.click();}



    public String getStatusMessage() {
        String msg = statusMsg.getText();
        System.out.println(msg);
        return msg;
    }
}
