package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Login {
    private final WebDriver driver;

    public Login(WebDriver driver) {
        this.driver = driver;
    }

    public void signIn(String username, String password) {
        driver.findElement(By.id("username")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.id("sign-in")).click();
    }

    public boolean hasInvalidCredentials() {
        return driver.findElement(
                        By.xpath("//*[@id=\"root\"]/div/main/div/form/div/div/div/div[1]/div[2]"))
                .isDisplayed();
    }
}