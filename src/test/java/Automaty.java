import com.google.common.truth.Truth;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

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
        driver.findElement(By.id("username")).sendKeys("admin");
        driver.findElement(By.id("password")).sendKeys("admin");
        driver.findElement(By.id("sign-in")).click();

        Truth.assertThat(driver.findElement(By.id("title-welcome-back")).isDisplayed()).isTrue();
    }

    @Test
    public void withIncorrectCredentials_clicksSignIn_shouldntBeAbleToLogin() {
        driver.findElement(By.id("username")).sendKeys("admint");
        driver.findElement(By.id("password")).sendKeys("admint");
        driver.findElement(By.id("sign-in")).click();

        Truth.assertThat(driver.findElement(By.xpath("//*[@id=\"root\"]/div/main/div/form/div/div/div/div[1]/div[2]"))
                .isDisplayed()).isTrue();
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

        Truth.assertThat(driver.findElement(By.xpath("//*[contains(text(), 'Thanks for')]")).isDisplayed());
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}