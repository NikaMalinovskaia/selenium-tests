package test.java;

import dev.effective.autotest.TestBase;
import dev.effective.autotest.pages.LoginPage;
import dev.effective.autotest.pages.PatientsPage;
import dev.effective.autotest.pages.SubmitTestDataPage;
import io.qameta.allure.junit4.DisplayName;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import static dev.effective.autotest.pages.LoginPage.URL;
import static dev.effective.autotest.TestBase.initialization;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

@DisplayName("Tests of Login Page")

    public class LoginPageTest extends TestBase {
        private static final java.lang.String PATIENT_USERNAME = "nika.malinovskaia@effective.band";
        private static final java.lang.String PATIENT_PASSWOPD = "Asdf1234!";
        private static final java.lang.String ADMIN_USERNAME = "maya@herabeat.com";
        private static final java.lang.String ADMIN_PASSWOPD = "Asdf1234!";
        private static final java.lang.String CAREPROVIDER_USERNAME = "yeyew80704@weepm.com";
        private static final java.lang.String WRONG_PASSWOPD = "Abcd123!";
        private static final java.lang.String SUBMIT_TEST_DATA_HEADER = "Submit Test Data";
        private static final java.lang.String SUBMIT_TEST_DATA_LIST = "Chronic Hypertension BP Bundle Sequence";
        private static final java.lang.String SUBMIT_TEST_DATA_MESSAGE = "Urine test";
        private static final java.lang.String HEADER_NAME = "Patients";
        private static final java.lang.String ALERT_NAME = "Error\nInvalid username or password";
        private static final java.lang.String ALERT_LOCKED = "Locked out";
        LoginPage loginPage;
        SubmitTestDataPage submitTestDataPage;

        PatientsPage patientsPage;

        public LoginPageTest() {
            super();
        }

        @BeforeClass
        public static void setUp() {
            initialization();
        }

        @Test
        public void loginPageRedirectTest() {
            loginPage = new LoginPage();
            loginPage.login(PATIENT_USERNAME, PATIENT_PASSWOPD);
            submitTestDataPage = new SubmitTestDataPage();
            Assert.assertEquals(submitTestDataPage.getHeaderText(), SUBMIT_TEST_DATA_HEADER);
        }

    @Test
    public void logout() {
        loginPage = new LoginPage();
        loginPage.login(PATIENT_USERNAME, PATIENT_PASSWOPD);
        submitTestDataPage = new SubmitTestDataPage();

        WebElement leftBar = driver.findElement(By.cssSelector(".MuiButtonBase-root"));
        leftBar.click();

        WebElement downButton = driver.findElement(By.cssSelector(".MuiButton-endIcon > .MuiSvgIcon-root"));
        downButton.click();

        WebElement logoutButton = driver.findElement(By.id("account_menu_logout"));
        logoutButton.click();
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void patientsToDos() {
        loginPage = new LoginPage();
        loginPage.login(ADMIN_USERNAME, ADMIN_PASSWOPD);
        patientsPage = new PatientsPage();
        Assert.assertEquals(patientsPage.getHeaderName(), HEADER_NAME);

        WebElement patient = driver.findElement(By.cssSelector(".MuiTableRow-root:nth-child(1) > .MuiTableCell-root:nth-child(2) > .MuiTypography-root"));
        patient.click();

        WebElement patientToDos = driver.findElement(By.cssSelector(".MuiGrid-root:nth-child(1) > .MuiTabs-root .MuiButtonBase-root:nth-child(1) > .MuiTab-wrapper"));
        patientToDos.click();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void lockedUser() {
        loginPage = new LoginPage();
        loginPage.login(CAREPROVIDER_USERNAME, WRONG_PASSWOPD);
        Assert.assertEquals(loginPage.getAlertLocked(), ALERT_LOCKED);
        WebElement alertLocked = driver.findElement(By.cssSelector("h1"));
        alertLocked.click();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void realTime() {
        loginPage = new LoginPage();
        loginPage.login(ADMIN_USERNAME, ADMIN_PASSWOPD);
        patientsPage = new PatientsPage();
        Assert.assertEquals(patientsPage.getHeaderName(), HEADER_NAME);

        WebElement live = driver.findElement(By.cssSelector(".MuiTableRow-root:nth-child(1) .MuiChip-label"));
        live.click();

        WebElement realTime = driver.findElement(By.cssSelector(".Mui-selected:nth-child(2) > .MuiTab-wrapper"));
        realTime.click();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @AfterClass
        public static void tearDown() {
            driver.quit();
        }

    }
