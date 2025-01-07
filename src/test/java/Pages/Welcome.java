package Pages;

import Utils.PageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Welcome extends PageObject {

    @FindBy(id = "title-welcome-back")
    private WebElement titleWelcomeBack;

    public Welcome(WebDriver driver) {
        super(driver);
    }

    public boolean hasTitle() {
        return titleWelcomeBack.isDisplayed();
    }
}