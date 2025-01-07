package Pages;

import Utils.PageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Login extends PageObject {

    @FindBy(id = "username")
    private WebElement usernameField;

    @FindBy(id = "password")
    private WebElement passwordField;

    @FindBy(id = "sign-in")
    private WebElement signIn;

    @FindBy(xpath = "//*[@id=\"root\"]/div/main/div/form/div/div/div/div[1]/div[2]")
    private WebElement invalidCredentialsHelper;

    public Login(WebDriver driver) {
        super(driver);
    }

    public void signIn(String username, String password) {
        this.usernameField.sendKeys(username);
        this.passwordField.sendKeys(password);
        this.signIn.click();
    }

    public boolean hasInvalidCredentials() {
        return this.invalidCredentialsHelper.isDisplayed();
    }
}