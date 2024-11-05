package tests.saveAndDeleteProject;

import org.junit.jupiter.api.Test;
import tests.base.BaseTest;

import static constants.Constant.Credentials.PASSWORD;
import static constants.Constant.Credentials.USER_NAME;
import static constants.Constant.URLs.AUTH_HOME_PAGE;

public class SaveAndDeleteProjectTest extends BaseTest {

    @Test
    public void saveProject() throws InterruptedException {
        basePage.open(AUTH_HOME_PAGE);
        Thread.sleep(2000);
        authorizationVisary.clickLogin(USER_NAME, PASSWORD);
        Thread.sleep(2000);
        visaryHomePage.clickTasKTracker();
        Thread.sleep(2000);
        tasktrackerPage.clickProject();
        Thread.sleep(2000);
        projectsPage.putProject().fillInTheDetails().saveObject();
    }

    @Test
    public void deleteProject() throws InterruptedException {
        basePage.open(AUTH_HOME_PAGE);
        Thread.sleep(2000);
        authorizationVisary.clickLogin(USER_NAME, PASSWORD);
        Thread.sleep(2000);
        visaryHomePage.clickTasKTracker();
        Thread.sleep(2000);
        tasktrackerPage.clickProject();
        Thread.sleep(2000);
        projectsPage.deleteObject();
    }
}
