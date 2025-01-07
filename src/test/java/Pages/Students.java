package Pages;

import Utils.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Students extends PageObject {

    @FindBy(id = "firstName")
    private WebElement firstNameField;

    @FindBy(id = "lastName")
    private WebElement lastNameField;

    @FindBy(id = "email")
    private WebElement emailField;

    @FindBy(id = "phone")
    private WebElement phoneField;

    @FindBy(css = "[id='\\:r8\\:']")
    private WebElement birthDatePicker;

    @FindBy(id = "province-autocomplete")
    private WebElement provincePicker;

    @FindBy(id = "register")
    private WebElement register;

    @FindBy(xpath = "//*[contains(text(), 'Thanks for')]")
    private WebElement registerConfirmation;

    public Students(WebDriver driver) {
       super(driver);
    }

    public void fill(
            String firstName,
            String lastName,
            String email,
            String phone,
            String birthday,
            String province
    ) {
        firstNameField.sendKeys(firstName);
        lastNameField.sendKeys(lastName);
        emailField.sendKeys(email);
        phoneField.sendKeys(phone);
        WebElement birthDay = birthDatePicker;
        birthDay.click();
        birthDay.sendKeys(Keys.chord(Keys.CONTROL, "a"));
        birthDay.sendKeys(Keys.BACK_SPACE);
        birthDay.sendKeys(birthday);
        WebElement provinceSelect = provincePicker;
        provinceSelect.sendKeys("Santo Domingo");
        WebElement element = driver.findElement(By.xpath("//*[contains(text(), '" + province + "')]"));
        element.click();
    }

    public void selectRegister() {
        register.click();
    }

    public boolean hasRegisteredToast() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOf(registerConfirmation));
        return registerConfirmation.isDisplayed();
    }
}