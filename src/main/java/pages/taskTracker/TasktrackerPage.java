package pages.taskTracker;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.base.BasePage;
import pages.projects.ProjectsPage;

public class TasktrackerPage extends BasePage {
    public TasktrackerPage(WebDriver driver) {
        super(driver);
    }

    private final By buttonProject = By.xpath("//span[text()='Проекты']");

    public TasktrackerPage clickProject() {
        WebElement webElement = driver.findElement(buttonProject);
        webElement.click();
        return this;
    }
}
