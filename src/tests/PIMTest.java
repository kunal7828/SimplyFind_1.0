package tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import common.BaseSetup;
import pages.PIMPage;

public class PIMTest extends BaseSetup {
	WebDriver driver;

	@Test(description="Verifying add employee functionality.",priority=1,enabled=true)
	public void verifyAddEmployee() {
		PIMPage pimPage = new PIMPage();

		pimPage.verifyPIMMenu();
		pimPage.verifyClickOnAddUser();
		pimPage.verifyEnterFirstName("Akash ");
		pimPage.verifyEnterLastName("Patil");
		pimPage.verifySaveButton();
		
	}
	@Test(description="Verifying search employee functionality.",priority=2,enabled=true)
	public void verifySearchEmployee()
	{         
		PIMPage pimPage = new PIMPage();
		pimPage.verifyClickEmployeeList();
		pimPage.verifyEnterEmployeeName("Akash");
		pimPage.verifySearchbutton();
	}
	
	@Test(description="Verifying edit employee functionality.",priority=3,enabled=true)
	public void verifyEditEmployee() 
	{
		PIMPage pimPage = new PIMPage();
		pimPage.verifyEditButton();
		pimPage.verifychangeEmployeeId("0875");
		//pimPage.verifySelectNationality();
		pimPage.verifyUpdateSaveButton();
	}
	
	@Test(description="Verifying delete employee functionality.",priority=4,enabled=true)
	public void verifyDeleteEmployee() 
	{
		PIMPage pimPage = new PIMPage();
		pimPage.verifyClickEmployeeList();
		pimPage.verifyEnterEmployeeName("Akash Patil");
		pimPage.verifySearchbutton();
		pimPage.verifyDeleteButton();
		pimPage.verifyDeleteYesButton();
	}
	
}
