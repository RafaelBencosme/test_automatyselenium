import Components.SideBar;
import Pages.Login;
import Pages.Students;
import Pages.Welcome;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

import static com.google.common.truth.Truth.assertThat;

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
    public void whenNavigatingToStudentForm_withCorrectInformation_shouldBeAbleToRegister(){
        driver.findElement(By.xpath("//*[@id=\"menu-students\"]/div/div[2]/span")).click();

        var sideBar = new SideBar(driver);
        sideBar.selectStudents();

        var students = new Students(driver);
        students.fill(
                "rafa",
                "benco",
                "rafa@rafa.rafa",
                "809-220-1111",
                "09-27-1995",
                "Santo Domingo"
        );

        students.selectRegister();

        assertThat(students.hasRegisteredToast()).isTrue();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}