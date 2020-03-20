package page.objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utils.GuestTypes;

import java.util.List;

public class GuestPage extends BasePage {

    @FindBy(how = How.CSS, using = "div[role='group'] ._hgs47m")
    private List<GuestTypes> guestTypes;
    @FindBy(how = How.CSS, using = "#filter-panel-save-button button")
    private WebElement saveButton;

    public GuestPage(WebDriver driver) {
        super(driver, ExpectedConditions.presenceOfElementLocated(By.cssSelector("._9cfq872")));
    }

    public GuestPage selectGuestTypeAndNumber(String type, Integer number) {
        getGuestByType(type).getCounter().incrementCounter(number);

        return this;
    }

    public HomePage saveFilters() {
        saveButton.click();

        return new HomePage(driver);
    }

    private GuestTypes getGuestByType(String type) {
        return guestTypes.stream().filter(t -> t.getGuestType().contains(type)).findFirst()
                .orElseThrow(() -> new RuntimeException("Guest type [" + type + "] not found."));
    }
}
