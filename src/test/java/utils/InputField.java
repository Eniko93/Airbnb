package utils;

import com.github.webdriverextensions.WebComponent;

public class InputField extends WebComponent {

    public void fillIn(String text) {
        getWrappedWebElement().clear();
        getWrappedWebElement().sendKeys(text);
    }
}
