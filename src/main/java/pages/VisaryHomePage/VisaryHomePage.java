package pages.VisaryHomePage;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.base.BasePage;
import pages.bi.RegistryPage;
import pages.taskTracker.TasktrackerPage;

import static constants.Constant.Credentials.USER_NAME;

public class VisaryHomePage extends BasePage {

    public VisaryHomePage(WebDriver driver) {
        super(driver);
    }
    //иконка юзера
    private final By imgToUser = By.cssSelector("#__BVID__39__BV_button_ > div > div.ba-flex.ba-items-center.ba-mr-2 > figure > img");
    //кнопка workflow
    private final By buttonWorkflow = By.xpath("//span[text()='Workflow']");
    //кнопка bi
    private final By buttonBi = By.xpath("//*[@id=\"vis-app-module-menu__item_0\"]");

    //TODO Есть проблема с этим xpath, дальше хз, возможно остальные по осохранению и удалению объекта тоже будут проблемными
    private final By  buttonTaskTracker = By.xpath("//a[@href='/tasktracker']");

    public VisaryHomePage checkUser (){

        WebElement userImageElement = driver.findElement(imgToUser);
        waitElementIsVisible(userImageElement);
        String name = userImageElement.getAttribute("title");
        Assertions.assertEquals(name, USER_NAME);
        return this;
    }

    public VisaryHomePage clickWorkflow(){
        WebElement workflowElement = driver.findElement(buttonWorkflow);
        waitElementIsVisible(workflowElement);
        workflowElement.click();
        return this;
    }

    public VisaryHomePage clickButtonBi (){
        WebElement bi = driver.findElement(buttonBi);
        waitElementIsVisible(bi);
        bi.click();
        return this;
    }

    public VisaryHomePage clickTasKTracker (){
        WebElement webElement = driver.findElement(buttonTaskTracker);
        webElement.click();
        return this;
    }
}
