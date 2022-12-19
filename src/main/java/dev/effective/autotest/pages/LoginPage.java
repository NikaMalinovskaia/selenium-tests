package dev.effective.autotest.pages;

import dev.effective.autotest.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import io.qameta.allure.Step;
public class LoginPage extends TestBase {
    public static final String URL = "https://dev.hera-med.com/";

    @FindBy(id="Username")
    WebElement usernameField;

    @FindBy(id="Password")
    WebElement passwordField;

    @FindBy(name="button")
    WebElement loginButton;

    @FindBy(css=".alert-danger")
    WebElement alert;

    @FindBy(className="page-header")
    WebElement header;

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

    public String getHeaderText() {
        return header.getText();
    }
    public String getAlertName() {
        return alert.getText();
    }

}


