package pages;

import common.SafeAction;
import org.openqa.selenium.WebDriver;

public class AdminPage extends SafeAction {

    // Corrected locators with consistent naming and syntax
    String adminLeftPanel = "//span[text()='Admin']";
    String addButtonUnderAdminPage = "//button[contains(@class, 'oxd-button--secondary')]";
    String userRoleDropdown = "//input[@placeholder='Type for hints...']//preceding::i[1]";
    String adminRoleOption = "//div[@class='oxd-select-dropdown --position-bottom']//span[text()='Admin']";
    String employeeNameInput = "//input[@placeholder='Type for hints...']";
    String selectEmployeeOption = "//input[@placeholder='Type for hints...']//following::span[1]";
    String statusDropdown = "//input[@placeholder='Type for hints...']//following::i";
    String enabledStatusOption = "//div[@class='oxd-select-dropdown --position-bottom']//span[text()='Enabled']";
    String usernameField = "//label[text()='Username']//following::input[1]";
    String passwordField = "//input[@type='password'][1]";
    String confirmPasswordField = "//input[@type='password'][2]";
    String saveButton = "//button[contains(@class, 'orangehrm-left-space')]";
    String usernameSearchField = "//label[text()='Username']//following::input[1]";
    String searchButton = "//label[text()='Username']//following::button[2]";
    String updateButton = "//div[text()='Actions']//following::button[2]";
    String updateCheckbox = "//label[text()='Username']//following::i[1]";
    String updatePasswordField = "//label[text()='Password']//following::input[1]";
    String updateConfirmPasswordField = "//label[text()='Confirm Password']//following::input[1]";
    String saveButtonInUpdatePanel = "//button[text()=' Save ']";
    String deleteButton = "//div[text()='Akash Patil']//following::button[1]";
    String confirmDeleteButton = "//button[text()=' Yes, Delete ']";

    WebDriver driver;

    public AdminPage(WebDriver driver) {
        super(); // Ensure SafeAction uses this driver
        this.driver = driver;
    }

    public void clickOnAdmin() {
        safeClick(adminLeftPanel);
    //    safeTakeScreenshot("clickOnAdmin");
        safeExplicitWait(addButtonUnderAdminPage, 10);
    }

    public void clickOnAddButton() {
        safeClick(addButtonUnderAdminPage);
 //       safeTakeScreenshot("clickOnAddButton");
        safeExplicitWait(userRoleDropdown, 10);
    }

    public void selectUserRole() {
        safeClick(userRoleDropdown);
 //       safeTakeScreenshot("selectUserRole");
        safeClick(adminRoleOption);
        safeExplicitWait(employeeNameInput, 10);
    }

    public void selectEmployeeName(String employeeNameValue) {
        safeType(employeeNameInput, employeeNameValue);
  //      safeTakeScreenshot("selectEmployeeName_" + employeeNameValue);
        needToWait(3);
        safeClick(selectEmployeeOption);
        safeExplicitWait(statusDropdown, 10);
    }

    public void selectStatus() {
        safeClick(statusDropdown);
    //    safeTakeScreenshot("selectStatus");
        safeClick(enabledStatusOption);
        safeExplicitWait(usernameField, 10);
    }

    public void enterUsername(String usernameValue) {
        safeType(usernameField, usernameValue);
  //      safeTakeScreenshot("enterUsername_" + usernameValue);
        safeExplicitWait(passwordField, 10);
    }

    public void enterPassword(String passwordValue) {
        safeType(passwordField, passwordValue);
   //     safeTakeScreenshot("enterPassword");
        safeExplicitWait(confirmPasswordField, 10);
    }

    public void enterConfirmPassword(String confirmPasswordValue) {
        safeType(confirmPasswordField, confirmPasswordValue);
   //     safeTakeScreenshot("enterConfirmPassword");
        safeExplicitWait(saveButton, 10);
    }

    public void clickOnSaveButton() {
        safeClick(saveButton);
    //    safeTakeScreenshot("clickOnSaveButton");
        safeExplicitWait(usernameSearchField, 10);
        needToWait(8);
    }

    public void enterUsernameInSearchPanel(String username) {
        safeType(usernameSearchField, username);
  //      safeTakeScreenshot("enterUsernameInSearchPanel_" + username);
        safeExplicitWait(searchButton, 10);
    }

    public void clickOnSearchButton() {
        safeClick(searchButton);
  //      safeTakeScreenshot("clickOnSearchButton");
      safeExplicitWait(updateButton, 10);
    }

    public void clickOnUpdateButton() {
        safeClick(updateButton);
   //     safeTakeScreenshot("clickOnUpdateButton");
        needToWait(2);
    }

    public void clickOnBoxInUpdatePanel() {
        safeClick(updateCheckbox);
    //    safeTakeScreenshot("clickOnBoxInUpdatePanel");
        safeExplicitWait(updatePasswordField, 10);
    }

    public void changePasswordInUpdatePanel(String password) {
        safeType(updatePasswordField, password);
 //       safeTakeScreenshot("changePasswordInUpdatePanel");
        safeExplicitWait(updateConfirmPasswordField, 10);
    }

    public void confirmPasswordInUpdatePanel(String confirmPassword) {
        safeType(updateConfirmPasswordField, confirmPassword);
  //      safeTakeScreenshot("confirmPasswordInUpdatePanel");
        safeExplicitWait(saveButtonInUpdatePanel, 10);
    }

    public void clickOnSaveButtonInUpdatePanel() {
        safeClick(saveButtonInUpdatePanel);
  //      safeTakeScreenshot("clickOnSaveButtonInUpdatePanel");
        safeExplicitWait(deleteButton, 10);
    }

    public void clickOnDeleteButton() {
        safeClick(deleteButton);
    //    safeTakeScreenshot("clickOnDeleteButton");
        safeClick(confirmDeleteButton);
    //    safeTakeScreenshot("clickOnConfirmDeleteButton");
        needToWait(10);
    }
}
