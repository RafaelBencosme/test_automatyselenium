package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Students {
    private final WebDriver driver;

    public Students(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "firstName")
    WebElement firstNameField;

    @FindBy(id = "lastName")
    WebElement lastNameField;

    @FindBy(id = "email")
    WebElement emailField;

    @FindBy(id = "phone")
    WebElement phoneField;

    @FindBy(css = "[id='\\:r8\\:']")
    WebElement birthDatePicker;

    @FindBy(id = "province-autocomplete")
    WebElement provincePicker;

    @FindBy(id = "register")
    WebElement register;

    @FindBy(xpath = "//*[contains(text(), 'Thanks for')]")
    WebElement registerConfirmation;

    public void fill(
            String firstName,
            String lastName,
            String email,
            String phone,
            String birthday,
            String province
    ) {
        this.firstNameField.sendKeys(firstName);
        this.lastNameField.sendKeys(lastName);
        this.emailField.sendKeys(email);
        this.phoneField.sendKeys(phone);
        WebElement birthDay = this.birthDatePicker;
        birthDay.click();
        birthDay.sendKeys(Keys.chord(Keys.CONTROL, "a"));
        birthDay.sendKeys(Keys.BACK_SPACE);
        birthDay.sendKeys(birthday);
        WebElement provinceSelect = this.provincePicker;
        provinceSelect.sendKeys("Santo Domingo");
        WebElement element = driver.findElement(By.xpath("//*[contains(text(), '" + province + "')]"));
        element.click();
    }

    public void selectRegister() {
        this.register.click();
    }

    public boolean hasRegisteredToast() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOf(registerConfirmation));
        return this.registerConfirmation.isDisplayed();
    }
}