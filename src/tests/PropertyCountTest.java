
package tests;

import org.testng.annotations.Test;
import common.BaseSetup;
import pages.PropertyCountPage;

public class PropertyCountTest extends BaseSetup {


    @Test(priority = 1)
    public void verifyQuickSearchFunctionality() throws Exception {
        PropertyCountPage propertyCountPage = new PropertyCountPage(BaseSetup.driver);
        propertyCountPage.clickOnBuy();
        propertyCountPage.clickOnMyRequirementField();
        propertyCountPage.selectValueMyRequirement();
        propertyCountPage.getNumberOfProperties();
        propertyCountPage.clickDashboard();
        propertyCountPage.sumAllBedAndStudioCounts();
        //clickDashboardAndSumProperties

        // Add your test steps here
    }
}
