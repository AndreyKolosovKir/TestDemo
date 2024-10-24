package tests.base;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.TestInstance;
import pages.AuthorizationVisary.AuthorizationVisary;
import pages.VisaryHomePage.VisaryHomePage;
import pages.WorkflowPage.WorkflowPage;
import pages.bi.RegistryPage;
import tests.common.CommonActions;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import pages.base.BasePage;
import tests.exportReport.ExportReportDemoTest;

import static common.Config.CLEAR_COOKIES_AND_STORAGE;
import static common.Config.HOLD_BROUSER_OPEN;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class BaseTest {

    protected WebDriver driver = CommonActions.cteateDriver();

    protected BasePage basePage = new BasePage(driver);
    protected AuthorizationVisary authorizationVisary = new AuthorizationVisary(driver);
    protected VisaryHomePage visaryHomePage = new VisaryHomePage(driver);

    protected WorkflowPage workflowPage = new WorkflowPage(driver);

    protected RegistryPage registryPage = new RegistryPage(driver);

    @AfterEach
    public void clearCookiesAndLocalStorage() {
        if (CLEAR_COOKIES_AND_STORAGE) {
            JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
            driver.manage().deleteAllCookies();
            javascriptExecutor.executeScript("window.sessionStorage.clear()");

        }
    }

    @AfterAll //будет обязательно выполняться в конце
    public void close() {
        if (HOLD_BROUSER_OPEN) {
            driver.quit();
        }
    }
}
