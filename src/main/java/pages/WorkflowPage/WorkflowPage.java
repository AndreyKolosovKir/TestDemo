package pages.WorkflowPage;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.base.BasePage;

import java.util.Stack;

import static constants.Constant.NewWorkflow.WORKFLOW_TITLE;

public class WorkflowPage extends BasePage {
    public WorkflowPage(WebDriver driver) {
        super(driver);
    }

    protected Stack<String> testTitleForCheck = new Stack<>();
    //раздел с бп
    private final By workflowSetting = By.cssSelector("body > div.app.app-module > div > div > div > nav > section > ul > li:nth-child(1) > a");
    //кнопка добавления
    private final By buttonAddWorkflow = By.cssSelector("body > div.app.app-module > div > main > div > div > div > div > div.ba-h-full.vis-grid > div.ba-h-full.dx-widget.dx-visibility-change-handler > div > div.dx-datagrid-header-panel > div > div > div.dx-toolbar-before > div:nth-child(2) > div > div > div");

    private final By title = By.xpath("//*[@id[starts-with(., 'dx_dx') and substring(., string-length()-string-length('_Title')+1)='_Title'] and @name='Title']");
    private final By typeWorkflow = By.cssSelector(".dx-show-invalid-badge.dx-selectbox.dx-textbox.dx-texteditor.dx-dropdowneditor-button-visible.dx-editor-outlined.dx-widget.dx-texteditor-empty.dx-dropdowneditor.dx-dropdowneditor-field-clickable.dx-validator.dx-visibility-change-handler");
    private final By typeObject = By.xpath("//input[@autocomplete='off' and @class='dx-texteditor-input' and @aria-haspopup='listbox' and @aria-autocomplete='list' and @type='text' and @spellcheck='false' and @tabindex='0' and @role='combobox' and @aria-expanded='false' and @aria-required='true']");
    private final By typeWorkflowIsBasic = By.cssSelector(".pr-2.fas.fa-file-circle-check");
    //выбрал из списка определенный вариант
    private final By typeObjectList = By.xpath("//div[text()='AccountAndGroupsMembershipContainer']");
    private final By buttonSaveWorkflow = By.cssSelector(".dx-widget.dx-button.dx-button-mode-contained.dx-button-success.dx-button-has-text");
    private final By titleWorkflowForCheck = By.xpath("(//td[@aria-describedby='dx-col-1'])[last()]");

    private final By buttonUpdate = By.xpath("//div[@title='Обновить']");

    public WorkflowPage clickWorkflowPage() {
        WebElement element = driver.findElement(workflowSetting);
        waitElementIsVisible(element);
        element.click();
        return this;
    }

    public WorkflowPage clickAddWorkflowObject() {
        WebElement element = driver.findElement(buttonAddWorkflow);
        waitElementIsVisible(element);
        element.click();
        return this;
    }

    public WorkflowPage fillingInTheFields() {
        //нашли поле с названием
        WebElement elementTitle = driver.findElement(title);
        waitElementIsVisible(elementTitle);

        testTitleForCheck.push(addNumberForTitle(WORKFLOW_TITLE));
        //заполнили
        elementTitle.sendKeys(testTitleForCheck.peek());
        //нажали тип
        WebElement elementTypeWorkflow = driver.findElement(typeWorkflow);
        waitElementIsVisible(elementTypeWorkflow);
        elementTypeWorkflow.click();
        //выбрали  основной тип
        WebElement elementTypeBasic = driver.findElement(typeWorkflowIsBasic);
        waitElementIsVisible(elementTypeBasic);
        elementTypeBasic.click();
        //нажали тип объекта
        WebElement elementTypeObject = driver.findElement(typeObject);
        waitElementIsVisible(elementTypeObject);
        elementTypeObject.click();
        //выюрали тип объектта
        WebElement elementTypeObjectList = driver.findElement(typeObjectList);
        waitElementIsVisible(elementTypeObjectList);
        elementTypeObjectList.click();

        return this;
    }

    public WorkflowPage saveWorkflowObject() {
        WebElement elementSave = driver.findElement(buttonSaveWorkflow);
        elementSave.click();
        return this;
    }

    public WorkflowPage updatePage (){
        WebElement elementUpdate = driver.findElement(buttonUpdate);
        elementUpdate.click();
        return this;
    }

    public WorkflowPage checkNewWorkflow() {
        WebElement elementNewWorkflow = driver.findElement(titleWorkflowForCheck);
        waitElementIsVisible(elementNewWorkflow);
        Assertions.assertEquals(testTitleForCheck.peek(), elementNewWorkflow.getText());
        //Проверка результата (не обязательно, чистоо для себя)
        System.out.println(testTitleForCheck.peek() + "//" + elementNewWorkflow.getText());
        return this;
    }


}
