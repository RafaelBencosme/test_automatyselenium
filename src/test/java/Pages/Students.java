package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Students {
    private final WebDriver driver;

    public Students(WebDriver driver) {
        this.driver = driver;
    }

    public void fill(
            String firstName,
            String lastName,
            String email,
            String phone,
            String birthday,
            String province
            ) {
        driver.findElement(By.id("firstName")).sendKeys(firstName);
        driver.findElement(By.id("lastName")).sendKeys(lastName);
        driver.findElement(By.id("email")).sendKeys(email);
        driver.findElement(By.id("phone")).sendKeys(phone);
        WebElement birthDay = driver.findElement(By.cssSelector("[id='\\:r8\\:']"));
        birthDay.click();
        birthDay.sendKeys(Keys.chord(Keys.CONTROL, "a")); // Select all
        birthDay.sendKeys(Keys.BACK_SPACE); // Clear
        birthDay.sendKeys(birthday);
        WebElement provinceSelect = driver.findElement(By.id("province-autocomplete"));
        provinceSelect.sendKeys("Santo Domingo");
        WebElement element = driver.findElement(By.xpath("//*[contains(text(), '" + province + "')]"));
        element.click();
    }

    public void selectRegister(){
        driver.findElement(By.id("register")).click();
    }

    public boolean hasRegisteredToast() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(), 'Thanks for')]")));
        return driver.findElement(By.xpath("//*[contains(text(), 'Thanks for')]")).isDisplayed();
    }
}