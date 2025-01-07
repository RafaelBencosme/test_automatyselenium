import Components.SideBar;
import Pages.Login;
import Pages.Students;
import Pages.Welcome;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.google.common.truth.Truth.assertThat;

public class Automaty {
    private Login logIn;
    private SideBar sideBar;
    private Students students;
    private WebDriver driver;
    private Welcome welcome;


    @BeforeMethod
    public void setup() {
        driver = new ChromeDriver();
        logIn = new Login(driver);
        sideBar = new SideBar(driver);
        students = new Students(driver);
        welcome = new Welcome(driver);
    }

    @Test
    public void withCorrectCredentials_clicksSignIn_shouldBeAbleToLogin() {
        logIn.signIn("admin", "admin");

        assertThat(welcome.hasTitle()).isTrue();
    }

    @Test
    public void withIncorrectCredentials_clicksSignIn_shouldntBeAbleToLogin() {
        logIn.signIn("admint", "admint");

        assertThat(logIn.hasInvalidCredentials()).isTrue();
    }

    @Test
    public void whenNavigatingToStudentForm_withCorrectInformation_shouldBeAbleToRegister() {
        sideBar.selectStudents();

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