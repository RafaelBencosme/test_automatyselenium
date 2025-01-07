package Components;

import Utils.PageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SideBar extends PageObject {

    @FindBy(xpath = "//*[@id=\"menu-students\"]/div/div[2]/span")
    private WebElement sidebarStudents;

    public SideBar(WebDriver driver) {
        super(driver);
    }

    public void selectStudents() {
        this.sidebarStudents.click();
    }
}