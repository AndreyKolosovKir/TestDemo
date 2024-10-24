package tests.AddNewWorkflow;

import org.junit.jupiter.api.Test;
import tests.base.BaseTest;

import static constants.Constant.Credentials.PASSWORD;
import static constants.Constant.Credentials.USER_NAME;
import static constants.Constant.URLs.AUTH_HOME_PAGE;

public class AddNewWorkflowTest extends BaseTest {

    @Test
    public void addNewWorkflowTest() throws InterruptedException {
        basePage.open(AUTH_HOME_PAGE);
        Thread.sleep(2000);
        authorizationVisary.clickLogin(USER_NAME, PASSWORD);
        Thread.sleep(2000);
        visaryHomePage.clickWorkflow();
        Thread.sleep(2000);
        workflowPage
                .clickWorkflowPage()
                .clickAddWorkflowObject()
                .fillingInTheFields()
                .saveWorkflowObject()
                .updatePage();
        Thread.sleep(2000);
        workflowPage.checkNewWorkflow();

        Thread.sleep(2000);
        System.out.println("Тест по добавлению workflow - true");
    }
}
