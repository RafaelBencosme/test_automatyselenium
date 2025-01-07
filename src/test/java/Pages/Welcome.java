package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Welcome {
    private final WebDriver driver;

    public Welcome(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "title-welcome-back")
    WebElement titleWelcomeBack;

    public boolean hasTitle() {
        return this.titleWelcomeBack.isDisplayed();
    }
}