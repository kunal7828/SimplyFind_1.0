package tests;

import org.testng.annotations.Test;
import common.BaseSetup;
import pages.LeavePage;

public class LeaveTest extends BaseSetup {

	@Test(priority = 1)
	public void verifyLeavefunUnderLeave() {
        setDes("verify Leave fun Under Leave");
		LeavePage leavePage = new LeavePage();
		leavePage.clickOnLeave();
		leavePage.clickOnApply();
		leavePage.selectLeaveType();
		leavePage.selectTypeOfLeave("2024-08-04");
		leavePage.descriptionWhyLeave("This is my personal leave . ");
		leavePage.clickOnSave();

	}

	
	@Test(priority = 2, enabled = true)
	public void verifyCancelfunUnderLeave() {
		setDes("verify Cancel fun Under Leave");
		LeavePage leavePage = new LeavePage();
		leavePage.clickOnLeave();
		leavePage.cencalLeave();
		
	}

}