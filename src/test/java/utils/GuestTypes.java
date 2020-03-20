package utils;

import com.github.webdriverextensions.WebComponent;
import lombok.Getter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class GuestTypes extends WebComponent {
    @FindBy(how = How.CSS, using = "._mke2gl1")
    private WebElement guestType;
    @Getter
    @FindBy(how = How.CSS, using = "._1fb7ddvw")
    private GuestCounter counter;

    public String getGuestType() {
        return guestType.getText();
    }
}
