package dev.effective.autotest.pages;

import dev.effective.autotest.TestBase;
import dev.effective.autotest.Utiles;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PatientsPage extends TestBase {
    @FindBy(css=".title")
    WebElement headerName;

    @FindBy(xpath = "//span[text()=\"Enabled\"]")
    WebElement live;

    @FindBy(css=".Mui-selected:nth-child(2) > .MuiTab-wrapper")
    WebElement realTime;

    @FindBy(css=".MuiTableRow-root:nth-child(1) > .MuiTableCell-root:nth-child(2) > .MuiTypography-root")
    WebElement patient;

    @FindBy(xpath="//span[text()=\"Active\"]")
    WebElement active;

    @FindBy(css="div.MuiDialogActions-root.MuiDialogActions-spacing > button.MuiButtonBase-root.MuiButton-root.MuiButton-contained.MuiButton-containedPrimary")
    WebElement agreement;
    @FindBy(xpath="//span[text()=\"Inactive\"]")
    WebElement inactive;

    @FindBy(css="div.MuiDialogActions-root.MuiDialogActions-spacing > button.MuiButtonBase-root.MuiButton-root.MuiButton-contained.MuiButton-containedPrimary")
    WebElement disagreement;

    public PatientsPage() {
        PageFactory.initElements(driver, this);
    }

    public String getHeaderName() {
        return headerName.getText();
    }

    public void liveRealTime() {
        live.click();
        realTime.click();
        Utiles.getScreenshotWithElement(driver, realTime);
    }

    public void patientFind() {
        patient.click();
        active.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
        wait.until(ExpectedConditions.visibilityOf(active));
        Utiles.getScreenshotWithElement(driver, agreement);
        agreement.click();
    }

    public void patientActivate() {
        inactive.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
        wait.until(ExpectedConditions.visibilityOf(disagreement));
        Utiles.getScreenshotWithElement(driver, disagreement);
        disagreement.click();
    }

}
