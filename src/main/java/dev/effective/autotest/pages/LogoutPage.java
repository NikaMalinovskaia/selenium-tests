package dev.effective.autotest.pages;

import dev.effective.autotest.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LogoutPage extends TestBase {
    public static final String URL = "https://dev.hera-med.com/patients";

    @FindBy(css=".MuiButtonBase-root")
    WebElement leftBar;

    @FindBy(css=".MuiButton-endIcon > .MuiSvgIcon-root")
    WebElement downArrow;

    @FindBy(id="account_menu_logout")
    WebElement logoutButton;

    // Initializing the Page Objects:
    public LogoutPage() {
        driver.get(URL);
        PageFactory.initElements(driver, this);
    }

    public void logout() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
        wait.until(ExpectedConditions.visibilityOf(leftBar));
        leftBar.click();
        downArrow.click();
        logoutButton.click();
    }
}



