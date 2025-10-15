package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import common.BaseSetup;
import common.Log4JTest;
import common.SafeAction;

public class LeavePage extends SafeAction {
	
	public Logger log = LogManager.getLogger(LeavePage.class);

	String leaveLeftPanel = "//span[text()='Leave']";
	String clickOnApply = "//*[contains(text(),'Apply')]";
	String selectLeaveType = "//i[@class='oxd-icon bi-caret-down-fill oxd-select-text--arrow']";
	String selectTypeOfLeave = "//*[contains(text(),'CAN')]";
	String selectDateFromTo = "//div[@class='oxd-date-input']/input";
	String descriptionWhyLeave = "//div[@class='oxd-date-input']//following::textarea";
	String clickOnSave = "//button[@type='submit']";
	String leaveClick = "//span[text()='Leave']";
	String cencalLeave = "//i[@class='oxd-icon bi-three-dots-vertical']";
	String cencalYes = "//*[text()='Cancel Leave']";

	public void clickOnLeave() {
		safeClick(leaveLeftPanel);
		log.info("test log");
        safeExplicitWait(clickOnApply, 10);
        BaseSetup.infoLog("Clicked on leave.");
	}

	public void clickOnApply()  {
		safeClick(clickOnApply);
		safeExplicitWait(selectLeaveType, 10);
needToWait(5);
BaseSetup.infoLog("Clicked on apply.");
	}

	public void selectLeaveType()  {
		safeClick(selectLeaveType);
		safeExplicitWait(selectTypeOfLeave, 10);
		safeClick(selectTypeOfLeave);
		safeExplicitWait(selectDateFromTo, 10);
		
	
	}

	public void selectTypeOfLeave(String Dateselect) {
		safeType(selectDateFromTo, Dateselect);
		safeExplicitWait(descriptionWhyLeave, 10);
		
	}

	public void descriptionWhyLeave(String description)  {
		safeType(descriptionWhyLeave, description);
		safeExplicitWait(clickOnSave, 10);


	}

	public void clickOnSave()  {
		safeClick(clickOnSave);
		safeExplicitWait(leaveClick, 10);
		BaseSetup.passLog("Save button clicked successfully.");



	}

	public void leaveClick(String Dateselect)  {
		safeClick(leaveClick);
		needToWait(5);
	}

	public void cencalLeave()  {
		safeClick(cencalLeave);
		safeClick(cencalYes);
		needToWait(5);
		BaseSetup.passLog("Cancel button clicked successfully.");

	}

}