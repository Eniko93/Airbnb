package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import page.objects.HomePage;


public class HomePageTest extends BaseTest {
    @Test(description = "Should navigate to Airbnb home page")
    public void goToAirbnbPage() {

        Assert.assertTrue(new HomePage(getDriver()).isSearchFormDisplayed());
    }

    @Test(description = "Select language")
    public void selectLanguage() {
        new HomePage(getDriver())
                .selectLanguage("Deutsch");

        Assert.assertTrue(new HomePage(getDriver()).getSelectedLanguage().contains("Deutsch (DE)"), "The selected language is not german");
    }

    @Test(description = "Select currency")
    public void selectCurrency() {
        new HomePage(getDriver())
                .selectCurrency("Canadian dollar");

        Assert.assertTrue(new HomePage(getDriver()).getSelectedCurrency().contains("$ CAD"), "The selected currency is not canadian dollar");
    }
}
