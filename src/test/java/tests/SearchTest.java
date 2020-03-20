package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import page.objects.HomePage;
import page.objects.ResultsPage;
import utils.URLs;
import utils.Utils;

public class SearchTest extends BaseTest {
    @Test(description = "Serach for a location and verify check Date and Guest number.")
    public void searchLocation() {
        getDriver().get(URLs.BASE_URL);

        new HomePage(getDriver())
                .searchLocation("Alicante, Spain")
                .clickCheckInField()
                .clickOnCurrentDate()
                .clickOnXDaysFromCurrentDate(5)
                .parent()
                .clickGuestButton()
                .selectGuestTypeAndNumber("Adults", 3)
                .selectGuestTypeAndNumber("Children", 5)
                .saveFilters()
                .search();

        String expectedStartDate = String.valueOf(Utils.getCurrentDate());
        String expectedEndDate = String.valueOf(Utils.getCurrentDate() + 5);

        Assert.assertTrue(new ResultsPage(getDriver()).getSelectedDate().getText().contains(expectedStartDate), "The selected date doesn't contains the expectedStartDate");
        Assert.assertTrue(new ResultsPage(getDriver()).getSelectedDate().getText().contains(expectedEndDate), "The selected date doesn't contains the expectedEndDate");
        Assert.assertEquals(new ResultsPage(getDriver()).getSelectedGuestNumber().getText(), "8 guests", "The number of guests is not 8");
    }
}
