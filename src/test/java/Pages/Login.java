package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login {
    private final WebDriver driver;

    public Login(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "username")
    WebElement usernameField;

    @FindBy(id = "password")
    WebElement passwordField;

    @FindBy(id = "sign-in")
    WebElement signIn;

    @FindBy(xpath = "//*[@id=\"root\"]/div/main/div/form/div/div/div/div[1]/div[2]")
    WebElement invalidCredentialsHelper;


    public void signIn(String username, String password) {
        this.usernameField.sendKeys(username);
        this.passwordField.sendKeys(password);
        this.signIn.click();
    }

    public boolean hasInvalidCredentials() {
        return this.invalidCredentialsHelper.isDisplayed();
    }
}