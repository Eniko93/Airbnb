package page.objects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class HomePage extends BasePage {
    private static final String SEARCH_BUTTON = "button[type='submit']";

    @FindBy(how = How.CSS, using = SEARCH_BUTTON)
    private WebElement searchButton;
    @FindBy(how = How.CSS, using = "li._1g2dfiu")
    private WebElement languageAndRegion;
    @FindBy(how = How.CSS, using = "._1fy05hv")
    private List<WebElement> languages;
    @FindBy(how = How.CSS, using = "li:nth-of-type(2)")
    private WebElement currency;
    @FindBy(how = How.ID, using = "Koan-magic-carpet-koan-search-bar__input")
    private utils.InputField whereField;
    @FindBy(how = How.ID, using = "checkin_input")
    private WebElement checkInField;
    @FindBy(how = How.ID, using = "lp-guestpicker")
    private WebElement guestPickerButton;

    public HomePage(WebDriver webDriver) {
        super(webDriver, ExpectedConditions.visibilityOfElementLocated(By.cssSelector(SEARCH_BUTTON)));
    }

    public boolean isSearchFormDisplayed() {
        return searchButton.isDisplayed();
    }

    public HomePage selectLanguage(String language) {
        languageAndRegion.click();
        waitUntil(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("._1oowfvr")));
        findLanguageOrCurrencyByName(language).click();

        return new HomePage(driver);
    }

    public HomePage selectCurrency(String value) {
        currency.click();
        waitUntil(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("._1oowfvr")));
        findLanguageOrCurrencyByName(value).click();
        waitUntil(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("._1oowfvr")));

        return new HomePage(driver);
    }

    public HomePage searchLocation(String value) {
        whereField.fillIn(value);
        whereField.sendKeys(Keys.ENTER);

        return this;
    }

    public CalendarPage clickCheckInField() {
        checkInField.click();

        return new CalendarPage(driver);
    }

    public GuestPage clickGuestButton() {
        guestPickerButton.click();

        return new GuestPage(driver);
    }

    public ResultsPage search() {
        searchButton.click();

        return new ResultsPage(driver);
    }

    private WebElement findLanguageOrCurrencyByName(String value) {
        return languages.stream().filter(a -> a.getText().contains(value)).findAny()
                .orElseThrow(() -> new RuntimeException("Language with name [" + value + "] not found."));
    }

    public String getSelectedLanguage() {
        return languageAndRegion.getText();
    }

    public String getSelectedCurrency() {
        return currency.getText();
    }
}
