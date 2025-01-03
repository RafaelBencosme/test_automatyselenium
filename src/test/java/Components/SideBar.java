package Components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SideBar {
    private final WebDriver driver;

    public SideBar(WebDriver driver) {
        this.driver = driver;
    }

    public void selectStudents() {
        driver.findElement(By.xpath("//*[@id=\"menu-students\"]/div/div[2]/span")).click();
    }
}