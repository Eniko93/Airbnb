package tests;

import lombok.Getter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import utils.Browsers;
import utils.URLs;
import utils.WebBrowsers;
import org.openqa.selenium.WebDriver;

@Getter
public class BaseTest {

    private WebDriver driver;

    @BeforeClass
    public void setUp(){
        driver = WebBrowsers.getDriver(Browsers.CHROME);
        driver.get(URLs.BASE_URL);
    }

    @AfterClass
    public void quit() {
        driver.quit();
    }
}
