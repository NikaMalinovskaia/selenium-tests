package dev.effective.autotest.pages;

import dev.effective.autotest.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import io.qameta.allure.Step;
public class LoginPage extends TestBase {
    public static final String URL = "https://us-dev.hera-med.com/";

    @FindBy(id="Username")
    WebElement usernameField;

    @FindBy(id="Password")
    WebElement passwordField;

    @FindBy(name="button")
    WebElement loginButton;

    @FindBy(name="Submit")
    WebElement submitButton;

    @FindBy(css=".alert-danger")
    WebElement alert;

    @FindBy(css="h1")
    WebElement alertLocked;

    // Initializing the Page Objects:
    public LoginPage() {
        driver.get(URL);
        PageFactory.initElements(driver, this);
    }

    @Step("Type {username} / {password}.")
    public void login(String username, String password) {
        enterUsername(username);
        enterPassword(password);
        loginButton.click();
    }

    private void enterUsername(String username) {
        usernameField.clear();
        usernameField.sendKeys(username);
    }

    private void enterPassword(String password) {
        passwordField.clear();
        passwordField.sendKeys(password);
    }

    public String getAlertName() {
        return alert.getText();
    }

    public String getAlertLocked() {
        return alertLocked.getText();
    }

}


