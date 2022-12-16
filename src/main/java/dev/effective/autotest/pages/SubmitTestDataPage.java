package dev.effective.autotest.pages;
import dev.effective.autotest.TestBase;
import dev.effective.autotest.Utiles;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.apache.commons.compress.harmony.pack200.NewAttributeBands;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
public class SubmitTestDataPage extends TestBase {

    @FindBy(css=".jss57 > .MuiTypography-root")
    WebElement header;

    @FindBy(css=".jss61 > [class*= lined]")
    WebElement list;

    @FindBy(css=".jss61 > [class*= lined]")
    WebElement element;

    @FindBy(css="[data-value='2']")
    WebElement elementChronic;

    @FindBy(css=".MuiTableRow-root:nth-child(6) > .MuiTableCell-root > .MuiButtonBase-root > .MuiButton-label")
    WebElement submitButton;

    @FindBy(css=".MuiButtonBase-root")
    WebElement leftBar;

    @FindBy(css=".jss27 > .MuiButtonBase-root")
    WebElement downButton;

    @FindBy(css=".jss23")
    WebElement logoutButton;

    public SubmitTestDataPage() {

        PageFactory.initElements(driver, this);
    }
    @Step("Get header of opened window")

    @Attachment(value = "Page screenshot", type = "image/png")
    public byte[] saveScreenshot(byte[] screenShot) {
        return screenShot;
    }

    public String getHeaderText() {

        return header.getText();
    }

    public String getListText() {

        return list.getText();
    }

    public String getElement() {

        return element.getText();
    }

    public String getElementChronic() {

        return elementChronic.getText();
    }

    public void getSubmitButton() {

        submitButton.click();
    }

    public void getLeftBar() {

        leftBar.click();
    }

    public void getDownButton() {
        downButton.click();
    }

    public void getLogoutButton() {

        logoutButton.click();
    }
}
