package tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import common.BaseSetup;
import pages.AdminPage;


public class AdminTest extends BaseSetup {
	WebDriver driver;
    @Test(priority = 1)
    public void verifyAddUserFunUnderAdmin() {
        // Create an instance of AdminPage
        AdminPage adminPage = new AdminPage(driver);

        // Perform actions and capture screenshots
        adminPage.clickOnAdmin();
        adminPage.clickOnAddButton();
        adminPage.selectUserRole();
        adminPage.selectEmployeeName("a");
        adminPage.selectStatus();
        adminPage.enterUsername("Akash Patil");
        adminPage.enterPassword("Akash@810#");
        adminPage.enterConfirmPassword("Akash@810#");
        adminPage.clickOnSaveButton();
    }

    @Test(priority = 2)
    public void verifySearchFunUnderAdmin() {
        // Create an instance of AdminPage
        AdminPage adminPage = new AdminPage(driver);

        // Perform actions and capture screenshots
        adminPage.enterUsernameInSearchPanel("Akash Patil");
        adminPage.clickOnSearchButton();
    }

    @Test(priority = 3)
    public void verifyUpdateFunUnderAdmin() {
        // Create an instance of AdminPage
        AdminPage adminPage = new AdminPage(driver);

        // Perform actions and capture screenshots
        adminPage.clickOnUpdateButton();
        adminPage.clickOnBoxInUpdatePanel();
        adminPage.changePasswordInUpdatePanel("Akash@810##");
        adminPage.confirmPasswordInUpdatePanel("Akash@810##");
        adminPage.clickOnSaveButtonInUpdatePanel();
    }

    @Test(priority = 4)
    public void verifyDeleteFunUnderAdmin() {
        // Create an instance of AdminPage
        AdminPage adminPage = new AdminPage(driver);

        // Perform actions and capture screenshots
        adminPage.clickOnDeleteButton();
    }
}
