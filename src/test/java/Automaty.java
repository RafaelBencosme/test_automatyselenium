import Pages.Login;
import Pages.Welcome;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.google.common.truth.Truth.assertThat;


import java.time.Duration;

public class Automaty {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("https://automaty-gd3cb.ondigitalocean.app/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @Test
    public void withCorrectCredentials_clicksSignIn_shouldBeAbleToLogin() {
        var logIn = new Login(driver);
        logIn.signIn("admin", "admin");

        var welcome = new Welcome(driver);
        assertThat(welcome.hasTitle()).isTrue();
    }

    @Test
    public void withIncorrectCredentials_clicksSignIn_shouldntBeAbleToLogin() {
        var logIn = new Login(driver);
        logIn.signIn("admint", "admint");

        assertThat(logIn.hasInvalidCredentials()).isTrue();
    }

    @Test
    public void whenNavigatingToStudentForm_withCorrectInformation_shouldBeAbleToRegister() throws InterruptedException {
        driver.findElement(By.xpath("//*[@id=\"menu-students\"]/div/div[2]/span")).click();
        driver.findElement(By.id("firstName")).sendKeys("rafa");
        driver.findElement(By.id("lastName")).sendKeys("benco");
        driver.findElement(By.id("email")).sendKeys("rafa@rafa.rafa");
        driver.findElement(By.id("phone")).sendKeys("809-220-1111");


        WebElement birthDay = driver.findElement(By.cssSelector("[id='\\:r8\\:']"));
        birthDay.click();
        birthDay.sendKeys(Keys.chord(Keys.CONTROL, "a")); // Select all
        birthDay.sendKeys(Keys.BACK_SPACE); // Clear
        birthDay.sendKeys("09-27-1995");

        WebElement province = driver.findElement(By.id("province-autocomplete"));
        province.sendKeys("Santo Domingo");
        WebElement element = driver.findElement(By.xpath("//*[contains(text(), 'Santo Domingo')]"));
        element.click();

        driver.findElement(By.id("register")).click();

        assertThat(driver.findElement(By.xpath("//*[contains(text(), 'Thanks for')]")).isDisplayed()).isTrue();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}