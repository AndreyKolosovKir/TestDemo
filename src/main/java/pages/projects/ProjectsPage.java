package pages.projects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.base.BasePage;

import java.util.Stack;

import static constants.Constant.NewWorkflow.DATE_FOR_OBJECT;
import static constants.Constant.NewWorkflow.WORKFLOW_TITLE;

public class ProjectsPage extends BasePage {
    public ProjectsPage(WebDriver driver) {
        super(driver);
    }

    protected Stack<String> testTitleForCheck = new Stack<>();
    private String titleTest;
    private final By buttonPlusProjject = By.xpath("//div[@class='dx-button-content']/i[@class='dx-icon far fa-plus-circle']");
    private final By title = By.xpath("//div[@class='dx-show-invalid-badge dx-textbox dx-texteditor dx-editor-outlined dx-texteditor-empty dx-widget dx-validator dx-visibility-change-handler']");
    private final By statusPublic = By.xpath("//div[text()='Публичный']");
    private final By dateStart = By.xpath("//div[@class='dx-datebox dx-textbox dx-texteditor dx-show-clear-button dx-dropdowneditor-button-visible dx-editor-outlined dx-texteditor-empty dx-widget dx-visibility-change-handler dx-dropdowneditor dx-datebox-date dx-datebox-calendar']/div/div/div/div[@class='dx-placeholder']");
    private final By dateExit = By.xpath("(//div[@class='dx-widget dx-button-mode-contained dx-button-normal dx-dropdowneditor-button' and @aria-label='Выбрать']/div/div[@class='dx-dropdowneditor-icon'])[8]");
    private final By dateForExit = By.xpath("//td[@class='dx-calendar-cell' and contains(@data-value, '2024/11/06') and contains(@aria-label, 'среда, 6 ноября 2024 г.')]");
    private final By saveAndClose = By.xpath("//span[text()='Сохранить и закрыть']");
    private final By objectTest = By.xpath("//tg[@title='" + titleTest + "']");
    private final By buttonDelete = By.xpath("//div[@class='dx-widget dx-button dx-button-mode-contained dx-button-normal dx-button-has-icon' and contains(@title, 'Удалить')]");

    private final By buttonYes = By.xpath("//div[contains(@aria-label, 'Да') and @class='dx-widget dx-button dx-button-mode-contained dx-button-default dx-button-has-text']");

    public ProjectsPage putProject() {
        WebElement webElement = driver.findElement(buttonPlusProjject);
        webElement.click();
        return this;
    }

    public ProjectsPage fillInTheDetails() throws InterruptedException {
        WebElement titleElement = driver.findElement(title);
        waitElementIsVisible(titleElement);
        titleTest = addNumberForTitle(WORKFLOW_TITLE);
        //testTitleForCheck.push(addNumberForTitle(WORKFLOW_TITLE));
        titleElement.sendKeys(titleTest);

        WebElement status = driver.findElement(statusPublic);
        waitElementIsVisible(status);
        status.click();

        WebElement dateStartElement = driver.findElement(dateStart);
        waitElementIsVisible(dateStartElement);
        dateStartElement.sendKeys(DATE_FOR_OBJECT);

        WebElement dateExitElement = driver.findElement(dateExit);
        waitElementIsVisible(dateExitElement);
        dateExitElement.click();
        WebElement dateForExitElement = driver.findElement(dateForExit);
        waitElementIsVisible(dateForExitElement);
        dateForExitElement.click();

        return this;
    }

    public ProjectsPage saveObject() {
        WebElement save = driver.findElement(saveAndClose);
        save.click();
        return this;
    }

    public ProjectsPage deleteObject() {
        WebElement testObjectElement = driver.findElement(objectTest);
        waitElementIsVisible(testObjectElement);
        testObjectElement.click();

        WebElement deleteElement = driver.findElement(buttonDelete);
        waitElementIsVisible(deleteElement);
        deleteElement.click();
        WebElement yesElement = driver.findElement(buttonYes);
        waitElementIsVisible(yesElement);
        yesElement.click();
        return this;
    }

}
