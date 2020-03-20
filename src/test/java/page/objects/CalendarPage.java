package page.objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utils.Utils;

import java.util.List;

public class CalendarPage extends BasePage {

    private static final String DAYS = "div[data-visible='true'] table[role='presentation'] tbody tr td[role='button']";

    @FindBy(how = How.CSS, using = DAYS)
    private List<WebElement> days;
    @FindBy(how = How.CSS, using = "._1h5uiygl")
    private WebElement nextMonthButton;

    public CalendarPage(WebDriver driver) {
        super(driver, ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector(DAYS)));
    }

    public HomePage parent() {
        return new HomePage(driver);
    }

    private void goToNextMonth() {
        nextMonthButton.click();
    }

    private void clickOnDate(Integer day) {
        days.stream().filter(d -> d.getText().equals(String.valueOf(day))).findFirst()
                .orElseThrow(() -> new RuntimeException("Day [" + day + "] was not found"))
                .click();
    }

    public CalendarPage clickOnCurrentDate() {
        Integer today = Utils.getCurrentDate();
        clickOnDate(today);

        return this;
    }

    public CalendarPage clickOnXDaysFromCurrentDate(Integer daysNumber) {
        Integer daysInTheMonth = days.size();
        Integer currentDate = Utils.getCurrentDate();
        Integer daysFromNow = currentDate + daysNumber;

        if (daysFromNow <= daysInTheMonth) {
            clickOnDate(daysFromNow);

        } else {
            goToNextMonth();
            waitUntil(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector(DAYS)));
            clickOnDate(daysFromNow % daysInTheMonth);
        }

        return this;
    }
}
