package Utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public abstract class PageObject {
    protected WebDriver driver;

    public PageObject(WebDriver driver) {
        this.driver = driver;
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
        driver.get("https://automaty-gd3cb.ondigitalocean.app/");
        PageFactory.initElements(driver, this);
    }
}