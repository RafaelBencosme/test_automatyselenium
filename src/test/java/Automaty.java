import Components.SideBar;
import Pages.Login;
import Pages.Students;
import Pages.Welcome;
import Utils.BaseTest;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.google.common.truth.Truth.assertThat;

public class Automaty extends BaseTest {
    private Login logIn;

    @BeforeMethod
    @Override
    public void setup() {
            super.setup();
            logIn = new Login(driver);
    }

    @Test
    public void withCorrectCredentials_clicksSignIn_shouldBeAbleToLogin() {
        logIn.signIn("admin", "admin");

        var welcome = new Welcome(driver);
        assertThat(welcome.hasTitle()).isTrue();
    }

    @Test
    public void withIncorrectCredentials_clicksSignIn_shouldntBeAbleToLogin() {
        logIn.signIn("admint", "admint");

        assertThat(logIn.hasInvalidCredentials()).isTrue();
    }

    @Test
    public void whenNavigatingToStudentForm_withCorrectInformation_shouldBeAbleToRegister() {
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
    @Override
    public void tearDown() {
       super.tearDown();
    }
}