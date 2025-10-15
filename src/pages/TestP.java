package pages;

import common.SafeAction;

public class TestP extends SafeAction {

    // Admin Module Elements
    String adminLeftPanel = "//span[text()='Admin']";
    String addButtonUnderAdminPage = "//Button[@class='oxd-button oxd-button--medium oxd-button--secondary']";
    String userRoleDropdown = "//input[@placeholder='Type for hints...']//preceding::i[1]";
    String selectAdminRole = "//div[@class='oxd-select-dropdown --positon-bottom']//span[text()='Admin']";
    String employeeNameField = "//input[@placeholder='Type for hints...']";
    String selectEmployee = "//input[@placeholder='Type for hints...']//following::span[1]";
    String statusDropdown = "//input[@placeholder='Type for hints...']//following::i";
    String selectStatusEnabled = "//div[@class='oxd-select-dropdown --positon-bottom']//span[text()='Enabled']";
    String usernameField = "//input[@placeholder='Type for hints...']//following::input[1]";
    String passwordField = "//input[@placeholder='Type for hints...']//following::input[2]";
    String confirmPasswordField = "//input[@placeholder='Type for hints...']//following::input[3]";
    String saveButton = "//button[@class='oxd-button oxd-button--medium oxd-button--secondary orangehrm-left-space']";

    // PIM Module Elements
    String pimLeftPanel = "//span[text()='PIM']";
    String addEmployeeButton = "//button[text()=' Add ']";
    String firstNameField = "//input[@name='firstName']";
    String lastNameField = "//input[@name='lastName']";
    String employeeIDField = "//label[text()='Employee Id']/following::input[1]";
    String saveEmployeeButton = "//button[text()=' Save ']";

    // Leave Module Elements
    String leaveLeftPanel = "//span[text()='Leave']";
    String applyLeaveButton = "//button[text()=' Apply ']";
    String leaveTypeDropdown = "//div[@class='oxd-select-text oxd-select-text--active']";
    String selectLeaveType = "//span[text()='CAN - Bereavement']";
    String leaveDescription = "//textarea[@placeholder='Comment']";
    String saveLeaveButton = "//button[text()=' Save ']";

    // Time Module Elements
    String timeLeftPanel = "//span[text()='Time']";
    String punchInButton = "//button[text()=' In ']";
    String punchOutButton = "//button[text()=' Out ']";

    // Recruitment Module Elements
    String recruitmentLeftPanel = "//span[text()='Recruitment']";
    String addCandidateButton = "//button[text()=' Add ']";
    String candidateFirstNameField = "//input[@name='firstName']";
    String candidateLastNameField = "//input[@name='lastName']";
    String candidateEmailField = "//input[@name='email']";
    String candidateResumeUpload = "//input[@type='file']";
    String candidateSaveButton = "//button[text()=' Save ']";

    // Admin Module Methods
    public void navigateToAdmin() {
        safeClick(adminLeftPanel);
        safeExplicitWait(addButtonUnderAdminPage, 10);
    }

    public void addAdminUser(String employeeName, String username, String password) {
        safeClick(addButtonUnderAdminPage);
        safeClick(userRoleDropdown);
        safeClick(selectAdminRole);
        safeType(employeeNameField, employeeName);
        safeClick(selectEmployee);
        safeClick(statusDropdown);
        safeClick(selectStatusEnabled);
        safeType(usernameField, username);
        safeType(passwordField, password);
        safeType(confirmPasswordField, password);
        safeClick(saveButton);
    }

    // PIM Module Methods
    public void navigateToPIM() {
        safeClick(pimLeftPanel);
        safeExplicitWait(addEmployeeButton, 10);
    }

    public void addEmployee(String firstName, String lastName, String empID) {
        safeClick(addEmployeeButton);
        safeType(firstNameField, firstName);
        safeType(lastNameField, lastName);
        safeType(employeeIDField, empID);
        safeClick(saveEmployeeButton);
    }

    // Leave Module Methods
    public void navigateToLeave() {
        safeClick(leaveLeftPanel);
        safeExplicitWait(applyLeaveButton, 10);
    }

    public void applyLeave(String description) {
        safeClick(applyLeaveButton);
        safeClick(leaveTypeDropdown);
        safeClick(selectLeaveType);
        safeType(leaveDescription, description);
        safeClick(saveLeaveButton);
    }

    // Time Module Methods
    public void navigateToTime() {
        safeClick(timeLeftPanel);
        safeExplicitWait(punchInButton, 10);
    }

    public void punchInOut() {
        safeClick(punchInButton);
        safeExplicitWait(punchOutButton, 10);
        safeClick(punchOutButton);
    }

    // Recruitment Module Methods
    public void navigateToRecruitment() {
        safeClick(recruitmentLeftPanel);
        safeExplicitWait(addCandidateButton, 10);
    }

    public void addCandidate(String firstName, String lastName, String email, String resumeFilePath) {
        safeClick(addCandidateButton);
        safeType(candidateFirstNameField, firstName);
        safeType(candidateLastNameField, lastName);
        safeType(candidateEmailField, email);
        safeClick(candidateSaveButton);
    }
}
