package tests.exportReport;

import org.junit.jupiter.api.Test;
import tests.base.BaseTest;

import static constants.Constant.Credentials.PASSWORD;
import static constants.Constant.Credentials.USER_NAME;
import static constants.Constant.PathsAndFiles.DOWNLOAD_FILE_PATH;
import static constants.Constant.PathsAndFiles.FILE_NAME;
import static constants.Constant.URLs.AUTH_HOME_PAGE;

public class ExportReportDemoTest extends BaseTest {

    @Test
    public void exportReport() throws InterruptedException {

        basePage.open(AUTH_HOME_PAGE);
        Thread.sleep(2000);
        authorizationVisary.clickLogin(USER_NAME, PASSWORD);
        Thread.sleep(2000);
        visaryHomePage.clickButtonBi();
        Thread.sleep(2000);
        registryPage.clickRegistry()
                .doubleClickReport()
                .getDropDownListOfFormatsForExport()
                .selectExportFormat();
        Thread.sleep(10000);
        basePage.searchLastDownloadedFile(DOWNLOAD_FILE_PATH, FILE_NAME);

        Thread.sleep(2000);
        System.out.println("Тест по экспорту точета - true");

    }
}
