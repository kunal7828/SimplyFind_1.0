package tests;

import org.testng.annotations.Test;
import common.BaseSetup;
import pages.TestP;

public class TestG extends BaseSetup {

    @Test(priority = 1)
    public void verifyAdminModule() {
    	TestP allModulesPage = new TestP();
        allModulesPage.navigateToAdmin();
        allModulesPage.addAdminUser("Akash", "Akash_doe", "Password123!");
    }

    @Test(priority = 2)
    public void verifyPIMModule() {
    	TestP allModulesPage = new TestP();
        allModulesPage.navigateToPIM();
        allModulesPage.addEmployee("Akash", "patil", "12345");
    }

    @Test(priority = 3)
    public void verifyLeaveModule() {
    	TestP allModulesPage = new TestP();
        allModulesPage.navigateToLeave();
        allModulesPage.applyLeave("Taking personal leave for the day.");
    }

    @Test(priority = 4)
    public void verifyTimeModule() {
    	TestP allModulesPage = new TestP();
        allModulesPage.navigateToTime();
        allModulesPage.punchInOut();
    }
}
