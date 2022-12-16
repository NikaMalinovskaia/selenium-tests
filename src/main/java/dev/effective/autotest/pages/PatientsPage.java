package dev.effective.autotest.pages;

import dev.effective.autotest.TestBase;
import dev.effective.autotest.Utiles;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PatientsPage extends TestBase {
    @FindBy(css=".title")
    WebElement headerName;

    @FindBy(css=".MuiTableRow-root:nth-child(1) > .MuiTableCell-root:nth-child(2) > .MuiTypography-root")
    WebElement patient;

    public PatientsPage() {
        PageFactory.initElements(driver, this);
    }

    public String getHeaderName() {
        Utiles.getScreenshotWithElement(driver, headerName);
    return headerName.getText();
    }

    public void getPatient() {
        patient.click();
    }


}
