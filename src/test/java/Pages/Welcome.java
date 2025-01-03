package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Welcome {
    private final WebDriver driver;

    public Welcome(WebDriver driver) {
        this.driver = driver;
    }

    public boolean hasTitle() {
        return driver.findElement(By.id("title-welcome-back")).isDisplayed();
    }
}