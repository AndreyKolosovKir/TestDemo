package pages.bi;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import pages.base.BasePage;

import static constants.Constant.PathsAndFiles.NAME_REPORT_FOR_EXPORT;

public class RegistryPage extends BasePage {
    public RegistryPage(WebDriver driver) {
        super(driver);
    }

    private final By buttonRegistry = By.xpath("//a[@href='/bi/registry' and @class='nav-link']");

    private final By demoReport = By.xpath("//td[text()='" + NAME_REPORT_FOR_EXPORT + "']");

    //TODO
    private final By buttonExport = By.cssSelector(".dxrd-preview-export-menu-item.dx-template-wrapper.dx-item-content.dx-menu-item-content");

    private final By xlsxEx = By.xpath("//div[@class='dxrd-preview-export-menu-item dx-template-wrapper dx-item-content dx-menu-item-content' and @title='XLSX']");

    public RegistryPage clickRegistry() {
        WebElement registry = driver.findElement(buttonRegistry);
        waitElementIsVisible(registry);
        registry.click();
        return this;
    }

    public RegistryPage doubleClickReport() {
        WebElement report = driver.findElement(demoReport);
        waitElementIsVisible(report);
        Actions actions = new Actions(driver);
        actions.doubleClick(report).perform(); //perform - выполняет все действия в Actions
        return this;
    }

    public RegistryPage getDropDownListOfFormatsForExport() {
        waitElementIsVisibleAndClickRetry(buttonExport);
        return this;
    }


    public RegistryPage selectExportFormat() {
        WebElement elementXlsx = driver.findElement(xlsxEx);
        waitElementIsVisible(elementXlsx);
        elementXlsx.click();
        return this;
    }


}
