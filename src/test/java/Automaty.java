import com.google.common.truth.Truth;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
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
        public void withCorrectCredentials_clicksSignIn_shouldBeAbleToLogin(){
            driver.findElement(By.id("username")).sendKeys("admin");
            driver.findElement(By.id("password")).sendKeys("admin");
            driver.findElement(By.id("sign-in")).click();

            Truth.assertThat(driver.findElement(By.id("title-welcome-back")).isDisplayed()).isTrue();
        }

        @Test
        public void withIncorrectCredentials_clicksSignIn_shouldntBeAbleToLogin(){
            driver.findElement(By.id("username")).sendKeys("admint");
            driver.findElement(By.id("password")).sendKeys("admint");
            driver.findElement(By.id("sign-in")).click();

            Truth.assertThat(driver.findElement(By.xpath("//*[@id=\"root\"]/div/main/div/form/div/div/div/div[1]/div[2]"))
                    .isDisplayed()).isTrue();
        }

        @AfterMethod
        public void tearDown(){
            driver.quit();
        }
    }