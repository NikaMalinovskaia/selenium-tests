package test.java;

import dev.effective.autotest.TestBase;
import dev.effective.autotest.Utiles;
import dev.effective.autotest.pages.LoginPage;
import dev.effective.autotest.pages.LogoutPage;
import dev.effective.autotest.pages.PatientsPage;
import io.qameta.allure.junit4.DisplayName;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;



@DisplayName("Login Tests")

public class TestPage extends TestBase {
    private static final java.lang.String ADMIN_USERNAME = "maya@herabeat.com";
    private static final java.lang.String ADMIN_PASSWOPD = "Asdf1234!";
    private static final java.lang.String CAREPROVIDER_USERNAME = "tetaraw303@iunicus.com";
    private static final java.lang.String WRONG_PASSWOPD = "Abcd123!";
    private static final java.lang.String HEADER_NAME = "Patients";
    private static final java.lang.String ALERT_NAME = "Error\nInvalid username or password";
    private static final java.lang.String LOGIN_PAGE_TITLE = "Login";
    LoginPage loginPage;
    LogoutPage logoutPage;
    PatientsPage patientsPage;
    PatientsPage liveRealTime;
    PatientsPage patientA;
    PatientsPage patient;

    public TestPage() {
        super();
    }

    @BeforeClass
    public static void setUp() {
        initialization();
    }

    @Test
    public void loginPageRedirectTest() {
        loginPage = new LoginPage();
        loginPage.login(ADMIN_USERNAME, ADMIN_PASSWOPD);
        patientsPage = new PatientsPage();
        Assert.assertEquals(patientsPage.getHeaderName(), HEADER_NAME);
        //Comment is for another test (Logout)
        //submitTestDataPage.logout()
        logoutPage = new LogoutPage();
        logoutPage.logout();
        Assert.assertEquals(loginPage.getHeaderText(), LOGIN_PAGE_TITLE);
    }

    @Test
    public void loginWithWrongPassword() {
        loginPage = new LoginPage();
        loginPage.login(CAREPROVIDER_USERNAME, WRONG_PASSWOPD);
        Assert.assertEquals(loginPage.getAlertName(), ALERT_NAME);
        Utiles.getScreenshot(driver);
    }

    @Test
    public void liveRealTime() {
        loginPage = new LoginPage();
        loginPage.login(ADMIN_USERNAME, ADMIN_PASSWOPD);
        patientsPage = new PatientsPage();
        Assert.assertEquals(patientsPage.getHeaderName(), HEADER_NAME);
        liveRealTime = new PatientsPage();
        liveRealTime.liveRealTime();
        Assert.assertEquals(liveRealTime.getHeaderName(), HEADER_NAME);
        logoutPage = new LogoutPage();
        logoutPage.logout();
    }

    @Test
    public void patientDeactivation() {
        loginPage = new LoginPage();
        loginPage.login(ADMIN_USERNAME, ADMIN_PASSWOPD);
        patientsPage = new PatientsPage();
        Assert.assertEquals(patientsPage.getHeaderName(), HEADER_NAME);
        patient = new PatientsPage();
        patient.patientFind();
        patientA = new PatientsPage();
        patientA.patientActivate();
        logoutPage = new LogoutPage();
        logoutPage.logout();

    }

    @AfterClass
    public static void tearDown() {
        driver.quit();
    }

}
