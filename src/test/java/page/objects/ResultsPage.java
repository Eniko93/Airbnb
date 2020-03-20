package page.objects;

import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;

@Getter
public class ResultsPage extends BasePage {
    private static final String SELECTED_DATE = "#menuItemButton-date_picker button";

    @FindBy(how = How.CSS, using = SELECTED_DATE)
    private WebElement selectedDate;
    @FindBy(how = How.CSS, using = "#menuItemButton-guest_picker button")
    private WebElement selectedGuestNumber;
    @FindBy(how = How.ID, using = "menuItemButton-room_type")
    private WebElement typeOfPlace;

    public ResultsPage(WebDriver driver) {
        super(driver, ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector(SELECTED_DATE)));
    }
}
