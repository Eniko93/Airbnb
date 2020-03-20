package utils;

import com.github.webdriverextensions.WebComponent;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class GuestCounter extends WebComponent {
    @FindBy(how = How.CSS, using = "._7eamzqx")
    private WebElement decrementButton;
    @FindBy(how = How.CSS, using = "._zac1rbz ._1p3joamp")
    private WebElement countResult;
    @FindBy(how = How.CSS, using = "._1a72ixey button")
    private WebElement incrementButton;

    public void decrementCounter(Integer count) {
        for (int i = 0; i < count; i++) {
            decrementButton.click();
        }
    }

    public void incrementCounter(Integer count) {
        for (int i = 0; i < count; i++) {
            incrementButton.click();
        }
    }

    public String getCountResult() {
        return countResult.getText();
    }
}
