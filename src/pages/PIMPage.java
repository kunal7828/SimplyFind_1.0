package pages;
import org.testng.Reporter;
import common.SafeAction;

public class PIMPage extends SafeAction{
	

     String pimMenu = "//span[text()='PIM']";
     String cilckOnAddUser = "//a[text()='Add Employee']";
     String enterFirstName = "//input[@placeholder='First Name']";
     String enterLastName = "//input[@placeholder='Last Name']";
     String clickOnSaveButton = "//button[normalize-space()='Save']";
     String employeeList = "//a[text()='Employee List']";
     String enterEmployeeName = "//label[text()='Supervisor Name']//preceding::input[@placeholder='Type for hints...']";
     String clickOnSearchButton = "//button[text()=' Search ']";
     String editButton = "//i[@class='oxd-icon bi-pencil-fill']";
     String changeEmployeeId = "//label[text()='Other Id']//following::input[1]";
     String saveButton = "//button[text()=' Save ']";
     String deleteButton = "//i[@class='oxd-icon bi-trash']";
     String deleteYesButton = "//button[@class='oxd-button oxd-button--medium oxd-button--label-danger orangehrm-button-margin']";
     
     public void verifyPIMMenu() 
     {
    	 
    	 safeClick(pimMenu);
    	 Reporter.log("Navigated to PIM page successfully.", true);
    	 safeExplicitWait(cilckOnAddUser, 10);
     }
     
     public void verifyClickOnAddUser()
     {
    	 safeClick(cilckOnAddUser);
    	 Reporter.log("Clicked on add employee button successfully.", true);
    	 safeExplicitWait(enterFirstName, 10);
    	
     }
     
     public void verifyEnterFirstName(String firstNameValue) 
     {
    	 safeClick(enterFirstName);
    	 safeType(enterFirstName, firstNameValue);
    	 Reporter.log("First name entered successfully: "+firstNameValue, true);
    	 safeExplicitWait(enterLastName, 10);
     }
     
     public void verifyEnterLastName(String lastNameValue)
     {
    	 safeClick(enterLastName);
    	
    	 safeType(enterLastName, lastNameValue);
    	 Reporter.log("Last name entered successfully: "+lastNameValue, true);
safeExplicitWait(clickOnSaveButton, 10);

     }
     
     public void verifySaveButton() 
     {
    	 safeClick(clickOnSaveButton);
    	 Reporter.log("Clicked on save button successfully.", true);
safeExplicitWait(employeeList, 10);
    	
     }
     
     public void verifyClickEmployeeList()
     {
    	 safeClick(employeeList);
    	 Reporter.log("Clicked on employee list button successfully.", true);
    	 safeExplicitWait(enterEmployeeName, 10);
     }
     
     
     public void verifyEnterEmployeeName(String employeeName) 
     {
    	 safeClick(enterEmployeeName);
    	 safeType(enterEmployeeName,employeeName);
    	 Reporter.log("Employee name enetered successfully: "+employeeName, true);
    	 safeExplicitWait(clickOnSearchButton, 10);
     }
     
     public void verifySearchbutton() 
     {
    	 safeClick(clickOnSearchButton);
    	 Reporter.log("Clicked on search button successfully.", true);
    	safeExplicitWait(editButton, 10);
     }
     
     public void verifyEditButton()
     {
    	 safeClick(editButton);
    	 Reporter.log("Clicked on edit button successfully.", true);
    	 safeExplicitWait(changeEmployeeId, 10);
    	
     }
     
     
     public void verifychangeEmployeeId(String EmployeeId ) 
     {
    	 safeClick(changeEmployeeId);
    	 safeType(changeEmployeeId, EmployeeId);
    	 Reporter.log("Change Employee Id successfully.", true);
    	 safeExplicitWait(saveButton, 10);
     }
  
     public void verifyUpdateSaveButton()
     {
    	 safeClick(saveButton);
    	 Reporter.log("Clicked on save successfully.", true);
    	 safeExplicitWait(deleteButton, 10);
     }
     
     public void verifyDeleteButton() 
     {
    	 safeClick(deleteButton);
    	 Reporter.log("Clicked on delete button successfully.", true);
    	 safeExplicitWait(deleteYesButton, 10);
     }
     
     public void verifyDeleteYesButton() 
     {
    	 safeClick(deleteYesButton);
    	 Reporter.log("Clicked on yes,delete button successfully.", true);
    	
     }
     
}
